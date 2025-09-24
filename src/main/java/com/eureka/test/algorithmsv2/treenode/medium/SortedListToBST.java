package com.eureka.test.algorithmsv2.treenode.medium;

import com.eureka.test.container.ListNode;
import com.eureka.test.container.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/convert-sorted-list-to-binary-search-tree/description/?envType=problem-list-v2&envId=linked-list
 * <p>
 * 有序链表转换二叉搜索树
 *
 * @author : yujie.wang
 * @date: 2025-09-24 18:02
 */
public class SortedListToBST {

    /**
     * 参考sortedArrayToBST 递归思想
     *
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode f = head;
        while (f != null) {
            list.add(f.val);
            f = f.next;
        }
        return dfs(list, 0, list.size() - 1);
    }

    TreeNode dfs(List<Integer> list, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = (l + r + 1) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = dfs(list, l, mid - 1);
        root.right = dfs(list, mid + 1, r);
        return root;
    }

    ListNode head;

    public TreeNode sortedListToBSTTwo(ListNode _head) {
        int n = 0;
        head = _head;
        ListNode f = _head;
        while (f != null) {
            n++;
            f = f.next;
        }
        return dfs(0, n - 1);
    }

    TreeNode dfs(int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = l + r + 1 >> 1;

        TreeNode left = dfs(l, mid - 1);
        TreeNode root = new TreeNode(head.val);
        head = head.next;
        root.left = left;
        root.right = dfs(mid + 1, r);
        return root;
    }

    public static void main(String[] args) {

        SortedListToBST slt = new SortedListToBST();
        ListNode node = new ListNode(-10);
        node.next = new ListNode(-3);
        node.next.next = new ListNode(0);
        node.next.next.next = new ListNode(5);
        node.next.next.next.next = new ListNode(9);
        System.out.println(slt.sortedListToBSTTwo(node));
    }
}
