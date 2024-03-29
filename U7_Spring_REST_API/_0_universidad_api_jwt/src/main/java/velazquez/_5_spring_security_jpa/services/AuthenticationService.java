package velazquez._5_spring_security_jpa.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import velazquez._5_spring_security_jpa.config.JwtService;
import velazquez._5_spring_security_jpa.controller.requests.AuthenticationRequest;
import velazquez._5_spring_security_jpa.controller.response.AuthenticationResponse;
import velazquez._5_spring_security_jpa.controller.requests.RegisterRequest;
import velazquez._5_spring_security_jpa.model.Usuario;
import velazquez._5_spring_security_jpa.repository.UsuarioRepository;

@Service
public class AuthenticationService {

  static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);

  private final UsuarioRepository usuarioRepository;

  private final PasswordEncoder passwordEncoder;

  private final JwtService jwtService;

  private final AuthenticationManager authenticationManager;

  public AuthenticationService(
      UsuarioRepository usuarioRepository,
      PasswordEncoder passwordEncoder,
      JwtService jwtService,
      AuthenticationManager authenticationManager) {
    this.usuarioRepository = usuarioRepository;
    this.passwordEncoder = passwordEncoder;
    this.jwtService = jwtService;
    this.authenticationManager = authenticationManager;
  }

  public AuthenticationResponse register(RegisterRequest request) {
    logger.info("Registering user: {}", request);
    Usuario usuario = new Usuario();
    usuario.setNombre(request.getFirstName());
    usuario.setUserName(request.getFirstName() + "_" + request.getLastName());
    usuario.setApellidos(request.getLastName());
    usuario.setEmail(request.getEmail());
    usuario.setPassword(passwordEncoder.encode(request.getPassword()));
    usuario.setRole("USER");
    usuario.setActivo(true);
    Usuario saved = usuarioRepository.save(usuario);
    String jwtToken = jwtService.generateToken(saved);
    return new AuthenticationResponse(jwtToken);
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    logger.info("Authenticating user: {}", request);
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
    logger.info("User authenticated: {}", request);
    Usuario usuario = usuarioRepository.findByEmail(request.getEmail()).orElseThrow();
    logger.info("Authenticating user: {}", usuario);
    String jwtToken = jwtService.generateToken(usuario);
    logger.info("JWT Token: {}", jwtToken);
    return new AuthenticationResponse(jwtToken);
  }
}
