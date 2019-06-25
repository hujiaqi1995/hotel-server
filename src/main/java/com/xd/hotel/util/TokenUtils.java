package com.xd.hotel.util;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by jiaqi on 2019/6/18 5:49 PM
 */
public class TokenUtils {
    private static final int TOKEN_LENGTH = 20;

    public static String generate() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < TOKEN_LENGTH; i++) {
            sb.append(ThreadLocalRandom.current().nextInt(10));
        }
        return sb.toString();
    }
}
