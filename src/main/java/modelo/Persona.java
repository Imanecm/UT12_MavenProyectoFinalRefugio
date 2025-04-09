/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.rmi.server.ObjID;

/**
 *
 * @author usuario
 */
public abstract class Persona implements Comparable<Persona>, Serializable{
    private String dni;
    private String nomYApe;
    private String direccion;
    private String telefono;
    private String email;
    
    
    //Constructor
    public Persona() {
    }

    public Persona(String nomYApe) {
        this.nomYApe = nomYApe;
    }
    
    public Persona(String dni, String nomYApe, String direccion, String email, String telefono) {
        this.dni = dni;
        this.nomYApe = nomYApe;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
    }
    //Getter and Setter

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNomYApe() {
        return nomYApe;
    }

    public void setNomYApe(String nomYApe) {
        this.nomYApe = nomYApe;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    //toString

    @Override
    public String toString() {
        return "Persona{" + "email=" + email + ", telefono=" + telefono + ", dni=" + dni + ", nomYApe=" + nomYApe + ", direccion=" + direccion + '}';
    }
    
    @Override
    public int compareTo(Persona per) {
        return nomYApe.compareToIgnoreCase(per.getNomYApe());
    }
    
}
