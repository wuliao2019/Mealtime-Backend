package com.cqu.mealtime.service;

import com.cqu.mealtime.entity.Canteens;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Canteens)表服务接口
 *
 * @author makejava
 * @since 2023-04-24 01:51:25
 */
public interface CanteensService {

    /**
     * 通过ID查询单条数据
     *
     * @param canteenId 主键
     * @return 实例对象
     */
    Canteens queryById(Integer canteenId);

    Integer countNum();

    /**
     * 分页查询
     *
     * @param canteens 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Canteens> queryByPage(Canteens canteens, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param canteens 实例对象
     * @return 实例对象
     */
    Canteens insert(Canteens canteens);

    /**
     * 修改数据
     *
     * @param canteens 实例对象
     * @return 实例对象
     */
    Canteens update(Canteens canteens);

    /**
     * 通过主键删除数据
     *
     * @param canteenId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer canteenId);

    List<Canteens> queryAll();
}
