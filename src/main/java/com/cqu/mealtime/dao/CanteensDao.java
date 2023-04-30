package com.cqu.mealtime.dao;

import com.cqu.mealtime.entity.Canteens;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Canteens)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-24 01:51:24
 */
public interface CanteensDao {

    /**
     * 通过ID查询单条数据
     *
     * @param canteenId 主键
     * @return 实例对象
     */
    Canteens queryById(Integer canteenId);

    Integer count();

    /**
     * 查询指定行数据
     *
     * @param canteens 查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Canteens> queryAllByLimit(Canteens canteens, @Param("pageable") Pageable pageable);


    /**
     * 统计总行数
     *
     * @param canteens 查询条件
     * @return 总行数
     */
    long count(Canteens canteens);

    /**
     * 新增数据
     *
     * @param canteens 实例对象
     * @return 影响行数
     */
    int insert(Canteens canteens);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Canteens> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Canteens> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Canteens> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Canteens> entities);

    /**
     * 修改数据
     *
     * @param canteens 实例对象
     * @return 影响行数
     */
    int update(Canteens canteens);

    /**
     * 通过主键删除数据
     *
     * @param canteenId 主键
     * @return 影响行数
     */
    int deleteById(Integer canteenId);

    List<Canteens> queryAll();
}

