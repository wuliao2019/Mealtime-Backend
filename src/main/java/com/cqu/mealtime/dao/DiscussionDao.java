package com.cqu.mealtime.dao;

import com.cqu.mealtime.entity.Discussion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Discussion)表数据库访问层
 *
 * @author makejava
 * @since 2023-05-06 17:04:58
 */
public interface DiscussionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param discussionId 主键
     * @return 实例对象
     */
    Discussion queryById(Integer discussionId);

    /**
     * 查询指定行数据
     *
     * @param discussion 查询条件
     * @return 对象列表
     */
    List<Discussion> queryAllByLimit(Discussion discussion);

    /**
     * 统计总行数
     *
     * @param discussion 查询条件
     * @return 总行数
     */
    long count(Discussion discussion);

    /**
     * 新增数据
     *
     * @param discussion 实例对象
     * @return 影响行数
     */
    int insert(Discussion discussion);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Discussion> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Discussion> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Discussion> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Discussion> entities);

    /**
     * 修改数据
     *
     * @param discussion 实例对象
     * @return 影响行数
     */
    int update(Discussion discussion);

    /**
     * 通过主键删除数据
     *
     * @param discussionId 主键
     * @return 影响行数
     */
    int deleteById(Integer discussionId);

}

