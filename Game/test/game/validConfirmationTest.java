/**
 * Final Project: Deliverable 3, BlackJack game
 * Group 10: Lara Alferez, Hung-Han Chen, Neil Froggatt, Matthew Nickel
 * Class: SYST17796 Fundamentals of Software Design
 * Instructor: Liz Dancy 
 * File: validConfirmationTest.java
 * Purpose: A class for good, bad and boundary test cases for the Game.validConfirmation() method
 * Valid values are y and n
 */

package game;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class validConfirmationTest {
    
    public validConfirmationTest() {
    }
    
    @Test
    public void testValidConfirmationGood(){
        System.out.println("validConfirmationGood");
        String confirmation="y";
        boolean expResult=true;
        boolean result = Game.validConfirmation(confirmation);
        assertEquals(expResult, result);    
    }
    
    @Test
    public void testValidConfirmationBad(){
        System.out.println("validConfirmationBad");
        String confirmation="4";
        boolean expResult=false;
        boolean result = Game.validConfirmation(confirmation);
        assertEquals(expResult, result);    
    }
    
    @Test
    public void testValidConfirmationBoundary(){
        System.out.println("validConfirmationBoundary");
        String confirmation="n";
        boolean expResult=true;
        boolean result = Game.validConfirmation(confirmation);
        assertEquals(expResult, result);    
    }
    
}
