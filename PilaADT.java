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
public interface PilaADT<T> {
    
    /**
     * Adds element to the top of the stack.
     * @param element element to be pushed into stack. 
     */
    public void push(T element);
    
    /**
     * Removes and returns the top element of the stack.
     * @return T element removed from the stack.
     * @throws java.lang.Exception
     */
    public T pop() throws Exception;
    
    /**
     * 
     * @return T top element from the stack.
     * @throws java.lang.Exception
     */
    public T peek() throws Exception;
    
    /**
     * 
     * @return if stack is empty
     */
    public boolean isEmpty();
    
    /**
     * 
     * @return stack's current size.
     */
    public int size();
    
    /**
     *
     * @return
     */
    @Override
    public String toString();
}

