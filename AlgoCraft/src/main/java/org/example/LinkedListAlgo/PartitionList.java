package org.example.LinkedListAlgo;

/*
Leetcode question
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.
*/
public class PartitionList {
    public static void main(String[] args) {
        ListNode l6 = new ListNode(2);
        ListNode l5 = new ListNode(5,l6);
        ListNode l4 = new ListNode(2,l5);
        ListNode l3 = new ListNode(3,l4);
        ListNode l2 = new ListNode(4,l3);
        ListNode l1 = new ListNode(1,l2);

        ListNode result = partition(l1, 3);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }

    }

    public static ListNode partition(ListNode head, int x){
        if(head == null || head.next == null){
            return head;
        }
        ListNode leftPointer = null;
        ListNode rightPointer = null;
        ListNode startLeftPointer = null;
        ListNode startRightPointer = null;

        while(head != null){
            ListNode dummy = new ListNode(head.val);
            if(dummy.val < x){
                if(leftPointer != null) {
                    leftPointer.next = dummy;
                }else{
                    startLeftPointer = dummy;
                }
                leftPointer = dummy;
            }else{
                if(rightPointer != null){
                    rightPointer.next = dummy;
                }else{
                    startRightPointer = dummy;
                }
                rightPointer = dummy;
            }
            head = head.next;
        }
        if(leftPointer != null){
            leftPointer.next = startRightPointer;
            return startLeftPointer;
        }
        return startRightPointer;

    }
}



class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
