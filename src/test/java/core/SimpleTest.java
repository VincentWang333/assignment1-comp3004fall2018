package core;

import static org.junit.Assert.assertTrue;

import junit.framework.TestCase;

public class SimpleTest extends TestCase{

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
		assertTrue(d.buildDeck().size() == 52);		
	}
	


	


}
