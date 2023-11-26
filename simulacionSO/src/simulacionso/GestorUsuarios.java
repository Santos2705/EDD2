/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacionso;


 */
public class GestorUsuarios {
    
    private Lista<Usuario> usuarios;
    
    
    public GestorUsuarios(){
        
        this.usuarios = new Lista<Usuario>();
        
    }
    
    public void agregarUsurario(Usuario usuario){
        
        usuarios.agregarElemento(usuario);
        
    }

    public Lista<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Lista<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

   
    
}
