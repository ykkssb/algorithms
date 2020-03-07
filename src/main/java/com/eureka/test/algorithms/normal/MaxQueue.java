package com.eureka.test.algorithms.normal;

/**
 * <p>队列最大值</p>
 * https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 *
 * @Author : Eric
 * @Date: 2020-03-07 15:03
 */
public class MaxQueue {




    transient Node first;
    transient Node last;
    transient Node maxNode;

    public int max_value() {
        if (maxNode == null) {
            return -1;
        }
        return maxNode.val;
    }

    public void push_back(int value) {
        Node nNode = new Node();
        nNode.val = value;
        if (last != null) {
            last.next = nNode;
            last = nNode;
            if (maxNode.val < nNode.val) {
                maxNode = nNode;
            }
        } else {
            maxNode = last = first = nNode;
        }
    }

    public int pop_front() {
       if(first == null){
           return -1;
       }
        int result = first.val;
       if(first == maxNode){
           maxNode = null;
       }
        first = first.next;
       if(first == null){
           last = null;
       }else if(maxNode == null){
           foundMaxNode();
       }
        return result;
    }

    public void foundMaxNode() {
        Node next = first;
        if (next == null) {
            maxNode = null;
            return;
        }
        maxNode = first;
        while (next != null) {
            if (next.val >= maxNode.val) {
                maxNode = next;
            }
            next = next.next;
        }

    }

    class Node {
        int val;
        Node next;
    }

    public static void main(String[] args) {

    }
}
