package bj_enum;

/** import */
import java.util.Arrays;
import java.util.Collections;

/**
 * Class define a Deck with 52 card in random order.
 */
class Deck{
    /** Field card_array is array of objects Card. */
    Card[] card_array = new Card[52];
    
    /** Method create array of Card and schuffle they randomly. */
    void shuffleDeck(){
        int i = 0;
        for(CardRank rank : CardRank.values())
            for(CardSuit suit : CardSuit.values()){          
                card_array[i] = new Card(rank.name + suit.suit, rank.rank); 
                ++i;
            }
        Collections.shuffle(Arrays.asList(card_array));   
    } 
    
    /** Enum CardRank consist all names and ranks of Cards */
    private static enum CardRank{
        TWO("2", 2),
        THREE("3", 3),
        FOUR("4", 4),
        FIVE("5", 5),
        SIX("6", 6),
        SEVEN("7", 7),
        EIGHT("8", 8),
        NINE("9", 9),
        TEN("10", 10),
        JACK("J", 10),
        QUINN("Q", 10),
        KING("K", 10),
        ACE("A", 11){};
        String name;
        int rank;
        
        CardRank(String name, int rank){
            this.name = name;
            this.rank = rank;
        }
    }
  
    /** Enum CardSuit consist all suits of Cards */
    private static enum CardSuit{
        DIAMANDS("D"),
        CLUBS("C"),
        HEARTS("H"),
        SPADES("S");
        String suit;
        
        CardSuit(String suit){
            this.suit = suit;
        }
    }
    
}
