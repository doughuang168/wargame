# WarGame
Game of war in Java 

## Download Instruction ##

git clone  https://github.com/doughuang168/wargame  

### How to Build ###
- cd wargame 
- .\gradlew.bat build(windows) or ./gradlew build(linux, Mac)


### How to Run ###

- java -jar build/libs/war-1.0-SNAPSHOT.jar 4 13 2
- 4 is numberOfSuits, 13 is numberOfRanks, 2 is numberOfPlayers

### Game Rule ###
 The play consists of the number of tricks. 
Each trick is played as follows: each player (in no particular order) 
turns the top card of their pack face up and places it on the table. 
Whoever has placed the highest rank card wins the trick, 
collects the cards on the table.  They are put to the side to form a new stack, which the player can use when he finishes his current stack.

The ranking of the cards is from ace (high) down to six (low), except that a six beats an ace. 
In other words, if a six and an ace are played the six counts as the highest card and wins the trick, 
but if a six is played an no one played an ace the six counts as lowest. 
(If you played with 52 cards it would be the 2, not the 6, that would beat the ace.)

If there is a tie for highest then  
	- everybody puts a new card face up on top of the card they played the previous trick
	
whoever plays the highest of the new face-up cards wins the trick, 
or if there is a tie the process is repeated.

End of the game:
The loser is the player who is left with all the cards at the end. 


