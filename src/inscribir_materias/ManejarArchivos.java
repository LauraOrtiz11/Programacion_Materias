package inscribir_materias;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ManejarArchivos {

    public void crearArchivo() {
        // Datos de ejemplo
        String[] materias = {"Cálculo Integral 301", "Cálculo Integral 302", "Programación II 301", "Programación II 302", "Física II 301", "Física II 302", "Lectura M1", "Lectura T1", "Inglés M1", "Inglés T1", "Ciudadanía M1", "Ciudadanía T1"};
        int[] creditos = {4, 4, 3, 3, 4, 4, 2, 2, 2, 2, 2, 2};
        int[] cupos = {30, 30, 30, 30, 30, 30, 40, 40, 40, 40, 40, 40,};
        String[] horarios = {"Martes: 11:00 - 13:00", "Miércoles: 11:00 - 13:00", "Lunes: 07:00 - 10:00", "Martes: 07:00 - 09:00", "Lunes: 10:00 - 12:00", "Lunes: 10:00 - 12:00", "Jueves: 07:00 - 09:00", "Jueves: 15:00 - 17:00", "Lunes: 10:00 - 12:00", "Jueves: 15:00 - 17:00", "Jueves: 11:00 - 13:00", "Viernes: 13:00 - 15:00"};

        // Ruta del archivo
        String rutaArchivo = "datos_materias.txt";

        try {
            // Crear FileWriter con el nombre del archivo
            FileWriter fileWriter = new FileWriter(rutaArchivo);

            // Crear BufferedWriter para escribir en el archivo
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Escribir los datos en el archivo
            for (int i = 0; i < materias.length; i++) {
                bufferedWriter.write("Materia: " + materias[i] + "\n");
                bufferedWriter.write("Créditos: " + creditos[i] + "\n");
                bufferedWriter.write("Cupos: " + cupos[i] + "\n");
                bufferedWriter.write("Horario: " + horarios[i] + "\n");
                bufferedWriter.write("\n"); // Separador entre cada entrada
            }

            // Cerrar BufferedWriter
            bufferedWriter.close();

            System.out.println("Archivo creado satisfactoriamente.");

        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}