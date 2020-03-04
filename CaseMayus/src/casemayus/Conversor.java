/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casemayus;

import java.util.regex.Pattern;

/**
 *
 * @author prog14
 */
public class Conversor {

    public String convertir(String cadena) {
        String cadenaConvertida = "";
        boolean espAnt = false;
        boolean mayAnt = false;
        for (int i = 0; i < cadena.length(); i++) {
            String aux = "" + cadena.charAt(i);
            if (Pattern.matches("[a-zA-Z]", aux)) {
                if (aux.equals(aux.toUpperCase()) && (i == 0) || espAnt) {
                    cadenaConvertida += aux.toLowerCase();
                    mayAnt = true;
                } else if (aux.equals(aux.toUpperCase())) {
                    if (mayAnt) {
                        cadenaConvertida += aux.toLowerCase();
                    } else {
                        cadenaConvertida += "_" + aux.toLowerCase();
                    }
                    mayAnt = true;
                } else {
                    cadenaConvertida += aux;
                    mayAnt = false;
                }
                espAnt = false;
            } else {
                cadenaConvertida += aux;
                espAnt = true;
                mayAnt = false;
            }
            // System.out.println(cadena.charAt(i));;
        }

        return cadenaConvertida;
    }
}
