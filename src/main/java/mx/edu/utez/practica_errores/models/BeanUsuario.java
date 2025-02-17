package mx.edu.utez.practica_errores.models;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "usuarios")
public class BeanUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, updatable = false)
    private String uuid;

    @Column(nullable = false, length = 150)
    private String razonSocial;

    @Column(nullable = false, unique = true, length = 13)
    private String rfc;

    @Column(nullable = false, length = 20)
    private String telefono;

    @Column(nullable = false, length = 100)
    private String contacto;

    @Column(nullable = false, unique = true, length = 100)
    private String correo;

    public BeanUsuario() {
        this.uuid = UUID.randomUUID().toString();
    }

    public BeanUsuario(String razonSocial, String rfc, String telefono, String contacto, String correo) {
        this.razonSocial = razonSocial;
        this.rfc = rfc;
        this.telefono = telefono;
        this.contacto = contacto;
        this.correo = correo;
        this.uuid = UUID.randomUUID().toString();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUuid() { return uuid; }
    public void setUuid(String uuid) { this.uuid = uuid; }

    public String getRazonSocial() { return razonSocial; }
    public void setRazonSocial(String razonSocial) { this.razonSocial = razonSocial; }

    public String getRfc() { return rfc; }
    public void setRfc(String rfc) { this.rfc = rfc; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getContacto() { return contacto; }
    public void setContacto(String contacto) { this.contacto = contacto; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
}
