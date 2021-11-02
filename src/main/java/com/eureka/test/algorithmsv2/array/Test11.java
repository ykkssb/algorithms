package com.eureka.test.algorithmsv2.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : yuji.wang
 * @date: 2021-10-26 19:32
 */
public class Test11 {

  public static int binarysearchKey(Object[] array, int targetNum) {

    Arrays.sort(array);
    for (int i = 0; i < array.length; i++) {
      System.out.println(array[i]);
    }
    int targetindex = 0;
    int left = 0, right = 0;
    for (right = array.length - 1; left != right; ) {
      int midIndex = (right + left) / 2;
      int mid = (right - left);
      int midValue = (Integer) array[midIndex];
      if (targetNum == midValue) {
        return midIndex;
      }

      if (targetNum > midValue) {
        left = midIndex;
      } else {
        right = midIndex;
      }

      if (mid <= 1) {
        break;
      }
    }
    int rightnum = ((Integer) array[right]).intValue();
    int leftnum = ((Integer) array[left]).intValue();
    int ret =
        Math.abs((rightnum - leftnum) / 2) > Math.abs(rightnum - targetNum) ? rightnum : leftnum;
    System.out.println("和要查找的数：" + targetNum + "最接近的数：" + ret);
    return ret;
  }

  public static void main(String[] args) {

    int[] arr = {1, 2, 29, 30, 32, 35, 40, 41, 50, 60, 68, 80};
    int targetNum = 33;
    List<Integer> list = findClosestElements(arr, 4, targetNum);
    list.forEach(System.out::println);
    Double a = 0.1;
    Double b = 0.1;
//    System.out.println(a.compareTo(b));
    Collections.sort(list,
        new Comparator<Integer>() {
          @Override
          public int compare(Integer a, Integer b) {
            return Math.abs(targetNum - a) < Math.abs(targetNum - b) ? -1 : 1;

          }
        });
    System.out.println("----------");
    list.forEach(System.out::println);
  }

  public static List<Integer> findClosestElements(int[] arr, int k, int x) {
    List<Integer> ret = Arrays.stream(arr).boxed().collect(Collectors.toList());
    int n = ret.size();
    if (x <= ret.get(0)) {
      return ret.subList(0, k);
    } else if (ret.get(n - 1) <= x) {
      return ret.subList(n - k, n);
    } else {
      int index = Collections.binarySearch(ret, x);
      if (index < 0) {
        index = -index - 1;
      }
      int low = Math.max(0, index - k - 1), high = Math.min(ret.size() - 1, index + k - 1);

      while (high - low > k - 1) {
        if ((x - ret.get(low)) <= (ret.get(high) - x)) {
          high--;
        } else if ((x - ret.get(low)) > (ret.get(high) - x)) {
          low++;
        } else {
          System.out.println("unhandled case: " + low + " " + high);
        }
      }
      return ret.subList(low, high + 1);
    }
  }


}
