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

    private int index = 0;
    private String fecha, idPaciente, idMedico, observaciones;


    public SolHistClinic() {
        validaciones = new Validacion();
    }

    @Override
    public void registrar() {

        if (!(SolPacientes.pacientes.size() > 0) || !(SolMedicos.medicos.size() > 0)) {
            if(!(SolPacientes.pacientes.size() > 0)){
                JOptionPane.showMessageDialog(null, "Debe registrar pacientes antes de crear historias");
            }
            else if(!(SolMedicos.medicos.size() > 0)){
                JOptionPane.showMessageDialog(null, "Debe registrar medicos antes de crear historias");
            }
        } else {
            boolean valido = false;
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
                if (idPaciente == "" || !validaciones.valida(idPaciente, 2)||!existePaciente(idPaciente)) {
                    if (idPaciente == "") {
                        JOptionPane.showMessageDialog(null, "Debe ingresar un identificador");
                    } else if (!validaciones.valida(idPaciente, 2)) {
                        JOptionPane.showMessageDialog(null, "el identificador es numerico, porfavor ingrese un identificador numerico");
                    } else if (!existePaciente(idPaciente)) {
                        JOptionPane.showMessageDialog(null, "el identificador ingresado no existe");
                    }
                    valido = false;
                } else {
                    valido = true;
                }
            } while (!valido);
            do {
                idMedico = JOptionPane.showInputDialog("*****Registro de nueva Historia Clinica*****\n\n"
                        + "Ingrese Idetificacion del Medico\n\n" + listarMedicos());
                if (idMedico == "" || !validaciones.valida(idMedico, 2) || !existeMedico(idMedico)) {
                    if (idMedico == "") {
                        JOptionPane.showMessageDialog(null, "Debe ingresar un identificador");
                    } else if (!validaciones.valida(idMedico, 2)) {
                        JOptionPane.showMessageDialog(null, "el identificador es numerico, porfavor ingrese un identificador numerico");
                    } else if (!existeMedico(idMedico)) {
                        JOptionPane.showMessageDialog(null, "el identificador ingresado no existe");
                    }
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


    public String listarHistorias() {
        String lstpac = "";
        for (HistClinic historia : histClinic) {
            Pacientes paciente = SolPacientes.pacientes.stream().filter(p -> p.getIdentificación().equals(historia.getIdPaciente())).findFirst().orElse(null);
            Medicos medico = SolMedicos.medicos.stream().filter(m -> m.getIdentificación().equals(historia.getIdMedico())).findFirst().orElse(null);
            lstpac += "**************************************\n"
                    + historia.getCódigo() + ".\nFecha: "
                    + historia.getFecha() + "\nPaciente: "
                    + paciente.getNombresApellidos() + "\nMedico: "
                    + medico.getNombresApellidos() + "\nObservaciones "
                    + historia.getObservaciones() + "\n**************************************\n";
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

    public boolean existeHistoria(String codigo) {
        boolean existe = false;
        for (HistClinic historia : histClinic) {
            if (historia.getCódigo().equals(codigo)) {
                index = histClinic.indexOf(historia);
                existe = true;
            }
        }
        return existe;

    }

    @Override
    public void mostrar() {
        JOptionPane.showMessageDialog(null, listarHistorias());
    }

    @Override
    public void modificar() {
        String sel = JOptionPane.showInputDialog("*****Ingrese el identificador de la historia a modificar*****\n"
                + listarHistorias());
        if (sel == "" || !validaciones.valida(sel, 2)) {
            if (sel == "") {
                JOptionPane.showMessageDialog(null, "Debe ingresar un identificador");
            } else if (!validaciones.valida(sel, 2)) {
                JOptionPane.showMessageDialog(null, "el identificador es numerico, porfavor ingrese un identificador numerico");
            }
        } else {
            if (!existeHistoria(sel)) {
                JOptionPane.showMessageDialog(null, "la historia seleccionada no existe");
            } else {
                boolean valido = false;
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
                    if (idPaciente == "" || !validaciones.valida(idPaciente, 2)) {
                        if (idPaciente == "") {
                            JOptionPane.showMessageDialog(null, "Debe ingresar un identificador");
                        } else if (!validaciones.valida(idPaciente, 2)) {
                            JOptionPane.showMessageDialog(null, "el identificador es numerico, porfavor ingrese un identificador numerico");
                        } else if (!existePaciente(idPaciente)) {
                            JOptionPane.showMessageDialog(null, "el identificador ingresado no existe");
                        }
                        valido = false;
                    } else {
                        valido = true;
                    }
                } while (!valido);
                do {
                    idMedico = JOptionPane.showInputDialog("*****Registro de nueva Historia Clinica*****\n\n"
                            + "Ingrese Idetificacion del Medico\n\n" + listarMedicos());
                    if (idMedico == "" || !validaciones.valida(idMedico, 2) || !existeMedico(idMedico)) {
                        if (idMedico == "") {
                            JOptionPane.showMessageDialog(null, "Debe ingresar un identificador");
                        } else if (!validaciones.valida(idMedico, 2)) {
                            JOptionPane.showMessageDialog(null, "el identificador es numerico, porfavor ingrese un identificador numerico");
                        } else if (!existeMedico(idMedico)) {
                            JOptionPane.showMessageDialog(null, "el identificador ingresado no existe");
                        }
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
                histClinic.get(index).setFecha(fecha);
                histClinic.get(index).setIdMedico(idMedico);
                histClinic.get(index).setIdPaciente(idPaciente);
                histClinic.get(index).setObservaciones(observaciones);

            }
            JOptionPane.showMessageDialog(null, "Historia modificada correctamente");
        }
    }

    @Override
    public void eliminar() {
        String sel = JOptionPane.showInputDialog("*****Ingrese el identificador de la historia a eliminar*****\n"
                + listarHistorias());
        if (sel == "" || !validaciones.valida(sel, 2)) {
            if (sel == "") {
                JOptionPane.showMessageDialog(null, "Debe ingresar un identificador");
            } else if (!validaciones.valida(sel, 2)) {
                JOptionPane.showMessageDialog(null, "el identificador es numerico, porfavor ingrese un identificador numerico");
            }
        } else {
            if (!existeHistoria(sel)) {
                JOptionPane.showMessageDialog(null, "Historia seleccionada no existe");
            } else {
                histClinic.remove(index);
            }
            JOptionPane.showMessageDialog(null, "Historia eliminada correctamente");
        }
    }
}
