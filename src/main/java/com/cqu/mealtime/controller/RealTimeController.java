package com.cqu.mealtime.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@EnableScheduling
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

    @Scheduled(cron = "*/1 * * * * *")
    private void simulate() {
        num.set(1, num.get(1) + 3.0);
        num.set(2, num.get(2) + 4.0);
        num.set(3, num.get(3) + 5.0);
        for (int i = 1; i < 4; i++)
            if (num.get(i) >= 75.0)
                num.set(i, num.get(i) - 75.0);
    }
}
