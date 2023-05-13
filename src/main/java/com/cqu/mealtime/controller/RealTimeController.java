package com.cqu.mealtime.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

import static com.cqu.mealtime.util.RequestUtil.*;

@EnableScheduling
@RestController
@RequestMapping("realtime")
public class RealTimeController {
    private final List<Double> num = Arrays.asList(1.0, 5.0, 9.0, 10.0);
    Random r = new Random();

    @GetMapping()
    public ResponseEntity<List<Double>> query() {
        return ResponseEntity.ok(num);
    }

    @PostMapping("{id}")
    public void update(@PathVariable("id") Integer id, @RequestParam("num") Double n, @RequestParam("key") String key) {
        if (Objects.equals(key, "20194086"))
            num.set(id - 1, n);
    }

    @PostMapping("photo")
    public String savePic(@RequestParam("file") MultipartFile file) {
        System.out.println("开始接收图片");
        try {
            String fileName = "pic.jpg";
            String imgFilePath = "/home/program/mealtime/";//新生成的图片
            File targetFile = new File(imgFilePath, fileName);
            if (!targetFile.getParentFile().exists()) //注意，判断父级路径是否存在
                targetFile.getParentFile().mkdirs();
            //保存
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("接收图片完成");
        Map<String, String> params = new HashMap<>();
        params.put("src_path", "/home/program/mealtime/pic.jpg");
        params.put("save_dir", "/home/program/mealtime/result/");
        return doPost("http://localhost:8000/infer", urlEncode(params));
    }

    @RequestMapping("getImg")
    public void getImg(HttpServletResponse response) {
        System.out.println("/getImg->访问图片->开始");
        String filePath = "/home/program/mealtime/result/1.jpg";
        File imageFile = new File(filePath);
        if (imageFile.exists()) {
            FileInputStream fis;
            OutputStream os;
            try {
                fis = new FileInputStream(imageFile);
                os = response.getOutputStream();
                int count;
                byte[] buffer = new byte[1024 * 8];
                while ((count = fis.read(buffer)) != -1) {
                    os.write(buffer, 0, count);
                    os.flush();
                }
                System.out.println("[图片接口]输出完成");
                fis.close();
                if (os != null)
                    os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Scheduled(cron = "*/1 * * * * *")
    private void simulate() {
        for (int i = 1; i < 4; i++) {
            double n = num.get(i) + r.nextDouble() * 12 - 6;
            if (n > 75.0)
                n = n - (n - 75);
            else if (n < 0)
                n = -n;
            num.set(i, n);
        }
    }
}
