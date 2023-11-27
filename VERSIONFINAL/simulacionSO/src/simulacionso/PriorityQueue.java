///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package simulacionso;
//
//import java.util.Arrays;
/
//public class PriorityQueue {
//    //ESTA ES LA BUENA VIRGUITA SIN TOCAR
//    
//    //LA COLA DE PRIORIDAD SE IMPLEMENTÓ USANDO UN MIN HEAP
//    
//    private int capacity;
//    
//    private int size;
//    
//    RegistroDocs[] registrosEncolados;
//    
//    int[] items;
//    
//    public PriorityQueue(){
//        this.capacity = 10;
//        this.size = 0;
//        this.registrosEncolados = new RegistroDocs[capacity];
//        this.items = new int [capacity];
//    }
//    
//    private int getLeftChildIndex(int parentIndex) {return 2*parentIndex+1;}
//    private int getRightChildIndex(int parentIndex) {return 2*parentIndex+2;}
//    private int getParentIndex(int childIndex) {return (childIndex - 1)/2;}
//    
//    private boolean hasLeftChild(int index) { return getLeftChildIndex(index) < size; }
//    private boolean hasRightChild(int index) { return getRightChildIndex(index) < size; }
//    private boolean hasParent(int index) { return getParentIndex(index) >= 0; }
//    
//    private int leftChild(int index) { return items[getLeftChildIndex(index)];}
//    private int rightChild(int index) { return items[getRightChildIndex(index)];}
//    private int parent(int index) { return items[getParentIndex(index)];}
//    
//    
//    private void swap(int indexOne, int indexTwo){
//        int temp = items[indexOne];
//        items[indexOne] = items[indexTwo];
//        items[indexTwo] = temp;
//    }
//    
//    private void ensureExtraCapacity(){
//        if(size == capacity){
//            items = Arrays.copyOf(items, capacity*2);
//            capacity*= 2;
//        }
//    }
//    
//    public int peek(){
//        if(size == 0) throw new IllegalStateException();
//        return items[0];
//    }
//    
//    public int poll(){
//        if(size == 0) throw new IllegalStateException();
//        
//        int item = items[0];
//        items[0] = items[size - 1];
//        size--;
//        heapifyDown();
//        return item;
//    }
//    
//    public void add(int item){
//        ensureExtraCapacity();
//        items[size] = item;
//        size++;
//        heapifyUp();
//    }
//
//
//    
//    public void heapifyUp(){
//        int index = size - 1;
//        while(hasParent(index)&& parent(index) > items[index]){
//            swap(getParentIndex(index),index);
//            index = getParentIndex(index);
//            
//        }
//    
//    }
//    
//    public void heapifyDown(){
//        int index = 0;
//        while(hasLeftChild(index)){
//            int smallestChildIndex = getLeftChildIndex(index);
//            if(hasRightChild(index) && rightChild(index) < leftChild(index)){
//                smallestChildIndex = getRightChildIndex(index);
//            }
//            
//            if(items[index] < items[smallestChildIndex]){
//                break;
//            } else {
//              swap(index, smallestChildIndex)  ;
//            }
//            index = smallestChildIndex;
//        }
//    
//    }
//    
//} 
//
//
