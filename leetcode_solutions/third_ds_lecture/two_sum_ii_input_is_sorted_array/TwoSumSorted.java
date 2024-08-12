package tasks.third_ds_lecture.two_sum_ii_input_is_sorted_array;

public class TwoSumSorted {
    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (nums[l] + nums[r] != target)
            if (nums[l] + nums[r] < target)
                l++;
            else
                r--;

        return new int[] {l+1, r+1}; // 1-indexed array.
    }
}
