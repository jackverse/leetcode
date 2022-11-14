package problem;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class Leetcode_704 {

    @Test
    public void test() {
        log.info("二分结果: {}", search(new int[]{-1,0,3,5,9,12}, 9));
    }


    /**
     * 二分法
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            if (target > nums[middle]) {
                left = middle + 1;
            } else if (target < nums[middle]) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
