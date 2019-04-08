/**
 * Final Project: Deliverable 3, BlackJack game
 * Group 10: Lara Alferez, Hung-Han Chen, Neil Froggatt, Matthew Nickel
 * Class: SYST17796 Fundamentals of Software Design
 * Instructor: Liz Dancy 
 * File: playerBetTest.java
 * Purpose: A class for good, bad and boundary test cases for the Player.bet() method
 * Valid values are between 1 and 300 inclusive
 */
package game;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class playerBetTest {
    
    //new players have $300 initially
    Player myPlayer = new Player ("testPlayer");
    
    public playerBetTest() {
    }
    
    @Test
    public void testPlayerBetGood(){
        System.out.println("playerBetGood");
        String bet="100";
        boolean expResult=true;
        boolean result = myPlayer.bet(bet);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testPlayerBetBadType(){
        System.out.println("playerBetBadType");
        String bet="number";
        boolean expResult=false;
        boolean result = myPlayer.bet(bet);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testPlayerBetBadValue(){
        System.out.println("playerBetBadValue");
        String bet="500";
        boolean expResult=false;
        boolean result = myPlayer.bet(bet);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testPlayerBetBoundaryHigh(){
        System.out.println("playerBetBoundaryHigh");
        String bet="300";
        boolean expResult=true;
        boolean result = myPlayer.bet(bet);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testPlayerBetBoundaryLow(){
        System.out.println("playerBetBoundaryLow");
        String bet="1";
        boolean expResult=true;
        boolean result = myPlayer.bet(bet);
        assertEquals(expResult, result);
    }
    
    public void testPlayerBetBoundaryZero(){
        System.out.println("playerBetBoundaryZero");
        String bet="0";
        boolean expResult=false;
        boolean result = myPlayer.bet(bet);
        assertEquals(expResult, result);
    }
}
