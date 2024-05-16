/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inscribir_materias;
import java.util.ArrayList;
/**
 *
 * @author VALENTINA
 */

public class Estudiante  {
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
        int creditosActuales = calcularCreditosMatriculados();
        if (creditosActuales + materia.getCreditos() > creditosMaximos) {
            System.out.println("El estudiante excede el número máximo de créditos.");
            return false;
        }

        for (Materia matricula : materiasMatriculadas) {
            if (hayConflictoHorarios(matricula, materia)) {
                System.out.println("Hay conflicto de horarios con otra materia matriculada.");
                return false;
            }
        }

        if (materia.getMateriasMatriculadas() >= materia.getCupoMaximo()) {
            System.out.println("La materia ha alcanzado su cupo máximo.");
            return false;
        }

        materiasMatriculadas.add(materia);
        materia.incrementarMateriasMatriculadas();
        System.out.println("Materia matriculada exitosamente.");
        return true;
    }

    private boolean hayConflictoHorarios(Materia materia1, Materia materia2) {
        // Lógica para verificar si hay conflicto de horarios entre dos materias
        return false; // Necesitas implementar la lógica adecuada
    }

    private int calcularCreditosMatriculados() {
        int totalCreditos = 0;
        for (Materia materia : materiasMatriculadas) {
            totalCreditos += materia.getCreditos();
        }
        return totalCreditos;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Materia> getMateriasMatriculadas() {
        return materiasMatriculadas;
    }

    public int getCreditosMaximos() {
        return creditosMaximos;
    }
}

