/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;


import java.util.List;
import org.hibernate.Session;


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
        session=TransactionManager.getCurrentSession();
        session.saveOrUpdate(o);
    }
    
    public void delete(Object deletar){
        session=TransactionManager.getCurrentSession();
        session.delete(deletar);
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
