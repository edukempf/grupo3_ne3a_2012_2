/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Modelo.Prato;
import java.util.List;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author Ligue01
 */
public class PratoDAO extends DaoBasic<Prato>{
     public PratoDAO() {
        super(Prato.class);
    }
    
      public List<Prato> buscaPorNome(String nome){
        session=HibernateConexao.getSession();
        session.beginTransaction().begin();
        List list = session.createCriteria(classe).add(Restrictions.like("nome", "%"+nome+"%")).list();
        session.close(); 
        return list;
    }
    
}
