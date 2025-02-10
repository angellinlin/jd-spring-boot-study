package com.jincou.apollo.juejin.juejin9;

/**
 * @author zhouguilong6
 * @date 2025/2/8 14:13
 */

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Fee Service 接口
 * @author 单程车票
 */
@Service
public interface FeeService extends IService<Fee> {

    /**
     * 普通插入
     * @param feeList 实体类列表
     * @return 插入结果
     */
    int saveByFor(List<Fee> feeList);

    /**
     * foreach 动态拼接插入
     * @param feeList 实体类列表
     * @return 插入结果
     */
    int saveByForeach(List<Fee> feeList);


    /**
     * 批处理插入
     * @param feeList 实体类列表
     * @return 插入结果
     */
    int saveByBatch(List<Fee> feeList);
}