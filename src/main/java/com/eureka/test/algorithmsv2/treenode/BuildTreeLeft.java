package com.eureka.test.algorithmsv2.treenode;

import com.eureka.test.container.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 *https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/?envType=problem-list-v2&envId=hash-table
 * 05. 从前序与中序遍历序列构造二叉树
 * @author : yujie.wang
 * @date: 2025-09-09 18:22
 */
public class BuildTreeLeft {

    /**
     * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solutions/1/105-cong-qian-xu-yu-zhong-xu-bian-li-xu-4lvkz/?envType=problem-list-v2&envId=hash-table
     * 非常难 todo
     */
    Map<Integer,Integer> map =new HashMap<>();
    public TreeNode buildTree(int[] p, int[] o) {
        TreeNode a = new TreeNode(p[0]);
        int n = p.length;
        for(int i=0;i<n;i++){
            map.put(o[i],i);
        }
        return buildCenter(p,o,0,n-1,0,n-1);
    }

    public TreeNode buildCenter(int[] p ,int[] o, int pefLeft ,int pefRight, int midLeft,int midRight){
        if(pefLeft>pefRight){
            return null;
        }
        //获取根节点在中序遍历数组中的索引
        int midIndex = map.get(p[pefLeft]);
        //前序遍历左边界获取根节点
        TreeNode root=  new TreeNode(p[pefLeft]);
        // 左子树长度
        int leftLength = midIndex- midLeft;
        // 右子树长度
        int rightLength = midRight-  midIndex;
        root.left= buildCenter(p, o, pefLeft+1, pefLeft+leftLength, midLeft, midRight);
        root.right=buildCenter(p,o,pefLeft+1+leftLength, pefRight, midIndex+1,midRight);
        return root;
    }

    public static void main(String[] args) {
        BuildTreeLeft bt = new BuildTreeLeft();
        int[] a = {3, 9, 20, 15, 7};
        int[] b = {9, 3, 15, 20, 7};
        System.out.println(bt.buildTree(a,b));
    }


}
