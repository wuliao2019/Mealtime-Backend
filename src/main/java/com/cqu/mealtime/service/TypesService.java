package com.cqu.mealtime.service;

import com.cqu.mealtime.entity.Types;

import java.util.List;

/**
 * (Types)表服务接口
 *
 * @author makejava
 * @since 2023-04-27 17:34:36
 */
public interface TypesService {

    /**
     * 通过ID查询单条数据
     *
     * @param typeId 主键
     * @return 实例对象
     */
    Types queryById(Integer typeId);

    /**
     *
     * @param types       筛选条件
     * @return 查询结果
     */
    List<Types> queryByPage(Types types);

    /**
     * 新增数据
     *
     * @param types 实例对象
     * @return 实例对象
     */
    Types insert(Types types);

    /**
     * 修改数据
     *
     * @param types 实例对象
     * @return 实例对象
     */
    Types update(Types types);

    /**
     * 通过主键删除数据
     *
     * @param typeId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer typeId);

}
