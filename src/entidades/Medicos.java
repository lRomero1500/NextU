/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author luisd
 */
public class Medicos {

    private String identificacion, nombres, apellidos, especialidad;

    public Medicos(String identificacion, String nombres, String apellidos, String especialidad) {
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.especialidad = especialidad;
    }

    public String getIdentificación() {
        return identificacion;
    }

    public void setIdentificación(String identificación) {
        this.identificacion = identificación;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getMedicoLista() {
        return this.identificacion + ". " + this.nombres + " " + this.apellidos + " " + this.especialidad + "\n";
    }
}
