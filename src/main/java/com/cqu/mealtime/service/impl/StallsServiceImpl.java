package com.cqu.mealtime.service.impl;

import com.cqu.mealtime.entity.Stalls;
import com.cqu.mealtime.dao.StallsDao;
import com.cqu.mealtime.service.StallsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Stalls)表服务实现类
 *
 * @author makejava
 * @since 2023-04-27 17:20:16
 */
@Service("stallsService")
public class StallsServiceImpl implements StallsService {
    @Resource
    private StallsDao stallsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param stallId 主键
     * @return 实例对象
     */
    @Override
    public Stalls queryById(Integer stallId) {
        return this.stallsDao.queryById(stallId);
    }

    /**
     *
     * @param stalls      筛选条件
     * @return 查询结果
     */
    @Override
    public List<Stalls> queryByPage(Stalls stalls) {
        return this.stallsDao.queryAllByLimit(stalls);
    }

    /**
     * 新增数据
     *
     * @param stalls 实例对象
     * @return 实例对象
     */
    @Override
    public Stalls insert(Stalls stalls) {
        this.stallsDao.insert(stalls);
        return stalls;
    }

    /**
     * 修改数据
     *
     * @param stalls 实例对象
     * @return 实例对象
     */
    @Override
    public Stalls update(Stalls stalls) {
        this.stallsDao.update(stalls);
        return this.queryById(stalls.getStallId());
    }

    /**
     * 通过主键删除数据
     *
     * @param stallId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer stallId) {
        return this.stallsDao.deleteById(stallId) > 0;
    }
}
