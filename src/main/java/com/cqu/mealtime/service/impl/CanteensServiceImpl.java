package com.cqu.mealtime.service.impl;

import com.cqu.mealtime.entity.Canteens;
import com.cqu.mealtime.dao.CanteensDao;
import com.cqu.mealtime.service.CanteensService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Canteens)表服务实现类
 *
 * @author makejava
 * @since 2023-04-24 01:51:25
 */
@Service("canteensService")
public class CanteensServiceImpl implements CanteensService {
    @Resource
    private CanteensDao canteensDao;

    /**
     * 通过ID查询单条数据
     *
     * @param canteenId 主键
     * @return 实例对象
     */
    @Override
    public Canteens queryById(Integer canteenId) {
        return this.canteensDao.queryById(canteenId);
    }

    @Override
    public Integer count() {
        return this.canteensDao.count();
    }

    /**
     * 分页查询
     *
     * @param canteens    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Canteens> queryByPage(Canteens canteens, PageRequest pageRequest) {
        long total = this.canteensDao.count(canteens);
        return new PageImpl<>(this.canteensDao.queryAllByLimit(canteens, pageRequest), pageRequest, total);
    }

    @Override
    public List<Canteens> queryAll() {
        return this.canteensDao.queryAll();
    }

    /**
     * 新增数据
     *
     * @param canteens 实例对象
     * @return 实例对象
     */
    @Override
    public Canteens insert(Canteens canteens) {
        this.canteensDao.insert(canteens);
        return canteens;
    }

    /**
     * 修改数据
     *
     * @param canteens 实例对象
     * @return 实例对象
     */
    @Override
    public Canteens update(Canteens canteens) {
        this.canteensDao.update(canteens);
        return this.queryById(canteens.getCanteenId());
    }

    /**
     * 通过主键删除数据
     *
     * @param canteenId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer canteenId) {
        return this.canteensDao.deleteById(canteenId) > 0;
    }
}
