package com.example.eiffelskills_back.models;

import org.apache.logging.log4j.message.Message;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Class Encoder
 * Used to encrypt user's password
 */
public class Encoder {
    MessageDigest crypt;

    /**
     * Empty Constructor
     */
    public Encoder() {
        try {
            crypt = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method encrypt
     * @param input String to encrypt
     * @return The string encrypted !Not working!
     */
    public String encrypt(String input) {
        crypt.reset();
        crypt.update(input.getBytes());
        return input;
        //return crypt.digest().toString();
    }
}
