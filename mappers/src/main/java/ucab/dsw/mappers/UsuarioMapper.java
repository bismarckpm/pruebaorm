package ucab.dsw.mappers;

import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.Usuario;
import ucab.dsw.excepciones.PruebaExcepcion;

import java.util.Objects;

public class UsuarioMapper
{


    public static Usuario mapDtoToEntity( UsuarioDto dto )
    {
        Usuario entity = new Usuario(dto.getId());


        entity.setNombre( dto.getNombre() );
        entity.setApellido( dto.getApellido() );
        entity.setCorreoElectronico( dto.getCorreoelectronico() );
        entity.setEstatus( dto.getEstatus() );
        entity.setUsername( dto.getUsername() );


        if ( Objects.nonNull( dto.getTipoUsuarioDto() ) )
        {
            entity.setTipoUsuario( TipoUsuarioMapper.mapDtoToEntity( dto.getTipoUsuarioDto() ) );
        }

        return entity;
    }

    public static UsuarioDto mapEntityToDto( Usuario entity ) throws PruebaExcepcion
    {
        final UsuarioDto dto = new UsuarioDto();


        dto.setId(entity.getId());
        dto.setNombre( entity.getNombre());
        dto.setApellido( entity.getApellido());
        dto.setCorreoelectronico(entity.getCorreoElectronico());
        dto.setEstatus( entity.getEstatus() );
        dto.setUsername( entity.getUsername() );
        dto.setTipoUsuarioDto( TipoUsuarioMapper.mapEntityToDto( entity.getTipoUsuario()));


        return dto;
    }
}