package com.cqu.mealtime.dao;

import com.cqu.mealtime.entity.Pictures;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Pictures)表数据库访问层
 *
 * @author makejava
 * @since 2023-05-16 22:57:38
 */
public interface PicturesDao {

    /**
     * 通过ID查询单条数据
     *
     * @param pictureId 主键
     * @return 实例对象
     */
    Pictures queryById(Integer pictureId);
    List<Pictures> queryRecent(Long current, Integer stallId);

    /**
     * 查询指定行数据
     *
     * @param pictures 查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Pictures> queryAllByLimit(Pictures pictures, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param pictures 查询条件
     * @return 总行数
     */
    long count(Pictures pictures);

    /**
     * 新增数据
     *
     * @param pictures 实例对象
     * @return 影响行数
     */
    int insert(Pictures pictures);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Pictures> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Pictures> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Pictures> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Pictures> entities);

    /**
     * 修改数据
     *
     * @param pictures 实例对象
     * @return 影响行数
     */
    int update(Pictures pictures);

    /**
     * 通过主键删除数据
     *
     * @param pictureId 主键
     * @return 影响行数
     */
    int deleteById(Integer pictureId);

}

