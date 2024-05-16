/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inscribir_materias;
import java.io.*;
/**
 *
 * @author VALENTINA
 */
public class ManejarArchivos {
   
    public static void escribirObjeto(Object objeto, String ruta) {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(ruta))) {
            salida.writeObject(objeto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object leerObjeto(String ruta) {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(ruta))) {
            return entrada.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}


