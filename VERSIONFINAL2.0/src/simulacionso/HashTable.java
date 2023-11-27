/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacionso;

public class HashTable <T>{
    
    private Nodo[] bucketArray;
    
    private int capacity;
    
    private int size;
    
   
    public HashTable(){
    
        this.capacity = 1021;
        
        this.bucketArray = new Nodo[this.capacity];
        
        this.size = 0;
    }

    public Nodo[] getBucketArray() {
        return bucketArray;
    }

    public void setBucketArray(Nodo[] bucketArray) {
        this.bucketArray = bucketArray;
    }

    

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    //METODOS PRIMITIVOS
    public boolean isEmpty(){
    
        return size == 0;
    }
   
    public int getBucketIndex(int key){
    
        int index = key % this.capacity;
        
        return index;
    
        
    }
    
    public void insertar(T info) {
        int indice = calcularHash(info);

        Nodo<T> nuevoNodo = new Nodo<>();
        nuevoNodo.setInfo(info);

        if (bucketArray[indice] == null) {
            bucketArray[indice] = nuevoNodo;
        } else {
            // Manejo de colisiones: agregar a la lista enlazada
            Nodo<T> actual = bucketArray[indice];
            while (actual.getpNext() != null) {
                actual = actual.getpNext();
            }
            actual.setpNext(nuevoNodo);
        }
    }

    public T buscar(T info) {
        int indice = calcularHash(info);

        Nodo<T> actual = bucketArray[indice];
        while (actual != null) {
            if (actual.getInfo().equals(info)) {
                return actual.getInfo();
            }
            actual = actual.getpNext();
        }

        return null; // No se encontró el elemento
    }

    private int calcularHash(T info) {
        return Math.abs(info.hashCode() % capacity);
    }
}
//    public void put_listas(Nodo art, T value){
//    
//        int key = stringtoNum(art.getInfo().toString());
//
//        int bucketIndex = getBucketIndex(key);
//            System.out.println(bucketIndex);
//
//        HashNode head = bucketArray[bucketIndex];
//        
//        while(head != null){
//        
//            if(head.getKey() == key){
//            
//                head.setValue(value);
//                
//                return;
//            }
//            head = head.getNext();
//        }
//        size++;
//        head = bucketArray[bucketIndex];
//        
//        HashNode<T> node = new HashNode<>(key, value);
//        
//        node.setNext(head);
//        bucketArray[bucketIndex] = node;
//    
//    }
//    public void put(Articulo articulo, T value){
//        
//        int key = stringtoNum(articulo.getTitulo());
//
//        int bucketIndex = getBucketIndex(key);
//            System.out.println(bucketIndex);
//
//        HashNode head = bucketArray[bucketIndex];
//        
//        while(head != null){
//        
//            if(head.getKey() == key){
//            
//                head.setValue(value);
//                
//                return;
//            }
//            head = head.getNext();
//        }
//        size++;
//        head = bucketArray[bucketIndex];
//        
//        HashNode<T> node = new HashNode<>(key, value);
//        
//        node.setNext(head);
//        bucketArray[bucketIndex] = node;
////        System.out.println(bucketArray[6].getValue());
//        
//    }
//    
//    
//}
