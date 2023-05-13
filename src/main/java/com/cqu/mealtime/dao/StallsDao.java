package com.cqu.mealtime.dao;

import com.cqu.mealtime.entity.Stalls;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Stalls)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-27 17:20:14
 */
public interface StallsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param stallId 主键
     * @return 实例对象
     */
    Stalls queryById(Integer stallId);

    /**
     * 查询指定行数据
     *
     * @param stalls   查询条件
     * @return 对象列表
     */
    List<Stalls> queryAllByLimit(Stalls stalls);

    /**
     * 统计总行数
     *
     * @param stalls 查询条件
     * @return 总行数
     */
    long count(Stalls stalls);

    /**
     * 新增数据
     *
     * @param stalls 实例对象
     * @return 影响行数
     */
    int insert(Stalls stalls);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Stalls> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Stalls> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Stalls> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Stalls> entities);

    /**
     * 修改数据
     *
     * @param stalls 实例对象
     * @return 影响行数
     */
    int update(Stalls stalls);

    /**
     * 通过主键删除数据
     *
     * @param stallId 主键
     * @return 影响行数
     */
    int deleteById(Integer stallId);

}

