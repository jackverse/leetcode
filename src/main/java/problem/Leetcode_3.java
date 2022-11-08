package problem;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class Leetcode_3 {

    @Test
    public void main() {
        String str = "abcabcbb";
        log.info("结果: {}", lengthOfLongestSubstring(str));
    }


    /**
     * first methods   使用HashSet来判断
     *  时间复杂度: O(n²)    125ms
     *  空间复杂度:          41.5MB
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int resultLen = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<String> aSet = new HashSet<String>();
            int lengthString = 0;
            int flag = i;
            while(flag < s.length()) {
                if (aSet.add(s.substring(flag, flag + 1))) {
                    lengthString++;
                } else {
                    break;
                }
                flag++;
            }
            resultLen = Math.max(lengthString, resultLen);
        }
        return resultLen;
    }

    /**
     * first methods 加强版  使用HashSet来判断
     *  时间复杂度: O(n²)    78ms
     *  空间复杂度:          42.3MB
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringCharacter(String s) {
        int resultLen = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> aSet = new HashSet<Character>();
            int lengthString = 0;
            int flag = i;
            while(flag < s.length()) {
                if (aSet.add(s.charAt(flag))) {
                    lengthString++;
                } else {
                    break;
                }
                flag++;
            }
            resultLen = Math.max(lengthString, resultLen);
        }
        return resultLen;
    }


    /**
     * 使用指针
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringLearn(String s) {
        Set<Character> aSet = new HashSet<Character>();
        int result = 0;
        int n = s.length();
        int rk = -1;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                aSet.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !aSet.contains(s.charAt(rk + 1))) {
                aSet.add(s.charAt(rk + 1));
                rk++;
            }
            result = Math.max(result, rk + 1 - i);
        }
        return result;
    }
}
