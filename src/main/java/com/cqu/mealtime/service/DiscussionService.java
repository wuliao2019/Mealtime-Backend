package com.cqu.mealtime.service;

import com.cqu.mealtime.entity.Discussion;

import java.util.List;

/**
 * (Discussion)表服务接口
 *
 * @author makejava
 * @since 2023-05-06 17:04:59
 */
public interface DiscussionService {

    /**
     * 通过ID查询单条数据
     *
     * @param discussionId 主键
     * @return 实例对象
     */
    Discussion queryById(Integer discussionId);

    /**
     *
     * @param discussion  筛选条件
     * @return 查询结果
     */
    List<Discussion> queryByPage(Discussion discussion);

    /**
     * 新增数据
     *
     * @param discussion 实例对象
     * @return 实例对象
     */
    Discussion insert(Discussion discussion);

    /**
     * 修改数据
     *
     * @param discussion 实例对象
     * @return 实例对象
     */
    Discussion update(Discussion discussion);

    /**
     * 通过主键删除数据
     *
     * @param discussionId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer discussionId);

}
