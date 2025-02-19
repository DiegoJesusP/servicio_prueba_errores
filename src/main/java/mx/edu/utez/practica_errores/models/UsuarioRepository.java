package mx.edu.utez.practica_errores.models;

import mx.edu.utez.practica_errores.models.BeanUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<BeanUsuario, Long> {
    Optional<BeanUsuario> findById(Long id);
    Optional<BeanUsuario> findByUuid(String uuid);
    Optional<BeanUsuario> findByCorreo(String correo);
}
