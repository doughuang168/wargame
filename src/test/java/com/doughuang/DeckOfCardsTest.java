package com.doughuang;
import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import java.util.*;

public class DeckOfCardsTest {

    private DeckOfCards myDeck;

    @Before
    public void setUp() {
        myDeck = new DeckOfCards();
        System.out.println("@Before - setUp");
    }


    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void testIndexOutOfBoundsExceptionOfCreate() {

        thrown.expect(IndexOutOfBoundsException.class);
        thrown.expectMessage(containsString("suit is out of range"));

        int a = 14;
        int b = 5;

        myDeck.create(a,b);
    }


    @Test
    public void testCardSuite() {
        myDeck.create(4,13);
        assertTrue(myDeck.getTotalCards() == 52);
        System.out.println("@Test - getTotalCards");
    }


}
