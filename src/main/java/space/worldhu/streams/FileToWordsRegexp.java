package space.worldhu.streams;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import space.worldhu.util.Const;

/**
 * @author hushicheng
 * @date 2020/11/12
 */
public class FileToWordsRegexp {

    private String all;

    private final Pattern compile = Pattern.compile("[ .,?]+");

    public FileToWordsRegexp(String filePath) throws Exception {
        all = Files.lines(Paths.get(filePath))
                .skip(1)
                .collect(Collectors.joining(" "));
    }

    public Stream<String> stream() {
        return compile.splitAsStream(all);
    }

    public static void main(String[] args) throws Exception {
        FileToWordsRegexp fileToWordsRegexp = new FileToWordsRegexp(Const.defFilePath);
        fileToWordsRegexp.stream()
                .limit(7)
                .map(w -> w + " ")
                .forEach(System.out::println);
        fileToWordsRegexp.stream()
                .skip(7)
                .limit(2)
                .map(w -> w + " ")
                .forEach(System.out::println);
    }
}
