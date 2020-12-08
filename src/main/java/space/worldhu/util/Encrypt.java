package space.worldhu.util;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import java.security.MessageDigest;
import sun.security.provider.MD4;

/**
 * @author hushicheng
 * @date 2020/11/30
 */
public class Encrypt {
    private static String md4(String src) {
        try {
            MessageDigest md4 = MD4.getInstance();
            byte[] digest = md4.digest(src.getBytes());
            return HexBin.encode(digest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
