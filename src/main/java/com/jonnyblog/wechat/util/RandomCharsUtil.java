package com.jonnyblog.wechat.util;

import java.util.Random;

public class RandomCharsUtil {
    private static String codes  = "0123456789";
    private static Random r = new Random();

    private static char randomChar () {
        int index = r.nextInt(codes.length());
        return codes.charAt(index);
    }

    public static String generate4RandomeChars(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<4; i++){
            sb.append(randomChar());
        }
        return sb.toString();
    }
}
