package com.jincou.apollo.juejin.strategeImpl;

import cn.hutool.core.util.ObjectUtil;
import lombok.NonNull;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhouguilong6
 * @date 2024/12/30 14:03
 */
public interface IDictEnum {
    /**
     * 缓存已获取的枚举数据
     */
    Map<Class<?>, Map<Integer, Enum<?>>> enumCache = new ConcurrentHashMap<>();

    /**
     * 获取类型
     */
    Integer getType();

    /**
     * 获取描述
     */
    String getDesc();

    /**
     * 获取类型字符串
     *
     * @return 类型字符串
     */
    default String getTypeString() {
        Integer type = getType();
        return ObjectUtil.isNull(type) ? null : type.toString();
    }

    /**
     * 根据类型获取类型描述
     *
     * @param type  类型
     * @param clazz 类
     * @param <E>   泛型
     * @return 枚举
     */
    static <E extends Enum<E> & IDictEnum> E getEnum(Integer type, Class<E> clazz) {
        if (type == null || clazz == null) {
            return null;
        }

        // 尝试从缓存中获取
        Map<Integer, Enum<?>> cachedEnums = enumCache.computeIfAbsent(clazz, k -> new ConcurrentHashMap<>());
        Enum<?> cachedEnum = cachedEnums.get(type);
        if (cachedEnum != null) {
            return clazz.cast(cachedEnum);
        }

        EnumSet<E> all = EnumSet.allOf(clazz);
        E result = all.stream().filter(e -> e.getType().equals(type)).findFirst().orElse(null);
        if (result != null) {
            cachedEnums.put(type, result);
        }

        return result;
    }

    /**
     * 根据类型获取类型描述
     *
     * @param type  类型
     * @param clazz 类
     * @param <E>   泛型
     * @return 枚举
     */
    static <E extends Enum<E> & IDictEnum> E getEnum(String type, Class<E> clazz) {
        return getEnum(Integer.parseInt(type), clazz);
    }

    /**
     * 如果为空则返回默认的字典
     *
     * @param type        类型
     * @param clazz       类
     * @param defaultDict 默认值
     * @param <E>         泛型
     * @return 枚举
     */
    static <E extends Enum<E> & IDictEnum> E defaultIfNull(Integer type, Class<E> clazz, E defaultDict) {
        return ObjectUtil.defaultIfNull(getEnum(type, clazz), defaultDict);
    }

    /**
     * 获取类型获取类型编号
     *
     * @param desc  描述
     * @param clazz 类
     * @param <E>   泛型
     * @return 枚举
     */
    static <E extends Enum<E> & IDictEnum> E getEnumByDesc(String desc, Class<E> clazz) {
        if (desc == null || clazz == null) {
            return null;
        }

        EnumSet<E> all = EnumSet.allOf(clazz);
        return all.stream().filter(e -> e.getDesc().equals(desc)).findFirst().orElse(null);
    }

    /**
     * 获取类型获取类型编号
     *
     * @param type  类型
     * @param clazz 类
     * @param <E>   泛型
     * @return 枚举
     */
    static <E extends Enum<E> & IDictEnum> String getDescByType(Integer type, Class<E> clazz) {
        E dict = getEnum(type, clazz);
        if (dict == null) {
            return "未知";
        }

        return dict.getDesc();
    }

    /**
     * 判断两个字典枚举是否一致
     *
     * @param e1 字典1
     * @param e2 字典2
     * @return 是否一致
     */
    static boolean eq(IDictEnum e1, IDictEnum e2) {
        if (ObjectUtil.isNull(e1) && ObjectUtil.isNull(e2)) {
            return true;
        }

        if (ObjectUtil.isNull(e1) || ObjectUtil.isNull(e2)) {
            return false;
        }

        return e1.equals(e2);
    }

    /**
     * 判断type是否和字典一样的类型
     *
     * @param type type
     * @param e    字典
     * @return 是否一致
     */
    static boolean eq(Integer type, IDictEnum e) {
        if (ObjectUtil.isNull(type) && ObjectUtil.isNull(e)) {
            return true;
        }

        if (ObjectUtil.isNull(type) || ObjectUtil.isNull(e)) {
            return false;
        }

        return type.equals(e.getType());
    }

    /**
     * 判断两个字典枚举是否不同
     *
     * @param e1 字典1
     * @param e2 字典2
     * @return 是否不同
     */
    static boolean ne(@NonNull IDictEnum e1, @NonNull IDictEnum e2) {
        return !eq(e1, e2);
    }

    /**
     * 判断两个字典枚举是否不同
     *
     * @param type 类型
     * @param e    字典
     * @return 是否不同
     */
    static boolean ne(Integer type, IDictEnum e) {
        return !eq(type, e);
    }

    /**
     * 判断多个字典枚举是否不同
     *
     * @param type 类型
     * @param es   字典
     * @return 是否不同
     */
    static boolean ne(Integer type, IDictEnum... es) {
        return es != null && es.length > 0 && Arrays.stream(es).allMatch(e -> ne(type, e));
    }

    /**
     * 判断该枚举值是否为空
     *
     * @param type  类型
     * @param clazz 类
     * @return 是否为空
     */
    static <E extends Enum<E> & IDictEnum> boolean isNull(Integer type, Class<E> clazz) {
        return ObjectUtil.isNull(getEnum(type, clazz));
    }

    /**
     * 当type是否和字典是一样的类型的时候执行指定函数
     *
     * @param type 类型
     * @param e    字典
     * @param func 函数引用
     */
    static void handleIfEqual(Integer type, IDictEnum e, Runnable func) {
        if (eq(type, e)) {
            func.run();
        }
    }

    /**
     * 当type是否和字典是一样的类型的时候执行指定函数
     *
     * @param e1   字典1
     * @param e2   字典2
     * @param func 函数引用
     */
    static void handleIfEqual(IDictEnum e1, IDictEnum e2, Runnable func) {
        if (eq(e1, e2)) {
            func.run();
        }
    }

    /**
     * 如果是该枚举则执行函数调用
     *
     * @param type 类型
     * @param func 函数引用
     */
    default void handleIf(Integer type, Runnable func) {
        if (eq(type, this)) {
            func.run();
        }
    }

    /**
     * 如果是该枚举则执行函数调用
     *
     * @param dict 字典
     * @param func 函数调用
     */
    default void handleIf(IDictEnum dict, Runnable func) {
        if (eq(dict, this)) {
            func.run();
        }
    }
}

