/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solicitudes;

import entidades.Medicos;
import java.util.ArrayList;
import java.util.List;
import validaciones.Validacion;

/**
 *
 * @author luisd
 */
public class SolMedicos extends Solicitudes{
    public static List<Medicos> medicos = new ArrayList<>();
    private Validacion validaciones;

    public SolMedicos() {
        validaciones = new Validacion();
    }
    
    @Override
    public void registrar() {
        boolean valido = false;
        String nombre = "";
        String apellidos = "";
        String especialidad = "";
        
    }

    @Override
    public void mostrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
