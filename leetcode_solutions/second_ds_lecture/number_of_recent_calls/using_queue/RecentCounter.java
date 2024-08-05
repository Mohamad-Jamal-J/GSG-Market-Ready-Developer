package tasks.second_ds_lecture.number_of_recent_calls.using_queue;

class RecentCounter {
   int[] calls;
   int old;
   int recent;
   public RecentCounter() {
      calls = new int[10000];
      old = 0;
      recent = -1;
   }

   public int ping(int t) {
      calls[++recent] = t;
      while(old <= recent && calls[old] < t - 3000)
         old++;

      return recent-old+1;
   }
}
