package com.cqu.mealtime.controller;

import com.cqu.mealtime.entity.Types;
import com.cqu.mealtime.service.TypesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import java.util.List;

/**
 * (Types)表控制层
 *
 * @author makejava
 * @since 2023-04-27 17:34:36
 */
@RestController
@RequestMapping("types")
public class TypesController {
    /**
     * 服务对象
     */
    @Resource
    private TypesService typesService;

    /**
     * @param types 筛选条件
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<List<Types>> queryByPage(Types types) {
        return ResponseEntity.ok(this.typesService.queryByPage(types));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Types> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.typesService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param types 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Types> add(Types types) {
        return ResponseEntity.ok(this.typesService.insert(types));
    }

    /**
     * 编辑数据
     *
     * @param types 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Types> edit(Types types) {
        return ResponseEntity.ok(this.typesService.update(types));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.typesService.deleteById(id));
    }

}

