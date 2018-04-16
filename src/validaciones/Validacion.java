/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validaciones;

import java.util.regex.Pattern;

/**
 *
 * @author luisd
 */
public class Validacion {

    public Validacion() {
    }

    public boolean valida(String txt, int tipo) {
        boolean resp = false;
        switch (tipo) {
            case 1:
                resp= Pattern.compile( "[^A-Za-z ]" ).matcher( txt ).find();
                break;
            case 2:
                resp=Pattern.compile("[0-9]").matcher(txt).find();
                break;
        }
        return resp;
    }
}
