package com.jincou.apollo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 3159. 查询数组中元素的出现位置
 * @author zhouguilong6
 * @date 2024/12/27 13:55
 */
public class occurrencesOfElement3159 {
    public static void main(String[] args) {
        int[] nums = {1,3,1,7};
        int[] queries = {1,3,2,4};
        System.out.println(Arrays.toString(occurrencesOfElement(nums, queries, 1)));
    }

    public static int[] occurrencesOfElement(int[] nums, int[] queries , int x){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == x){
                list.add(i);
            }
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
           if(list.size()<queries[i]){
               res[i] = -1;
           }else{
               res[i] = list.get(queries[i]-1);
           }
        }
        return res;
    }

}
