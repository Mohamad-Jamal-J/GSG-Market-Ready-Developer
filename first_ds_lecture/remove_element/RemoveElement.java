package tasks.first_ds_lecture.remove_element;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int n = 0;
        for(int i = 0 ; i < nums.length; i++)
            if(nums[i]!=val)
                nums[n++] = nums[i];
        return n;
    }
}
