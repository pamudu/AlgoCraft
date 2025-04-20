package org.example.pointers;

import java.util.HashMap;
import java.util.List;

// Leetcode problem
//link - https://leetcode.com/problems/rotate-list/?envType=problem-list-v2&envId=two-pointers
public class RotateList {
    public static void main(String[] args) {
        ListNode node_5 = new ListNode(5);
        ListNode node_4 = new ListNode(4, node_5);
        ListNode node_3 = new ListNode(3, node_4);
        ListNode node_2 = new ListNode(2, node_3);
        ListNode node_1 = new ListNode(1, node_2);

        ListNode node = rotateRight(node_4, 2);
        while(node != null){
            System.out.print(node.val + " -> ");
            node = node.next;
        }
    }

    public static ListNode rotateRight(ListNode head, int k){
        if(head==null || head.next == null || k == 0){
            return head;
        }
        HashMap<Integer, ListNode> indexedNodes = new HashMap<>();
        int increment = 1;
        ListNode originalHead = head;
        while(head != null){
            indexedNodes.put(increment, head);
            if(head.next != null){
                increment++;
            }
            head = head.next;
        }

        // we need to break the original list from -> list size - k
        int rotate = 0;

        if(k >= increment){
            rotate = k % increment;
            if(rotate == 0){
                return originalHead;
            }
        }
        else{
            rotate = k;
        }

        int breakingPoint = increment - rotate;
        indexedNodes.get(breakingPoint).next = null;
        indexedNodes.get(increment).next = indexedNodes.get(1);
        return indexedNodes.get(breakingPoint+1);
    }
}


 //Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

