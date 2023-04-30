package com.cqu.mealtime.controller;

import com.cqu.mealtime.entity.Stalls;
import com.cqu.mealtime.service.StallsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Stalls)表控制层
 *
 * @author makejava
 * @since 2023-04-27 17:20:14
 */
@RestController
@RequestMapping("stalls")
public class StallsController {
    /**
     * 服务对象
     */
    @Resource
    private StallsService stallsService;

    /**
     *
     * @param stalls      筛选条件
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<List<Stalls>> queryByPage(Stalls stalls) {
        return ResponseEntity.ok(this.stallsService.queryByPage(stalls));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Stalls> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.stallsService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param stalls 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Stalls> add(Stalls stalls) {
        return ResponseEntity.ok(this.stallsService.insert(stalls));
    }

    /**
     * 编辑数据
     *
     * @param stalls 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Stalls> edit(Stalls stalls) {
        return ResponseEntity.ok(this.stallsService.update(stalls));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.stallsService.deleteById(id));
    }

}

