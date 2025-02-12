package mx.edu.utez.practica_errores.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import mx.edu.utez.practica_errores.models.usuario;

import java.util.Set;
@NoArgsConstructor
@Setter
@Getter
public class UsuarioDto {
    private Long id;
    private String nombre;
    private String email;
}
