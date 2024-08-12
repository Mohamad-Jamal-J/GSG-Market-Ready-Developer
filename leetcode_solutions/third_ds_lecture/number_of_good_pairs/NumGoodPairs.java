package tasks.third_ds_lecture.number_of_good_pairs;
// idea:
// arr[x] = n : number of occurrences.
// if we saw another x: then we have additional n pairs with the newly found x.
public class NumGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        int counter = 0;
        int[] arr = new int[100];
        for(int i : nums)
            if(arr[i-1] == 0)
                arr[i-1] = 1;
            else
                counter += arr[i-1]++;
        return counter;
    }
}

