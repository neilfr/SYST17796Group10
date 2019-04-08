/**
 * Final Project: Deliverable 3, BlackJack game
 * Group 10: Lara Alferez, Hung-Han Chen, Neil Froggatt, Matthew Nickel
 * Class: SYST17796 Fundamentals of Software Design
 * Instructor: Liz Dancy 
 * File: playerNameValidatorTest.java
 * Purpose: A class for good, bad and boundary test cases for the Game.uniqueName() method
 * Valid name values must be unique among the players in the ArrayList<Player>
 */
package game;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class playerNameValidatorTest {
    
    ArrayList<Player> players = new ArrayList<Player>();
    Player newPlayer = new Player("foobar");
    
    public playerNameValidatorTest() {
    }

    @Test
    public void testNameUniqueGood(){
        players.add(newPlayer);
        System.out.println("uniqueNameGood");
        String name="foo";
        boolean expResult=true;
        boolean result = Game.uniqueName(name,players);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testNameUniqueBad(){
        players.add(newPlayer);
        System.out.println("uniqueNameBad");
        String name="foobar";
        boolean expResult=false;
        boolean result = Game.uniqueName(name,players);
        assertEquals(expResult, result);
    }

    @Test
    public void testNameUniqueBoundary(){
        players.add(newPlayer);
        System.out.println("uniqueNameBoundary");
        String name="Foo";
        boolean expResult=true;
        boolean result = Game.uniqueName(name,players);
        assertEquals(expResult, result);
    }
    
}
