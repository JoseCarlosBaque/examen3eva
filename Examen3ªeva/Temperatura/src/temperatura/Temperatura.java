/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temperatura;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class Temperatura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lector;
        Scanner reader = new Scanner(System.in);
        System.out.println("Dime el nombre del archivo");
        String path = reader.next();
        ArrayList<Integer> numeritos = new ArrayList<Integer>();
        int temp_max_alta, tem_max_baja, temp_min_alta, temp_min_baja;
        try {
            lector = new Scanner(new File("tenerife\\" + path));
            while (lector.hasNext()) {
                String palabra = lector.next();
                String[] palabras = palabra.split(" ");
                String numero = String.valueOf(palabras);
                int numeros = Integer.parseInt(numero);
                numeritos.add(numeros);
            }
            for (int i = 0; i < numeritos.size(); i++) {
                System.out.println(numeritos);
            }
        } catch (Exception e) {
            System.out.println("Archivo no encontrado");
        }
    }

}
