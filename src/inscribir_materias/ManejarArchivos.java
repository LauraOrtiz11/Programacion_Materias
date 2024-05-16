package inscribir_materias;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ManejarArchivos {

    public void crearArchivo() {

        String[] materias = {"Cálculo Integral 301", "Cálculo Integral 302", "Programación II 301", "Programación II 302", "Física II 301", "Física II 302", "Lectura M1", "Lectura T1", "Inglés M1", "Inglés T1", "Ciudadanía M1", "Ciudadanía T1"};
        int[] id = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
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
                bufferedWriter.write("ID: " + id[i] + "\n");
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

    String rutaMatricula = "matricula.txt";
    
    public void matriEstudiante(){
        FileWriter fichero = null;
        PrintWriter linea = null;

        try {
            fichero = new FileWriter(rutaMatricula, true); 
            linea = new PrintWriter(fichero); // apunta el PrintWriter al archivo creado
            
            // Inicia captura de datos del usuario
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            // Captura los datos del estudiante
            System.out.println("Digite codigo:");
            String codigo = br.readLine();
            System.out.println("Digite nombre:");
            String nombre = br.readLine();
            System.out.println("Digite creditos maximos:");
            int creditosMaximos = Integer.parseInt(br.readLine());
            
            Estudiante estudiante = new Estudiante(codigo, nombre, creditosMaximos);

            // Captura las materias
            while (true) {
                System.out.println("¿Desea agregar una materia? (si/no):");
                String respuesta = br.readLine();
                if (!respuesta.equalsIgnoreCase("si")) {
                    break;
                }
                
                System.out.println("Digite nombre de la materia:");
                String nombreMateria = br.readLine();
                System.out.println("Digite creditos de la materia:");
                int creditos = Integer.parseInt(br.readLine());
                System.out.println("Digite cupo maximo de la materia:");
                int cupoMaximo = Integer.parseInt(br.readLine());
                System.out.println("Digite horario de la materia:");
                String horario = br.readLine();

                Materia materia = new Materia(nombreMateria, creditos, cupoMaximo, horario);
                estudiante.matricularMateria(materia);
            }

            // Escribiendo los datos del estudiante y sus materias en el archivo
            linea.println("Codigo: " + estudiante.getCodigo());
            linea.println("Nombre: " + estudiante.getNombre());
            linea.println("Creditos Maximos: " + estudiante.getCreditosMaximos());
            linea.println("Materias Matriculadas:");

            for (Materia materia : estudiante.getMateriasMatriculadas()) {
                linea.println("  - Nombre: " + materia.getNombre());
                linea.println("    Creditos: " + materia.getCreditos());
                linea.println("    Cupo Maximo: " + materia.getCupoMaximo());
                linea.println("    Horario: " + materia.getHorario());
            }
            
        } catch(IOException e) {
            System.out.print("Error creando archivo");
        } finally {
            try {
                if(fichero != null) {
                    fichero.close();
                }
            } catch(IOException e1) {
                System.out.print("Error cerrando archivo");
            }
        }
    }
}
