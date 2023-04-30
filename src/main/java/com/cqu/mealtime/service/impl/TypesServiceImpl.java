package com.cqu.mealtime.service.impl;

import com.cqu.mealtime.entity.Types;
import com.cqu.mealtime.dao.TypesDao;
import com.cqu.mealtime.service.TypesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Types)表服务实现类
 *
 * @author makejava
 * @since 2023-04-27 17:34:36
 */
@Service("typesService")
public class TypesServiceImpl implements TypesService {
    @Resource
    private TypesDao typesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param typeId 主键
     * @return 实例对象
     */
    @Override
    public Types queryById(Integer typeId) {
        return this.typesDao.queryById(typeId);
    }

    /**
     * 分页查询
     *
     * @param types       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public List<Types> queryByPage(Types types) {
        return this.typesDao.queryAllByLimit(types);
    }

    /**
     * 新增数据
     *
     * @param types 实例对象
     * @return 实例对象
     */
    @Override
    public Types insert(Types types) {
        this.typesDao.insert(types);
        return types;
    }

    /**
     * 修改数据
     *
     * @param types 实例对象
     * @return 实例对象
     */
    @Override
    public Types update(Types types) {
        this.typesDao.update(types);
        return this.queryById(types.getTypeId());
    }

    /**
     * 通过主键删除数据
     *
     * @param typeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer typeId) {
        return this.typesDao.deleteById(typeId) > 0;
    }
}
