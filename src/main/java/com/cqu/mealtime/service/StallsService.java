package com.cqu.mealtime.service;

import com.cqu.mealtime.entity.Stalls;

import java.util.List;

/**
 * (Stalls)表服务接口
 *
 * @author makejava
 * @since 2023-04-27 17:20:16
 */
public interface StallsService {

    /**
     * 通过ID查询单条数据
     *
     * @param stallId 主键
     * @return 实例对象
     */
    Stalls queryById(Integer stallId);

    /**
     * @param stalls 筛选条件
     * @return 查询结果
     */
    List<Stalls> queryByPage(Stalls stalls);

    /**
     * 新增数据
     *
     * @param stalls 实例对象
     * @return 实例对象
     */
    Stalls insert(Stalls stalls);

    /**
     * 修改数据
     *
     * @param stalls 实例对象
     * @return 实例对象
     */
    Stalls update(Stalls stalls);

    /**
     * 通过主键删除数据
     *
     * @param stallId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer stallId);

    List<Stalls> getStallsByName(String name);
}
