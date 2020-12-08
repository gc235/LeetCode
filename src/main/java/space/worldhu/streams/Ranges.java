package space.worldhu.streams;

import java.util.stream.IntStream;

/**
 * @author hushicheng
 * @date 2020/11/6
 */
public class Ranges {

    public static void main(String[] args) {
        int result = 0;
        for (int i : IntStream.range(10, 20).toArray()) {
            System.out.println(i);
            result += i;
        }
        System.out.println(result);
        System.out.println(IntStream.range(10, 20).sum());

    }
}
