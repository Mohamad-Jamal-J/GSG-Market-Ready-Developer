package tasks.third_ds_lecture.two_sum;
import java.util.HashMap;
import java.util.Map;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i<nums.length ; i++){
            if(map.containsKey( target-nums[i]))
                return new int[]{i,map.get(target-nums[i])};
            else
                map.put(nums[i],i);
        }
        return null;
    }
}

