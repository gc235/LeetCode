package space.worldhu.streams;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author hushicheng
 * @date 2020/11/6
 */
public class Randoms {

    public static void main(String[] args) {
        new Random(47)
                .ints(5, 20)
                .distinct()
                .limit(7)
                .sorted()
                .forEach(System.out::println);

        System.out.println();
        orderStyle();
    }

    public static void orderStyle() {
        Random rand = new Random(47);
        SortedSet<Integer> rints = new TreeSet<>();
        while(rints.size() < 7) {
            int r = rand.nextInt(20);
            if (r >= 5) {
                rints.add(r);
            }
        }
        System.out.println(rints);
    }
}
