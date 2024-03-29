package velazquez._5_spring_security_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import velazquez._5_spring_security_jpa.model.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

  Departamento findByNombre(String nombre);
}
