package org.example.general;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class IdealStringTest {

    @Test
    public void idealString(){
        IdealString idealString = new IdealString();
        assertTrue(idealString.checkValue("BEECCCC"));
    }
}
