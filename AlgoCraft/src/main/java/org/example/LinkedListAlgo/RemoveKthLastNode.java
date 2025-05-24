package org.example.LinkedListAlgo;

/*
Return the head of a singly linked list after removing the kth node from the end of it.
Example:
k • 2
1 -> 2 -> 4 -> 7 -> 3
1 -> 2 -> 4 ->   -> 3

Constraints:
• The linked list contains at least one node
*/
public class RemoveKthLastNode {
    public static void main(String[] args) {
        Node n5 = new Node(3);
        Node n4 = new Node(7, n5);
        Node n3 = new Node(4, n4);
        Node n2 = new Node(2, n3);
        Node n1 = new Node(1, n2);

        Node newNode = removeKthLastNode(n1, 2);
        while(newNode != null){
            System.out.println(newNode.getVal());
            newNode = newNode.getNext();
        }
    }

    public static Node removeKthLastNode(Node head, int k){
        //A dummy node to ensure there is a node before 'head' in case we
        // need to remove the head node.
        Node dummy = new Node(-1);
        dummy.setNext(head);
        Node trailer = dummy;
        Node leader = dummy;

        //Advance leader  k steps
        for(int i=0; i <= k-1; i++){
            leader = leader.getNext();
            // If k is larger than the length of the linked list,
            // no node needs to be removed
            if(leader == null){
                return head;
            }
        }

        //Move leader t the end of the linked list, keeping trailer k nodes behind
        while(leader.getNext() != null){
            leader = leader.getNext();
            trailer = trailer.getNext();
        }

        //Remove the K th node from the end
        trailer.setNext(trailer.getNext().getNext());
        return dummy.getNext();
    }
}
