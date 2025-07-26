package org.example.slowandfastpointers;
/*
* Given a singly linked list, find and return its middle node. If there are two middle nodes,
  return the second one
  * Example 1:
  * 1 -> 2 -> 4 -> 7 -> 3
  * output: Node 4

  * Example 2
  * 1 -> 2 -> 4 -> 7
  * output: Node 4

* Constraints:
  The linked list contains at least one node.
  The linked list contains unique values.

* */


public class MidPoint {
    public static void main(String[] args) {
        Node n5 = new Node(3);
        Node n4 = new Node(7, n5);
        Node n3 = new Node(4, n4);
        Node n2 = new Node(2, n3);
        Node n1 = new Node(1, n2);

        Node midNode = getMidNode(n1);
        System.out.println(midNode.value);
    }

    public static Node getMidNode(Node head){
        Node slowNode = head;
        Node fastNode = head;

        while(fastNode != null && fastNode.next != null){
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }

        return slowNode;
    }
}


