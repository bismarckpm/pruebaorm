package ucab.dsw.directorio;

import ucab.dsw.dtos.UsuarioDto;

import javax.naming.Context;
import javax.naming.NameAlreadyBoundException;
import javax.naming.NamingEnumeration;
import javax.naming.directory.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;


/**
 * Una clase para la gestion completa del directorio activo. LDAP
 * @version 1.0, 02/01/2021
 * @author Jesus Requena
 * @author Gabriel Romero
 */
public class DirectorioActivo
{

    private DirContext _ldapContext;
    private String _url = "ldap://127.0.0.1:10389";
    private String _connType =  "simple";
    private String _directory =  "ou=users,o=pruebaucab";
    private String _userDirectory =  "cn=%s";
    private String _user =  "admin";
    private String _password =  "secret";

    /*
    Method to connect with the ldap
     */
    public DirectorioActivo()
    {}

    /**
     * Esta metodo es la encargada de realizar la conexion con el servidor LDAP
     * @author Gabriel Romero
     * @param user corresponde al usuario del admin en el servidor LDAP
     * @param password corresponde a la contrasena de admin en el servidor LDAP
     * @throws Exception si ocurre cualquier excepcion general no controlada previamente
     */
    private void connectLDAP(String user, String password)
    {
        try
        {
            Hashtable<String, String> environment = new Hashtable<String, String>();
            environment.put( Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory" );
            environment.put( Context.PROVIDER_URL, _url );
            environment.put( Context.SECURITY_AUTHENTICATION, _connType );
            environment.put( Context.SECURITY_PRINCIPAL, String.format( "uid=%s,ou=system", user ) );
            environment.put( Context.SECURITY_CREDENTIALS, password );
            _ldapContext = new InitialDirContext( environment );
        }
        catch ( Exception e )
        {

        }
    }

    private void disconnectLDAP()
    {
        try
        {
            _ldapContext.close();
        }
        catch ( Exception e )
        {

        }
    }

    /*
      Method that adds users to ldap
     */
    public void addEntryToLdap(UsuarioDto user)
    {

        try
        {
            connectLDAP( _user, _password );
            Attribute oc = new BasicAttribute( "objectClass" );
            oc.add( "top" );
            oc.add( "person" );
            SimpleDateFormat format = new SimpleDateFormat( "yyyyMMddHHmm" );
            BasicAttributes entry = new BasicAttributes();
            entry.put( oc );
            entry.put( new BasicAttribute( "cn", user.getCorreoelectronico() ) );
            entry.put( new BasicAttribute( "sn", user.getCorreoelectronico() ) );
            entry.put( new BasicAttribute( "userpassword", user.getContrasena() ) );
            entry.put( new BasicAttribute( "pwdLastSuccess", format.format( new Date() ) + "Z" ) );
            _ldapContext.createSubcontext( String.format( _userDirectory + "," + _directory, user.getCorreoelectronico()), entry );

        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    /**
     * Esta funcion consiste autenticar las credenciales de un usuario
     * @author Gabriel Romero
     * @param user corresponde al objeto de la capa web que contiene los datos que se desean autenticar (usuario/correo y contraseña)
     * @return retorna un long. Devuelve 0 si las credenciales son incorrectas y devuelve 1 en caso de ser correctas.
     */
    public boolean userAuthentication(UsuarioDto user)
    {
        try
        {
            connectLDAP( _user, _password );
            if(this.AutenticateUserInLdap(user)){
                SimpleDateFormat format = new SimpleDateFormat( "yyyyMMddHHmm" );
                ModificationItem[] modificationItems = new ModificationItem[ 1 ];
                modificationItems[ 0 ] = new ModificationItem( DirContext.REPLACE_ATTRIBUTE, new BasicAttribute(
                        "pwdLastSuccess", format.format( new Date() ) + "Z" ) );
                _ldapContext.modifyAttributes(String.format(_userDirectory + "," + _directory, user.getCorreoelectronico()), modificationItems );
                System.out.println("Credenciales correctas");
                return true;
            }
            else{
                System.out.println("Credenciales incorrectas");
                return false;
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            return false;
        }
        finally
        {
            disconnectLDAP();
        }
    }

    /**
     * Esta funcion consiste en realizar la conexion con el servidor LDAP para realizar la atenticacion del usuario
     * @author Gabriel Romero
     * @param user corresponde al objeto que contiene los datos que se desean autenticar (usuario/correo y contraseña)
     * @return retorna un boolean. Devuelve true si el userContext es distinto de nulo, lo que indica
     * que las credenciales son validas y devuelve false en caso de ser incorrectas.
     */
    public Boolean AutenticateUserInLdap(UsuarioDto user){
        try
        {
            Hashtable<String, String> environment = new Hashtable<String, String>();
            environment.put( Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory" );
            environment.put( Context.PROVIDER_URL, _url );
            environment.put( Context.SECURITY_AUTHENTICATION, _connType );
            environment.put( Context.SECURITY_PRINCIPAL, String.format( "cn=%s,ou=users,o=pruebaucab", user.getCorreoelectronico() ) );
            environment.put( Context.SECURITY_CREDENTIALS, user.getContrasena());
            DirContext userContext = new InitialDirContext( environment );

            if(userContext!=null){
                return true;
            }else{
                return false;
            }
        }
        catch ( Exception e )
        {
            return false;
        }
    }



    /*
         Method that remove users to ldap
        */
    public void deleteEntry(UsuarioDto user)
    {
        try
        {
            connectLDAP( _user, _password );
            _ldapContext.destroySubcontext( String.format(_userDirectory + "," + _directory, user.getCorreoelectronico()));
        }
        catch ( Exception exception )
        {
            exception.printStackTrace();
        }
        finally
        {
            disconnectLDAP();
        }
    }

    /*
     Method that obtains user data from ldap
    */
    public void getEntry(UsuarioDto user)
    {
        try
        {
            connectLDAP( _user, _password );
            SearchControls searcCon = new SearchControls();
            searcCon.setSearchScope( SearchControls.SUBTREE_SCOPE );
            NamingEnumeration results =
                    _ldapContext.search( _directory, String.format(_userDirectory, user.getCorreoelectronico()), searcCon );
            if ( results != null )
            {
                while ( results.hasMore() )
                {
                    SearchResult res = ( SearchResult ) results.next();
                    Attributes atbs = res.getAttributes();
                    Attribute atb = atbs.get( "cn" );
                    String name = ( String ) atb.get();
                }
            }
            else
            {
                System.out.println( "fail" );
            }
        }
        catch ( Exception exception )
        {
            exception.printStackTrace();
        }
        finally
        {
            disconnectLDAP();
        }
    }

    /*
    Method that updates the user in the ldap
     */
    public void updateEntry(UsuarioDto user)
    {
        try
        {
            connectLDAP( _user, _password );
            Attributes atbs = new BasicAttributes();
            Attribute atb = new BasicAttribute("mail","java2db@mai.com");
            atbs.put(atb);

            _ldapContext.modifyAttributes( String.format(_userDirectory + "," + _directory, user.getCorreoelectronico())
                    , DirContext.REPLACE_ATTRIBUTE,atbs );
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            disconnectLDAP();
        }
    }


    public void changePassword(UsuarioDto user)
    {
        try
        {
            connectLDAP( _user, _password );
            ModificationItem[] modificationItems = new ModificationItem[ 2 ];
            modificationItems[ 0 ] = new ModificationItem( DirContext.REPLACE_ATTRIBUTE,
                    new BasicAttribute( "userpassword", user.getContrasena()
                    ) );
            modificationItems[ 1 ] = new ModificationItem( DirContext.REPLACE_ATTRIBUTE,
                    new BasicAttribute( "description", "NUEVO"
                    ) );
            _ldapContext.modifyAttributes(String.format(_userDirectory + "," + _directory, user.getCorreoelectronico
                    ()), modificationItems );
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            disconnectLDAP();
        }
    }












}