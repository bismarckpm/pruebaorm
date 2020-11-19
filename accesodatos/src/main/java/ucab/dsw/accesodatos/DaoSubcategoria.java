/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucab.dsw.accesodatos;

import ucab.dsw.entidades.Subcategoria;

/**
 *
 * @author Omar David
 */
public class DaoSubcategoria extends Dao<Subcategoria>{
    static DaoHandler _handler = new DaoHandler();

    public DaoSubcategoria(DaoHandler daoHandler) {
        super(daoHandler);
    }
    
}
