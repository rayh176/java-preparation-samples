package org.example.logic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PalindromeSolution {

    public boolean isPalindrome(ListNode head) {
        List<Integer> values = new ArrayList<>();
        if (head.val == 0) {
            return false;
        }

        values.add(head.val);
        ListNode pos = head.next;
        while (pos.next != null) {
            values.add(pos.val);
            pos = pos.next;
        }
        //add the last value
        values.add(pos.val);
        // check values
        int m = values.size() / 2;
        int lo = 0 ;
        int high =  values.size() -1;
        for (int i=0; i < m; i++){
            if (values.get(lo++) != values.get(high--))
            {
                return false;
            }
        }

        // convert Queue to List of elements

//        Queue<ListNode> queue = new LinkedList<>();
//        queue.offer(head);
//        while(!queue.isEmpty()){
//            int counter = 0;
//            ListNode queueHead = queue.poll();
//            ListNode nextHead = queueHead.next;
//            boolean status = checkPalindrome(nextHead, queueHead, counter++);
//            if (!status) {
//                // look for the next value
//                return false;
//            }
//            queue.offer(nextHead);
//        }
        return true;
    }

    private boolean checkPalindrome(ListNode nextValue, ListNode head, int counter) {
        ListNode pos = nextValue;
        if (head == null || pos == null) {
            return false;
        }
        pos = pos.next;
        while(pos.next != null) {
            pos = pos.next;
        }

        if (head.val == pos.val) {
            return true;
        }
        return false;
    }

    static public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

   public static void main(String args []) {
       PalindromeSolution pp = new PalindromeSolution();
       ListNode head = new ListNode(1);
       head.next = new ListNode(2);
       head.next.next = new ListNode(2);
       head.next.next.next = new ListNode(1);
       System.out.println("Test isPalindrome="+pp.isPalindrome(head));
       head = new ListNode(1);
       head.next = new ListNode(2);
       head.next.next = new ListNode(3);
       head.next.next.next = new ListNode(1);
       System.out.println("Test isPalindrome="+pp.isPalindrome(head));
       head = new ListNode(1);
       head.next = new ListNode(2);
       head.next.next = new ListNode(1);
       System.out.println("Test isPalindrome="+pp.isPalindrome(head));
   }
}
