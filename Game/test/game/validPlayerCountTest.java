/**
 * Final Project: Deliverable 3, BlackJack game
 * Group 10: Lara Alferez, Hung-Han Chen, Neil Froggatt, Matthew Nickel
 * Class: SYST17796 Fundamentals of Software Design
 * Instructor: Liz Dancy 
 * File: validPlayerCountTest.java
 * Purpose: A class for good, bad and boundary test cases for the Game.validPlayerCount() method
 * Valid values are 1, 2 and 3
 */

package game;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class validPlayerCountTest {
    
    public validPlayerCountTest() {
    }
    
    @Test
    public void testValidPlayerCountGood(){
        System.out.println("validPlayerCountGood");
        String givenPlayerCount="2";
        boolean expResult=true;
        boolean result = Game.validPlayerCount(givenPlayerCount);
        assertEquals(expResult, result);    
    }
    
    @Test
    public void testValidPlayerCountBad(){
        System.out.println("validPlayerCountBad");
        String givenPlayerCount="foo";
        boolean expResult=false;
        boolean result = Game.validPlayerCount(givenPlayerCount);
        assertEquals(expResult, result);    
    }
        
    @Test
    public void testValidPlayerCountBoundary(){
        System.out.println("validPlayerCountBoundary");
        String givenPlayerCount="0";
        boolean expResult=false;
        boolean result = Game.validPlayerCount(givenPlayerCount);
        assertEquals(expResult, result);    
    }
}
