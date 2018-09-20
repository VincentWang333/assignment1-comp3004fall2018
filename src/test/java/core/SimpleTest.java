package core;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import junit.framework.TestCase;

public class SimpleTest extends TestCase{
	
	public void testPoker()
	{
		Card a = new Card("19","Apple");
		assertTrue(a.iSPoker() == false);
				
	}

	public void testTheValueOfEightOfHeart()
	{
		Card cardEightOfHeart = new Card("8","Hearts");
		assertTrue(cardEightOfHeart.getValue()==8);
	}
	public void testIfAceOfHeartIsAce()
	{
		Card aceOfHeart = new Card ("Ace","Hearts");
		assertTrue(aceOfHeart.isAce());
	}
	public void testTheValueOfAceOfHeart()
	{
		Card aceOfHeart = new Card ("Ace","Hearts");
		assertTrue(aceOfHeart.getValue()==11);
	}
	
	public void testBuildDeck()
	{
		Deck d = new Deck();
		d.buildDeck();
		assertTrue(d.getSize()==52);		
	} 
	public void testShuffleDeck()
	{
		List<Card> exampleCards = new ArrayList<Card>(); 
		Deck d = new Deck();
		d.buildDeck();
		d.shuffleDeck();
		Card newCard = d.drawCard(exampleCards);
		assertTrue(d.getSize()==51 && d.cards!=null && newCard.getValue()!=11);	
	}
	public void testDrawACard()
	{
		Deck d = new Deck();
		d.buildDeck();
		List<Card> playersCards = new ArrayList<Card>();
		assertTrue(d.getSize()==52);
		assertTrue(d.drawCard(playersCards).getValue()== 11 && d.getSize()==51);	
		assertTrue(playersCards.size()==1);
	}
	public void testValueOfTenOfHeart()
	{
		Card tenOfHeart = new Card("10","Heart");
		assertTrue(tenOfHeart.getValue()==10);
		
	}
	public void testJQK()
	{
		Card KingOfHearts = new Card("K", "H");
		Card KingOfDiamonds = new Card("K", "D");
		Card KingOfSpades = new Card("K", "S");
		Card KingOfCubes = new Card("K", "C");
		
		Card QueenOfHearts = new Card("Q", "H");
		Card QueenOfDiamonds = new Card("Q", "D");
		Card QueenOfSpades = new Card("Q", "S");
		Card QueenOfCubes = new Card("Q", "C");
		
		Card JackOfHearts = new Card("J", "H");
		Card JackOfDiamonds = new Card("J", "D");
		Card JackOfSpades = new Card("J", "S");
		Card JackOfCubes = new Card("J", "C"); 
		
		assertTrue(KingOfHearts.getValue()==10);
		assertTrue(KingOfDiamonds.getValue()==10);
		assertTrue(KingOfSpades.getValue()==10);
		assertTrue(KingOfCubes.getValue()==10);
		assertTrue(QueenOfHearts.getValue()==10);
		assertTrue(QueenOfDiamonds.getValue()==10);
		assertTrue(QueenOfSpades.getValue()==10);
		assertTrue(QueenOfCubes.getValue()==10);
		assertTrue(JackOfHearts.getValue()==10);
		assertTrue(JackOfDiamonds.getValue()==10);
		assertTrue(JackOfSpades.getValue()==10);
		assertTrue(JackOfCubes.getValue()==10);	
	}
	
	
	public void testBlackJackTest()
	{
		int blackjack = 21;
		GameMain aGame = null;
		assertTrue(aGame.isBlackJack(blackjack) == true);	
	}
	
	public void test39()
	{
		int money = 100;
		int dealerTotal = 19;
		int playerTotal = 21;
		GameMain aGame = null;
		int moneyAfter = 0;
		int moneyChange = 0;
		moneyChange = aGame.winCheck(playerTotal, dealerTotal, 10);
		moneyAfter = money + moneyChange;
		assertTrue(moneyAfter>money);	
	}
	public void test40()
	{
		int money = 100;
		int dealerTotal = 21;
		int playerTotal = 19;
		GameMain aGame = null;
		int moneyAfter = 0;
		int moneyChange = 0;
		moneyChange = aGame.winCheck(playerTotal, dealerTotal, 100);
		moneyAfter = money + moneyChange;
		assertTrue(moneyAfter<money);	
	}
	public void test43()
	{
		int playerTotal = 19;
		int dealerTotal = 19;
		int money = 100;
		int moneyAfter = 0;
		int moneyChange = 0;
		GameMain aGame = null;
		moneyChange = aGame.winCheck(playerTotal, dealerTotal, 10);
		moneyAfter = money + moneyChange;
		assertTrue(money>=moneyAfter);
		
	    playerTotal = 19;
		dealerTotal = 18;
		money = 100;
		moneyAfter = 0;
		moneyChange = 0;
		aGame = null;
		moneyChange = aGame.winCheck(playerTotal, dealerTotal, 10);
		moneyAfter = money + moneyChange;
		assertTrue(money<=moneyAfter);
		
		playerTotal = 18;
		dealerTotal = 19;
		money = 100;
		moneyAfter = 0;
		moneyChange = 0;
		aGame = null;
		moneyChange = aGame.winCheck(playerTotal, dealerTotal, 10);
		moneyAfter = money + moneyChange;
		assertTrue(money>=moneyAfter);
		
		
		
	}
	


	

	


	


}
