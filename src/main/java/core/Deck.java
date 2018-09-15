package core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
	

	public static String[] names = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
	public static String[] suites = {"Hearts","Spades","Clubs","Diamonds"};

	
	public static List<Card> buildDeck(){
		List<Card> deck = new ArrayList<Card>();
		for (int i = 0; i < suites.length; i++){
			for (int j = 0; j < names.length; j++){
				Card k = new Card(names[j], suites[i]);
				deck.add(k);
			}
		}
		return deck;
	}
	
	public static List<Card> shuffleDeck(List<Card> deck){
		List<Card> shuffledDeck = new ArrayList<Card>();
		int r = 0;
		while (deck.size() > 0){
			Random card = new Random();
			r = card.nextInt(deck.size());
			Card temp = deck.remove(r);
			shuffledDeck.add(temp);
		}
		return shuffledDeck;
	}
	
	public static int drawCard(List<Card> newDeck, int playerTotal, List<Card> playersCards){
		int total = 0;
		Card playerCard1 = newDeck.remove(0);
		playerCard1.printCard();
		total += playerCard1.getValue();
		playersCards.add(playerCard1);
		return total;
	}

	
}
