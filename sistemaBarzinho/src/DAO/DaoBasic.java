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
        session=HibernateConexao.getSession();
        session.beginTransaction().begin();
        session.saveOrUpdate(o);
        session.beginTransaction().commit();
        session.close();
    }
    
    public T delete(int id){
        Object deletado= this.get(id);
        session=HibernateConexao.getSession();
        session.beginTransaction().begin();
        session.delete(deletado);
        session.beginTransaction().commit();
        session.close();
        return (T)deletado;
    }
    
    public T get(int id){
        session=HibernateConexao.getSession();
        session.beginTransaction().begin();
        Object busca=session.get(this.classe, id);
        session.close();
        return (T) busca;
    }
    
    public List<T> lista(){
        session=HibernateConexao.getSession();
        session.beginTransaction().begin();
        List list = session.createCriteria(classe).list();
        session.close(); 
        return list;
    }
      
}
