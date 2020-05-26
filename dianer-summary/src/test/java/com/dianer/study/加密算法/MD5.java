package 学习模块.加密算法;

import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @program: dianer-study
 * @description:
 * @author: dianer
 * @create: 2020-04-12 16:33
 **/

@Slf4j
public final class MD5 {

    private static final String LOG_TAG = "MD5";
    private static final String ALGORITHM = "MD5";

    private static char sHexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static MessageDigest sDigest;

    static {
        try {
            sDigest = MessageDigest.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            log.error("Get MD5 Digest failed.", e);
        }
    }

    private MD5() {
    }

    public final static String encode(String source) {
        byte[] bytes = source.getBytes();
        return encode(bytes);
    }

    public static String encode(byte[] bytes) {
        byte[] encodedBytes = sDigest.digest(bytes);
        return hexString(encodedBytes);
    }

    public static String hexString(byte[] source) {
        if (source == null || source.length <= 0) {
            return "";
        }
        final int size = source.length;
        final char str[] = new char[size * 2];
        int index = 0;
        byte b;
        for (int i = 0; i < size; i++) {
            b = source[i];
            str[index++] = sHexDigits[b >>> 4 & 0xf];
            str[index++] = sHexDigits[b & 0xf];
        }
        return new String(str);
    }

    public static String hash(String str, int len) {
        int h = 0;
        byte[] p = str.getBytes();

        for (int i = 0; i < p.length; i++)
            h = 31 * h + p[i];

        String value = String.valueOf(h);
        if (len > value.length())
            return "";

        return value.substring(value.length() - len, value.length());
    }

    public static void main(String[] args) {
        System.out.println(MD5.encode(""));
        System.out.println(MD5.encode(MD5.encode("")));
    }
}
