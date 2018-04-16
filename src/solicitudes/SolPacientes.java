/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solicitudes;

import entidades.Pacientes;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import validaciones.Validacion;

/**
 *
 * @author luisd
 */
public class SolPacientes extends Solicitudes {

    public List<Pacientes> pacientes = new ArrayList<>();
    private Validacion validaciones;

    public SolPacientes() {
        validaciones = new Validacion();
    }

    @Override
    public void registrar() {
        boolean valido = false;
        String nombre = "";
        String apellidos = "";
        String genero = "";
        String edad = "";

        do {
            nombre = JOptionPane.showInputDialog("*****Registro de nuevos pacientes*****\n\n"
                    + "Ingrese Nombre del paciente");
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
            apellidos = JOptionPane.showInputDialog("*****Registro de nuevos pacientes*****\n\n"
                    + "Ingrese Apellido del paciente");
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
            genero = JOptionPane.showInputDialog("*****Registro de nuevos pacientes*****\n\n"
                    + "Ingrese Genero del paciente");
            if (genero == "" || validaciones.valida(genero, 1)) {
                if (genero == "") {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un genero");
                } else if (validaciones.valida(genero, 1)) {
                    JOptionPane.showMessageDialog(null, "El genero debe contener solo letras");
                }
                valido = false;
            } else {
                valido = true;
            }
        } while (!valido);
        do {
            edad = JOptionPane.showInputDialog("*****Registro de nuevos pacientes*****\n\n"
                    + "Ingrese edad del paciente");
            if (edad == "" || !validaciones.valida(edad, 2)) {
                if (edad == "") {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un edad");
                } else if (!validaciones.valida(edad, 2)) {
                    JOptionPane.showMessageDialog(null, "La edad debe contener solo numeros");
                }
                valido = false;
            } else {
                valido = true;
            }
        } while (!valido);
        pacientes.add(new Pacientes(String.valueOf(pacientes.size() + 1), nombre, apellidos, genero, Integer.parseInt(edad)));
        JOptionPane.showMessageDialog(null, "Paciente creado correctamente");
    }

    @Override
    public void mostrar() {

        JOptionPane.showMessageDialog(null, listar());
    }

    private String listar() {
        String lstpac = "";
        for (Pacientes paciente : pacientes) {
            lstpac += paciente.getPacienteLista();
        }
        return lstpac;
    }

    @Override
    public void modificar() {

        String sel = JOptionPane.showInputDialog("*****Ingrese el identificador del paciente a modificar*****\n"
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
            for (Pacientes paciente : pacientes) {
                String id = paciente.getIdentificación();
                if (paciente.getIdentificación().equals(sel)) {
                    index = pacientes.indexOf(paciente);
                    existe = true;
                }
            }
            if (!existe) {
                JOptionPane.showMessageDialog(null, "Paciente seleccionado no existe");
            } else {
                boolean valido = false;
                String nombre = "";
                String apellidos = "";
                String genero = "";
                String edad = "";
                do {
                    nombre = JOptionPane.showInputDialog("*****Edicion de pacientes*****\n\n"
                            + "Ingrese Nombre del paciente");
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
                    apellidos = JOptionPane.showInputDialog("*****Edicion de pacientes*****\n\n"
                            + "Ingrese Apellido del paciente");
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
                    genero = JOptionPane.showInputDialog("*****Edicion de pacientes*****\n\n"
                            + "Ingrese Genero del paciente");
                    if (genero == "" || validaciones.valida(genero, 1)) {
                        if (genero == "") {
                            JOptionPane.showMessageDialog(null, "Debe ingresar un genero");
                        } else if (validaciones.valida(genero, 1)) {
                            JOptionPane.showMessageDialog(null, "El genero debe contener solo letras");
                        }
                        valido = false;
                    } else {
                        valido = true;
                    }
                } while (!valido);
                do {
                    edad = JOptionPane.showInputDialog("*****Edicion de pacientes*****\n\n"
                            + "Ingrese edad del paciente");
                    if (edad == "" || !validaciones.valida(edad, 2)) {
                        if (edad == "") {
                            JOptionPane.showMessageDialog(null, "Debe ingresar un edad");
                        } else if (!validaciones.valida(edad, 2)) {
                            JOptionPane.showMessageDialog(null, "La edad debe contener solo numeros");
                        }
                        valido = false;
                    } else {
                        valido = true;
                    }
                } while (!valido);
                pacientes.get(index).setNombres(nombre);
                pacientes.get(index).setApellidos(apellidos);
                pacientes.get(index).setGénero(genero);
                pacientes.get(index).setEdad(Integer.parseInt(edad));
            }
            JOptionPane.showMessageDialog(null, "Paciente modificado correctamente");
        }

    }

    @Override
    public void eliminar() {
        String sel = JOptionPane.showInputDialog("*****Ingrese el identificador del paciente a Eliminar*****\n"
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
            for (Pacientes paciente : pacientes) {
                String id = paciente.getIdentificación();
                if (paciente.getIdentificación().equals(sel)) {
                    index = pacientes.indexOf(paciente);
                    existe = true;
                }
            }
            if (!existe) {
                JOptionPane.showMessageDialog(null, "Paciente seleccionado no existe");
            } else {
                pacientes.remove(index);
            }
            JOptionPane.showMessageDialog(null, "Paciente eliminado correctamente");
        }
    }

}
