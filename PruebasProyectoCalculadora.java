/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectocalculadora;

/**
 *
 * @author romanzm
 */

public class PruebasProyectoCalculadora {
    public static void main(String[] args) {
        
        //Pruebas para evaluar sintaxis
        /*
        ProyectoCalculadora c1 = new ProyectoCalculadora("(a+b)");
        ProyectoCalculadora c2 = new ProyectoCalculadora("(a+b");
        ProyectoCalculadora c3 = new ProyectoCalculadora("(a+-b)");
        ProyectoCalculadora c4 = new ProyectoCalculadora("");
       
        try{
             System.out.println("CP1: "+c1.evaluaSintaxis());
             System.out.println("CP2: "+c2.evaluaSintaxis());
             System.out.println("CP3: "+c3.evaluaSintaxis());
             System.out.println("CP4: "+c4.evaluaSintaxis());
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        */
        
        //Pruebas para convertir de infija a postfija
        ProyectoCalculadora c5 = new ProyectoCalculadora("(((5+9)*2)+(6*5))");
        
        try{
            
            System.out.println(c5.convierteInfijaAPostfija());
            
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
