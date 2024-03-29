package com.eureka.test.factory;

import com.eureka.test.algorithmsv2.bfs.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2021-07-12 17:01
 */
public class NodeTrans {
    public static List<Node> list = new ArrayList<>();
    public static Integer NUL = 1000;

    public static Node transNode(int[] array) {

//        TreeNode tmp = res;
        for (int i = 0; i < array.length; i++) {
            Node node = new Node(array[i]);
            //创建结点，每一个结点的左结点和右结点为null
            if (array[i] == NUL) {
                list.add(null);
            } else {
                list.add(node);
            }

            // list中存着每一个结点
        }
        // 构建二叉树
        if (list.size() > 0) {
            for (int i = 0; i < array.length / 2 - 1; i++) {
                if (list.get(2 * i + 1) != null) {
                    // 左结点
                    list.get(i).left = list.get(2 * i + 1);
                }
                if (list.get(2 * i + 2) != null) {
                    // 右结点
                    list.get(i).right = list.get(2 * i + 2);
                }
            }
            // 判断最后一个根结  点：因为最后一个根结点可能没有右结点，所以单独拿出来处理
            int lastIndex = array.length / 2 - 1;
            // 左结点
            if (list.get(lastIndex) != null)
                list.get(lastIndex).left = list.get(lastIndex * 2 + 1);
            // 右结点，如果数组的长度为奇数才有右结点
            if (array.length % 2 == 1) {
                list.get(lastIndex).right = list.get(lastIndex * 2 + 2);
            }

        }
        return list.get(0);
    }

    public static boolean isF(int i) {
        return i == 1000;
    }

    public static void main(String[] args) {
        int[] array = {1, 1000, 2, 3};
        Node t = NodeTrans.transNode(array);

       /* List<Integer> list = new ArrayList<>();
        list.add(null);
        list.get(0);*/
    }
}
