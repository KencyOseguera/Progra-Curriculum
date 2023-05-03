/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Noé Sosa
 */
import java.util.Scanner;

public class Ejercicio4 {
    
    public static void main(String[] args){
        
        Scanner console = new Scanner(System.in);
        
        //DECLARACION DE 3 VARIABLES STRING y también las inicialice
        String a = "";
        String b = "";
        String c = "";
        
        //PEDIR LAS TRES CADENAS AL USUARIO.
        System.out.println("Ingrese una cadena");
        a = console.nextLine();
        
        System.out.println("Ingrese una segunda cadena");
        b = console.nextLine();
        
        System.out.println("Ingrese una tercera cadena");
        c = console.nextLine();
        
        // PROCESO DE LAS PERMUTACIONES
        System.out.println("Las posibles permutaciones son: ");
        System.out.println(a+b+c);
        System.out.println(a+c+b);
        System.out.println(b+a+c);
        System.out.println(b+c+a);
        System.out.println(c+a+b);
        System.out.println(c+b+a);
        
        console.close(); // COMO BUENA PRACTICA DE PROGRAMACION
        
    }
}
