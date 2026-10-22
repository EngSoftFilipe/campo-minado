package br.com.javaprojects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class FirstTest {
    
    @Test
    void testIfEqualsTwo(){
        int a = 1 + 1;
        assertEquals(2, a);
    }

    @Test 
    void testIfEqualsThree(){
        int x = 2 + 10 - 9;
        assertEquals(3, x);
    }

    // @Test 
    // void testIfEqualsThreeFail(){
    //     int x = 2 + 10 - 7;
    //     assertEquals(3, x);
    // }

    @Test
    void testWithNotEquals(){
        String x = "Filipe";
        assertNotEquals("filipe", x);
    }
}