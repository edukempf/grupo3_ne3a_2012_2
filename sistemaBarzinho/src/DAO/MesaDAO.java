/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Mesa;
import java.util.List;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Juliana
 */
public class MesaDAO extends DaoBasic<Mesa>{

    public MesaDAO() {
        super(Mesa.class);
    }
    
     public List<Mesa> buscaPorNome(String nome){
        session=HibernateConexao.getSession();
        session.beginTransaction().begin();
        List list = session.createCriteria(classe).add(Restrictions.like("nome", "%"+nome+"%")).list();
        session.close(); 
        return list;
    }
    
    
}
