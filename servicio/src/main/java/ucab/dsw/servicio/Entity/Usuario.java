package ucab.dsw.servicio.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    private String correoElectronico;

    @Column(columnDefinition = "CHECK (status IN ('I','A','B'))")
    private String status;

}
