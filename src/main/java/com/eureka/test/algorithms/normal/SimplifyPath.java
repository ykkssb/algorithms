package com.eureka.test.algorithms.normal;

import java.util.Stack;

/**
 * <p>简化路径</p>
 * https://leetcode-cn.com/problems/simplify-path/
 *
 * @Author : Eric
 * @Date: 2020-05-27 21:18
 */
public class SimplifyPath {

    /**
     * 首先定义栈用来存储路径信息，定义字符数组 str 来分隔字符串
     *
     * 依次遍历字符数组内容，这里使用增强型 for 循环，如果是 “..” 还要再判断是否为空才能弹出栈
     *
     * 如果不为空也不为 “.” 这说明当前元素是路径信息，入栈即可
     *
     * 最后遍历完之后，先判断栈中是否有元素，没有则返回 “/”
     *
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();

        String[] ss = path.split("/");

        for (String s : ss) {
            if (s.equals("")) {
                continue;
            }
            if (!st.isEmpty() && s.equals("..")) {
                st.pop();
            } else {
                if (!s.equals(".") && !s.equals(".."))
                    st.push(s);
            }
        }

        if (st.isEmpty()) {
            return "/";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < st.size(); i++) {
            sb.append("/" + st.elementAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        SimplifyPath s = new SimplifyPath();
        System.out.println(s.simplifyPath("/../a/b/c"));

    }
}
