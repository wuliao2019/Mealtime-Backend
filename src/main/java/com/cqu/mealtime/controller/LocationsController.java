package com.cqu.mealtime.controller;

import com.cqu.mealtime.entity.Locations;
import com.cqu.mealtime.service.LocationsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Locations)表控制层
 *
 * @author makejava
 * @since 2023-04-27 17:34:54
 */
@RestController
@RequestMapping("locations")
public class LocationsController {
    /**
     * 服务对象
     */
    @Resource
    private LocationsService locationsService;

    /**
     *
     * @param locations   筛选条件
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<List<Locations>> queryByPage(Locations locations) {
        return ResponseEntity.ok(this.locationsService.queryByPage(locations));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Locations> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.locationsService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param locations 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Locations> add(Locations locations) {
        return ResponseEntity.ok(this.locationsService.insert(locations));
    }

    /**
     * 编辑数据
     *
     * @param locations 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Locations> edit(Locations locations) {
        return ResponseEntity.ok(this.locationsService.update(locations));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.locationsService.deleteById(id));
    }

}

