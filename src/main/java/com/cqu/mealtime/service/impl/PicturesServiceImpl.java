package com.cqu.mealtime.service.impl;

import com.cqu.mealtime.entity.Pictures;
import com.cqu.mealtime.dao.PicturesDao;
import com.cqu.mealtime.service.PicturesService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Pictures)表服务实现类
 *
 * @author makejava
 * @since 2023-05-16 22:57:40
 */
@Service("picturesService")
public class PicturesServiceImpl implements PicturesService {
    @Resource
    private PicturesDao picturesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param pictureId 主键
     * @return 实例对象
     */
    @Override
    public Pictures queryById(Integer pictureId) {
        return this.picturesDao.queryById(pictureId);
    }

    @Override
    public List<Pictures> queryRecent(Long current, Integer stallId) {
        return this.picturesDao.queryRecent(current, stallId);
    }

    /**
     * 分页查询
     *
     * @param pictures    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Pictures> queryByPage(Pictures pictures, PageRequest pageRequest) {
        long total = this.picturesDao.count(pictures);
        return new PageImpl<>(this.picturesDao.queryAllByLimit(pictures, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param pictures 实例对象
     * @return 实例对象
     */
    @Override
    public Pictures insert(Pictures pictures) {
        this.picturesDao.insert(pictures);
        return pictures;
    }

    /**
     * 修改数据
     *
     * @param pictures 实例对象
     * @return 实例对象
     */
    @Override
    public Pictures update(Pictures pictures) {
        this.picturesDao.update(pictures);
        return this.queryById(pictures.getPictureId());
    }

    /**
     * 通过主键删除数据
     *
     * @param pictureId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer pictureId) {
        return this.picturesDao.deleteById(pictureId) > 0;
    }
}
