package com.eureka.test.algorithms.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>复原IP地址</p>
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 *
 * @Author : Eric
 * @Date: 2020-06-30 19:37
 */
public class RestoreIpAddresses {

    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        if (s == null || len == 0 || len > 12 || len < 4) {
            return res;
        }
        List<String> ip = new ArrayList<>();
        dfs(s, len, 0, 4, ip, res);
        return res;
    }


    public void dfs(String s, int len, int index, int last, List<String> ip, List<String> res) {
        if (index == len && last == 0) {
            res.add(String.join(".", ip));
            return;
        }
        for (int i = index; i < index + 3; i++) {

            if (i >= len) {
                break;
            }

            if (last * 3 < len - i) {
                continue;
            }
            if (isIpSeg(s, index, i)) {
                String tmp = s.substring(index, i + 1);
                ip.add(tmp);

                dfs(s, len, i + 1, last - 1, ip, res);
                ip.remove(ip.size() - 1);
            }
        }

    }


    public boolean isIpSeg(String s, int start, int end) {
        int len = end - start +1;
        // 长度>1 只能有一个0
        if (len > 1 && s.charAt(start) == '0') {
            return false;
        }

        int res = 0;
        while (start <= end) {
            res = res * 10 + s.charAt(start) - '0';
            start++;
        }

        return res >= 0 && res <= 255;
    }

    public static void main(String[] args) {
//        String s = "2552551112";
        String s = "010010";
        RestoreIpAddresses re = new RestoreIpAddresses();
        System.out.println(re.restoreIpAddresses(s));
//        String s = "1";
//        System.out.println(s.substring(0,1));
    }
}
