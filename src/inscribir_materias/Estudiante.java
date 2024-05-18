package inscribir_materias;

import java.util.ArrayList;

public class Estudiante {
    private String codigo;
    private String nombre;
    private ArrayList<Materia> materiasMatriculadas;
    private int creditosMaximos;
    
    public Estudiante(String codigo, String nombre, int creditosMaximos) {
        if (codigo == null || codigo.isEmpty()) {
            throw new IllegalArgumentException("El código de estudiante no puede estar vacío.");
        }
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre de estudiante no puede estar vacío.");
        }
        if (creditosMaximos <= 0) {
            throw new IllegalArgumentException("Los créditos máximos deben ser un valor positivo.");
        }
        
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditosMaximos = 18;
        this.materiasMatriculadas = new ArrayList<>();
    }

    public boolean matricularMateria(Materia materia) {
        if (materia != null && creditosMaximos >= materia.getCreditos() && materia.getCupoMaximo() > 0) {
            for (Materia inscrita : materiasMatriculadas) {
                if (materia.conflictoHorario(inscrita)) {
                    System.out.println("Conflicto de horario con otra materia inscrita.");
                    return false;
                }
            }
            creditosMaximos -= materia.getCreditos();
            materiasMatriculadas.add(materia);
            materia.decrementarCupo();
            return true;
        } else {
            System.out.println("No se puede matricular la materia. Créditos insuficientes o no hay cupos disponibles.");
            return false;
        }
    }

    // Getters and other methods

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCreditosMaximos() {
        return creditosMaximos;
    }

    public ArrayList<Materia> getMateriasMatriculadas() {
        return materiasMatriculadas;
    }
}
