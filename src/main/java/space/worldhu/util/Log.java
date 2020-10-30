package space.worldhu.util;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author hushicheng
 * @date 2020/7/24
 */
public class Log {
//    static {
//        try {
//            String usrHome = System.getProperty("user.home");
//            System.setOut(new PrintStream(new FileOutputStream(usrHome + "/logs/LeetCode/all.log",true),true));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

    public static void println(String formatter, Object... objs) {
        for (int i = 0; i < objs.length; i++) {
            formatter = formatter.replaceFirst("\\{}", "{" + i + "}");
        }
        String formatStr = MessageFormat.format(formatter, objs);
        System.out.println(formatStr);
    }

    public static void printErrLn(String formatter, Object... objs) {
        for (int i = 0; i < objs.length; i++) {
            formatter = formatter.replaceFirst("\\{}", "{" + i + "}");
        }
        String formatStr = MessageFormat.format(formatter, objs);
        System.err.println(formatStr);
    }

    public static void println(Object obj) {
        System.out.println(JSON.toJSONString(obj));
    }

    public static void readLine() {
        try {

            List<String> readLines = new ArrayList<>();
            IoUtil.readLines(new FileInputStream(new File(System.getProperty("user.home")
                    + "\\logs\\LeetCode\\all.log")), Charset
                            .defaultCharset(), readLines);
            Set<String> theSet = new HashSet<>(readLines);
            System.out.println(theSet.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
