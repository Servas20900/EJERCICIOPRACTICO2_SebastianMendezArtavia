package CasoEstudio2.Caso2.domain;


import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Entity
@Data
@Table(name = "ruta")
public class Ruta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRuta;

    private String patron;   // ejemplo: /carrito/** o /admin/**
    private String rolName;  // ejemplo: ROLE_ADMIN
}