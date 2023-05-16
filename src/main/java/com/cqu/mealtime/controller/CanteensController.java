package com.cqu.mealtime.controller;

import com.cqu.mealtime.entity.Canteens;
import com.cqu.mealtime.service.CanteensService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Canteens)表控制层
 *
 * @author makejava
 * @since 2023-04-24 01:51:24
 */
@RestController
@RequestMapping("canteens")
public class CanteensController {
    /**
     * 服务对象
     */
    @Resource
    private CanteensService canteensService;

    /**
     *
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<List<Canteens>> queryAll() {
        return ResponseEntity.ok(this.canteensService.queryAll());
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Canteens> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.canteensService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param canteens 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Canteens> add(Canteens canteens) {
        return ResponseEntity.ok(this.canteensService.insert(canteens));
    }

    /**
     * 编辑数据
     *
     * @param canteens 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Canteens> edit(Canteens canteens) {
        return ResponseEntity.ok(this.canteensService.update(canteens));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.canteensService.deleteById(id));
    }
}

