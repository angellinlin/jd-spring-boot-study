package com.jincou.apollo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 3159. 查询数组中元素的出现位置
 * 给你一个整数数组 nums ，一个整数数组 queries 和一个整数 x 。
 *
 * 对于每个查询 queries[i] ，你需要找到 nums 中第 queries[i] 个 x 的位置，并返回它的下标。如果数组中 x 的出现次数少于 queries[i] ，该查询的答案为 -1 。
 *
 * 请你返回一个整数数组 answer ，包含所有查询的答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,1,7], queries = [1,3,2,4], x = 1
 *
 * 输出：[0,-1,2,-1]
 *
 * 解释：
 *
 * 第 1 个查询，第一个 1 出现在下标 0 处。
 * 第 2 个查询，nums 中只有两个 1 ，所以答案为 -1 。
 * 第 3 个查询，第二个 1 出现在下标 2 处。
 * 第 4 个查询，nums 中只有两个 1 ，所以答案为 -1 。
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
