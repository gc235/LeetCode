package space.worldhu.test;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Enumeration;
import space.worldhu.util.JsUtils;
import space.worldhu.util.RSAUtil;

/**
 * @author hushicheng
 * @date 2020/10/14
 */
public class Test {

    public static void main(String[] args)
            throws InvalidKeySpecException, NoSuchAlgorithmException {
        String key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA73jDjqpLU/z2J2yhTTgH9wgN/Ztym1wRqhHcpAevdEHmJ02/+Qm+2rEHlAfUZR89WD6rxOjMRukIjojmxCIzdZMvN9HM1oZO+PHfpWV1vcxKiCKqfhZgtHSY8IkXGybg45mfhl8Ds3Huji2RPNkBMj8KPU2Ofb8HtBptl/hIGy1rctWy4GSceb7arra5Il+wsjV46Yig/bwrldkePwSZvbRja/DOZCtLOMQJv41rvRH1gSYoWwd5KeJQT1lWBBIoFbfNGSlr8H7ejt1nWJInlRVceWy157eeLqPz9TmEqrYD5VAFqn1sYMphysXIHUPr3IUZJWnooT/330k6A2ec8QIDAQAB";
        String s = RSAUtil.publicEncrypt("371122198801067278", RSAUtil.getPublicKey(key));
        System.out.println(s);

    }

    public static String getRealIp() throws SocketException {
        String localip = null;// 本地IP，如果没有配置外网IP则返回它
        String netip = null;// 外网IP

        Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
        InetAddress ip = null;
        boolean finded = false;// 是否找到外网IP
        while (netInterfaces.hasMoreElements() && !finded) {
            NetworkInterface ni = netInterfaces.nextElement();
            Enumeration<InetAddress> address = ni.getInetAddresses();
            while (address.hasMoreElements()) {
                ip = address.nextElement();
                if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {// 外网IP
                    netip = ip.getHostAddress();
                    finded = true;
                    break;
                } else if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress()
                        && ip.getHostAddress().indexOf(":") == -1) {// 内网IP
                    localip = ip.getHostAddress();
                }
            }
        }

        if (netip != null && !"".equals(netip)) {
            return netip;
        } else {
            return localip;
        }
    }
}
