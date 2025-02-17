package mx.edu.utez.practica_errores.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UsuarioDto {
    private String razonSocial;
    private String rfc;
    private String telefono;
    private String contacto;
    private String correo;
}
