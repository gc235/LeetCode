package space.worldhu.util;

import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hushicheng
 * @date 2020/11/10
 */
public class ReadFileUtil {

    public static void main(String[] args) {
        ReadFileUtil readFileUtil = new ReadFileUtil();
        readFileUtil.readLines();
    }

    public void readLines() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\Hu\\Desktop\\xxx.txt"));
            lines.stream().map(s -> {
                List<String> list = new ArrayList<>();
                String[] split = s.split(": ");
                list.add(split[0]);
                list.add(split[1]);
                return list;
            }).forEach(list -> {
                JSONObject params = new JSONObject();

                System.out.println("params.put(\"" + list.get(0) + "\", " + list.get(1) + ");");
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
