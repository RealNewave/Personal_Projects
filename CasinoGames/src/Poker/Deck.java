package Poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hans
 */
public class Deck {

    public ArrayList<String> getCards() {
        ArrayList<String> cards = new ArrayList<>();
        int x = 1;
        for (int i = 0; i < 4; i++) {
            int y = 1;
            String a = "" + x;
            for (int j = 1; j < 14; j++) {
                String b = "" + y;
                cards.add(a + "," + b);
                y++;
            }
            x++;
        }
        Collections.shuffle(Arrays.asList(cards));

        return cards;
    }
}
