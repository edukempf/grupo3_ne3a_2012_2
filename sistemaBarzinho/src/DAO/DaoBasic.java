/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


/**
 *
 * @author Eduardo
 */


public abstract class DaoBasic<T> {

    public DaoBasic() {
    }
    
    
   
    protected Class classe;
    public DaoBasic(Class classe) {
        this.classe=classe;
    }
        
    protected static Session session;
    
    public void persisteObjeto(Object o){
        session=HibernateConexao.iniciaConexao();
        session.beginTransaction().begin();
        session.saveOrUpdate(o);
        session.beginTransaction().commit();
        HibernateConexao.fechaConexao(session);
    }
    
    public T delete(int id){
        Object deletado= this.get(id);
        session=HibernateConexao.iniciaConexao();
        session.beginTransaction().begin();
        session.delete(deletado);
        session.beginTransaction().commit();
        HibernateConexao.fechaConexao(session);
        return (T)deletado;
    }
    
    public T get(int id){
        session=HibernateConexao.iniciaConexao();
        session.beginTransaction().begin();
        Object busca=session.get(this.classe, id);
        HibernateConexao.fechaConexao(session);
        return (T) busca;
    }
    
    public List<T> lista(){
        session=HibernateConexao.iniciaConexao();
        session.beginTransaction().begin();
        List list = session.createCriteria(classe).list();
        HibernateConexao.fechaConexao(session);
        return list;
    }
      
}
