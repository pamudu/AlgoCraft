package org.example.LinkedListAlgo;

public class LinkedListReversal {
    public static void main(String[] args) {
        Node node_5 = new Node(3, null);
        Node node_4 = new Node(7, node_5);
        Node node_3 = new Node(4, node_4);
        Node node_2 = new Node(2, node_3);
        Node node_1 = new Node(1, node_2);

        Node reversedList = reverseList(node_1);
        while(reversedList != null){
            System.out.println(reversedList.getVal());
            reversedList = reversedList.getNext();
        }
    }

    public static Node reverseList(Node list){
        if(list == null){
            return null;
        }
        Node prevNode = null;
        Node currentNode = list;
        while(currentNode !=null){
            Node next = currentNode.getNext();
            currentNode.setNext(prevNode);
            prevNode = currentNode;
            currentNode = next;
        }
        return prevNode;
    }

}

class Node{
    private int val;
    private Node next;
    public Node(int val, Node next){
        this.val = val;
        this.next = next;
    }
    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }



}