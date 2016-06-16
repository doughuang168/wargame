package com.doughuang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by douglas on 6/15/2016.
 */
public class Player implements Iterator {
    private ArrayList<Card> hand;
    private ArrayList<Card> faceUp;
    private String id;
    protected int myIndex = 0;

    public Player(){
        //Instantiates hand as a new array.
        hand = new ArrayList<Card>();
        faceUp = new ArrayList<Card>();
    }


    public Player(int index){
        //Instantiates hand as a new array.
        Integer idx = (Integer) index;
        hand = new ArrayList<Card>();
        faceUp = new ArrayList<Card>();
        id = idx.toString();
    }

    public void add(Card C){
        //Adds passed card value to the hand.
        hand.add(C);
    }


    public void addFaceup(Card C){
        //Adds passed card value to the hand.
        faceUp.add(C);
    }

    protected void shuffle(){
        Collections.shuffle(hand);
        myIndex = 0;
    }

    public void showCards(){
        //Will print each element of the hand
        hand.forEach(c->System.out.println(c.toString()));
    }

    public int handSize()
    {
        //return HANDSIZE;
        return hand.size();
    }

    public boolean hasNext() {
        return myIndex < hand.size();
    }

    public Object next() {
        Card card = hand.get(myIndex);
        myIndex++;
        return card;
    }

    public Card current() {
        Card card = hand.get(myIndex-1);
        return card;
    }

    public boolean hasFaceUp() {
        return faceUp.size() > 0;
    }

    public String getId() {
        return this.id;
    }

    public void resetHand() {
        hand.clear();
        myIndex = 0;
        //copy from faceUpCards
        this.faceUp.forEach(card->this.add(card));
        faceUp.clear();//reset
        shuffle();
    }

    public ArrayList<Card> getFaceUp() {
        return this.faceUp;
    }
}
