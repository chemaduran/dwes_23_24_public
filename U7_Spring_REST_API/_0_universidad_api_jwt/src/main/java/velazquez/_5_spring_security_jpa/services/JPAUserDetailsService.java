package velazquez._5_spring_security_jpa.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import velazquez._5_spring_security_jpa.model.JPAUserDetails;
import velazquez._5_spring_security_jpa.model.Usuario;
import velazquez._5_spring_security_jpa.repository.UsuarioRepository;
//
//@Service
//public class JPAUserDetailsService implements UserDetailsService {
//
//  final UsuarioRepository usuarioRepository;
//
//  public JPAUserDetailsService(UsuarioRepository usuarioRepository) {
//    this.usuarioRepository = usuarioRepository;
//  }
//
//  @Override
//  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//    // Obtengo el usuario
//    Usuario user =
//        usuarioRepository
//            .findByUserName(username)
//            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//
//    return user;
//
//    // Adapto la información del usuario al UserDetails que es lo que debe devolver el método
////    JPAUserDetails userDetails = new JPAUserDetails(user);
////    return userDetails;
//  }
//}
