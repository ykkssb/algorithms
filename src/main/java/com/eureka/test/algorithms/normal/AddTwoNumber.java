package com.eureka.test.algorithms.normal;

import com.eureka.test.container.ListNode;

/**
 * @ClassName : AddTwoNumber
 * https://leetcode-cn.com/problems/add-two-numbers/solution/liang-shu-xiang-jia-by-leetcode/
 * @Description : 两数相加
 * @Author : Eric
 * @Date: 2020-03-03 10:33
 */
public class AddTwoNumber {

    /**
     * 时间复杂度：O(max(m, n))，假设 m 和 n 分别表示 l1 和 l2 的长度，上面的算法最多重复 max(m, n) 次。
     * <p>
     * 空间复杂度：O(max(m,n))， 新列表的长度最多为max(m,n) + 1
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumber(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int a = p != null ? p.val : 0;
            int b = q != null ? q.val : 0;
            int sum = carry + a + b;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            if (p != null && p.next != null) {
                p = p.next;
            } else {
                p = null;
            }
            if (q != null && q.next != null) {
                q = q.next;
            } else {
                q = null;
            }
            curr = curr.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1 = ne(l1, new ListNode(9));
//        ne(l1.next, new ListNode(9));
//        ne(l1.next.next, new ListNode(1));

        ListNode l2 = new ListNode(0);
//        ne(l2, new ListNode(1));
//        ne(l2.next, new ListNode(2));
//        ne(l2.next.next, new ListNode(9));

        ListNode test = addTwoNumber(l1, l2);
        System.out.println(test);

    }

    public static ListNode ne(ListNode l1, ListNode l2) {
        l1.next = l2;
//        l1 = l1.next;
        return l1;
    }
}
