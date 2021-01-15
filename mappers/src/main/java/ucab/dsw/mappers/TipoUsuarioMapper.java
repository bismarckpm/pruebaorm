package ucab.dsw.mappers;

import ucab.dsw.dtos.TipoUsuarioDto;
import ucab.dsw.entidades.TipoUsuario;
import ucab.dsw.excepciones.PruebaExcepcion;

import java.util.Objects;

public class TipoUsuarioMapper
{
    public static TipoUsuario mapDtoToEntity( TipoUsuarioDto dto )
    {
        TipoUsuario entity = new TipoUsuario(dto.getId());


        entity.setDescripcion( dto.getDescripcion() );
        entity.setEstatus( dto.getEstatus() );


        return entity;
    }

    public static TipoUsuarioDto mapEntityToDto( TipoUsuario entity ) throws PruebaExcepcion
    {
        final TipoUsuarioDto dto = new TipoUsuarioDto();


        dto.setId(entity.getId());
        dto.setEstatus( entity.getEstatus());
        dto.setDescripcion( entity.getDescripcion());


        return dto;
    }
}
