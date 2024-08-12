package tasks.third_ds_lecture.find_the_duplicate_number;

public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        boolean[] seen = new boolean[nums.length];
        for (int i:nums)
            if (!seen[i])
                seen[i] = true;
            else
                return i;
        return seen.length;
    }
}
