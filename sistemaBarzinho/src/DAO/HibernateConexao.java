/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Eduardo
 */
public class HibernateConexao {

    private static SessionFactory factory;
    private static Session session;

    private static AnnotationConfiguration getConfiguracaoHibernate() {
        AnnotationConfiguration cfg = new AnnotationConfiguration();

        cfg.addAnnotatedClass(Funcionario.class);
        cfg.addAnnotatedClass(Comida.class);
        cfg.addAnnotatedClass(Bebida.class);
        cfg.addAnnotatedClass(Cliente.class);
        cfg.addAnnotatedClass(Mesa.class);
        cfg.addAnnotatedClass(Pedido.class);
        cfg.addAnnotatedClass(Prato.class);

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

    public static Session iniciaConexao() {
        factory = getConfiguracaoHibernate().buildSessionFactory();
        return factory.openSession();
    }
    
    public static void fechaConexao(){
        session.close();
    }
}
