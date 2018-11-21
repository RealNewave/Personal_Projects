/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Poker;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hans
 */
public class HandRankingTest {

    
        @Test
    public void testPair() {
        
        String[] hand = {"1,3","2,3"};
        ArrayList<String> cards = new ArrayList<>(Arrays.asList("3,4","2,6","3,8","1,10","1,11"));
        HandRanking instance = new HandRanking();
        String expResult = "One Pair";
        String result = instance.evaluate(hand, cards);
        assertEquals(expResult, result);
        
    }
        @Test
    public void testTwoPair() {
        
        String[] hand = {"1,3","2,3"};
        ArrayList<String> cards = new ArrayList<>(Arrays.asList("3,4","2,4","3,8","1,10","1,11"));
        HandRanking instance = new HandRanking();
        String expResult = "Two Pair";
        String result = instance.evaluate(hand, cards);
        assertEquals(expResult, result);
        
    }
        @Test
    public void testThreeOfAKind() {
        
        String[] hand = {"1,3","2,3"};
        ArrayList<String> cards = new ArrayList<>(Arrays.asList("3,3","2,5","3,4","1,7","1,6"));
        HandRanking instance = new HandRanking();
        String expResult = "Three Of A Kind";
        String result = instance.evaluate(hand, cards);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testFlush() {
        
        String[] hand = {"1,3","2,3"};
        ArrayList<String> cards = new ArrayList<>(Arrays.asList("1,4","1,6","1,8","1,10","2,11"));
        HandRanking instance = new HandRanking();
        String expResult = "Flush";
        String result = instance.evaluate(hand, cards);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testStraight() {
        
        String[] hand = {"1,3","2,3"};
        ArrayList<String> cards = new ArrayList<>(Arrays.asList("3,4","2,6","3,5","1,7","1,11"));
        HandRanking instance = new HandRanking();
        String expResult = "Straight";
        String result = instance.evaluate(hand, cards);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testFullHouse() {
        
        String[] hand = {"1,3","2,3"};
        ArrayList<String> cards = new ArrayList<>(Arrays.asList("3,3","2,4","3,4","1,5","1,6"));
        HandRanking instance = new HandRanking();
        String expResult = "FullHouse";
        String result = instance.evaluate(hand, cards);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testFourOfAKind() {
        
        String[] hand = {"1,3","2,3"};
        ArrayList<String> cards = new ArrayList<>(Arrays.asList("3,3","4,3","3,4","1,5","1,6"));
        HandRanking instance = new HandRanking();
        String expResult = "Four Of A Kind";
        String result = instance.evaluate(hand, cards);
        assertEquals(expResult, result);
        
    }
}
