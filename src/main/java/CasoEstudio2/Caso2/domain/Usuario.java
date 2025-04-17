package CasoEstudio2.Caso2.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import javax.validation.constraints.NotEmpty;


@Entity
@Data
@Table(name="usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;

    @OneToMany
    @JoinColumn(name="id_usuario")
    private List<Rol> roles;
}