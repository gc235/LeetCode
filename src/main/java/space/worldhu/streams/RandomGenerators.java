package space.worldhu.streams;

import java.util.Random;
import java.util.stream.Stream;

/**
 * @author hushicheng
 * @date 2020/11/6
 */
public class RandomGenerators {

    public static <T> void show(Stream<T> stream) {
        stream.limit(4)
                .forEach(System.out::println);
        System.out.println("+++++++");
    }

    public static void main(String[] args) {
        Random rand = new Random(47);
        show(rand.ints(2).boxed());
        show(rand.longs(2).boxed());
        show(rand.doubles(2).boxed());
    }
}
