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

import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mjmedza
 */
public class PostfixEv {
        
    private Pila<Float> pila;

    /**
     *
     */
    public PostfixEv() {
        pila = new Pila<>();
    }
    
    /**
     *evalute es una función que regresa el resultado de la operación.
     * @param expression es la operación introducida por el usuario.
     * @return el resultado de la operación.
     */
    public float evaluate(String expression) {
        float operator1, operator2, result = 0;
        String token;
        StringTokenizer tokenizer = new StringTokenizer(expression);
        while (tokenizer.hasMoreTokens()){
            token = tokenizer.nextToken();
            
            if (Utils.isOperator(token)) {
                try {
                    operator2 = pila.pop();
                    operator1 = pila.pop();
                    result = evaluateOperation(token.charAt(0), operator1, operator2);
                    pila.push(result);
                } catch (EmptyCollectionException ex) {
                    Logger.getLogger(PostfixEv.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                pila.push(Float.parseFloat(token));
            }
        }
        return pila.pop();
    }
    
    /**
     *evaluteOperation es la funcion que resuelve por operaciones de únicamente dos números.
     * @param operand es el operando.
     * @param operator1 es el primer número.
     * @param operator2 es el segundo número.
     * @return regresa el resultado de la operación de dos números.
     */
    public float evaluateOperation(char operand, float operator1, float operator2) {
        switch (operand) {
            case Utils.ADD:
                return operator1 + operator2;
            case Utils.SUBTRACT:
                return operator1 - operator2;
            case Utils.MULTIPLY:
                return operator1 * operator2;
            case Utils.DIVIDE:
                return operator1 / operator2;
            default:
                return 0;
        }
    }
    
}

