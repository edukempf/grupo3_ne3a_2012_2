/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Eduardo
 */
public class Utilitarios {

    public static String dataBRtoISO(String data) {
        String[] d = data.split("/");
        return d[2] + "-" + d[1] + "-" + d[0];
    }

    public static String dataISOtoBR(String data) {
        String[] d = data.split("-");
        return d[2] + "/" + d[1] + "/" + d[0];
    }

    public static String dateToString(Date d) {
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        return formatador.format(d);
    }
}
