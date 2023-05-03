/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarea_2_elmer.sosa;

import java.util.Scanner;

/**
 *
 * @author kency
 */
public class Tarea_2_elmerSosa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        String s1 ;
        String s2 ;
        String operando ;
        
        double num1 ;
        double num2;
        double resultado = 0;
        
        System.out.println("*-------------------------------------*");
        System.out.println("\t\tBienvenido");
        System.out.println("*-------------------------------------*");
        System.out.println("Ingrese una cadena -- (con espacios)");
        System.out.println("Ejemplo 3 + 2");
        
        /*-----------------------------------------------------------*/
        //Aqui obtengo los valores separados de la cadena:
        s1 = in.next();
        operando = in.next();
        s2 = in.next();
        /*-----------------------------------------------------------*/
        //Conversión de los numeros para poder usarlos en las operaciones.
        
        num1 = Double.parseDouble(s1);
        num2 = Double.parseDouble(s2);
        
        switch( operando ){
            case "+":
                resultado = num1 + num2;
                break;
            case "-":
                resultado = num1 - num2;
                break;
            case "*":
                resultado = num1 * num2;
                break;
            case "/":
                resultado = num1 / num2;
                break;
                //Nota: no estoy exceptuando el hecho de que se divida sobre 0.
            default:
                System.out.println("No tiene una opción valida");
                    
        }
        
        System.out.println("Por tanto su resultado es: "+resultado);
        System.out.println("Gracias por usar mi programa");
        
        in.close();//como buena práctica de programación
        
        
        
    }
    
}
