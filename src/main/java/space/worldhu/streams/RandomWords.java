package space.worldhu.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author hushicheng
 * @date 2020/11/6
 */
public class RandomWords implements Supplier<String> {

    List<String> words = new ArrayList<>();

    Random rand = new Random(47);

    RandomWords(String fname) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(fname));
        for (String line :
                lines.subList(1, lines.size())) {
            for (String word :
                    line.split("[ .?,]+")) {
                words.add(word.toLowerCase());
            }
        }
    }

    /**
     * Gets a result.
     *
     * @return a result
     */
    @Override
    public String get() {
        return words.get(rand.nextInt(words.size()));
    }

    @Override
    public String toString() {
        return String.join(" ", words);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(
                Stream.generate(new RandomWords("C:/Users/Hu/MySpace/IDEA-Personal/LeetCode/target/classes/Cheese.dat"))
                .limit(10)
                .collect(Collectors.joining(" "))
        );

        IntStream.generate(() -> (int) (System.nanoTime()))
                .limit(10).forEach(System.out::println);
    }
}
