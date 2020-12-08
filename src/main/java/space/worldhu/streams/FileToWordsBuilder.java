package space.worldhu.streams;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;
import space.worldhu.util.Const;

/**
 * @author hushicheng
 * @date 2020/11/12
 */
public class FileToWordsBuilder {

    Builder<String> builder = Stream.builder();
    
    public FileToWordsBuilder(String filePath) throws Exception {
        Files.lines(Paths.get(filePath))
                .skip(1)
                .forEach(line -> {
                    for (String w :
                            line.split("[ .?,]+")) {
                        builder.add(w);
                    }
                });
    }

    Stream<String> stream() {
        return builder.build();
    }

    public static void main(String[] args) throws Exception {
        FileToWordsBuilder fileToWordsBuilder = new FileToWordsBuilder(Const.defFilePath);
        Stream<String> stream = fileToWordsBuilder.stream();
        stream.limit(7)
              .map(w -> w + " ")
              .forEach(System.out::println);
//        不可继续操作
//        fileToWordsBuilder.builder.build().forEach(System.out::println);
//        fileToWordsBuilder.builder.add("xxx");
    }
}
