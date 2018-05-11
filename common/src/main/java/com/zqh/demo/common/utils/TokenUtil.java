package com.zqh.demo.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class TokenUtil {
    private static String cc = "express-demo";

    public static String createToken(String userName) throws NoSuchAlgorithmException {
        //用于加密的字符
        char md5String[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};

        MessageDigest mdInst = MessageDigest.getInstance("md5");
        mdInst.update((cc+"-"+userName).getBytes());
        byte[] md = mdInst.digest();

        // 把密文转换成十六进制的字符串形式
        int j = md.length;
        System.out.println(j + "=======================");
        char str[] = new char[j * 2];
        int k = 0;
        for (int i = 0; i < j; i++) { // i = 0
            byte byte0 = md[i]; //95
            str[k++] = md5String[byte0 >>> 4 & 0xf]; // 5
            str[k++] = md5String[byte0 & 0xf]; // F
        }

        return new String(str);
    }




}
