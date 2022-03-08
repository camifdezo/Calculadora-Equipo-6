/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadora;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author camilafernandez
 */
public class Calculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Caratula.main(args);
        System.out.println(new PostfixEv().evaluate(new InfixEv().evaluate("6 + 9 * 9")));
        //System.out.println(new InfixEvaluator().evaluate("1.5 + 2"));
        System.out.println(new PostfixEv().evaluate("5 7 8 - / 4 + 9 1 + *"));
        
        //comenzaremos haciendo pruebas desde aquí en lugar de la interfaz para que sea claro
        //NOTA: se los damos como string por la naturaleza de nuestro programa.
        
        //pruebas con multiplicacion
        System.out.println(new PostfixEv().evaluate(new InfixEv().evaluate("101 * 9")));
        
        //pruebas con suma
        System.out.println(new PostfixEv().evaluate(new InfixEv().evaluate("45 + 101")));
        
        //pruebas con resta
        System.out.println(new PostfixEv().evaluate(new InfixEv().evaluate("82 - 109")));
        
        //pruebas con división
        System.out.println(new PostfixEv().evaluate(new InfixEv().evaluate("780 / 15")));
        
        //pruebas con jerarquía de operandos
        System.out.println(new PostfixEv().evaluate(new InfixEv().evaluate("2 + 3 * 4 - 5 / 5")));
        
        //pruebas con paréntesis
        System.out.println(new PostfixEv().evaluate(new InfixEv().evaluate("( ( ( 3 + 4 ) + ( 4 - 3 ) ) * ( 2 + 1 ) )")));
    }
}
    
