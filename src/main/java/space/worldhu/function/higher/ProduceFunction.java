package space.worldhu.function.higher;

import java.util.function.Function;

/**
 * @author hushicheng
 * @date 2020/11/4
 */
public class ProduceFunction {
    static FuncSS produce() {
        return s -> s.toLowerCase();
    }

    public static void main(String[] args) {
        FuncSS f = produce();
        System.out.println(f.apply("YELLING"));
    }
}

interface FuncSS extends Function<String, String> {}
