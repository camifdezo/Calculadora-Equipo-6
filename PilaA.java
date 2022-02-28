/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectocalculadora;

/**
 *
 * @author romanzm
 * 
 */
public class PilaA <T> implements PilaADT <T>{
    private T[] pila;
    private int tope; // nos dice la pos del tope no el total
    private final int MAXIMO = 20;
    
    
    public PilaA(){
        pila=(T[]) new Object [MAXIMO]; //convertiendo el tipo T a object 
        tope=-1; //lo inicializamos asi porque como el arreglo esta vacio, no hay tope
    }

    @Override
    public void push(T dato) {
        if(tope == pila.length-1)
            expand();
        
        tope++;
        pila[tope]=dato;
    }
    
    // Método auxiliar para gnerar una pila más grande que la actual
    private void expand(){
        T[] nuevo = (T[]) new Object[pila.length * 2];
        
        for(int i=0;i<=tope;i++){
            nuevo[i]= pila[i];
        }
        pila = nuevo;
    }

    @Override
    public T pop() {
        if(this.isEmpty())
            throw new ColeccionVaciaException("Pila vacia");
        
        T resultado;
        resultado = pila[tope]; //asignamos a resultado la ultima pos del arre
        pila[tope]=null; 
        tope--;
        return resultado;
    }

    @Override
    public boolean isEmpty() {
        return tope == -1; //si el tope=-1 regresa verdadero
        
    }

    @Override
    public T peek() {
        if(this.isEmpty())
            throw new ColeccionVaciaException("Pila vacia"); 
        
        return pila[tope];
    }
    
    public String toString(){
        StringBuilder sb= new StringBuilder();
        
        for(int i=tope;i>=0;i--){
            sb.append(pila[i]).append("\n");
        }
        return sb.toString();
    }
     
}
