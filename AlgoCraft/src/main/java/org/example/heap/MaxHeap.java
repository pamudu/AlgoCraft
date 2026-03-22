package org.example.heap;

import java.util.NoSuchElementException;

import static java.util.Collections.swap;

/*
Core Concepts
A heap is represented as an array where for any element at index i:

Left child → 2*i + 1
Right child → 2*i + 2
Parent → (i - 1) / 2

*/
public class MaxHeap {
    private int[] heap;
    private int size;

    public void capacity(int capacity){
        this.heap = new int[capacity];
    }

    public void insert(int value){
        if(this.heap == null){
            throw new RuntimeException("Heap capacity is not defined");        }
        if (this.heap.length == size) {
            throw new RuntimeException("Heap has the maximum capacity");
        }
        this.heap[size] = value;
        heapifyUp(size);
        this.size++;
    }

    private void heapifyUp(int index){
        int parent = (index - 1)/2;

        while(index > 0 && heap[parent] < heap[index]){
            swap(parent, index);
            index = parent;
            parent = (index - 1)/2;
        }
    }

    private void heapifyDown(int index){
        int largest = index;
        int left    = 2 * index + 1;
        int right   = 2 * index + 2;

        // Check if left child is larger than current node
        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }
        // Check if right child is larger than the current candidate
        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }
        // If the largest is not the current node, swap and recurse
        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);  // recurse down the subtree
        }
    }

    private void swap(int parent, int index) {
        int temp = this.heap[parent];
        this.heap[parent] = this.heap[index];
        this.heap[index] = temp;
    }

    public int getMax(){
        if(size == 0){
            throw new NoSuchElementException("Heap is empty");
        }
        return this.heap[0];
    }

    public int extractMax(){
        if(size == 0){
            throw new NoSuchElementException("Heap is empty");
        }
        int max = this.heap[0];
        heap[0] = heap[--size];   // move last element to root
        heapifyDown(0);
        return max;
    }

}
