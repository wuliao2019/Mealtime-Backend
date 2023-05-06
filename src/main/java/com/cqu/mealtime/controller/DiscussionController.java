package com.cqu.mealtime.controller;

import com.cqu.mealtime.entity.Discussion;
import com.cqu.mealtime.service.DiscussionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Discussion)表控制层
 *
 * @author makejava
 * @since 2023-05-06 17:04:58
 */
@RestController
@RequestMapping("discussion")
public class DiscussionController {
    /**
     * 服务对象
     */
    @Resource
    private DiscussionService discussionService;

    /**
     *
     * @param discussion  筛选条件
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<List<Discussion>> queryByPage(Discussion discussion) {
        return ResponseEntity.ok(this.discussionService.queryByPage(discussion));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Discussion> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.discussionService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param discussion 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Discussion> add(Discussion discussion) {
        return ResponseEntity.ok(this.discussionService.insert(discussion));
    }

    /**
     * 编辑数据
     *
     * @param discussion 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Discussion> edit(Discussion discussion) {
        return ResponseEntity.ok(this.discussionService.update(discussion));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.discussionService.deleteById(id));
    }

}

