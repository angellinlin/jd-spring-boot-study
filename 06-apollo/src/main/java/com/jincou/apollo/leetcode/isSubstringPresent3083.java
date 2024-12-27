package com.jincou.apollo.leetcode;

/**
 * 3083. 字符串及其反转中是否存在同一子字符串

 * 给你一个字符串 s ，请你判断字符串 s 是否存在一个长度为 2 的子字符串，在其反转后的字符串中也出现。
 *
 * 如果存在这样的子字符串，返回 true；如果不存在，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "leetcode"
 *
 * 输出：true
 *
 * 解释：子字符串 "ee" 的长度为 2，它也出现在 reverse(s) == "edocteel" 中。
 * @author zhouguilong6
 * @date 2024/12/27 16:01
 */
public class isSubstringPresent3083 {
    public static void main(String[] args) {
        System.out.println(isSubstringPresent("leetcode"));
    }

    public static boolean isSubstringPresent(String s) {
        for (int i = 0; i < s.length()-1; i++) {
            String subStr = new StringBuilder(s.substring(i, i + 2)).reverse().toString();
            if(s.contains(subStr)){
                return true;
            }
        }
        return false;
    }
}
