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
 * @param <T>
 */
public class Pila<T> implements PilaADT<T> {
    
    private final int DEFAULT_CAPACITY = 100;
    private int top;
    private T[] pila;

    /**
     *
     */
    public Pila() {
        top = 0;
        pila = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     *
     * @param initialCapacity
     */
    public Pila(int initialCapacity) {
        top = 0;
        pila = (T[]) new Object[initialCapacity];
    }
    
    /**
     *
     * @param element
     */
    @Override
    public void push(T element) {
        if (size() == pila.length) 
            expandCapacity();
        
        pila[top] = element;
        top++;
    }

    /**
     *
     * @return
     */
    @Override
    public T pop() {
        if (isEmpty())
            throw new EmptyCollectionException("Pila");
        
        top--;
        T result = pila[top];
        pila[top] = null;
        return result;
    }

    /**
     *
     * @return
     */
    @Override
    public T peek() {
        if (isEmpty())
            throw new EmptyCollectionException("Pila");
        
        return pila[top-1];
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return pila[0] == null || pila == null;
    }

    /**
     *
     * @return
     */
    @Override
    public int size() {
        return top;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = size() -1; i >= 0; i--) {
            stringBuilder.append(pila[i]).append("\n");
        }
        return stringBuilder.toString();
    }
    
    private void expandCapacity() {
        T[] temporalPila = (T[]) new Object[pila.length*2];
        for (int i = 0; i < pila.length; i++) {
            temporalPila[i] = pila[i];
        }
        pila = temporalPila;
    }
    
}
