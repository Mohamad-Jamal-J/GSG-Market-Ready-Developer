package tasks.third_ds_lecture.find_all_duplicates_in_array;

import java.util.ArrayList;
import java.util.List;
public class FindAllDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();

        for (int num : nums) {
            int index = Math.abs(num) - 1;
            if (nums[index] < 0) {
                duplicates.add(index + 1);
            } else {
                nums[index] = -nums[index];
            }
        }

        return duplicates;
    }
}