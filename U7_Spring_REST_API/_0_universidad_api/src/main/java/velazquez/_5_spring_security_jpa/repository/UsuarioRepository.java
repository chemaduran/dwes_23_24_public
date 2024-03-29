package velazquez._5_spring_security_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import velazquez._5_spring_security_jpa.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

  Usuario findByUserName(String userName);
}
