/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solicitudes;

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
public class SolMedicos extends Solicitudes {

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
        do {
            nombre = JOptionPane.showInputDialog("*****Registro de nuevos Medicos*****\n\n"
                    + "Ingrese Nombre del medico");
            if (nombre == "" || validaciones.valida(nombre, 1)) {
                if (nombre == "") {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un nombre");
                } else if (validaciones.valida(nombre, 1)) {
                    JOptionPane.showMessageDialog(null, "El nombre debe contener solo letras");
                }
                valido = false;
            } else {
                valido = true;
            }
        } while (!valido);
        do {
            apellidos = JOptionPane.showInputDialog("*****Registro de nuevos Medicos*****\n\n"
                    + "Ingrese Apellido del medico");
            if (apellidos == "" || validaciones.valida(apellidos, 1)) {
                if (apellidos == "") {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un apellido");
                } else if (validaciones.valida(apellidos, 1)) {
                    JOptionPane.showMessageDialog(null, "El apellido debe contener solo letras");
                }
                valido = false;
            } else {
                valido = true;
            }
        } while (!valido);
        do {
            especialidad = JOptionPane.showInputDialog("*****Registro de nuevos Medicos*****\n\n"
                    + "Ingrese especialidad del medico");
            if (especialidad == "" || validaciones.valida(especialidad, 1)) {
                if (especialidad == "") {
                    JOptionPane.showMessageDialog(null, "Debe ingresar una especialidad");
                } else if (validaciones.valida(especialidad, 1)) {
                    JOptionPane.showMessageDialog(null, "la especialidad debe contener solo letras");
                }
                valido = false;
            } else {
                valido = true;
            }
        } while (!valido);
        medicos.add(new Medicos(String.valueOf(medicos.size() + 1), nombre, apellidos, especialidad));
        JOptionPane.showMessageDialog(null, "Medico creado correctamente");
    }

    @Override
    public void mostrar() {
        JOptionPane.showMessageDialog(null, listar());
    }

    private String listar() {
        String lstpac = "";
        if (medicos.size() > 0) {
            for (Medicos medico : medicos) {
                lstpac += medico.getMedicoLista();
            }
        } else {
            return "No existen Medicos Creados";
        }
        return lstpac;
    }

    @Override
    public void modificar() {
        String sel = JOptionPane.showInputDialog("*****Ingrese el identificador del medico a modificar*****\n"
                + listar());
        if (sel == "" || !validaciones.valida(sel, 2)) {
            if (sel == "") {
                JOptionPane.showMessageDialog(null, "Debe ingresar un identificador");
            } else if (!validaciones.valida(sel, 2)) {
                JOptionPane.showMessageDialog(null, "el identificador es numerico, porfavor ingrese un identificador numerico");
            }
        } else {
            int index = 0;
            boolean existe = false;
            for (Medicos medico : medicos) {
                String id = medico.getIdentificación();
                if (medico.getIdentificación().equals(sel)) {
                    index = medicos.indexOf(medico);
                    existe = true;
                }
            }
            if (!existe) {
                JOptionPane.showMessageDialog(null, "Medico seleccionado no existe");
            } else {
                boolean valido = false;
                String nombre = "";
                String apellidos = "";
                String especialidad = "";
                do {
                    nombre = JOptionPane.showInputDialog("*****Edicion de Medicos*****\n\n"
                            + "Ingrese Nombre del Medico");
                    if (nombre == "" || validaciones.valida(nombre, 1)) {
                        if (nombre == "") {
                            JOptionPane.showMessageDialog(null, "Debe ingresar un nombre");
                        } else if (validaciones.valida(nombre, 1)) {
                            JOptionPane.showMessageDialog(null, "El nombre debe contener solo letras");
                        }
                        valido = false;
                    } else {
                        valido = true;
                    }
                } while (!valido);
                do {
                    apellidos = JOptionPane.showInputDialog("*****Edicion de Medicos*****\n\n"
                            + "Ingrese Apellido del medico");
                    if (apellidos == "" || validaciones.valida(apellidos, 1)) {
                        if (apellidos == "") {
                            JOptionPane.showMessageDialog(null, "Debe ingresar un apellido");
                        } else if (validaciones.valida(apellidos, 1)) {
                            JOptionPane.showMessageDialog(null, "El apellido debe contener solo letras");
                        }
                        valido = false;
                    } else {
                        valido = true;
                    }
                } while (!valido);
                do {
                    especialidad = JOptionPane.showInputDialog("*****Edicion de Medicos*****\n\n"
                            + "Ingrese especialidad del medico");
                    if (especialidad == "" || validaciones.valida(especialidad, 1)) {
                        if (especialidad == "") {
                            JOptionPane.showMessageDialog(null, "Debe ingresar una especialidad");
                        } else if (validaciones.valida(especialidad, 1)) {
                            JOptionPane.showMessageDialog(null, "La especialidad debe contener solo letras");
                        }
                        valido = false;
                    } else {
                        valido = true;
                    }
                } while (!valido);
                medicos.get(index).setNombres(nombre);
                medicos.get(index).setApellidos(apellidos);
                medicos.get(index).setEspecialidad(especialidad);

            }
            JOptionPane.showMessageDialog(null, "Medico modificado correctamente");
        }
    }

    @Override
    public void eliminar() {
        String sel = JOptionPane.showInputDialog("*****Ingrese el identificador del medico a Eliminar*****\n"
                + listar());
        if (sel == "" || !validaciones.valida(sel, 2)) {
            if (sel == "") {
                JOptionPane.showMessageDialog(null, "Debe ingresar un identificador");
            } else if (!validaciones.valida(sel, 2)) {
                JOptionPane.showMessageDialog(null, "el identificador es numerico, porfavor ingrese un identificador numerico");
            }
        } else {
            int index = 0;
            boolean existe = false;
            for (Medicos medico : medicos) {
                String id = medico.getIdentificación();
                if (medico.getIdentificación().equals(sel)) {
                    index = medicos.indexOf(medico);
                    existe = true;
                }
            }
            if (!existe) {
                JOptionPane.showMessageDialog(null, "Medico seleccionado no existe");
            } else {
                medicos.remove(index);
            }
            JOptionPane.showMessageDialog(null, "Medico eliminado correctamente");
        }
    }

}
