package tasks.second_ds_lecture.min_stack;
class MinStack {
   private Node top;
   public MinStack() {
      top = null;
   }
   public void push(int val) {
      Node node = new Node(val, null);
      if(top == null){
         top = node;
         return;
      }
      node.next = top;
      if(node.minSoFar >= top.minSoFar)
         node.minSoFar = top.minSoFar;

      top = node;
   }
   public void pop() {
      top=top.next;
   }
   public int top() {
      return top.value;
   }
   public int getMin() {
      return top.minSoFar;
   }

   class Node{
      int value;
      int minSoFar;
      Node next;
      Node(int value, Node next){
         this.value = value;
         this.minSoFar = value;
         this.next = next;
      }
   }
}