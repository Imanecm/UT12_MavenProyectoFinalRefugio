/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USUARIO
 */
public class Voluntario extends Persona{
    
    private boolean disponible;
    enum Turno {MAÑANA, TARDE};
    private Turno turno;

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Voluntario() {
    }
    //Constructors

    public Voluntario(boolean disponible, Turno turno) {
        this.disponible = disponible;
        this.turno = turno;
    }

    public Voluntario(boolean disponible, Turno turno, String dni, String nomYApe, String direccion, String email, String telefono) {
        super(dni, nomYApe, direccion, email, telefono);
        this.disponible = disponible;
        this.turno = turno;
    }
    //toString

    @Override
    public String toString() {
        return "Voluntario{" + "disponible=" + disponible + ", turno=" + turno + '}';
    }
    
    
}
