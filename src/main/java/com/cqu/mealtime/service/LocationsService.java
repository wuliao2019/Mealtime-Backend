package com.cqu.mealtime.service;

import com.cqu.mealtime.entity.Locations;

import java.util.List;

/**
 * (Locations)表服务接口
 *
 * @author makejava
 * @since 2023-04-27 17:34:54
 */
public interface LocationsService {

    /**
     * 通过ID查询单条数据
     *
     * @param locationId 主键
     * @return 实例对象
     */
    Locations queryById(Integer locationId);

    /**
     *
     * @param locations   筛选条件
     * @return 查询结果
     */
    List<Locations> queryByPage(Locations locations);

    /**
     * 新增数据
     *
     * @param locations 实例对象
     * @return 实例对象
     */
    Locations insert(Locations locations);

    /**
     * 修改数据
     *
     * @param locations 实例对象
     * @return 实例对象
     */
    Locations update(Locations locations);

    /**
     * 通过主键删除数据
     *
     * @param locationId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer locationId);

}
