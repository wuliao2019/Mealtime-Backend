package com.cqu.mealtime.service;

import com.cqu.mealtime.entity.Pictures;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Pictures)表服务接口
 *
 * @author makejava
 * @since 2023-05-16 22:57:40
 */
public interface PicturesService {

    /**
     * 通过ID查询单条数据
     *
     * @param pictureId 主键
     * @return 实例对象
     */
    Pictures queryById(Integer pictureId);

    /**
     * 分页查询
     *
     * @param pictures    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Pictures> queryByPage(Pictures pictures, PageRequest pageRequest);

    List<Pictures> queryRecent(Long current, Integer stallId);

    /**
     * 新增数据
     *
     * @param pictures 实例对象
     * @return 实例对象
     */
    Pictures insert(Pictures pictures);

    /**
     * 修改数据
     *
     * @param pictures 实例对象
     * @return 实例对象
     */
    Pictures update(Pictures pictures);

    /**
     * 通过主键删除数据
     *
     * @param pictureId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer pictureId);

}
