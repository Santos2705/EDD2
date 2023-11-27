/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacionso;


public class RegistroDocs {
    
    private Documento documento;
    
    private long tiempoTranscurrido;

    
    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public long getTiempoTranscurrido() {
        return tiempoTranscurrido;
    }

    public void setTiempoTranscurrido(long tiempoTranscurrido) {
        this.tiempoTranscurrido = tiempoTranscurrido;
    }
    
     public void restarTiempo(long valor) {
        
         this.tiempoTranscurrido = valor - tiempoTranscurrido ;
         
        
         if (this.tiempoTranscurrido < 0) {
         
             this.tiempoTranscurrido = 0;  // Asegurarse de que no sea negativo
        }
    }
    
}
