package space.worldhu.streams;

import java.util.stream.Stream;

/**
 * @author hushicheng
 * @date 2020/11/6
 */
public class StreamOf {

    public static void main(String[] args) {
        Stream.of("It`s ", "a", "wonderful ", "day ", "for ", "pie!")
                .forEach(System.out::print);
        System.out.println();
        Stream.of(3.14159, 2.718, 1.618)
                .forEach(System.out::println);
    }
}
