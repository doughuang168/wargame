package com.doughuang;

import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import java.util.*;

public class PlayerTest {
    private Card card;
    private Player player;

    @Before
    public void setUp() {

        player = new Player(1);
        card = new Card(4, 13);

        System.out.println("@Before - setUp");
    }


    @Test
    public void testGetId() {
        String id = player.getId();
        assertTrue(id.contentEquals("1"));
        System.out.println("@Test - testGetId");
    }

    @Test
    public void testHandSize() {
        player.add(card);
        player.add(new Card(4, 13));
        assertTrue(player.handSize() == 2);
        System.out.println("@Test - testHandSize");
    }

    @Test
    public void testAddFaceup() {
        player.addFaceup(card);
        player.add(new Card(4, 13));
        ArrayList<Card> faceUpCards = player.getFaceUp();
        assertTrue(faceUpCards.size() == 1);
        System.out.println("@Test - testAddFaceup");
    }


    @Test
    public void testResetHand() {
        player.addFaceup(card);
        player.addFaceup(card);
        player.addFaceup(card);
        player.resetHand();
        assertTrue(player.handSize() == 3);
        System.out.println("@Test - testResetHand");
    }


    @Test
    public void testHasFaceUp() {
        assertFalse(player.hasFaceUp());
        player.addFaceup(card);
        assertTrue(player.hasFaceUp());
        System.out.println("@Test - testResetHand");
    }
}
