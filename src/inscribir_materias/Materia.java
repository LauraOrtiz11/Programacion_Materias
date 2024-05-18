package inscribir_materias;

public class Materia {
    private String nombre;
    private int creditos;
    private int cupoMaximo;
    private String horario;
  

    public Materia(String nombre, int creditos, int cupoMaximo, String horario) {
        this.nombre = nombre;
        this.creditos = creditos;
        this.cupoMaximo = cupoMaximo;
        this.horario = horario;

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

    public int decrementarCupo() {
        if (cupoMaximo > 0) {
            cupoMaximo--;
            return cupoMaximo;
        } else {
            return -1; // Devolver un valor negativo para indicar que no hay cupo disponible
        }
    }


}

