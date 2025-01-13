package com.example.eiffelskills_back.models;

import org.apache.logging.log4j.message.Message;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @Class Encoder
 * Used to encrypt user's password
 */
public class Encoder {
    MessageDigest crypt;

    public Encoder() {
        try {
            crypt = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String encrypt(String input) {
        crypt.reset();
        crypt.update(input.getBytes());
        return Arrays.toString(crypt.digest());
    }
}
