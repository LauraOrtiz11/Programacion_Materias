/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inscribir_materias;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author VALENTINA
 */
public class ManejarArchivos {
   
    
    static void crear(){
        String dato; //variable para almacenar nombre y apellido
        String cadena; //nombre;apellido;
        FileWriter fichero = null;  //objeto principal (archivo)
        PrintWriter linea = null;   //objeto de contenido de archivo
        
        try{
            fichero = new FileWriter("d:/Prog2024.txt",true); //crea el archivo 
            linea = new PrintWriter(fichero); //apunta el PrintWriter al archivo creado
            // Inicia captura de datos del usuario
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Digite nombre:");
            dato = br.readLine();
            cadena = dato + "#";
            System.out.println("Digite apellido:");
            dato = br.readLine();
            cadena = cadena + dato + "#";
            System.out.println("Digite correo:");
            dato = br.readLine();
            cadena = cadena + dato + "#";
            System.out.println("Digite edad:");
            dato = br.readLine();
            cadena = cadena + dato + "#";
            
            linea.println(cadena); //escribiendo en el archivo
            
      }catch(IOException e){
           System.out.print("Error creando archivo");
        }
        finally{
            try{
                if(fichero != null){
                    fichero.close();
                }
            }catch(IOException e1){
                System.out.print("Error cerrando archivo");
            }
        }
        
    
    }
    private static void printPaths(File file) throws IOException {
		System.out.println("Absolute Path: " + file.getAbsolutePath());
		System.out.println("Canonical Path: " + file.getCanonicalPath());
		System.out.println("Path: " + file.getPath());
    }    
    static void mostrar(){
        File archivo = null;  //apuntar al archivo almancenado DD
        FileReader contenido = null;  //acceder a todo el contenido del archivo
        BufferedReader linea = null; //accede linea a linea al contenido
        
        try{
            archivo = new File("d:/Prog2024.txt");
            //printPaths(archivo);
            contenido = new FileReader(archivo);
            linea = new BufferedReader(contenido);
            
            String cadena=""; //variable captura los datos del archivo
            while((cadena=linea.readLine()) != null){ //recorre todo el archivo
                String dato[] = cadena.split("#");
                System.out.println("Nombre: "+ dato[0]);
                System.out.println(" Apellido: "+ dato[1]);  
                System.out.println(" Correo: "+ dato[2]);
                System.out.println(" Edad: "+ dato[3]);
                System.out.println(" ********** ");
            }
         }catch(IOException e){
           System.out.print("Error abriendo archivo");
        }
        finally{
            try{
                if(contenido != null){
                    contenido.close();
                }
            }catch(IOException e1){
                System.out.print("Error cerrando archivo");
            }
        }
    }
    static void buscar(String filtro, int index){
        File archivo = null;  //apuntar al archivo almancenado DD
        FileReader contenido = null;  //acceder a todo el contenido del archivo
        BufferedReader linea = null; //accede linea a linea al contenido
        
        try{
            archivo = new File("d:/Prog2024.txt");
            contenido = new FileReader(archivo);
            linea = new BufferedReader(contenido);
            
            String cadena=""; //variable captura los datos del archivo
            while((cadena=linea.readLine()) != null){ //recorre todo el archivo
                String dato[] = cadena.split("#");
                if(dato[index].contains(filtro)){
                    System.out.println("Nombre: "+ dato[0]);
                    System.out.println(" Apellido: "+ dato[1]);  
                    System.out.println(" Correo: "+ dato[2]);
                }   
            }
         }catch(IOException e){
           System.out.print("Error consultando archivo");
        }
        finally{
            try{
                if(contenido != null){
                    contenido.close();
                }
            }catch(IOException e1){
                System.out.print("Error cerrando archivo");
            }
        }
    }
   
    public static void main(String[] args) {
           try {
         
            crear();
            crear();
            crear();
           // mostrar();
            //datos dt = new datos();
            //dt.crear();
            //Persona p = new Persona();.
            //ArrayList<Persona> p = new ArrayList<Persona>();
            //p = dt.mostrar();
           
            //for (int i = 0; i < p.size(); i++) {
            //    System.out.println(p.get(i).getNombre());
           //}
            // System.out.println(p.getNombre());             
             System.out.println("================");
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             System.out.println("Digite criterio (0 - nombre / 1 -apellido / 2 - correo)");             
             String dato = br.readLine();
             int criterio = Integer.parseInt(dato);
             System.out.println("Digite el elemento a buscar");             
             dato = br.readLine();
             
             buscar(dato,criterio);
             System.out.println("================");
             
         } catch (IOException ex) {
             Logger.getLogger(ManejarArchivos.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}



