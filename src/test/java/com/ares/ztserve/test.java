package com.ares.ztserve;

import org.junit.jupiter.api.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author ESy
 * @date 2023/2/17 017 14:41
 */
public class test {
    public static String getMd5(String plainText) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (byte value : b) {
                i = value;
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            //32位加密
            return buf.toString();
            // 16位的加密
            //return buf.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static void main(String[] args) {
        String context = "cyf1997";
        String md5Context = getMd5(context);
        System.out.println(md5Context);
    }

    @Test
    public void test(){
        boolean contains = "/login/APLUS/1".contains("/login");
        System.out.println(contains);
    }
}
