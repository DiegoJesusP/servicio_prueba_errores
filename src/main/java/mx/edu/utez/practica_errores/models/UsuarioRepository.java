package mx.edu.utez.practica_errores.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<BeanUsuario, Long> {
    Optional<BeanUsuario> findById(Long id);  // findById ya existe en JpaRepository, pero puedes declararlo
    List<BeanUsuario> findByNombre(String nombre);
    Optional<BeanUsuario> findByEmail(String email);
}
