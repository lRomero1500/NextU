/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import javax.swing.JOptionPane;
import solicitudes.SolHistClinic;
import solicitudes.SolMedicos;
import solicitudes.SolPacientes;

/**
 *
 * @author luisd
 */
public class Menu {

    private static Menu instMenu;
    private SolPacientes solpac;
    private SolMedicos solMed;
    private SolHistClinic solHist;
    private Menu() {
        solpac= new SolPacientes();
        solMed= new SolMedicos();
        solHist = new SolHistClinic();
    }

    public static Menu getInstMenu() {
        if (instMenu == null) {
            instMenu = new Menu();
        }
        return instMenu;
    }

    public void menuPrincipal() {
        int op = 0;

        do {
            String sel = JOptionPane.showInputDialog("*****Menu Principal*****"
                    + "\n\n1.Gestionar Pacientes.\n"
                    + "\n\n2.Gestionar Médicos.\n"
                    + "\n\n3.Gestionar Historial Clínico.\n"
                    + "\n\n4.Salir\n\n");
            if ((sel == null) || (sel.equals(""))) {
                JOptionPane.showMessageDialog(null, "Debe ingresar una opcion");
            } else {
                try {
                    op = Integer.parseInt(sel);
                } catch (NumberFormatException excepcion) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar solo numeros");
                }

                if ((op >= 1 && op <= 3)) {
                    menuSecundario(op);
                } else if (op != 4) {
                    JOptionPane.showMessageDialog(null, "Opcion Invalida!");
                }
            }

        } while (op != 4);
    }

    public void menuSecundario(int op1) {
        int op2 = 0;
        switch (op1) {
            case 1:
                op2 = Integer.parseInt(JOptionPane.showInputDialog("*****Menu de Gestion*****"
                        + "\n\n1.Registrar Pacientes\n"
                        + "\n\n2.Mostrar Pacientes\n"
                        + "\n\n3.Modificar Paciente\n"
                        + "\n\n4.Eliminar Paciente\n"
                        + "\n\n5.Atrás\n\n"));
                break;
            case 2:
                op2 = Integer.parseInt(JOptionPane.showInputDialog("*****Menu de Gestion*****"
                        + "\n\n1.Registrar Médicos\n"
                        + "\n\n2.Mostrar Médicos\n"
                        + "\n\n3.Modificar Médicos\n"
                        + "\n\n4.Eliminar Médicos\n"
                        + "\n\n5.Atrás\n\n"));
                break;
            case 3:
                op2 = Integer.parseInt(JOptionPane.showInputDialog("*****Menu de Gestion*****"
                        + "\n\n1.Registrar Historial Clínico\n"
                        + "\n\n2.Mostrar Historial Clínico\n"
                        + "\n\n3.Modificar Historial Clínico\n"
                        + "\n\n4.Eliminar Historial Clínico\n"
                        + "\n\n5.Atrás\n\n"));
                break;
        }

        while (op2 != 5) {
            switch (op2) {
                case 1:
                    if(op1==1)
                        solpac.registrar();
                    else if(op1==2)
                        solMed.registrar();
                    else if (op1==3)
                        solHist.registrar();
                    break;
                case 2:
                    if(op1==1)
                        solpac.mostrar();
                    else if(op1==2)
                        solMed.mostrar();
                    else if (op1==3)
                        solHist.mostrar();
                    break;
                case 3:
                    if(op1==1)
                        solpac.modificar();
                    else if(op1==2)
                        solMed.modificar();
                    else if (op1==3)
                        solHist.modificar();
                    break;
                case 4:
                    if(op1==1)
                        solpac.eliminar();
                    else if(op1==2)
                        solMed.eliminar();
                    else if (op1==3)
                        solHist.eliminar();
                    break;
            }
            break;
        }
    }
}
