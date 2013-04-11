/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Modelo.Comida;
import Modelo.Prato;
import java.util.List;
/**
 *
 * @author Ligue01
 */
public class PratoDAO extends DaoBasic<Comida>{
     public PratoDAO() {
        super(Prato.class);
    }
    
    public List<Prato> buscaPorNome(String nome){
        session=HibernateConexao.iniciaConexao();
        session.beginTransaction().begin();
        List list = session.createQuery("from Prato as prato where prato.nome like '%"+nome+"%'").list();
        session.beginTransaction().commit();
        HibernateConexao.fechaConexao(session);
        return list;
    }
}
