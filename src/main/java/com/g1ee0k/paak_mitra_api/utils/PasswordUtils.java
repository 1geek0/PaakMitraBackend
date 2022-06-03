package com.g1ee0k.paak_mitra_api.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordUtils {
    public static String hashPassword(String password) {
        String salt = BCrypt.gensalt(12);
        return BCrypt.hashpw(password, salt);
    }

    public static boolean validatePassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}
