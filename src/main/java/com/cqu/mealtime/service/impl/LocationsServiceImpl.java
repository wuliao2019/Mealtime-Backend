package com.cqu.mealtime.service.impl;

import com.cqu.mealtime.entity.Locations;
import com.cqu.mealtime.dao.LocationsDao;
import com.cqu.mealtime.service.LocationsService;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.util.List;

/**
 * (Locations)表服务实现类
 *
 * @author makejava
 * @since 2023-04-27 17:34:54
 */
@Service("locationsService")
public class LocationsServiceImpl implements LocationsService {
    @Resource
    private LocationsDao locationsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param locationId 主键
     * @return 实例对象
     */
    @Override
    public Locations queryById(Integer locationId) {
        return this.locationsDao.queryById(locationId);
    }

    /**
     * @param locations 筛选条件
     * @return 查询结果
     */
    @Override
    public List<Locations> queryByPage(Locations locations) {
        return this.locationsDao.queryAllByLimit(locations);
    }

    /**
     * 新增数据
     *
     * @param locations 实例对象
     * @return 实例对象
     */
    @Override
    public Locations insert(Locations locations) {
        this.locationsDao.insert(locations);
        return locations;
    }

    /**
     * 修改数据
     *
     * @param locations 实例对象
     * @return 实例对象
     */
    @Override
    public Locations update(Locations locations) {
        this.locationsDao.update(locations);
        return this.queryById(locations.getLocationId());
    }

    /**
     * 通过主键删除数据
     *
     * @param locationId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer locationId) {
        return this.locationsDao.deleteById(locationId) > 0;
    }
}
