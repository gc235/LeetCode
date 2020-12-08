package space.worldhu.function.closure;

import java.util.function.IntSupplier;

/**
 * @author hushicheng
 * @date 2020/11/4
 */
public class Closure1 {

    IntSupplier makeFun(int x) {
        int i = 0;
        return () -> x + i;
    }
}
