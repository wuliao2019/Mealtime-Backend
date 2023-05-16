package com.cqu.mealtime.controller;

import com.cqu.mealtime.entity.Stalls;
import com.cqu.mealtime.service.StallsService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import static com.cqu.mealtime.util.RequestUtil.*;

@EnableScheduling
@RestController
@RequestMapping("realtime")
public class RealTimeController {
    private final List<Double> num = Arrays.asList(1.0, 5.0, 9.0, 10.0);
    Random r = new Random();
    @Resource
    private StallsService stallsService;

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
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS");
        String name = simpleDateFormat.format(date);
        String fileName = name + ".jpg";
        String imgFilePath = "/home/program/mealtime/";//新生成的图片
        System.out.println("开始接收图片");
        try {
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
        params.put("src_path", imgFilePath + fileName);
        params.put("save_dir", imgFilePath);
        params.put("file_name", name);
        final JSONObject[] jsonObject = new JSONObject[1];
        final int[] stallId = {0};
        final int[] canId = {0};
        try {
            CompletableFuture.allOf(
                    CompletableFuture.runAsync(new FutureTask<Void>(() -> {
                        System.out.println("开始推理图片");
                        jsonObject[0] = new JSONObject(doPost("http://localhost:8000/infer", urlEncode(params)));
                        System.out.println("推理图片完成");
                    }, null)),
                    CompletableFuture.runAsync(new FutureTask<Void>(() -> {
                        System.out.println("开始识别档口名称");
                        JSONObject js = new JSONObject(queryName(imgFilePath + fileName));
                        if (js.getInt("words_result_num") > 0) {
                            JSONArray jsonArray = js.getJSONArray("words_result");
                            JSONObject temp_js = jsonArray.getJSONObject(0);
                            int max_s = temp_js.getInt("score");
                            String max_n = temp_js.getString("words");
                            for (int i = 1; i < jsonArray.length(); i++) {
                                temp_js = jsonArray.getJSONObject(i);
                                if (temp_js.getInt("score") > max_s) {
                                    max_s = temp_js.getInt("score");
                                    max_n = temp_js.getString("words");
                                }
                            }
                            System.out.println(max_n);
                            List<Stalls> stallsList = this.stallsService.getStallsByName(max_n);
                            if (stallsList.size() > 0) {
                                double min = getStringDistance(stallsList.get(0).getStallName(), max_n);
                                int ind = 0;
                                for (int i = 1; i < stallsList.size(); i++) {
                                    double t = getStringDistance(stallsList.get(i).getStallName(), max_n);
                                    if (t < min) {
                                        min = t;
                                        ind = i;
                                    }
                                }
                                stallId[0] = stallsList.get(ind).getStallId();
                                canId[0] = stallsList.get(ind).getCanId();
                                System.out.println(stallsList.get(ind).getStallName());
                            }
                        }
                        System.out.println("识别档口名称完成");
                    }, null))
            ).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        jsonObject[0].put("stallId", stallId[0]);
        jsonObject[0].put("canId", canId[0]);
        return jsonObject[0].toString();
    }

    @RequestMapping("getImg/{file_name}")
    public void getImg(HttpServletResponse response, @PathVariable("file_name") String name) {
        System.out.println("/getImg->访问图片->开始");
        String filePath = "/home/program/mealtime/" + name + "_out.jpg";
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

    public double getStringDistance(String s1, String s2) {
        double[][] distance;// 定义距离表
        int s1_len = s1.length();
        int s2_len = s2.length();
        if (s1_len == 0)
            return s2_len;
        if (s2_len == 0)
            return s1_len;
        distance = new double[s1_len + 1][s2_len + 1];
        // 二维数组第一行和第一列放置自然数
        for (int i = 0; i <= s1_len; i++)
            distance[i][0] = i;
        for (int j = 0; j <= s2_len; j++)
            distance[0][j] = j;
        // 比较，若行列相同，则代价为0，否则代价为1；
        for (int i = 1; i <= s1_len; i++) {
            char s1_i = s1.charAt(i - 1);
            // 逐一比较
            for (int j = 1; j <= s2_len; j++) {
                char s2_j = s2.charAt(j - 1);
                // 若相等，则代价取0；直接取左上方值
                if (s1_i == s2_j) {
                    distance[i][j] = distance[i - 1][j - 1];
                } else {
                    // 否则代价取1，取左上角、左、上 最小值 + 代价（代价之和便是最终距离）
                    distance[i][j] = getMin(distance[i - 1][j], distance[i][j - 1], distance[i - 1][j - 1]) + 1;
                }
            }
        }
        // 取二位数组最后一位便是两个字符串之间的距离
        return distance[s1_len][s2_len];
    }

    // 求最小值
    private double getMin(double a, double b, double c) {
        double min = a;
        if (b < min)
            min = b;
        if (c < min)
            min = c;
        return min;
    }
}
