package space.worldhu.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author hushicheng
 * @date 2020/10/20
 */
public class GuoShouJsonCompare {

    public static void main(String[] args) {
        JSONObject gpic = readText("1.json");
        JSONObject local = readText("2.json");
        Map<String, Integer> c1 = new HashMap<>();
        Map<String, Integer> c2 = new HashMap<>();
        compare(gpic, local, c1);
//        compare(local, gpic, c2);
//        c2.forEach((k2, v) -> {
//            if (!c2.get(k2).equals(c1.get(k2))) {
//                System.out.println(k2 + "  " + v);
//            }
//        });
    }

    public static Map<String, Integer> compare(JSONObject obj1, JSONObject obj2,
            Map<String, Integer> map) {
        obj1.forEach((key, o) -> {
            Integer xx = map.get(key);
            if (xx == null) {
                xx = 1;
            } else {
                xx = xx + 1;
            }
            map.put(key, xx);
            if (key.equals("id") || key.endsWith("Id")) {
                return;
            }
            Object o1 = obj1.get(key);
            Object o2 = obj2.get(key);
            if (Objects.equals(o1, o2)) {
                return;
            }
            if (o1 == null || o2 == null) {
                Log.println("null value-->key:{}  o1:{}  o2:{}", key, o1, o2);
            }else if (!(o1 instanceof JSONObject) && !(o1 instanceof JSONArray)) {
                if (Objects.equals(o1, o2)) {
//                    Log.println("equals  key:{}  o1:{}  o2:{}", key, o1, o2);
                } else {
                    Log.printErrLn("not key:{}  o1:{}  o2:{}", key, o1, o2);
                }
            }else if (o1 instanceof JSONObject) {
                Log.println("+++++++++++++++++++++++++");
                Log.println("enter {}", key);
                compare((JSONObject) o1, (JSONObject) o2, map);
            }else if (o1 instanceof JSONArray) {
                JSONArray arr1 = (JSONArray) o1;
                JSONArray arr2 = (JSONArray) o2;
                for (int i = 0; i < arr1.size(); i++) {
                    Log.println("+++++++++++++++++++++++++");
                    Log.println("enter {}:{}", key, i);
                    compare(arr1.getJSONObject(i), arr2.getJSONObject(i), map);
                }

            }
        });
//        set.forEach(System.out::println);
        return map;
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
