/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.*;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author Eduardo
 */


public class DaoBasic<T> {

    
    private Class classe;
    public DaoBasic(Class classe) {
        this.classe=classe;
    }
    
    
    
    private static SessionFactory factory;
    private static Session session;
    
    private static AnnotationConfiguration getConfiguracaoHibernate(){
        AnnotationConfiguration cfg = new AnnotationConfiguration(); 
        
        cfg.addAnnotatedClass(Funcionario.class);
        cfg.addAnnotatedClass(Comida.class);
        cfg.addAnnotatedClass(Bebida.class);
        
        cfg.setProperty("hibernate.connection.driver", "com.mysql.jdbc.Driver");
        cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost/aluno");
        cfg.setProperty("hibernate.connection.user", "root");
        cfg.setProperty("hibernate.connection.password", "");
        cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        cfg.setProperty("hibernate.show_sql", "true");
        cfg.setProperty("hibernate.format_sql", "true");
        cfg.setProperty("hibernate.hbm2ddl.auto", "update");
        
        return cfg;
    }
    
    public void persisteObjeto(Object o){
        factory=getConfiguracaoHibernate().buildSessionFactory();
        session=factory.openSession();
        session.beginTransaction().begin();
        session.saveOrUpdate(o);
        session.beginTransaction().commit();
        session.close();
    }
    
    public T delete(int id){
        Object deletado= this.get(id);
        factory=getConfiguracaoHibernate().buildSessionFactory();
        session=factory.openSession();
        session.beginTransaction().begin();
        session.delete(deletado);
        session.beginTransaction().commit();
        session.flush();
        session.close();
        return (T)deletado;
    }
    
    public T get(int id){
        factory=getConfiguracaoHibernate().buildSessionFactory();
        session=factory.openSession();
        session.beginTransaction().begin();
        Object busca=session.get(this.classe, id);
        session.close();
        return (T) busca;
    }
    
    public List<T> lista(){
        factory=getConfiguracaoHibernate().buildSessionFactory();
        session=factory.openSession();
        session.beginTransaction().begin();
        List list = session.createCriteria(classe).list();
        session.close();
        return list;
    }
    
    
}
