package space.worldhu.streams;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import java.security.MessageDigest;
import java.util.stream.LongStream;
import org.apache.commons.codec.digest.DigestUtils;
import sun.security.provider.MD4;

/**
 * @author hushicheng
 * @date 2020/11/16
 */
public class Prime {

    public static Boolean isPrime(long n) {
        return LongStream.rangeClosed(2, (long) Math.sqrt(n))
                .peek(System.out::print)
                .noneMatch(i -> n % i == 0);
    }

    public LongStream numbers() {
        return LongStream.iterate(2, i -> i + 1)
                .filter(Prime::isPrime);
    }

    public static void main(String[] args) {
        new Prime().numbers()
                .limit(10)
                .forEach(n -> System.out.format("%d ", n));
        System.out.println();
        new Prime().numbers()
                .skip(90)
                .limit(10)
                .forEach(n -> System.out.format("%d ", n));
    }


}

