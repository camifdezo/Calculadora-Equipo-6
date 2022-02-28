/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectocalculadora;

/**
 *
 * @author romanzm
 */
public class ColeccionVaciaException extends RuntimeException{
    public ColeccionVaciaException(){
        super();
    }
    
    public ColeccionVaciaException(String mensaje){
        super(mensaje);
    }
    
}
