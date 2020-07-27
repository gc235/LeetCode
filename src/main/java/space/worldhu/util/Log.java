package space.worldhu.util;

import com.alibaba.fastjson.JSON;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.MessageFormat;

/**
 * @author hushicheng
 * @date 2020/7/24
 */
public class Log {
    static {
        try {
            String usrHome = System.getProperty("user.home");
            System.setOut(new PrintStream(new FileOutputStream(usrHome + "/logs/LeetCode/all.log",true),true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void println(String formatter, Object... objs) {
        for (int i = 0; i < objs.length; i++) {
            formatter = formatter.replaceFirst("\\{}", "{" + i + "}");
        }
        String formatStr = MessageFormat.format(formatter, objs);
        System.out.println(formatStr);
    }

    public static void println(Object obj) {
        System.out.println(JSON.toJSONString(obj));
    }
}
