/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inscribir_materias;
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author VALENTINA
 */

public class Estudiante implements Serializable {
    private String codigo;
    private String nombre;
    private ArrayList<Materia> materiasMatriculadas;
    
    private int creditosMaximos;

    public Estudiante(String codigo, String nombre, int creditosMaximos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditosMaximos = creditosMaximos;
        this.materiasMatriculadas = new ArrayList<>();
    }

    
    public boolean matricularMateria(Materia materia) {
        // Verificar si el estudiante excede los créditos máximos
        int creditosActuales = calcularCreditosMatriculados();
        if (creditosActuales + materia.getCreditos() > creditosMaximos) {
            System.out.println("El estudiante excede el número máximo de créditos.");
            return false;
        }

        // Verificar si hay conflicto de horarios
        for (Materia matricula : materiasMatriculadas) {
            if (hayConflictoHorarios(matricula, materia)) {
                System.out.println("Hay conflicto de horarios con otra materia matriculada.");
                return false;
            }
        }

        // Verificar si se excede el cupo máximo de la materia
        if (materia.getMateriasMatriculadas() >= materia.getCupoMaximo()) {
            System.out.println("La materia ha alcanzado su cupo máximo.");
            return false;
        }

        // Matricular la materia
        materiasMatriculadas.add(materia);
        materia.incrementarMateriasMatriculadas();
        System.out.println("Materia matriculada exitosamente.");
        return true;
    }

    private boolean hayConflictoHorarios(Materia materia1, Materia materia2) {
        // Lógica para verificar si hay conflicto de horarios entre dos materias
    }

    private int calcularCreditosMatriculados() {
        int totalCreditos = 0;
        for (Materia materia : materiasMatriculadas) {
            totalCreditos += materia.getCreditos();
        }
        return totalCreditos;
    }
        // Método para mostrar las materias matriculadas
    public void mostrarMateriasMatriculadas() {
        if (materiasMatriculadas.isEmpty()) {
            System.out.println("El estudiante no tiene materias matriculadas.");
        } else {
            System.out.println("Materias matriculadas por " + nombre + ":");
            for (Materia materia : materiasMatriculadas) {
                System.out.println("Nombre: " + materia.getNombre());
                System.out.println("Créditos: " + materia.getCreditos());
                System.out.println("Cupo máximo: " + materia.getCupoMaximo());
                System.out.println("Horario: " + materia.getHorario());
                System.out.println();
            }
        }
    }
    
}

