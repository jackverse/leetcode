package problem;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class Leetcode_2 {

    @Test
    public void FirstMethods() {
        ListNode demo1 = new ListNode(0);
        ListNode demoOne = demo1;
        demo1.next = new ListNode(2);
        demo1 = demo1.next;
        demo1.next = new ListNode(4);
        demo1 = demo1.next;
        demo1.next = new ListNode(3);

        ListNode demo2 = new ListNode(0);
        ListNode demoTwo = demo2;
        demo2.next = new ListNode(5);
        demo2 = demo2.next;
        demo2.next = new ListNode(6);
        demo2 = demo2.next;
        demo2.next = new ListNode(4);
        log.info("方法一: {}", demoOne.toString());
        log.info("方法一: {}", demoTwo);
        log.info("方法一: {}", addTwoNumbers(demoOne, demoTwo));
    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 方法一
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode();
        ListNode result = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int one = l1 != null ? l1.val : 0;
            int two = l2 != null ? l2.val : 0;
            int sum = one + two + carry;
            carry = sum / 10;
            sum = sum % 10;
            result.next = new ListNode(sum);
            result = result.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            result.next = new ListNode(carry);
        }
        return pre.next;
    }
}
