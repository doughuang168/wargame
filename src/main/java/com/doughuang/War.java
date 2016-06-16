package com.doughuang;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class War {

    private int numberOfSuits;
    private int numberOfRanks;
    private int numberOfPlayers;
    private int handSizePerPlayer;
    private DeckOfCards myDeck;
    List<Player> players;

    private void initPlay() {
        myDeck = new DeckOfCards();
        myDeck.create(numberOfSuits, numberOfRanks);
        myDeck.shuffle();
        players = new ArrayList<Player>();
        handSizePerPlayer = (int) myDeck.getTotalCards() / numberOfPlayers;
        //Create players
        for (int player = 0; player < numberOfPlayers; player++) {
            players.add(new Player(player));
        }

        //Assign card to each player
        for (int i = 0; i < handSizePerPlayer; i++) {
            for (int player = 0; player < numberOfPlayers; player++) {
                players.get(player).add(myDeck.deal());
            }
        }
    }
    //driver to play the game
    public void play( int numberOfSuits,
                      int numberOfRanks, int numberOfPlayers )
    {
        this.numberOfSuits = numberOfSuits;
        this.numberOfRanks = numberOfRanks;
        this.numberOfPlayers = numberOfPlayers;

        initPlay();

        List<Card> tieList = new ArrayList<Card>();

        while (true) {

            List<Integer> ranklist = new ArrayList<Integer>();
            List<Card> currentCardList = new ArrayList<Card>();


            for (int p = 0; p < numberOfPlayers; p++) {
                Player player = players.get(p);
                if (players.get(p).hasNext()) {
                    Card card = (Card) player.next();
                    ranklist.add(card.getRank());
                    currentCardList.add(card);
                } else if (player.hasFaceUp()) {
//                    System.out.println("hasFaceUp");
//                    ArrayList<Card> faceUp = player.getFaceUp();
//                    System.out.println(faceUp.size());
                    player.resetHand();
                    Card card = (Card) player.next();
                    ranklist.add(card.getRank());
                    currentCardList.add(card);
                } else {
                    System.out.println("out of card");
                }
            }

            //Find the highest rank
            int max = ranklist.stream()
                    .collect(Collectors.summarizingInt(Integer::intValue))
                    .getMax();

            //Id which player hold the higest rank
            List<Player> compList = players.stream()
                    .filter(p -> p.current().getRank() == max)
                    .collect(Collectors.toList());

            //Update the result in player class
            if (compList.size() == 1) {//if we have winner
                //Found the winner, add currentCardList to it faceUp list
                System.out.println("Player "+compList.get(0).getId() + " wins");
                System.out.println(compList.get(0).current().toString());
                currentCardList.forEach(card ->
                        players
                                .get(Integer.parseInt(compList.get(0).getId()))
                                .addFaceup(card));
                if (tieList.size() > 0) {
                    tieList.forEach(card ->
                            players
                                    .get(Integer.parseInt(compList.get(0).getId()))
                                    .addFaceup(card));
                    tieList.clear();
                }
            } else if (compList.size() > 1) {//or if we have tie, which one more player have been found
                //Tie situation, add to tieList
                System.out.println("game ties");
                currentCardList.forEach(card -> tieList.add(card));
            }

            //Check if any player exhaused their card
            List<Player> rsltList = players.stream()
                    .filter(p -> (!p.hasNext()) && (!p.hasFaceUp()))
                    .collect(Collectors.toList());

            if (rsltList.size() > 0) {
                System.out.println("Player "+rsltList.get(0).getId() + " loss");
                break;
            }

        }
        //players.forEach(player->player.showCards());

        System.out.println("War game end");

    }

}
