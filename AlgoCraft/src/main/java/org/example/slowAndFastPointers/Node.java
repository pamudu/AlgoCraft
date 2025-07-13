package org.example.slowAndFastPointers;

public class Node {
    public int value;
    public Node next;

    public Node(int value, Node next){
        this.value = value;
        this.next = next;
    }

    public Node(int value){
        this.value = value;
    }
}
