package com.eureka.test.algorithmsv2.lru;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>146. LRU 缓存机制</p>
 * https://leetcode-cn.com/problems/lru-cache/submissions/
 *
 * @Author : Eric
 * @Date: 2021-08-04 00:46
 * <p>
 * todo LRU LinkedHashMap实现
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {


/**
 * todo v4 LRU LinkedHashMap实现 removeEldestEntry
 *//*
    private int capacity;

    public LRUCache(int capacity) {x
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<Integer, Integer> entry) {
        return size() > capacity;
    }*/


    /**
     * todo v3 手撸LRU算法
     */
//public class LRUCache {

    LruNode head;
    LruNode tail;
    int max;
    int count;
    Map<Integer, LruNode> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.max = capacity;
        head = new LruNode();
        tail = new LruNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        LruNode t = map.get(key);
        if (t == null) {
            return -1;
        }
        moveToHead(t);
        return t.val;
    }


    public void put(int key, int value) {
        LruNode t = map.get(key);
        if (t == null) {
            t = new LruNode(key, value, null, null);
            addHead(t);
            if (++count > max) {
                LruNode last = removeTail();
                map.remove(last.key);
            }
            map.put(key, t);
        } else {
            t.val = value;
            moveToHead(t);
        }

    }


    public void addHead(LruNode node) {
        head.next.pre = node;
        node.next = head.next;
        head.next = node;
        node.pre = head;
    }

    public void removeNode(LruNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void moveToHead(LruNode node) {
        removeNode(node);
        addHead(node);
    }

    public LruNode removeTail() {
        LruNode last = tail.pre;
        last.pre.next = tail;
        tail.pre = last.pre;
        count--;
        return last;
    }


    public static void main(String[] args) {
        LRUCache l = new LRUCache(2);
        l.put(1, 0);
        l.put(2, 2);
        System.out.println(l.get(1));
        l.put(3, 3);
        System.out.println(l.get(2));
        l.put(4, 4);
        System.out.println(l.get(1));

      /*  l.put(3, 3);
        l.put(4, 4);
        System.out.println(l.get(3));
        System.out.println(l.get(1));
        System.out.println(l.get(4));
*/
    }

    public static class LruNode {
        public int key;
        public int val;
        public LruNode next;
        public LruNode pre;

        public LruNode() {
        }

        public LruNode(int key, int val, LruNode next, LruNode pre) {
            this.val = val;
            this.key = key;
            this.next = next;
            this.pre = pre;
        }
    }
}
