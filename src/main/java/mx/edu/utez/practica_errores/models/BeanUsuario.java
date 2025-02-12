package mx.edu.utez.practica_errores.models;
import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class BeanUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;

    public BeanUsuario() {}

    public BeanUsuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}