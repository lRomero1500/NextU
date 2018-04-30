/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solicitudes;

import entidades.HistClinic;
import entidades.Medicos;
import entidades.Pacientes;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import validaciones.Validacion;

/**
 *
 * @author luisd
 */
public class SolHistClinic extends Solicitudes {

    public static List<HistClinic> histClinic = new ArrayList<>();
    private Validacion validaciones;

    public SolHistClinic() {
        validaciones = new Validacion();
    }

    @Override
    public void registrar() {
        boolean valido = false;
        String fecha, idPaciente, idMedico, observaciones;
        do {
            fecha = JOptionPane.showInputDialog("*****Registro de nueva Historia Clinica*****\n\n"
                    + "Ingrese fecha de la historia");
            if (fecha == "" || validaciones.valida(fecha, 3)) {
                if (fecha == "") {
                    JOptionPane.showMessageDialog(null, "Debe ingresar una fecha");
                } else if (validaciones.valida(fecha, 3)) {
                    JOptionPane.showMessageDialog(null, "la fecha debe tener el siguiente formato Ejemplo: '01-12-2018'");
                }
                valido = false;
            } else {
                valido = true;
            }
        } while (!valido);
        do {
            idPaciente = JOptionPane.showInputDialog("*****Registro de nueva Historia Clinica*****\n\n"
                    + "Ingrese Idetificacion del paciente\n\n" + listarPacientes());
            if (idPaciente == "" || validaciones.valida(idPaciente, 2)) {
                if (idPaciente == "") {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un identificador");
                } else if (!validaciones.valida(idPaciente, 2)) {
                    JOptionPane.showMessageDialog(null, "el identificador es numerico, porfavor ingrese un identificador numerico");
                }
                else if(!existePaciente(idPaciente))
                    JOptionPane.showMessageDialog(null, "el identificador ingresado no existe");
                valido = false;
            } else {
                valido = true;
            }
        } while (!valido);
        do {
            idMedico = JOptionPane.showInputDialog("*****Registro de nueva Historia Clinica*****\n\n"
                    + "Ingrese Idetificacion del Medico\n\n" + listarMedicos());
            if (idMedico == "" || validaciones.valida(idMedico, 2)||!existeMedico(idMedico)) {
                if (idMedico == "") {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un identificador");
                } else if (!validaciones.valida(idMedico, 2)) {
                    JOptionPane.showMessageDialog(null, "el identificador es numerico, porfavor ingrese un identificador numerico");
                }
                else if(!existeMedico(idMedico))
                    JOptionPane.showMessageDialog(null, "el identificador ingresado no existe");
                valido = false;
            } else {
                valido = true;
            }
        } while (!valido);
        do {
            observaciones = JOptionPane.showInputDialog("*****Registro de nueva Historia Clinica*****\n\n"
                    + "Ingrese observaciones de la historia");
            if (observaciones == "") {
                JOptionPane.showMessageDialog(null, "Debe ingresar una observacion");
                valido = false;
            } else {
                valido = true;
            }
        } while (!valido);
        histClinic.add(new HistClinic(String.valueOf(histClinic.size() + 1), fecha, idPaciente, idMedico, observaciones));
        JOptionPane.showMessageDialog(null, "Historia Clinica creada correctamente");
    }

    public String listarPacientes() {
        String lstpac = "";
        for (Pacientes paciente : SolPacientes.pacientes) {
            lstpac += paciente.getPacienteLista();
        }
        return lstpac;
    }

    public String listarMedicos() {
        String lstpac = "";
        for (Medicos medico : SolMedicos.medicos) {
            lstpac += medico.getMedicoLista();
        }
        return lstpac;
    }

    public boolean existeMedico(String idMedico) {
        int index = 0;
        boolean existe = false;
        for (Medicos medico : SolMedicos.medicos) {
            if (medico.getIdentificación().equals(idMedico)) {
                index = SolMedicos.medicos.indexOf(medico);
                existe = true;
            }
        }
        return existe;
    }
    public boolean existePaciente(String idMedico) {
        int index = 0;
        boolean existe = false;
        for (Pacientes paciente : SolPacientes.pacientes) {
            if (paciente.getIdentificación().equals(idMedico)) {
                index = SolPacientes.pacientes.indexOf(paciente);
                existe = true;
            }
        }
        return existe;
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
