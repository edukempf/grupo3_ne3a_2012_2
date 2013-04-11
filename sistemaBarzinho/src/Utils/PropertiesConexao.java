/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/** 
 *
 * @author Eduardo
 */
public class PropertiesConexao {

    public static Properties getProp() {
        Properties prop = new Properties();
        FileInputStream file = null;
        try {
            file = new FileInputStream("./src/Utils/conexao.properties");
            prop.load(file);
        } catch (IOException ex) {
            Logger.getLogger(PropertiesConexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                file.close();
            } catch (IOException ex) {
                Logger.getLogger(PropertiesConexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return prop;
    }
    
    public static boolean saveProp(Properties prop){
        FileOutputStream file = null;
        boolean teste=false;
        try {
            file = new FileOutputStream("./src/Utilitarios/conexao.properties");
            prop.store(file, null);
            teste=true;
        } catch (IOException ex) {
            Logger.getLogger(PropertiesConexao.class.getName()).log(Level.SEVERE, null, ex);
            
        } finally {
            try {
                file.close();
            } catch (IOException ex) {
                Logger.getLogger(PropertiesConexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            return teste;
    }
}
