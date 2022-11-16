package problem;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class Leetcode_34 {

    @Test
    public void test() {
        log.info("二分结果: {}", searchRange(new int[]{5,7,7,8,8,10}, 8));
    }


    public int[] searchRange(int[] nums, int target) {
        int leftIndex = binarySearch(nums, target, true);
        int rightIndex = binarySearch(nums, target, false) - 1;
        if (leftIndex <= rightIndex && rightIndex < nums.length && nums[leftIndex] == target && nums[rightIndex] == target) {
            return new int[]{leftIndex, rightIndex};
        }
        return new int[]{-1, -1};
    }



    public int binarySearch(int[] nums, int target, boolean flag) {
        int leftIndex = 0, rightIndex = nums.length - 1,ans = nums.length;
        while (leftIndex <= rightIndex) {
            int middle = (leftIndex + rightIndex)/2;
            if (nums[middle] > target || ((nums[middle] >= target) &&  flag)) {
                rightIndex = middle - 1;
                ans = middle;
            } else {
                leftIndex = middle + 1;
            }
        }
        return ans;
    }
}
