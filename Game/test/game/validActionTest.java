/**
 * Final Project: Deliverable 3, BlackJack game
 * Group 10: Lara Alferez, Hung-Han Chen, Neil Froggatt, Matthew Nickel
 * Class: SYST17796 Fundamentals of Software Design
 * Instructor: Liz Dancy 
 * File: validActionTest.java
 * Purpose: A class for good, bad and boundary test cases for the Game.validAction() method
 * Valid values are 1, 2 and 3
 */
package game;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class validActionTest {
    
    public validActionTest() {
    }
  
    @Test
    public void testValidActionGood(){
        System.out.println("validActionGood");
        String givenActionString="2";
        boolean expResult=true;
        boolean result = Game.validAction(givenActionString);
        assertEquals(expResult, result);    
    }
    @Test
    public void testValidActionBad(){
        System.out.println("validActionBad");
        String givenActionString="foo";
        boolean expResult=false;
        boolean result = Game.validAction(givenActionString);
        assertEquals(expResult, result);    
    }
    
    @Test
    public void testValidActionBoundaryHigh(){
        System.out.println("validActionBoundaryHigh");
        String givenActionString="4";
        boolean expResult=false;
        boolean result = Game.validAction(givenActionString);
        assertEquals(expResult, result);    
    }
    
    @Test
    public void testValidActionBoundaryLow(){
        System.out.println("validActionBoundaryLow");
        String givenActionString="0";
        boolean expResult=false;
        boolean result = Game.validAction(givenActionString);
        assertEquals(expResult, result);    
    }
  
}
