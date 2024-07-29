package tasks.first_ds_lecture.remove_nth_from_end;

public class RemoveNthNode {
   /**
   motivation:
   n: position from right, list length is k
   so k-n: position from left (given k>=n>=1)
   k-n is the position where we should stop to delete the target node (at k-n+1)
   approach:
   using two pointers
   move one pointer by n steps ahead
   then move both pointers k-n step ahead (until the first one is at k, and the second is at k-n)
    **/
   public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode fast = head, slow = head;
      for(int i=0; i<n ;i++) // move fast n times
         fast = fast.next;

      if(fast==null)
         return head.next;

      while(fast.next!=null){
         // move k-n times
         // until fast becomes at k
         // and slow at k-n (the position before the target node)
         fast = fast.next;
         slow = slow.next;
      }
      slow.next = slow.next.next;
      return head;
   }

}


 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

