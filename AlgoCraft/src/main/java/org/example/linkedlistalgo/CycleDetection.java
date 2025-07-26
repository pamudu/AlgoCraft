package org.example.linkedlistalgo;

/*
A cycle means that if you keep following the "next" pointers in the list, you'll eventually revisit
a node you've already seen before. This creates an infinite loop when traversing the list.
Visual Examples:

Linked list WITH a cycle:

        1 → 2 → 3 → 4 → 5
                ↑       ↓
                ↑       ↓
                ↑       ↓
                ←←←←←←←←←
In this example, node 5 points back to node 3, creating a cycle.

Linked list WITHOUT a cycle:

        1 → 2 → 3 → 4 → 5 → NULL
Here, the last node (5) points to NULL, indicating the end of the list.
Your Task:
*/
public class CycleDetection {

   /*
   solution:
   Floyd's Cycle Finding Algorithm (also called the "tortoise and hare" algorithm).

   Here's how the "tortoise and hare" approach works:
    1. Use two pointers, slow and fast
    2. Move slow pointer one step at a time
    3. Move fast pointer two steps at a time
    4. If there's a cycle, the fast pointer will eventually meet the slow pointer
    5. If there's no cycle, the fast pointer will reach the end of the list (null)
   * */

    public static void main(String[] args) {
        Node node_5 = new Node(3, null);
        Node node_4 = new Node(7, node_5);
        Node node_3 = new Node(4, node_4);
        Node node_2 = new Node(2, node_3);
        Node node_1 = new Node(1, node_2);
        System.out.println(hasCycle(node_1));

        int[] values1 = {3, 2, 0, -4};
        Node linkedListWithCycle = createLinkedListWithCycle(values1, 1);
        System.out.println(hasCycle(linkedListWithCycle));
    }

    public static boolean hasCycle(Node head){
        if(head == null || head.getNext() == null){
            return false;
        }
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();

            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    private static Node createLinkedListWithCycle(int[] values, int pos) {
        if (values == null || values.length == 0) {
            return null;
        }

        Node[] nodes = new Node[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new Node(values[i]);
            if (i > 0) {
                nodes[i-1].setNext(nodes[i]);
            }
        }

        // Create cycle if pos is valid
        if (pos >= 0 && pos < values.length) {
            nodes[values.length - 1].setNext(nodes[pos]);
        }

        return nodes[0];
    }
}

