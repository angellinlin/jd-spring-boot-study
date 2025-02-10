package com.jincou.apollo.juejin.juejin9;

/**
 * @author zhouguilong6
 * @date 2025/2/8 14:13
 */

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Fee Service 实现类
 * @author 单程车票
 */
@Service
public class FeeServiceImpl extends ServiceImpl<FeeMapper, Fee> implements FeeService {

    @Resource
    private FeeMapper feeMapper;

    @Resource
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public int saveByFor(List<Fee> feeList) {
        // 记录结果（影响行数）
        int res = 0;
        // 循环插入
        for (Fee fee : feeList) {
            res += feeMapper.insertByOne(fee);
        }
        return res;
    }

    @Override
    public int saveByForeach(List<Fee> feeList) {
        // 通过mapper的foreach动态拼接sql插入
        return feeMapper.insertByForeach(feeList);
    }

    @Transactional
    @Override
    public int saveByBatch(List<Fee> feeList) {
        // 记录结果（影响行数）
        int res = 0;
        // 开启批处理模式
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        FeeMapper feeMapper = sqlSession.getMapper(FeeMapper.class);
        for (int i = 1; i <= feeList.size(); i++) {
            // 利用mapper的单条插入方法插入
            res += feeMapper.insertByOne(feeList.get(i-1));
            // 进行分片类似 JDBC 的批处理
            if (i % 100000 == 0) {
                sqlSession.commit();
                sqlSession.clearCache();
            }
        }
        sqlSession.commit();
        sqlSession.clearCache();
        return res;
    }
}