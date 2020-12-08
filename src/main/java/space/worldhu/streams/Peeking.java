package space.worldhu.streams;

import java.util.Arrays;

/**
 * @author hushicheng
 * @date 2020/11/12
 */
public class Peeking {

    public static void main(String[] args) {
        Arrays.stream(new int[] { 1, 3, 5, 7, 15, 28, 37 }, 3, 6)
                .forEach(n -> System.out.format("%d ", n));
    }
}
