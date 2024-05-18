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
