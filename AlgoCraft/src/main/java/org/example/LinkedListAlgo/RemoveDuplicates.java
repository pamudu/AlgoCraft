package org.example.LinkedListAlgo;

import java.util.List;

/*
* Remove Duplicates from Sorted List
* Leetcode question - https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/?envType=problem-list-v2&envId=linked-list
*
* */
public class RemoveDuplicates {
    public static void main(String[] args) {
        ListNode node_3 = new ListNode(2);
        ListNode node_2 = new ListNode(1, node_3);
        ListNode node_1 = new ListNode(1, node_2);
        ListNode result = deleteDuplicates(node_1);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode resultHead = head;
        while(head.next != null){
            if(head.val == head.next.val){
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }
        return resultHead;
    }
}
