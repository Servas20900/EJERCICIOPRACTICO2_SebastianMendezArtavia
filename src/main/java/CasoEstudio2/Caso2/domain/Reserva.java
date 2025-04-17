package CasoEstudio2.Caso2.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Entity
@Data
@Table(name = "reservas")
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuarios")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_funcion")
    private Funcion funcion;

    private int cantidad;
}
