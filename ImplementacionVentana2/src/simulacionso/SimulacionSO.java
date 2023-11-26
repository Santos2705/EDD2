/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package simulacionso;
import simulacionso.PriorityQueuePrueba;


public class SimulacionSO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PriorityQueuePrueba pq = new PriorityQueuePrueba();
        Documento doc = new Documento("doc0", 20, "tipo_a");
        Documento doc_1 = new Documento("doc1", 30, "tipo_b");
        Documento doc_2 = new Documento("doc2", 70, "tipo_c");
        Documento doc_3 = new Documento("doc3", 10, "tipo_d");
        Documento doc_4 = new Documento("doc4", 50, "tipo_e");
        Documento doc_5 = new Documento("doc5", 40, "tipo_f");
        Documento doc_6 = new Documento("doc6", 60, "tipo_g");
        
        RegistroDocs registro = new RegistroDocs();
        RegistroDocs registro_1 = new RegistroDocs();
        RegistroDocs registro_2 = new RegistroDocs();
        RegistroDocs registro_3 = new RegistroDocs();
        RegistroDocs registro_4 = new RegistroDocs();
        RegistroDocs registro_5 = new RegistroDocs();
        RegistroDocs registro_6 = new RegistroDocs();
        
        registro.setDocumento(doc);
        registro.setTiempoTranscurrido(doc.getTamanio());
        
        registro_1.setDocumento(doc_1);
        registro_1.setTiempoTranscurrido(doc_1.getTamanio());
        
        registro_2.setDocumento(doc_2);
        registro_2.setTiempoTranscurrido(doc_2.getTamanio());
        
        registro_3.setDocumento(doc_3);
        registro_3.setTiempoTranscurrido(doc_3.getTamanio());
        
        registro_4.setDocumento(doc_4);
        registro_4.setTiempoTranscurrido(doc_4.getTamanio());
        
        registro_5.setDocumento(doc_5);
        registro_5.setTiempoTranscurrido(doc_5.getTamanio());
        
        registro_6.setDocumento(doc_6);
        registro_6.setTiempoTranscurrido(doc_6.getTamanio());
        
        pq.add(registro);
        pq.add(registro_1);
        pq.add(registro_2);
        pq.add(registro_3);
        pq.add(registro_4);
        pq.add(registro_5);
        pq.add(registro_6);
        
        for (int i = 0; i < pq.registrosEncolados.length; i++) {
            System.out.println(pq.registrosEncolados[i].getDocumento().getTamanio());
            
        }
        
        
        
        
    }
    
}
