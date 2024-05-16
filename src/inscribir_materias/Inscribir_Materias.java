/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inscribir_materias;

/**
 * @author VALENTINA
 */
import java.util.ArrayList;
public class Inscribir_Materias {
    
    public static void main(String[] args) {
      Estudiante estudiante = new Estudiante("001", "Juan", 20);
    ArrayList<Materia> listaMaterias = new ArrayList<>();

        // Agregar materias a la lista
        listaMaterias.add(new Materia("Cálculo II", 4, 30, "Lunes 10:00 - 12:00"));
        listaMaterias.add(new Materia("Física II", 3, 25, "Martes 14:00 - 16:00"));
        listaMaterias.add(new Materia("Programación", 2, 20, "Lunes 10:00 - 12:00"));
       

        // Mostrar la lista de materias
        System.out.println("Lista de materias:");
        for (Materia materia : listaMaterias) {
            System.out.println("Nombre: " + materia.getNombre());
            System.out.println("Créditos: " + materia.getCreditos());
            System.out.println("Cupo máximo: " + materia.getCupoMaximo());
            System.out.println("Horario: " + materia.getHorario());
            System.out.println();
        }

        // Crear y matricular materias
        Materia materia1 = new Materia("Matemáticas", 4, 30, "Lunes 10:00 - 12:00");
        Materia materia2 = new Materia("Física", 3, 25, "Martes 14:00 - 16:00");

        estudiante.matricularMateria(materia1);
        estudiante.matricularMateria(materia2);
        estudiante.mostrarMateriasMatriculadas();
    }
}
