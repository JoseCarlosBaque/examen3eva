/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bombones;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class Bombones {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner lector;
        Scanner reader = new Scanner(System.in);
        boolean si_o_no = false;
        String alumno;
        HashMap<String, Integer> alumnado = new HashMap<>();
        System.out.println("¿Cuantos alumnos participan?");
        int participantes = reader.nextInt();
        int nº_random_participantes = (int) Math.floor(Math.random() * participantes);//hago un random para coger ese valor como maximo para agregar al hasmap
        System.out.println("¿Cuantos bombones por cabeza?");
        int max_bombon = reader.nextInt();
        int nº_random_bombones = (int) Math.floor(Math.random() * max_bombon);//hago un random para coger el numero de bombones por cabeza
        System.out.println("Escribe el nombre del alumno");
        alumno = reader.next();
        try {
            lector = new Scanner(new File("alumnos\\participants.csv"));
            while (lector.hasNext()) {
                String palabra = lector.nextLine();
                for (int i = 0; i < nº_random_participantes; i++) {//separo con el split las palabras del archivo
                    String[] palabras = palabra.split(" ");
                    String nombre = String.valueOf(Arrays.toString(palabras));
                    alumnado.put(nombre, nº_random_bombones);
                }
            }
            for (String e : alumnado.keySet()) {
                if (alumno == e) {
                    si_o_no = true;
                }
            }
            if (si_o_no == true) {
                System.out.println("El alumno: " + alumno + " recibe " + nº_random_bombones + " bombones");
            } else {
                System.out.println("El alumno no esta en la lista");
            }
            for (String h : alumnado.keySet()) {
                System.out.println(h + "  " + alumnado.get(h));//imprimo la lista para comprobar que se parten los nombres como yo quiero
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no Encontrado");
        }
    }

}
