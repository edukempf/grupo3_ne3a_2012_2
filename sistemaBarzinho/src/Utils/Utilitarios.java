/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Eduardo 
 */
public class Utilitarios {

    public static String dataBRtoISO(String data) {
        String[] d = data.split("/");
        return d[2] + "-" + d[1] + "-" + d[0];
    }

    public static String formatDate(Date data){
        DateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(data);
    }
    
    public static String dataISOtoBR(String data) {
        String[] d = data.split("-");
        return d[2] + "/" + d[1] + "/" + d[0];
    }

    public static String dateToString(Date d) {
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        return formatador.format(d);
    }
    
    public static String tiraTudo(String texto) {

        texto = texto.replace(".", "");
        texto = texto.replace(",", "");
        texto = texto.replace("*", "");
        texto = texto.replace("/", "");
        texto = texto.replace("-", "");
        texto = texto.replace("+", "");
        texto = texto.replace(")", "");
        texto = texto.replace("(", "");
        texto = texto.replaceAll(" ", "");

        return texto;
    }
    
    public static boolean validaCpf(String cpf) {
        
        String strCpf = tiraTudo(cpf);
        if("".equals(strCpf) || "00000000000".equals(strCpf) || "11111111111".equals(strCpf) || "22222222222".equals(strCpf) || "33333333333".equals(strCpf) || "44444444444".equals(strCpf) || "55555555555".equals(strCpf) || "66666666666".equals(strCpf) || "77777777777".equals(strCpf) || "88888888888".equals(strCpf) || "99999999999".equals(strCpf)) {
            return false;
        }
        
        if (!strCpf.substring(0, 1).equals("")) {
            try {
                int d1, d2;
                int digito1, digito2, resto;
                int digitoCPF;
                String nDigResult;
                d1 = d2 = 0;
                digito1 = digito2 = resto = 0;
                for (int nCount = 1; nCount < strCpf.length() - 1; nCount++) {
                    digitoCPF = Integer.valueOf(strCpf.substring(nCount - 1, nCount)).intValue();
                    d1 = d1 + (11 - nCount) * digitoCPF;
                    d2 = d2 + (12 - nCount) * digitoCPF;
                }
                resto = (d1 % 11);
                if (resto < 2) {
                    digito1 = 0;
                } else {
                    digito1 = 11 - resto;
                }
                d2 += 2 * digito1;
                resto = (d2 % 11);
                if (resto < 2) {
                    digito2 = 0;
                } else {
                    digito2 = 11 - resto;
                }
                String nDigVerific = strCpf.substring(strCpf.length() - 2, strCpf.length());
                nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
                return nDigVerific.equals(nDigResult);
            } catch (Exception e) {
                System.err.println("Erro !" + e);
                return false;
            }
        } else {
            return false;
        }
    }
    public static MaskFormatter setMascara(String mascara) {  
        MaskFormatter mask = null;  
        try {  
            mask = new MaskFormatter(mascara);  
        } catch (ParseException e) {  
  
            e.printStackTrace();  
        }  
        return mask;  
    }
}
