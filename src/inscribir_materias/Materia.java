/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inscribir_materias;


/**
 *
 * @author VALENTINA
 */

public class Materia {
    
    private String nombre;
    private int creditos;
    private int cupoMaximo;
    private String horario;
    private int materiasMatriculadas;

    // Constructor, getters y setters
        public Materia(String nombre, int creditos, int cupoMaximo, String horario) {
        this.nombre = nombre;
        this.creditos = creditos;
        this.cupoMaximo = cupoMaximo;
        this.horario = horario;
        this.materiasMatriculadas = 0;
    }
        
    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    public int getMateriasMatriculadas() {
        return materiasMatriculadas;
    }

    public void incrementarMateriasMatriculadas() {
        materiasMatriculadas++;
    }
}


