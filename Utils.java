/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 *
 * @author mjmedza
 */
public class Utils {
    
    public static final char ADD = '+';

    public static final char SUBTRACT = '-';

    public static final char MULTIPLY = '*';

    public static final char DIVIDE = '/';

    public static final char LEFT = '(';

    public static final char RIGHT = ')';
    
    /**
     *isOperator función que determina que operador utiliza el usuario.
     * @param token es el operador que introduce el usuario.
     * @return bolean para saber que operador es el que se está utilizando.
     */
    public static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
    
    /**
     *isMinorOperator función que determina la jerarquía de operadores.
     * @param token es la cadena de los de menor jerarquía.
     * @param operator es la cadena de los de mayor jerarquía.
     * @return
     */
    public static boolean isMinorOperator(String token, String operator) {
        if (token.equals("+") || token.equals("-")) {
            return false;
        } else {
            return !(operator.equals("*") || operator.equals("/"));
        }
    }
}
