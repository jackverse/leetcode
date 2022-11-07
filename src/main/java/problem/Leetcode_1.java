package problem;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Leetcode_1 {

    @Test
    public void FirstMethods() {
        log.info("HashMaps: {}", JSONObject.toJSONString(twoSum(new int[]{2,7,11, 15}, 9)));
    }

    /**
     * 时间复杂度  O(N)  其中 N是数组中的元素数量。对于每一个元素 x，我们可以 O(1) 地寻找 target - x
     * 空间复杂度  O(N)  其中 N 是数组中的元素数量。主要为哈希表的开销。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> aMap = new HashMap<Integer, Integer>();
        for (int i = 0;  i < nums.length; i++) {
            if (aMap.containsKey(nums[i])) {
                return new int[]{aMap.get(nums[i]), i};
            } else {
                aMap.put(target - nums[i], i);
            }
        }
        return nums;
    }
}
