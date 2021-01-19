package com.eureka.test.algorithmsv2.twopointer;

/**
 * <p>925. 长按键入</p>
 * https://leetcode-cn.com/problems/long-pressed-name/
 *
 * @Author : Eric
 * @Date: 2021-01-19 22:08
 */
public class IsLongPRessedName {
    public boolean isLongPressedName(String name, String typed) {
        int l = 0, r = 0;
        while (l < name.length() && r < typed.length()) {

            if (name.charAt(l) == typed.charAt(r)) {
                l++;
                r++;
            } else if (r > 0 &&
                    typed.charAt(r) == typed.charAt(r - 1)) {
                r++;
            } else {
                return false;
            }
        }
        if (l != name.length()) {
            return false;
        }
        while (r < typed.length()) {
            if (typed.charAt(r) != typed.charAt(r - 1)) {
                return false;
            }
            r++;
        }
        return true;
    }

    public static void main(String[] args) {
        String n = "alex";
        String t = "alleexxx";
        IsLongPRessedName is = new IsLongPRessedName();

        System.out.println(is.isLongPressedName(n, t));
    }
}
