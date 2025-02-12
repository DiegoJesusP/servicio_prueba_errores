package mx.edu.utez.practica_errores.services;

import org.springframework.transaction.annotation.Transactional;
import mx.edu.utez.practica_errores.config.ApiResponse;
import mx.edu.utez.practica_errores.models.BeanUsuario;
import mx.edu.utez.practica_errores.models.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> findAll() {
        return ResponseEntity.ok(new ApiResponse(
                usuarioRepository.findAll(),
                HttpStatus.OK
        ));
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> findById(Long id) {
        return usuarioRepository.findById(id)
                .map(usuario -> ResponseEntity.ok(new ApiResponse(usuario, HttpStatus.OK)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse(HttpStatus.NOT_FOUND, true, "Usuario no encontrado")));
    }

    @Transactional
    public ResponseEntity<ApiResponse> save(BeanUsuario usuario) {
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse(HttpStatus.BAD_REQUEST, true, "El correo ya está registrado"));
        }
        usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse(usuario, HttpStatus.CREATED));
    }

    @Transactional
    public ResponseEntity<ApiResponse> deleteById(Long id) {
        if (!usuarioRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse(HttpStatus.NOT_FOUND, true, "Usuario no encontrado"));
        }
        usuarioRepository.deleteById(id);
        return ResponseEntity.ok(new ApiResponse(HttpStatus.OK, false, "Usuario eliminado correctamente"));
    }
}

