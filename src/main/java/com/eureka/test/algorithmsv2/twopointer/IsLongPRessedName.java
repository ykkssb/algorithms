package com.eureka.test.algorithmsv2.twopointer;

/**
 * <p>925. 长按键入</p>
 * https://leetcode-cn.com/problems/long-pressed-name/
 *
 * @Author : Eric
 * @Date: 2021-01-19 22:08
 */
public class IsLongPRessedName {
    /**
     * todo v2
     *
     * @param name
     * @param typed
     * @return
     */
    public boolean isLongPressedName(String name, String typed) {
        int l = 0, r = 0;
        int len = name.length(), rlen = typed.length();
        while (r < rlen) {
            if (l < len && name.charAt(l) == typed.charAt(r)) {
                ++l;
                ++r;
            } else if (r > 0 && typed.charAt(r - 1) == typed.charAt(r)) {
                ++r;
            } else {
                return false;
            }
        }
        return l == len;
    }

    public static void main(String[] args) {
        String n = "alex";
        String t = "alleexxx";
        IsLongPRessedName is = new IsLongPRessedName();

        System.out.println(is.isLongPressedName(n, t));
    }
}
