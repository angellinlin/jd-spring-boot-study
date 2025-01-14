package com.jincou.apollo.leetcode;

/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 * @author zhouguilong6
 * @date 2025/1/14 14:43
 */
public class FindTheDifference {
    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd", "abcde"));
    }

    public static char findTheDifference(String s, String t) {
        String[] split = s.split("");
        for (String string : split) {
            t = t.replaceFirst(string, "");
        }
        return t.toCharArray()[0];
    }

}
