package space.worldhu.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author hushicheng
 * @date 2020/11/20
 */
public class ZhonghuaLianHeCompare {

    public static void main(String[] args) {
        JSONObject zhonghua = readLine("1.json");
        JSONObject local = readText("2.json");
        zhonghua.keySet().forEach(key -> {
            Object z = zhonghua.get(key);
            Object l = local.get(key);
            if (Objects.equals(z, l)) {
                return;
            }
            Log.println("zhonghua: {} : {} , local: {}", key, z, l);
        });
    }

    public static JSONObject readLine(String fileName) {
        try {
            List<String> readLines = IOUtils
                    .readLines(new FileInputStream(new File("C:\\Users\\Hu\\Desktop\\" + fileName)), Charset
                            .defaultCharset());
            Map<String, Object> mapy = new HashMap<>();
            readLines.forEach(line -> {
                String[] split = line.split(":");
                String name = split[0];
                String value = "";
                if (split.length > 1) {
                    if (!StringUtils.isEmpty(split[1].trim())) {
                        value = split[1].trim();
                    }
                }
                mapy.put(name, value);
            });
            JSONObject obj = new JSONObject(mapy);
            return obj;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static JSONObject readText(String fileName) {
        File file = new File("C:\\Users\\Hu\\Desktop\\" + fileName);
        try {
            String s = copyToString(new FileInputStream(file), Charset.defaultCharset());

            JSONObject obj = JSON.parseObject(s, Feature.OrderedField);
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String copyToString( InputStream in, Charset charset) throws IOException {
        if (in == null) {
            return "";
        }

        StringBuilder out = new StringBuilder();
        InputStreamReader reader = new InputStreamReader(in, charset);
        char[] buffer = new char[4096];
        int bytesRead = -1;
        while ((bytesRead = reader.read(buffer)) != -1) {
            out.append(buffer, 0, bytesRead);
        }
        return out.toString();
    }
}
