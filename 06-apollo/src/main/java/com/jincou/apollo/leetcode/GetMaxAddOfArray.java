package com.jincou.apollo.leetcode;

/**
 * @author zhouguilong6
 * @date 2025/3/31 11:26
 */
public class GetMaxAddOfArray {
    public static void main(String[] args) {
        int[] array = {2, 3, -6, 4, 6, 2, -2, 5, -9};
        int max = getMaxAddOfArray(array, array.length);
        System.out.println(max);
    }

    public static int getMaxAddOfArray(int[] arr, int sz) {
        if (arr == null || sz <= 1)
            return 0;
        int MAX = arr[0];
        int sum = arr[0];
        for (int i = 1; i < sz; i++) {
            if (sum < 0)
                sum = arr[i];
            else {
                sum += arr[i];
            }

            if (sum > MAX)
                MAX = sum;
        }
        return MAX;
    }

}
