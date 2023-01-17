package com.hva.helios.utilities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AuthenticationTests {
    Authentication authentication = new Authentication();

    @Test
    public void testHash() {
        String plainText = "password";
        String expectedHashedValue = "5f4dcc3b5aa765d61d8327deb882cf99";
        String hashedValue = authentication.hash(plainText);
        assertEquals(expectedHashedValue, hashedValue);
    }

    @Test
    public void testHashWithNullInput() {
        assertThrows(
                NullPointerException.class,
                () -> {
                    authentication.hash(null);
                }
        );
    }

    @Test
    public void testHashWithEmptyString() {
        String plainText = "";
        String expectedHashedValue = "d41d8cd98f00b204e9800998ecf8427e";
        String hashedValue = authentication.hash(plainText);
        assertEquals(expectedHashedValue, hashedValue);
    }

    @Test
    public void testHashWithSpecialCharacters() {
        String plainText = "pa$$word";
        String expectedHashedValue = "a61a78e492ee60c63ed8f2bb3a6a0072";
        String hashedValue = authentication.hash(plainText);
        assertEquals(expectedHashedValue, hashedValue);
    }

    @Test
    public void testHashWithLargeString() {
        String plainText = "This is a very long string which is used to test the hash function with large input";
        String expectedHashedValue = "8fa42939b77f71158044119b303045cc";
        String hashedValue = authentication.hash(plainText);
        assertEquals(expectedHashedValue, hashedValue);
    }
}
