package com.hva.helios.utilities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * A utility class that provides methods for authentication-related tasks.
 */
public class Authentication {
    /**
     * Hashes a given plain text string using the MD5 algorithm
     *
     * @param plainText The plain text string to be hashed
     * @return The hashed string
     */
    public String hash(String plainText) {
        String generatedPassword = null;

        try {
            // Obtain a message digest instance using the MD5 algorithm
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Update the digest using the plain text input
            md.update(plainText.getBytes());

            // Perform the digest
            byte[] bytes = md.digest();

            // Build a string to hold the hashed password
            StringBuilder sb = new StringBuilder();

            // Append each byte of the digest to the string
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }

            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return generatedPassword;
    }
}
