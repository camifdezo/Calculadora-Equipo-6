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
public class InfixEv {
    
    private Pila<String> pila;
    
    /**
     *
     */
    public InfixEv() {
        pila = new Pila<>();
    }
    
    /**
     *evalute método que recibe una cadena de caracteres y los convierte a expresión infija.
     * @param expression operacion introducida por el ususario.
     * @return regresa la cadena de caracteres en notacion infija.
     */
    public String evaluate(String expression) {
        String token;
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer tokenizer = new StringTokenizer(expression);
        
        while (tokenizer.hasMoreTokens()) {
            token = tokenizer.nextToken();
            if (token.equals("(")) {
                pila.push(token);
            } else if (token.equals(")")) {
                try {
                    String pop = pila.pop();
                    while (!pop.equals("(")) {
                        stringBuilder.append(pop).append(" ");
                        pop = pila.pop();
                    }
                } catch (EmptyCollectionException ex) {
                    Logger.getLogger(InfixEv.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (Utils.isOperator(token)) {
                if (!pila.isEmpty()) {
                    String top = pila.peek();
                    while (!top.equals("(") && !pila.isEmpty()) {
                        if (Utils.isOperator(top) && !Utils.isMinorOperator(token, top)) {
                            stringBuilder.append(pila.pop()).append(" ");
                            if (!pila.isEmpty())
                                top = pila.peek();
                            else
                                break;
                        } else
                            break;
                    }
                }
                pila.push(token);
            } else {
                stringBuilder.append(token).append(" ");
            }
        }
        
        if (!pila.isEmpty()) {
            for (int i = 0; i <= pila.size(); i++) {
                stringBuilder.append(pila.pop()).append(" ");
                
            }
        }
        
        return stringBuilder.toString();
    }
}

