package tasks.first_ds_lecture.remove_nth_from_end;

public class RemoveNthNode {
   public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode fast = head, slow = head;
      for(int i=0; i<n ;i++) // move fast n times
         fast = fast.next;

      if(fast==null)
         return head.next;

      while(fast.next!=null){
         // move k-n-1 times
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

