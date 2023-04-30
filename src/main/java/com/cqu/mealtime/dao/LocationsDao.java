package com.cqu.mealtime.dao;

import com.cqu.mealtime.entity.Locations;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Locations)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-27 17:34:54
 */
public interface LocationsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param locationId 主键
     * @return 实例对象
     */
    Locations queryById(Integer locationId);

    /**
     * @param locations 查询条件
     * @return 对象列表
     */
    List<Locations> queryAllByLimit(Locations locations);

    /**
     * 统计总行数
     *
     * @param locations 查询条件
     * @return 总行数
     */
    long count(Locations locations);

    /**
     * 新增数据
     *
     * @param locations 实例对象
     * @return 影响行数
     */
    int insert(Locations locations);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Locations> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Locations> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Locations> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Locations> entities);

    /**
     * 修改数据
     *
     * @param locations 实例对象
     * @return 影响行数
     */
    int update(Locations locations);

    /**
     * 通过主键删除数据
     *
     * @param locationId 主键
     * @return 影响行数
     */
    int deleteById(Integer locationId);

}

