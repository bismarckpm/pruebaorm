package ucab.dsw.accesodatos;

import ucab.dsw.entidades.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class DaoUsuario extends Dao<Usuario>
{
    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();


    public DaoUsuario( )
    {
        super( _handler );
        this._em = _handler.getSession();
    }

    public Usuario getUsuarioByUsername(String username){

        try{
            TypedQuery<Usuario> usuario = this._em.createNamedQuery("getUsuarioByUsername", Usuario.class);
            usuario.setParameter("username", username).getSingleResult();

            Usuario resultado = usuario.getSingleResult();
            return resultado;
        }catch (Exception e){
            return null;
        }
    }
}