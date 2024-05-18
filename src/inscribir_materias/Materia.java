package inscribir_materias;

// Clase Materia con métodos adicionales
class Materia {
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
            return -1; // Indica que no hay cupos disponibles
        }
    }

    // Método para verificar si hay conflicto de horario con otra materia
    public boolean conflictoHorario(Materia otraMateria) {
        return this.horario.equalsIgnoreCase(otraMateria.getHorario());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Materia materia = (Materia) obj;
        return nombre.equals(materia.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }
}