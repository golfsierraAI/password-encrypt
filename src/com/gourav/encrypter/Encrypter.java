package com.gourav.encrypter;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypter {

    private static byte[] getByteCode(String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        return messageDigest.digest(password.getBytes(StandardCharsets.UTF_8));
    }

    public static String getEncryptedString(String password) throws NoSuchAlgorithmException {
        BigInteger number = new BigInteger(1, getByteCode(password));
        StringBuffer str = new StringBuffer(number.toString(16));
        while (str.length() < 32) {
            str.insert(0, '0');
        }
        return str.toString();
    }
}
