package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


    @Entity
    @Table( name = "opcion" )
    public class Opcion extends EntidadBase
    {
        @Column( name = "descripcion", nullable = false )
        private String _descripcion;

        @ManyToOne
        @JoinColumn(name="idPregunta ")
        private Pregunta pregunta;

        @OneToMany(mappedBy = "opcion", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
        private List<Ejecucionencuesta> Lopcion;

        public Pregunta get_pregunta()
        {
            return this.pregunta;
        }
        public void set_pregunta( Pregunta P )
        {
            this.pregunta= P;
        }

        public String get_descripcion()
        {
            return _descripcion;
        }
        public void set_descripcion( String _descripcion )
        {
            this._descripcion = _descripcion;
        }

        public List<Ejecucionencuesta> get_ejercicioEncuesta()
        {
            return this.Lopcion;
        }
        public void set_ejercicioEncuesta( List<Ejecucionencuesta> EE )
        {
            this.Lopcion =EE;
        }

        public Opcion( long id )
        {
            super( id );
        }

        public Opcion( ) {}
    }
