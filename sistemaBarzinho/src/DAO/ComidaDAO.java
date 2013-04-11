package DAO;

import Modelo.Comida;
import java.util.List;

public class ComidaDAO extends DaoBasic<Comida> {

    public ComidaDAO() {
        super(Comida.class);
    }
    
    public List<Comida> buscaPorNome(String nome){
        session=HibernateConexao.getSession();
        session.beginTransaction().begin();
        List list = session.createQuery("from Comida as f where f.nome like '%"+nome+"%'").list();
        session.beginTransaction().commit();
        HibernateConexao.fechaConexao(session);
        return list; 
    }
    
}
  