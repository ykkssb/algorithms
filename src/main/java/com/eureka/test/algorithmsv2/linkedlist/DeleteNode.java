package com.eureka.test.algorithmsv2.linkedlist;

import com.eureka.test.container.ListNode;

/**
 * <p>面试题 02.03. 删除中间节点</p>
 * https://leetcode-cn.com/problems/delete-middle-node-lcci/
 *
 * @Author : Eric
 * @Date: 2021-01-19 22:40
 */
public class DeleteNode {
    /**
     * 出题人的语文老师是杀猪匠
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
