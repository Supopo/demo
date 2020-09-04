package com.xxx.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

public class JwtUtil {
    public static String SECRET = "Supopo";
    public static Long MAXTIME = 30L * 24L * 60 * 60 * 1000;

    public static String createToken(int userId) throws Exception {
        return JWT.create()
                .withExpiresAt(new Date(System.currentTimeMillis() + MAXTIME))  //设置过期时间
                .withAudience(String.valueOf(userId)) //设置接受方信息，一般时登录用户
                .sign(Algorithm.HMAC256(SECRET));
    }

}
