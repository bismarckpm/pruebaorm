package ucab.dsw.entidades;


import javax.persistence.*;

@Entity
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String fecha;

    @Column(columnDefinition = "CHECK (status IN ('I','A'))")
    private String status;
}
