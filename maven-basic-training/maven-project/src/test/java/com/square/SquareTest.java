package com.square;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareTest {

    @Test
    public void testSquare() {
        Square square = new Square();
        int input = 5;
        int expectedOutput = 25;
        int actualOutput = square.square(input);
        assertEquals(expectedOutput, actualOutput);
    }

}
