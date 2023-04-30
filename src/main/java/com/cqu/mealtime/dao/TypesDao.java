package com.cqu.mealtime.dao;

import com.cqu.mealtime.entity.Types;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Types)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-27 17:34:36
 */
public interface TypesDao {

    /**
     * 通过ID查询单条数据
     *
     * @param typeId 主键
     * @return 实例对象
     */
    Types queryById(Integer typeId);

    /**
     * @param types 查询条件
     * @return 对象列表
     */
    List<Types> queryAllByLimit(Types types);

    /**
     * 统计总行数
     *
     * @param types 查询条件
     * @return 总行数
     */
    long count(Types types);

    /**
     * 新增数据
     *
     * @param types 实例对象
     * @return 影响行数
     */
    int insert(Types types);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Types> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Types> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Types> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Types> entities);

    /**
     * 修改数据
     *
     * @param types 实例对象
     * @return 影响行数
     */
    int update(Types types);

    /**
     * 通过主键删除数据
     *
     * @param typeId 主键
     * @return 影响行数
     */
    int deleteById(Integer typeId);

}

