import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;

//DeckOfCards class will hold 52 cards, each card will grab their own properties from the class card
public class DeckOfCards
{

    //declare variables
    private static Card[] cardDeck;
    private static Card[] shuffledDeck;

    public final static int DIAMOND = 1;
    public final static int CLUB = 2;
    public final static int HEART = 3;
    public final static int SPADE = 4;

    public static Card[] top = new Card[26];
    public static Card[] bottom = new Card[26];

    public static void main(String[] args) throws IOException
    {
        
        DeckOfCards card = new DeckOfCards();

        //print out the array list of the original deck in order
        System.out.println("\nOriginal Deck: " +Arrays.toString(cardDeck));
        
        //print out the array list of the original deck in a perfect shuffle
        System.out.println("\nPerfect Shuffle: " +Arrays.toString(shuffledDeck));
        
    }

    public DeckOfCards()
    {
        //create array to hold info for 52 cards
        cardDeck = new Card[52];

        //initialize all 52 card objects in array
        int i = 0;
        
        //s for suit
        for(int s = 1; s <= 4; s++)
        {
            //r for rank
            for(int r = 1; r <= 13; r++)
            {
                cardDeck[i++] = new Card(r, s);
            }
        }

        //create separate decks by copying the original array
        Card[] top = Arrays.copyOf(cardDeck, 26);
        Card[] bottom = Arrays.copyOfRange(cardDeck, 26, 52);

        //create a new array to hold info of 52 cards from shuffling top and bottom arrays
        shuffledDeck = new Card[52];

        //loop to put top and bottom in a specific order in the shuffled deck
        for(int j = 0; j < 26; j++)
        {
            shuffledDeck[j*2] = top[j];
            shuffledDeck[j*2+1] = bottom[j];
        }
        
    }

    //Card class will provide the properties of one cardf
    public class Card
    {
        //Four suits as ints, each assigned their own number
        public final static int DIAMOND = 1;
        public final static int CLUB = 2;
        public final static int HEART = 3;
        public final static int SPADE = 4;

        //Ace, Jack, Queen, and King in numerical values
        public final static int ACE = 1;
        public final static int JACK = 11;
        public final static int QUEEN = 12;
        public final static int KING = 13;

        private final int rank;
        private final int suit;

        //Card constructor
        public Card(int theRank, int theSuit)
        {
            rank = theRank;
            suit = theSuit;
                  
        }

        //get rank and suit methods
        //rank of a single Card
        public int getRank()
        {
            return rank;
        }

        //suit of a single Card
        public int getSuit()
        {
            return suit;
        }


        //Return rank as a String
        public String rankString()
        {
            if(rank == 1)
                return "Ace";
            else if(rank == 2)
                return "2";
            else if(rank == 3)
                return "3";
            else if(rank == 4)
                return "4";
            else if(rank == 5)
                return "5";
            else if(rank == 6)
                return "6";
            else if(rank == 7)
                return "7";
            else if(rank == 8)
                return "8";
            else if(rank == 9)
                return "9";
            else if(rank == 10)
                return "10";
            else if(rank == 11)
                return "Jack";
            else if(rank == 12)
                return "Queen";
            else if(rank == 13)
                return "King";
            else
                return "Invalid";
        }

        //Return suit as a String
        public String suitString()
        {
            if(suit == DIAMOND)
                return "Diamonds";
            else if(suit == CLUB)
                return "Clubs";
            else if(suit == HEART)
                return "Hearts";
            else if(suit == SPADE)
                return "Spades";
            else 
                return "Invalid";
        }

        //return the card in a sentence
        public String toString()
        {
            return "\n" + rankString() + " of " + suitString();
        }
    }
    
}