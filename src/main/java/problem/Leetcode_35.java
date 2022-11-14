package problem;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class Leetcode_35 {

    @Test
    public void test() {
        log.info("二分结果: {}", searchInsert(new int[]{1,3,5,6}, 4));
    }


    /**
     * 二分法
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            if (target > nums[middle]) {
                left = middle + 1;
            } else if (target < nums[middle]){
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return left;
    }
}
