package inscribir_materias;

import java.io.*;

public class ManejarArchivos {
    private final String rutaArchivo = "datos_materias.txt";

    // Método para crear el archivo de materias
    public void crearArchivo() {
        String[] materias = {"Calculo-Integral-301", "Calculo-Integral-302", "Programacºion-II-301", "Programacion-II-302", "Fisica-II-301", "Fisica-II-302", "Lectura-M1", "Lectura-T1", "Ingles-M1", "Ingles-T1", "Ciudadania-M1", "Ciudadania-T1"};
        int[] id = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int[] creditos = {4, 4, 3, 3, 4, 4, 2, 2, 2, 2, 2, 2};
        int[] cupos = {30, 30, 30, 30, 30, 30, 40, 40, 40, 40, 40, 40};
        String[] horarios = {"Martes:11:00-13:00", "Miércoles:11:00-13:00", "Lunes:07:00-10:00", "Martes:07:00-09:00", "Lunes:10:00-12:00", "Lunes:10:00-12:00", "Jueves:07:00-09:00", "Jueves:15:00-17:00", "Lunes:10:00-12:00", "Jueves:15:00-17:00", "Jueves:11:00-13:00", "Viernes:13:00-15:00"};

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (int i = 0; i < materias.length; i=i+1) {
                bufferedWriter.write("Materia: " + materias[i] + "\n");
                bufferedWriter.write("ID: " + id[i] + "\n");
                bufferedWriter.write("Créditos: " + creditos[i] + "\n");
                bufferedWriter.write("Cupos: " + cupos[i] + "\n");
                bufferedWriter.write("Horario: " + horarios[i] + "\n");
                bufferedWriter.write("\n"); // Separador entre cada entrada
            }
            System.out.println("Archivo creado satisfactoriamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}