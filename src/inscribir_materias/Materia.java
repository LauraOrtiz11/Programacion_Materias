package inscribir_materias;

public class Materia {
    private String nombre;
    private int creditos;
    private int cupoMaximo;
    private String horario;
    private int materiasMatriculadas;

    public Materia(String nombre, int creditos, int cupoMaximo, String horario) {
        this.nombre = nombre;
        this.creditos = creditos;
        this.cupoMaximo = cupoMaximo;
        this.horario = horario;
        this.materiasMatriculadas = 0;
    }

    // Constructor vacío
    public Materia() {
    }

    public String getNombre() {
        return nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public String getHorario() {
        return horario;
    }

    public int getMateriasMatriculadas() {
        return materiasMatriculadas;
    }

    public void incrementarMateriasMatriculadas() {
        this.materiasMatriculadas++;
    }
    
    public void decrementarCupo() {
        this.cupoMaximo--;
    }
}
