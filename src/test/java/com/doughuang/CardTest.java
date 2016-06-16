package com.doughuang;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

import com.doughuang.Card;

public class CardTest {

    private Card card;

    @Before
    public void setUp() {

        card = new Card(4, 13);
        System.out.println("@Before - setUp");
    }


    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void testIndexOutOfBoundsException() {

        thrown.expect(IndexOutOfBoundsException.class);
        thrown.expectMessage(containsString("suit is out of range"));

        int a = 14;
        int b = 5;

        Card c = new Card(a,b);
    }

    @Test
    public void testIndexOutOfBoundsExceptionToo() {

        thrown.expect(IndexOutOfBoundsException.class);
        thrown.expectMessage(containsString("rank is out of range"));

        int a = 4;
        int b = 14;

        Card c = new Card(a,b);
    }
    @Test
    public void testCardSuite() {
        assertTrue(card.getSuit() == 4);
        System.out.println("@Test - testCardSuite");
    }

    @Test
    public void testCardRank() {
        assertTrue(card.getRank() == 13);
        System.out.println("@Test - testCardRank");
    }


}
