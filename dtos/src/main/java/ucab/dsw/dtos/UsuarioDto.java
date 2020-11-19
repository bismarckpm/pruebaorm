package ucab.dsw.dtos;

import java.util.List;

public class UsuarioDto extends DtoBase
{
    private String nombre;
    private String apellido;
    private String correoelectronico;
    private TipoUsuarioDto tipoUsuarioDto;
    private List<EstudioDto> estudios;
    private List<PreguntaDto> preguntas;
    private String contrasena;
    private String estatus;

    public UsuarioDto(long id) throws Exception {
        super(id);
    }

    public UsuarioDto() {
    }
    private String contrasena;
    private String estatus;

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre( String nombre )
    {
        this.nombre = nombre;
    }

    public String getApellido()
    {
        return apellido;
    }

    public void setApellido( String apellido )
    {
        this.apellido = apellido;
    }

    public String getCorreoelectronico()
    {
        return correoelectronico;
    }

    public void setCorreoelectronico( String correoelectronico )
    {
        this.correoelectronico = correoelectronico;
    }

    public TipoUsuarioDto getTipoUsuarioDto()
    {
        return tipoUsuarioDto;
    }

    public void setTipoUsuarioDto( TipoUsuarioDto tipoUsuarioDto )
    {
        this.tipoUsuarioDto = tipoUsuarioDto;
    }

    public String getContrasena()
    {
        return contrasena;
    }

    public void setContrasena( String contrasena )
    {
        this.contrasena = contrasena;
    }

    public String getEstatus()
    {
        return estatus;
    }

    public void setEstatus( String estatus )
    {
        this.estatus = estatus;
    }
    public UsuarioDto()
    {
    }

    public List<EstudioDto> getEstudios() {
        return estudios;
    }

    public void setEstudios(List<EstudioDto> estudios) {
        this.estudios = estudios;
    public UsuarioDto( long id ) throws Exception
    {
        super( id );
    }
}
