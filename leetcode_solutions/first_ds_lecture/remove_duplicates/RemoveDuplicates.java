package tasks.first_ds_lecture.remove_duplicates;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int n=0;
        for(int i = 1; i < nums.length; i++)
            if(nums[n] != nums[i])
                nums[++n]=nums[i];
        return n+1;
    }
}
