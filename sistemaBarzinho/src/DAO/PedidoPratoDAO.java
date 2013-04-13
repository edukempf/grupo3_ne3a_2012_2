/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Modelo.Pedido;
import java.util.List;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author Ligue01
 */
public class PedidoDAO extends DaoBasic<Pedido>{
     public PedidoDAO() {
        super(Pedido.class);
    }
    
       public List<Pedido> buscaPorNome(String nome){
        session=HibernateConexao.getSession();
        session.beginTransaction().begin();
        List list = session.createCriteria(classe).add(Restrictions.like("nome", "%"+nome+"%")).list();
        session.close(); 
        return list;
    }
    
}