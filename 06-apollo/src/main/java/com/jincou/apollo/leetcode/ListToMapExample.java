package com.jincou.apollo.leetcode;

import com.alibaba.ttl.threadpool.agent.internal.javassist.bytecode.analysis.Util;
import com.wangyin.commons.util.StringUtil;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhouguilong6
 * @date 2025/3/31 9:59
 */
public class ListToMapExample {

    public static void main(String[] args) {
        List<Map<String, Object>> list = new ArrayList<>();

        // 添加测试数据
        Map<String, Object> item1 = new HashMap<>();
        item1.put("id", "110");
        item1.put("name", "詹三");

        Map<String, Object> item2 = new HashMap<>();
        item2.put("id", "220");
        item2.put("name", "杨武");

        Map<String, Object> item3 = new HashMap<>();
        item3.put("id", "110"); // 重复的键测试
        item3.put("name", "花海");

        Map<String, Object> item4 = new HashMap<>();
        item4.put("id", null); // null 值测试
        item4.put("name", "非请");

        Map<String, Object> item5 = new HashMap<>();
        item5.put("id", ""); // 空字符串测试
        item5.put("name", "院士");

        list.add(item1);
        list.add(item2);
        list.add(item3);
        list.add(item4);
        list.add(item5);

        // list转map
        Map<String, Map<String, Object>> map = list.stream()
                .filter(Objects::nonNull)
                .filter(item -> StringUtil.isNotBlank(ListToMapExample.getStrOfObj(item.get("id"))))
                .collect(Collectors.toMap(
                        item -> ListToMapExample.getStrOfObj(item.get("id")),
                        item -> item,
                        (existing, replacement) -> existing
                ));

        // 打印结果
        map.forEach((key, value) -> System.out.printf("%s ： %s \n", key, value));
    }

    public static String getStrOfObj(Object obj) {
        if (obj == null) {
            return null; // or return a default value
        }
        return obj.toString();
    }
}
