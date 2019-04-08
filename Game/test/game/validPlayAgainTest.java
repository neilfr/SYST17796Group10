/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author neilf
 */
public class validPlayAgainTest {
    
    public validPlayAgainTest() {
    }
    @Test
    public void testValidPlayAgainGood(){
        System.out.println("validPlayAgainGood");
        String playAgain="1";
        boolean expResult=true;
        boolean result = Game.validPlayAgain(playAgain);
        assertEquals(expResult, result);    
    }
    
    @Test
    public void testValidPlayAgainBad(){
        System.out.println("validPlayAgainBad");
        String playAgain="foo";
        boolean expResult=false;
        boolean result = Game.validPlayAgain(playAgain);
        assertEquals(expResult, result);    
    }
    
    @Test
    public void testValidPlayAgainBoundary(){
        System.out.println("validPlayAgainBoundary");
        String playAgain="3";
        boolean expResult=false;
        boolean result = Game.validPlayAgain(playAgain);
        assertEquals(expResult, result);    
    }
}
