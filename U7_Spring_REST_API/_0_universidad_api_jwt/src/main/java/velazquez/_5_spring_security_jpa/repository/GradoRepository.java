package velazquez._5_spring_security_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import velazquez._5_spring_security_jpa.model.Grado;

@Repository
public interface GradoRepository extends JpaRepository<Grado, Long> {
    Grado findByNombre(String nombre);
}
