package ucab.dsw.servicio.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Estudio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Date fechaCreacion;

    @Column(columnDefinition = "CHECK (status IN ('C','EP','F', 'E'))")
    private String status;
}
