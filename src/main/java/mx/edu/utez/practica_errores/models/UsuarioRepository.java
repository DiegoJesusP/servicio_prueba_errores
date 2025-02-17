package mx.edu.utez.practica_errores.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<BeanUsuario, Long> {
    List<BeanUsuario> findByRazonSocial(String razonSocial);
    Optional<BeanUsuario> findByCorreo(String correo);
    Optional<BeanUsuario> findByUuid(String uuid);
}
