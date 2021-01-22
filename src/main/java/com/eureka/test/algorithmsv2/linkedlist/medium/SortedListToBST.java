package com.eureka.test.algorithmsv2.linkedlist.medium;

import com.eureka.test.algorithms.container.ListNode;
import com.eureka.test.algorithms.container.TreeNode;
import org.w3c.dom.Node;

import java.util.List;
import java.util.TreeMap;

/**
 * <p>109. 有序链表转换二叉搜索树</p>
 * https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 *
 * @Author : Eric
 * @Date: 2021-01-21 23:16
 */
public class SortedListToBST {

    /**
     * todo 二叉树BST (Binary Search Tree)分治思想
     *
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        TreeNode treeNode = build(head, null);
        return treeNode;
    }

    public TreeNode build(ListNode l, ListNode r) {
        if (l == r) {
            return null;
        }

        ListNode mid = half(l, r);
        TreeNode no = new TreeNode(mid.val);
        no.left = build(l, mid);
        no.right = build(mid.next, r);
        return no;
    }

    public ListNode half(ListNode l, ListNode r) {
        ListNode s = l, f = l;
        while (f != r && f.next != r) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }

    ListNode global;

    public TreeNode sortedListToBSTwo(ListNode head) {
        global = head;
        ListNode cur = head;
        int n = 0;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        return buildT(0, n - 1);
    }

    public TreeNode buildT(int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = (l + r + 1) / 2;
        TreeNode node = new TreeNode();
        node.left = buildT(l, mid - 1);
        node.val = global.val;
        global = global.next;
        node.right = buildT(mid + 1, r);
        return node;
    }

    /**
     * -10 -3 0 5 9
     * 0 4 2 ( L:-3<0(0,4)<9)
     * L:0 1 1  - (-10(0,0) <-3(0,1) <null(1,1)                R: 3 4 4 (5(3,3)< 9(3,4) <null(4,4)
     * L:0 0 0 (null<-10<null)     L:3 3 3(null< 5 <null) R:4 3    544
     *
     * @param args
     */
    public static void main(String[] args) {
        SortedListToBST sl = new SortedListToBST();
        ListNode l = new ListNode();
        l.val = -10;
        l.next = new ListNode(-3);
        l.next.next = new ListNode(0);
        l.next.next.next = new ListNode(5);
        l.next.next.next.next = new ListNode(9);

        System.out.println(sl.sortedListToBSTwo(l));
    }
}
