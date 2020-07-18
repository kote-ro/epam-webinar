package com.epam.task3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Part4 {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        hash("asdf", "MD5");
        hash("asdf", "SHA-256");
    }

    public static String hash(String input, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.update(input.getBytes());
        byte[] hash = digest.digest();

        String result = Part4.bytesToHex(hash).toUpperCase();

        return result;

    }

    private static String bytesToHex(byte[]hashInBytes) {

        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();

    }
}
