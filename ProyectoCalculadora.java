/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectocalculadora;

/**
 *
 * @author romanzm
 */
public class ProyectoCalculadora {
    private String cad;
    
    public ProyectoCalculadora(){
        
    }
    
    public ProyectoCalculadora(String cad){
        this.cad=cad;
    }
    
    
    
    private boolean analizaParentesis() throws Exception{
        boolean flag = true;
        int i=0;
        PilaA <Character> pila = new PilaA <Character> (); //creando e instanciando pila como variable local

        
         if(cad.equals("")){
            throw new ColeccionVaciaException("Cadena vacía");
        }
        
        
        while(i<cad.length() && flag){
            if(cad.charAt(i) == '('){
                pila.push(cad.charAt(i));
            }
            
            else if(cad.charAt(i) == ')'){
                if(pila.isEmpty()){
                    flag = false;
                }
                else{
                    pila.pop();
                }
            }
            
            i++;
        }
        
        if(!pila.isEmpty()){
            flag = false;
        }
        
        return flag;
    }
    
    private boolean isOperador(char operador){ //metodo aux
        
        return operador == '+'|| operador == '-' || operador == '*' || operador ==  '/' || operador == '^';
    }
    
    private int getPrioridad(char operador){
        int res=999;
        
        switch(operador){
            case '(':
                res = 0;
                break;
        
            case '^':
                res = 3;
                break;
                
            case '*':
            case '/':
                res = 2;
                break;
                
                
            case '+':
            case '-':
                res = 1;
                break;   
        }
        
        return res;
    }
    
     
    private boolean analizaOperadores(){
        boolean flag = true;
        int i=1;
        
        while(i<cad.length() && flag){
            if(isOperador(cad.charAt(i))){
                 if(isOperador(cad.charAt(i-1))){
                     flag = false;
                 }
            }
            i++;
        }
        return flag;
    }
    
    private boolean evaluaSintaxis() throws Exception{ //cambiar a privado
        boolean res = false;
        
        if(analizaParentesis() == true && analizaOperadores() == true){
            res = true;
        }
        
        return res;
    }
    
    //cambiar a privado
    public String convierteInfijaAPostfija() throws Exception {  
        StringBuilder sb = new StringBuilder();
        PilaA <Character> pilaOperador = new PilaA <Character> (); 
        PilaA <Character> postFija = new PilaA <Character> (); //esta cadena representa la postfija
        
        if(evaluaSintaxis() == true){
            
            for(int i=0;i<cad.length();i++){
                
                //Caso 1 que sea (
                if(cad.charAt(i) == '('){
                    pilaOperador.push(cad.charAt(i));
                }
                
                //Caso 2 que sea numero
                if(isOperador(cad.charAt(i)) == false && cad.charAt(i) != '(' && cad.charAt(i) != ')'){
                    sb.append(cad.charAt(i));
                    
                    
                }
                
                //Caso 3 que sea operador 
                if(isOperador(cad.charAt(i))){ 
                   while(!pilaOperador.isEmpty() && getPrioridad(cad.charAt(i)) <= getPrioridad(pilaOperador.peek())){
                       sb.append(pilaOperador.pop());
                       
                       
                   }
                   pilaOperador.push(cad.charAt(i));
                }
                
                //Caso 4 que sea )
                if(cad.charAt(i) == ')'){
                    while(pilaOperador.peek() != '('){
                        sb.append(pilaOperador.pop());
                        
                        
                    }
                    pilaOperador.pop();
                }
            }
            
            while(!pilaOperador.isEmpty()){
                sb.append(pilaOperador.pop());
                
            }
            
        }
        return sb.toString();
    }
    
    public double Calcular(){
        double res=0;
        
        return res;
    }
       
}
