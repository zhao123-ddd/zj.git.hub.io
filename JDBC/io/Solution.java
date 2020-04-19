package JDBC.io;


import java.math.BigInteger;
import java.util.ArrayList;

class ListNode {
     int val;
       ListNode next;
     ListNode(int x) { val = x; }
  }

public class Solution {
    public static void main(String[] args) {
        ListNode p=new ListNode(129);
        ListNode p1=new ListNode(129);
        p.next=p1;
        System.out.println(Solution.isPalindrome(p));;
    }
    public static boolean isPalindrome(ListNode head) {
         ListNode slow=head;
         ListNode fast=head;
         ListNode newhead=null;
         ListNode slow1=slow.next;
         while(fast!=null&&fast.next!=null){
             fast=fast.next.next;
             slow.next=newhead;
             newhead=slow;
             slow=slow1;
             slow1=slow.next;
         }
         if(fast!=null){
             slow=slow.next;
         }
         while(slow!=null){
             if(slow.val!=newhead.val){
                 return  false;
             }
             slow=slow.next;
             newhead=newhead.next;
         }
         return  true;
    }
}
