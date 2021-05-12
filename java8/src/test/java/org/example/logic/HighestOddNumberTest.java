package org.example.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HighestOddNumberTest {

    private HighestOddNumber highestOddNumber;

    @BeforeEach
    public void setUp(){
        highestOddNumber = new HighestOddNumber();
    }

    @Test
    public void findTest() {
        assertEquals(5, highestOddNumber.findHighestOddNumber(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5}));
        assertEquals(-1, highestOddNumber.findHighestOddNumber(new int[]{1,1,2,-2,5,2,4,4,-1,-2,5}));
        assertEquals(5, highestOddNumber.findHighestOddNumber(new int[]{20,1,1,2,2,3,3,5,5,4,20,4,5}));
        assertEquals(10, highestOddNumber.findHighestOddNumber(new int[]{10}));
        assertEquals(10, highestOddNumber.findHighestOddNumber(new int[]{1,1,1,1,1,1,10,1,1,1,1}));
        assertEquals(1, highestOddNumber.findHighestOddNumber(new int[]{5,4,3,2,1,5,4,3,2,10,10}));
    }
}