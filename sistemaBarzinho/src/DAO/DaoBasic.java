/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.*;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author Eduardo
 */


public class DaoBasic {
    
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
    
    public static void persisteObjeto(Object o){
        factory=getConfiguracaoHibernate().buildSessionFactory();
        session=factory.openSession();
        session.beginTransaction().begin();
        session.persist(o);
        session.beginTransaction().commit();
        session.close();
    }
    
    public static Object delete(int id){
        factory=getConfiguracaoHibernate().buildSessionFactory();
        session=factory.openSession();
        session.beginTransaction().begin();
    }
    
    
    
    public static void main(String[] args) {
        
        
        Funcionario f=new Funcionario();
        f.setCpf("111111111");
        f.setDataNasc(new Date("12/12/2000"));
        f.setEstadoCivil("Solteiro");
        f.setFuncao("teste");
        f.setNome("hahaha");
        f.setRg("ssss");
        f.setSalario(22);
        
        Bebida b=new Bebida();
        b.setDataValidade(new Date("12/12/2012"));
        b.setNome("bebida");
        b.setPreco(12);
        b.setQtde(12);
        b.setTipo("suco");
        
        Comida c=new Comida();
        c.setDataValidade(new Date("12/12/2000"));
        c.setNome("sss");
        c.setQuantidade(2);
        c.setTipo("aaa");
        
        persisteObjeto(c);
        
      
    }
    
}
