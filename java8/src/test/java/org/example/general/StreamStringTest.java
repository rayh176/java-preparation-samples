package org.example.general;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StreamStringTest {

    private StreamString streamString;

    @BeforeEach
    public final void beforeStart(){
        streamString = new StreamString();
    }

    @Test
    public void testValidString(){

        assertTrue(streamString.isValid(""));
        assertTrue(streamString.isValid("abcd"));
        assertTrue(streamString.isValid("aabbccdd"));
        assertTrue(streamString.isValid("aabbcccdd"));
        assertFalse(streamString.isValid("aabbcccddd"));
        assertFalse(streamString.isValid("aabbccccdd"));
        assertFalse(streamString.isValid("aabbccccddd"));
        assertFalse(streamString.isValid("aabbccccdddd"));
    }
}
