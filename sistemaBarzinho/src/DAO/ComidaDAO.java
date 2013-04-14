package DAO;

import Modelo.Comida;
import java.util.List;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Juliana
 */
public class ComidaDAO extends DaoBasic<Comida> {

    public ComidaDAO() {
        super(Comida.class);
    }
    
     public List<Comida> buscaPorNome(String nome){
        session=HibernateConexao.getSession();
        session.beginTransaction().begin();
        List list = session.createCriteria(classe).add(Restrictions.like("nome", "%"+nome+"%")).list();
        session.close(); 
        return list;
    }
    
}
  