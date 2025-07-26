package org.example.linkedlistalgo;

/*
Return the node where two singly linked lists intersect If the linked lists don't intersect,
return null.

An intersection occurs when two linked lists converge at a shared node and, from that point
 1 -> 3 -> 4
            |-> 8 ->7 ->2
        6-> 4

output node: 8
*/
public class LinkedListIntersection {
    public static void main(String[] args) {
        Node node_c3 = new Node(2,null);
        Node node_c2 = new Node(7,node_c3);
        Node node_c1 = new Node(8,node_c2);

        Node node_a3 = new Node(4, node_c1);
        Node node_a2 = new Node(3, node_a3);
        Node node_a1 = new Node(1, node_a2);

        Node node_b2 = new Node(2, node_c1);
        Node node_b1 = new Node(1, node_b2);

        System.out.println(linkedListIntersection(node_a1, node_b1).getVal());
    }

     // this problem is easier to solve if the two linked lists are of equal length.
     // This is because the intersection node can be found at the same position from the heads of
     // both linked lists. So, we're guaranteed to reach the intersection node at the same time.

    // Let's combine those two lists, so we can  see if combine them we get the same tail nodes

    public static Node linkedListIntersection(Node headA, Node headB){
        Node pointerA = headA;
        Node pointerB = headB;

        if(pointerA == null || pointerB ==null){
            return null;
        }

        while(pointerA != pointerB){
            if(pointerA.getNext() != null){
                pointerA = pointerA.getNext();
            }else{
                pointerA = headB;
                headB = null;
            }

            if(pointerB.getNext() != null){
                pointerB = pointerB.getNext();
            }else{
                pointerB = headA;
                headA = null;
            }

        }
        return pointerA;
    }
}
