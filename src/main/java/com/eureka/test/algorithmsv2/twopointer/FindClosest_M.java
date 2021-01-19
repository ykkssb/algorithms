package com.eureka.test.algorithmsv2.twopointer;

/**
 * <p>面试题 17.11. 单词距离</p>
 * https://leetcode-cn.com/problems/find-closest-lcci/
 *
 * @Author : Eric
 * @Date: 2021-01-19 10:44
 */
public class FindClosest_M {
    /**
     * 双指针1
     *
     * @param words
     * @param word1
     * @param word2
     * @return
     */
    public int findClosest(String[] words, String word1, String word2) {
        int l = 0, r = 0, dist = words.length;
        String next = "";
        while (r < words.length) {
            if (isMatch(words[r], word1, word2)) {

                if (words[r].equals(next) && r - l < dist) {
                    dist = r - l;
                }
                next = getNext(words[r], word1, word2);
                l = r++;
            } else {
                r++;
            }
        }
        return dist;
    }

    /**
     * 一次遍历
     *
     * @param words
     * @param word1
     * @param word2
     * @return
     */
    public int findClosest2(String[] words, String word1, String word2) {
        int l = -1, r = -1, dist = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                l = i;
            } else if (words[i].equals(word2)) {
                r = i;
            }
            if (l != -1 && r != -1) {
                dist = Math.min(dist, Math.abs(r - l));
                if (dist == 1) {
                    return dist;
                }
            }
        }
        return dist;

    }

    private boolean isMatch(String s, String w1, String w2) {
        if (s.equals(w1) || s.equals(w2)) {
            return true;
        }
        return false;
    }

    private String getNext(String s, String w1, String w2) {
        return s.equals(w1) ? w2 : w1;
    }

    public static void main(String[] args) {
        String[] words = {"a", "am", "an", "student", "from", "a", "university", "in", "a", "city"};
        String word1 = "a", word2 = "student";
        FindClosest_M m = new FindClosest_M();
        System.out.println(m.findClosest2(words, word1, word2));
    }
}
