package space.worldhu.function.higher;

import java.util.function.Function;

/**
 * @author hushicheng
 * @date 2020/11/4
 */
public class ConsumeFunction {

    static Two consume(Function<One, Two> onetwo) {
        return onetwo.apply(new One());
    }

    public static void main(String[] args) {
        Two two = consume(one -> new Two());
    }
}

class One {}

class Two {}
