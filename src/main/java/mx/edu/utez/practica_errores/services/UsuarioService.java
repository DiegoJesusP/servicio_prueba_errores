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
        return ResponseEntity.ok(new ApiResponse(usuarioRepository.findAll(), HttpStatus.OK));
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> findById(Long id) {
        return usuarioRepository.findById(id)
                .map(usuario -> ResponseEntity.ok(new ApiResponse(usuario, HttpStatus.OK))) // Usuario encontrado
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse("Usuario no encontrado", HttpStatus.NOT_FOUND))); // Usuario no encontrado
    }
}
