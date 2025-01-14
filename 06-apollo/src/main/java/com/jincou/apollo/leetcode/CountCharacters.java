package com.jincou.apollo.leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * 给定一个字符串，统计字符串中每个字符的出现次数，按照字母表顺序输出，a2b2c4 这种
 * @author zhouguilong6
 * @date 2025/1/14 14:08
 */
public class CountCharacters {

    public static void main(String[] args) {
        System.out.println(countCharacters("ababccdccddddf"));
    }
    public static String countCharacters(String str) {
        //使用 TreeMap 实现有序输出
        Map<Character, Integer> countMap = new TreeMap<>();
        // 统计每个字符串出现的次数
        for (char c : str.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            sb.append(entry.getKey()).append(entry.getValue());
        }
        return sb.toString();
    }

}
