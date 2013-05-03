/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import DAO.DBConnection;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRBand;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRStaticText;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.base.JRBaseStaticText;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JRDesignBand;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.type.SplitTypeEnum;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author lgvalentin
 */
public class Jasper {
    public static void generateReport(String camRelatorio) throws SQLException, ClassNotFoundException, IOException{
        try {
            File caminhoRelatorio=new File(camRelatorio);
            System.out.println(caminhoRelatorio.getAbsolutePath());
            System.out.println(caminhoRelatorio.isFile());
            
            JasperDesign jd = JRXmlLoader.load(caminhoRelatorio);
            
            JasperReport jr = JasperCompileManager.compileReport(jd);
            
            JasperPrint jp = JasperFillManager.fillReport(jr,null, DBConnection.getMyDBConnection());
            
            JasperViewer.viewReport(jp,false);
        
        } catch (JRException ex) {
            Logger.getLogger(Jasper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
}
