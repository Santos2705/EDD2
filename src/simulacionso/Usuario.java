/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacionso;


/**
 *
 * @author davidmizrahi
 */
public class Usuario {
    
    private String nombre;
    
    private String tipo_prioridad;
    
    private Lista<Documento> docs; 
    
    
    public Usuario(String nombre, String tipo_prioridad){
        
        this.nombre = nombre;
        
        this.tipo_prioridad = tipo_prioridad;
        
        this.docs = new Lista<Documento>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo_prioridad() {
        return tipo_prioridad;
    }

    public void setTipo_prioridad(String tipo_prioridad) {
        this.tipo_prioridad = tipo_prioridad;
    }

    public Lista<Documento> getDocs() {
        return docs;
    }

    public void setDocs(Lista<Documento> docs) {
        this.docs = docs;
    }

   
}
    


