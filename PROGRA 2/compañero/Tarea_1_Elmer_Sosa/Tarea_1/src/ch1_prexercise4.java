/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Noé Sosa
 */

    // a)
    import java.util.Scanner;
    
public class ch1_prexercise4 {
    
    public static void main(String[] args) {
        // b)
        Scanner console = new Scanner(System.in);
        
        // C)
        final int SECRET = 11;
        final double RATE = 12.50;
        
        // d)
        int num1;
        int num2;
        int newNum;
        
        String name;
        
        double hoursWorked;
        double wages;
        
        // e)
        System.out.println("Digite un número: ");
        num1 = console.nextInt();
        
        System.out.println("Digite otro número: ");
        num2 = console.nextInt();
        
        // f)
        System.out.println("The value of num1 = "+ num1 +" and the value of num2 = "+ num2);
        
        // g)
        newNum = (num1*2) + num2;
        
        System.out.println("The value of newNum = "+ newNum);
        
        // h)
        newNum = newNum + SECRET;
        
        System.out.println("The new value of newNum is: "+ newNum);
        console.nextLine();
        // i)
        System.out.println();
        
        System.out.println("Ingrese el apellido de una persona: ");
        name = console.nextLine();
        
        // j)
        System.out.println("Ingrese un numero decimal entre 0 y 70");
        hoursWorked = console.nextDouble();
        
        // k)
        wages = RATE * hoursWorked;
        
        // l)
        System.out.println("Name: "+name);
        System.out.println("Pay Rate: $"+RATE);
        System.out.println("Hours Worked: "+hoursWorked);
        System.out.println("Salary: $"+wages);
        
        console.close();//como buena práctica de programación
        
    }
}
