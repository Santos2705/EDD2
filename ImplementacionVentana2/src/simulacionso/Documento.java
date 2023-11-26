/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacionso;

/**
 *
 * @author davidmizrahi
 */
public class Documento {
    
    private String nombre;
    
    private int tamanio;
    
    private String tipo;
    

     public Documento(String nombre, int tamanio, String tipo){
        
        this.nombre = nombre;
        
        this.tamanio = tamanio;
        
        this.tipo = tipo;
    }
     
     public Documento(){
         
     };
     
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
 
    
    
   
}
