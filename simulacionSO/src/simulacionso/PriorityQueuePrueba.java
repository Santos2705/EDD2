/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacionso;

import java.util.Arrays;


public class PriorityQueuePrueba {
    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * 
 */

    
    
    //LA COLA DE PRIORIDAD SE IMPLEMENTÓ USANDO UN MIN HEAP
    
    private int capacity;
    
    private int size;
    
    RegistroDocs[] registrosEncolados;
    
    
    
    public PriorityQueuePrueba(){
        this.capacity = 10;
        this.size = 0;
        this.registrosEncolados = new RegistroDocs[capacity];
//        this.registrosEncolados = new int [capacity];
    }
    
    private int getLeftChildIndex(int parentIndex) {return 2*parentIndex+1;}
    private int getRightChildIndex(int parentIndex) {return 2*parentIndex+2;}
    private int getParentIndex(int childIndex) {return (childIndex - 1)/2;}
    
    private boolean hasLeftChild(int index) { return getLeftChildIndex(index) < size; }
    private boolean hasRightChild(int index) { return getRightChildIndex(index) < size; }
    private boolean hasParent(int index) { return getParentIndex(index) >= 0; }
    
    private long leftChild(int index) { return registrosEncolados[getLeftChildIndex((int) index)].getTiempoTranscurrido();}
    
    private long rightChild(int index) { return registrosEncolados[getRightChildIndex(index)].getTiempoTranscurrido();}
    private long parent(int index) { return registrosEncolados[getParentIndex(index)].getTiempoTranscurrido();}
    
    
    private void swap(int indexOne, int indexTwo){
        RegistroDocs temp = registrosEncolados[indexOne];
        registrosEncolados[indexOne] = registrosEncolados[indexTwo];
        registrosEncolados[indexTwo] = temp;
        
//        registrosEncolados[indexTwo].setTiempoTranscurrido(temp);
    }
    
    private void ensureExtraCapacity(){
        if(size == capacity){
            registrosEncolados = Arrays.copyOf(registrosEncolados, capacity*2);
            capacity*= 2;
        }
    }
    
    public String peek(){
        if(size == 0) throw new IllegalStateException();
        return "Documento próximo a imprimir: \nNombre: " + registrosEncolados[0].getDocumento().getNombre() + "Tipo: " + registrosEncolados[0].getDocumento().getTipo();
    }
    
    public RegistroDocs poll(){
        if(size == 0) throw new IllegalStateException();
        
        RegistroDocs item = registrosEncolados[0];
        registrosEncolados[0] = registrosEncolados[size - 1];
        size--;
        heapifyDown();
        return item;
    }
    
    public void add(RegistroDocs item){
        ensureExtraCapacity();
        registrosEncolados[size] = item;
        size++;
        heapifyUp();
    }


    
    public void heapifyUp(){
        int index = size - 1;
        while(hasParent(index) && parent(index) > registrosEncolados[index].getTiempoTranscurrido()){
            swap(getParentIndex(index),index);
            index = getParentIndex(index);
            
        }
    
    }
    
    public void heapifyDown(){
        int index = 0;
        while(hasLeftChild(index)){
            int smallestChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && rightChild(index) < leftChild(index)){
                smallestChildIndex = getRightChildIndex(index);
            }
            
            if(registrosEncolados[index].getTiempoTranscurrido() < registrosEncolados[smallestChildIndex].getTiempoTranscurrido()){
                break;
            } else {
              swap(index, smallestChildIndex)  ;
            }
            index = smallestChildIndex;
        }
    
    }
    
} 



    

