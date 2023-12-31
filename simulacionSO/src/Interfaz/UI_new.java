package Interfaz;


import com.opencsv.exceptions.CsvValidationException;
import java.io.File;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import simulacionso.FileHandling;
import simulacionso.GestorUsuarios;
import simulacionso.Nodo;
import simulacionso.Usuario;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author davidmizrahi
 */
public class UI_new extends javax.swing.JFrame {

    /**
     * Creates new form UI_new
     */
    
    public static File selectedFile;
    GestorUsuarios gu = new GestorUsuarios();
    DefaultListModel<Object> modeloLista = new DefaultListModel<>();
//    
    public UI_new() {
        

        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cargarArchivo = new javax.swing.JButton();
        cargarDocumento = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cargarArchivo.setText("Cargar Archivo");
        cargarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarArchivoActionPerformed(evt);
            }
        });
        jPanel1.add(cargarArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        cargarDocumento.setText("Cargar Documento");
        cargarDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarDocumentoActionPerformed(evt);
            }
        });
        jPanel1.add(cargarDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarArchivoActionPerformed
        // TODO add your handling code here:
    
         JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        
        if (result == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fileChooser.getSelectedFile();
                    String filePath = selectedFile.getPath();
                    
                    try{
                        gu.setUsuarios(FileHandling.readFile(selectedFile));
                    }catch(IOException | CsvValidationException e){
            e.printStackTrace();
        }
//                    System.out.println("Selected file path: " + filePath);
             boolean flag = true;
        
        JOptionPane.showMessageDialog(null, "Archivo cargado exitosamente!");
                }
        
        
       
        
        
        
    
    }//GEN-LAST:event_cargarArchivoActionPerformed

    private void cargarDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarDocumentoActionPerformed
        // TODO add your handling code here:
        
        
        String[] userNames = new String[gu.getUsuarios().size()];
           
            Nodo temp = gu.getUsuarios().getpFirst();
//            Usuario user = (Usuario) temp.getInfo()
            
           for (int i = 0; i < userNames.length; i++) {
                
               if (temp.getInfo() instanceof Usuario) {
                    
                    Usuario auxOne = (Usuario) temp.getInfo();
                    
                    userNames[i] = (String) auxOne.getNombre();
                    
                    temp = temp.getpNext();
            
                }
            }
           
           
            
//            while(temp != null){
//                modeloLista.addElement(temp.getInfo());
//                temp = temp.getpNext();
//                
//            }
            
            jList1.setListData(userNames);
        jList1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

//            JScrollPane scrollPane = new JScrollPane(userList);

            jList1.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        // Acciones que deseas realizar cuando se selecciona un usuario
                        String selectedUser = jList1.getSelectedValue();
                        int hashCode = selectedUser.hashCode();
                       Nodo aux = gu.getUsuarios().getpFirst();
                       
                        System.out.println("Usuario seleccionado: " + selectedUser + "hashCode = " + hashCode);
                        
                        while(aux != null){
                           if(aux.getInfo() instanceof Usuario){
                           Usuario temp = (Usuario)aux.getInfo();
                           if (selectedUser.equals(temp.getNombre())){
                               VentanaCargaDocumentos ventanaCarga = new VentanaCargaDocumentos(temp);
                                ventanaCarga.setVisible(true);
                                break;
                           } else {
                               aux = aux.getpNext();
                           }
                       }
                       }
                        // Realiza tus operaciones aquí
                 
                    
                    }
                        
                        
                }
                
            });
        
        
        
        
        
            
//            jList1.setVisible(true);
            
            
     

    }//GEN-LAST:event_cargarDocumentoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UI_new.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI_new.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI_new.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI_new.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
//            jList1.setVisible(true);
            public void run() {
                            
                new UI_new().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cargarArchivo;
    private javax.swing.JButton cargarDocumento;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
