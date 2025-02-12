package mx.edu.utez.practica_errores.controller;

import mx.edu.utez.practica_errores.models.BeanUsuario;
import mx.edu.utez.practica_errores.services.UsuarioService;
import mx.edu.utez.practica_errores.config.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<ApiResponse> getAllUsers() {
        return usuarioService.findAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<ApiResponse> getUserById(@PathVariable Long id) {
        return usuarioService.findById(id);
    }

    @PostMapping(value = "/registrar", produces = "application/json")
    public ResponseEntity<ApiResponse> registerUser(@RequestBody BeanUsuario usuario) {
        return usuarioService.save(usuario);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long id) {
        return usuarioService.deleteById(id);
    }
}
