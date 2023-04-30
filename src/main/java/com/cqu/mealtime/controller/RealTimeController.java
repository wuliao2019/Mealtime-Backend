package com.cqu.mealtime.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("realtime")
public class RealTimeController {
    private final List<Double> num = Arrays.asList(1.0, 5.0, 9.0, 10.0);

    @GetMapping()
    public ResponseEntity<List<Double>> query() {
        return ResponseEntity.ok(num);
    }

    @PostMapping("{id}")
    public void update(@PathVariable("id") Integer id, @RequestParam("num") Double n, @RequestParam("key") String key) {
        if (Objects.equals(key, "20194086"))
            num.set(id - 1, n);
    }
}
