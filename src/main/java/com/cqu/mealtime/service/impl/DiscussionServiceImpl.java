package com.cqu.mealtime.service.impl;

import com.cqu.mealtime.dao.DiscussionDao;
import com.cqu.mealtime.entity.Discussion;
import com.cqu.mealtime.service.DiscussionService;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.util.List;

/**
 * (Discussion)表服务实现类
 *
 * @author makejava
 * @since 2023-05-06 17:04:59
 */
@Service("discussionService")
public class DiscussionServiceImpl implements DiscussionService {
    @Resource
    private DiscussionDao discussionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param discussionId 主键
     * @return 实例对象
     */
    @Override
    public Discussion queryById(Integer discussionId) {
        return this.discussionDao.queryById(discussionId);
    }

    /**
     *
     * @param discussion  筛选条件
     * @return 查询结果
     */
    @Override
    public List<Discussion> queryByPage(Discussion discussion) {
        return this.discussionDao.queryAllByLimit(discussion);
    }

    /**
     * 新增数据
     *
     * @param discussion 实例对象
     * @return 实例对象
     */
    @Override
    public Discussion insert(Discussion discussion) {
        this.discussionDao.insert(discussion);
        return discussion;
    }

    /**
     * 修改数据
     *
     * @param discussion 实例对象
     * @return 实例对象
     */
    @Override
    public Discussion update(Discussion discussion) {
        this.discussionDao.update(discussion);
        return this.queryById(discussion.getDiscussionId());
    }

    /**
     * 通过主键删除数据
     *
     * @param discussionId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer discussionId) {
        return this.discussionDao.deleteById(discussionId) > 0;
    }
}
