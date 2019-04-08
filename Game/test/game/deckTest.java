/**
 * Final Project: Deliverable 3, BlackJack game
 * Group 10: Lara Alferez, Hung-Han Chen, Neil Froggatt, Matthew Nickel
 * Class: SYST17796 Fundamentals of Software Design
 * Instructor: Liz Dancy 
 * File: deckTest.java
 * Purpose: A class for test cases for the Deck.deckSize(), Deck.getCard() and Deck.addCard() methods
 */
package game;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class deckTest {
    
    public deckTest() {
    }
    
    @Test
    public void testDeckSizeAtCreationGood(){
        System.out.println("deckSizeAtCreationGood");
        Deck myDeck = new Deck();
        int expResult=52;
        int result = myDeck.getDeckSize();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDeckSizeAfterGetCardBoundaryLow(){
        System.out.println("deckSizeAfterGetCardBoundaryLow");
        Deck myDeck = new Deck();
        Card myCard = myDeck.getCard(0);
        int expResult=51;
        int result = myDeck.getDeckSize();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDeckSizeAfterGetCardBoundaryHigh(){
        System.out.println("deckSizeAfterGetCardBoundaryHigh");
        Deck myDeck = new Deck();
        Card myCard = myDeck.getCard(myDeck.getDeckSize()-1);
        int expResult=51;
        int result = myDeck.getDeckSize();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDeckSizeAfterGetCardAndAddCardGood(){
        System.out.println("deckSizeAfterGetCardAndAddCardGood");
        Deck myDeck = new Deck();
        Card myCard = myDeck.getCard(0);
        myDeck.setCard(26, myCard);
        int expResult=52;
        int result = myDeck.getDeckSize();
        assertEquals(expResult, result);
    }
}
