/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.*;
import java.util.Properties;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author Juliana
 */
public class HibernateConexao {

    private static SessionFactory factory;
    private static AnnotationConfiguration cfg;

    private static AnnotationConfiguration getConfiguracaoHibernate() {
        if (cfg == null) {
            Properties prop = Utils.PropertiesConexao.getProp();

            cfg = new AnnotationConfiguration();
            cfg.addAnnotatedClass(Funcionario.class);
            cfg.addAnnotatedClass(Comida.class);
            cfg.addAnnotatedClass(Bebida.class);
            cfg.addAnnotatedClass(Mesa.class);
            cfg.addAnnotatedClass(Prato.class);
            cfg.addAnnotatedClass(PedidoBebida.class);
            cfg.addAnnotatedClass(PedidoPrato.class);
            cfg.setProperty("hibernate.connection.driver", "com.mysql.jdbc.Driver");
            cfg.setProperty("hibernate.connection.url", "jdbc:mysql://" + prop.getProperty("host") + "/" + prop.getProperty("database"));
            cfg.setProperty("hibernate.connection.user", prop.getProperty("login"));
            cfg.setProperty("hibernate.connection.password", prop.getProperty("password"));
            cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
            cfg.setProperty("hibernate.show_sql", "true");
            cfg.setProperty("hibernate.format_sql", "true");
            cfg.setProperty("hibernate.hbm2ddl.auto", "create or update");
        }
        return cfg;
    }

    public static Session getSession() {
        if (factory == null) {
            factory = getConfiguracaoHibernate().buildSessionFactory();
        }
        return factory.openSession();
    }

    public static void createSchema() {
        getSession().close();
        cfg = null;//anulando a atual instancia de cfg para criar uma nova.
        org.hibernate.tool.hbm2ddl.SchemaExport schemaEx = new SchemaExport(getConfiguracaoHibernate());
        schemaEx.create(true, true);
    }
}
