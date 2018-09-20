package core;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameMain {
	
	
	
	
	
	
	public static void main(String[] arg) throws FileNotFoundException	{
		Scanner console = new Scanner(System.in);
		boolean isConsole = false;
		int money =	1000;
		intro(money);
		boolean play = true;
		System.out.println("you want to file input or console input? (c/C console, f/F file)");
		//console.next().charAt(0);
		String answer = console.next();
	    
		if(answer.indexOf("c") == 0 || answer.indexOf("C") == 0)
	    {
	    	isConsole = true;
	    }
	    else if(answer.indexOf("f") == 0 || answer.indexOf("F") == 0)
	    {
	    	isConsole = false;
	    }
		
		
		
		
		String dealerSecondHandCard = new String();
		
		
		File file = new File("./src/test/resources/test1.txt");
		Scanner sc = new Scanner(file);
		

		while (money > 0 && play == true) {
			Deck newDeck = new Deck();
			newDeck.buildDeck();

			int playerTotal = 0;
			int dealerTotal = 0;
			boolean playerCanSplit = false;

			//For future development (Split, Double Down, etc)
			List<Card> playersCards = new ArrayList<Card>(); 
			List<Card> dealersCards = new ArrayList<Card>();

			//deck setup
			newDeck.shuffleDeck();
			int roundBet = betAmount(money, console);

			//Initial Deal
			int aceInPlayerHand = 0;
			int aceInDealerHand = 0;
			
			System.out.print("First card: ");
			Card playerFirstCard = new Card("10","K");
			if(!isConsole) {
				String s = null;
				if(sc.hasNext())
				{
					s = sc.next();
				}
				else
				{
					System.out.println("missing input");
					System.exit(0);
				}
				playerFirstCard = newDeck.drawTheCardFromDeckAndCheck(s.substring(1), s.substring(0,1));
				//playerFirstCard = new Card(s.substring(1),s.substring(0, 1));
				if(!playerFirstCard.iSPoker())
				{
					System.out.println("Input file is not correct");
					System.exit(0);
					
				}
				playersCards.add(playerFirstCard);
			}
			else
			{
				 playerFirstCard = newDeck.drawCard(playersCards);
			}
			playerFirstCard.printCard();
			playerTotal += playerFirstCard.getValue();
			if(playerFirstCard.getValue()==11)
			{
				aceInPlayerHand++;
			}
			
			
			System.out.print("Second card: ");
			Card playerSecondCard = new Card("10","K");
			if(!isConsole)
			{
				String s = null;
				if(sc.hasNext())
				{
					s = sc.next();
				}
				else
				{
					System.out.println("missing input");
					System.exit(0);
				}
				playerSecondCard = newDeck.drawTheCardFromDeckAndCheck(s.substring(1), s.substring(0,1));
				//playerSecondCard = new Card(s.substring(1),s.substring(0, 1));
				if(!playerSecondCard.iSPoker())
				{
					System.out.println("Input file is not correct");
					System.exit(0);
					
				}
				playersCards.add(playerSecondCard);
				
			}
			else
			{
				playerSecondCard = newDeck.drawCard(playersCards);
			}
			playerSecondCard.printCard();
			playerTotal += playerSecondCard.getValue();
			if(playerSecondCard.getValue()==11)
			{
				aceInPlayerHand++;
			}

			if(playerFirstCard.getName().equals(playerSecondCard.getName()))
			{
			
				playerCanSplit = true;
			}
			


			
			
			System.out.println("Dealer showing: ");
			Card dealerFirstCard = new Card("10","K");
			if(!isConsole)
			{
				String s = null;
				if(sc.hasNext())
				{
					s = sc.next();
				}
				else
				{
					System.out.println("missing input");
					System.exit(0);
				}
				
				dealerFirstCard = newDeck.drawTheCardFromDeckAndCheck(s.substring(1),s.substring(0, 1));
				//dealerFirstCard = new Card(s.substring(1),s.substring(0, 1));
				if(!dealerFirstCard.iSPoker())
				{
					System.out.println("Input file is not correct");
					System.exit(0);	
				}
				dealersCards.add(dealerFirstCard);
				
			}
			else
			{
				dealerFirstCard = newDeck.drawCard(dealersCards);
			}
			dealerFirstCard.printCard();
			dealerTotal += dealerFirstCard.getValue();
			if(dealerFirstCard.getValue() ==11)
			{
				aceInDealerHand++;
			}
			
			dealerSecondHandCard = null;
			if(sc.hasNext())
			{
				dealerSecondHandCard = sc.next();
			}
			else
			{
				System.out.println("missing input");
				System.exit(0);
			}
			
			System.out.println("Dealer has: " + dealerTotal);
		
			//player split loop
			if(playerCanSplit)
			{
				String splitAnswer;
				if(!isConsole)
				{
					String sa = null;
					if(sc.hasNext())
					{
					  sa = sc.next();
					}
					else
					{
						System.out.println("missing input");
						System.exit(0);
					}
					if(sa.equals("D"))
					{
						splitAnswer = "y";
						System.out.println("player choose split");
					}
					else
					{
						splitAnswer = "n";
						System.out.println("player choose stand");
					}
				}
				else
				{
					System.out.println("Do you want to split? (y/Y or n/N)");
				    splitAnswer = console.next();
				}

			    if(splitAnswer.indexOf("y") == 0 || splitAnswer.indexOf("Y") == 0)
			    {
			    	List<Card> optionOne = new ArrayList<Card>();
			    	List<Card> optionTwo = new ArrayList<Card>();
			    	int aceInOptionOne = 0;
			    	int aceInOptionTwo = 0;
			    	int optionOneTotal = 0;
			    	int optionTwoTotal = 0;
			    	boolean anotherCardForOptionOne = true;
			    	boolean anotherCardForOptionTwo = true;
			    	optionOne.add(playerFirstCard);
			    	optionTwo.add(playerSecondCard);
			    	if(playerFirstCard.getValue()==11)
			    	{
			    		aceInOptionOne++;
			    	}
			    	if(playerSecondCard.getValue()==11)
			    	{
			    		aceInOptionTwo++;
			    	}
			    	optionOneTotal += playerFirstCard.getValue();
			    	optionTwoTotal += playerSecondCard.getValue();
			    	
			    	Card newCardForOprionOne =  new Card("10","K");
			    	Card newCardForOprionTwo =  new Card("10","K");
			    	
			    	if(!isConsole)
			    	{
			    		String a = null;
			    		if(sc.hasNext())
						{
						  a = sc.next();
						}
						else
						{
							System.out.println("missing input");
							System.exit(0);
						}
			    		newCardForOprionOne = newDeck.drawTheCardFromDeckAndCheck(a.substring(1),a.substring(0, 1));

			    		//newCardForOprionOne = new Card(a.substring(1),a.substring(0, 1));
			    		if(!newCardForOprionOne.iSPoker())
						{
							System.out.println("Input file is not correct");
							System.exit(0);	
						}
			    		optionOne.add(newCardForOprionOne);
			    		optionOneTotal += newCardForOprionOne.getValue();
			    		
			    		a = null;
			    		if(sc.hasNext())
						{
						  a = sc.next();
						}
						else
						{
							System.out.println("missing input");
							System.exit(0);
						}
			    		newCardForOprionTwo = newDeck.drawTheCardFromDeckAndCheck(a.substring(1),a.substring(0, 1));

						//newCardForOprionTwo = new Card(a.substring(1),a.substring(0, 1));
						if(!newCardForOprionTwo.iSPoker())
						{
							System.out.println("Input file is not correct");
							System.exit(0);	
						}
						optionTwo.add(newCardForOprionTwo);
			    		optionTwoTotal += newCardForOprionTwo.getValue();	
			    	}
			    	else
			    	{
			    		newCardForOprionOne = newDeck.drawCard(optionOne);
			    		optionOneTotal +=newCardForOprionOne.getValue();
			    		newCardForOprionTwo = newDeck.drawCard(optionTwo);
			    		optionTwoTotal += newCardForOprionTwo.getValue();
			    	}
			    	
			    	
			    	System.out.println("Now we are dealing with option one ,the card you have is: " );
			    	playerFirstCard.printCard();
			    	newCardForOprionOne.printCard();
			    	while(optionOneTotal<21 && anotherCardForOptionOne)
			    	{
			    		if(!isConsole)
						{
							String r = null;
							if(sc.hasNext())
							{
							  r = sc.next();
							}
							else
							{
								System.out.println("missing input");
								System.exit(0);
							}
				
							if(r.equals("S"))
							{
								anotherCardForOptionOne = false;
								System.out.println("player stand on option one");
							}
							else if (r.equals("H"))
							{
								anotherCardForOptionOne = true;
								System.out.println("player hit on option one");
							}
						}
						else
						{
							anotherCardForOptionOne = Hit(optionOneTotal,console);
						}
			    		
						if (optionOneTotal > 21 || optionOneTotal == 21 || !anotherCardForOptionOne)
						{
							System.out.println("option one is end");
							break;	
						}
						else 
						{
							
							Card anotherNewCardForOptionOne = new Card("10","K");
							if(!isConsole)
							{
								String c = null;
								if(sc.hasNext())
								{
								  c = sc.next();
								}
								else
								{
									System.out.println("missing input");
									System.exit(0);
								}
								anotherNewCardForOptionOne = newDeck.drawTheCardFromDeckAndCheck(c.substring(1),c.substring(0, 1));

								//anotherNewCardForOptionOne = new Card(c.substring(1),c.substring(0, 1));
								if(!anotherNewCardForOptionOne.iSPoker())
								{
									System.out.println("Input file is not correct");
									System.exit(0);	
								}
								optionOne.add(anotherNewCardForOptionOne);
							}
							else
							{
								anotherNewCardForOptionOne = newDeck.drawCard(optionOne);
							}
							anotherNewCardForOptionOne.printCard();
							optionOneTotal += anotherNewCardForOptionOne.getValue();
							if(anotherNewCardForOptionOne.getValue() ==11)
							{
								aceInOptionOne++;
							}
							
						}
						if(optionOneTotal>21 && aceInOptionOne!=0) {
							optionOneTotal -= 10;
							aceInOptionOne--;
						}	
			    		
			    	}
			    	System.out.println("Now we are dealing with option two ,the card you have is: " );
			    	playerSecondCard.printCard();
			    	newCardForOprionTwo.printCard();
			    	while(optionTwoTotal<21 &&anotherCardForOptionTwo)
			    	{
			    		if(!isConsole)
						{
							String r = null;
							if(sc.hasNext())
							{
							  r = sc.next();
							}
							else
							{
								System.out.println("missing input");
								System.exit(0);
							}
							
							if(r.equals("S"))
							{
								anotherCardForOptionTwo = false;
								System.out.println("player stand on option two");
							}
							else if (r.equals("H"))
							{
								anotherCardForOptionTwo = true;
								System.out.println("player hit on option two");
							}
						}
			    		else
			    		{
			    			anotherCardForOptionTwo = Hit(optionTwoTotal,console);	
			    		}
			    		
			    		
						if (optionTwoTotal > 21 || optionTwoTotal == 21 || !anotherCardForOptionTwo)
						{
							System.out.println("option two is end");
							break;	
						}
						else 
						{
							Card anotherNewCardForOptionTwo = new Card("10","K");
							if(!isConsole)
							{
								
								String c = null;
								if(sc.hasNext())
								{
								  c = sc.next();
								}
								else
								{
									System.out.println("missing input");
									System.exit(0);
								}
								anotherNewCardForOptionTwo = newDeck.drawTheCardFromDeckAndCheck(c.substring(1),c.substring(0, 1));

								//anotherNewCardForOptionTwo = new Card(c.substring(1),c.substring(0, 1));
								if(!anotherNewCardForOptionTwo.iSPoker())
								{
									System.out.println("Input file is not correct");
									System.exit(0);	
								}
								optionTwo.add(anotherNewCardForOptionTwo);
							}
							else
							{
								anotherNewCardForOptionTwo = newDeck.drawCard(optionTwo);
							}
							anotherNewCardForOptionTwo.printCard();
							optionTwoTotal += anotherNewCardForOptionTwo.getValue();
							if(anotherNewCardForOptionTwo.getValue() ==11)
							{
								aceInOptionTwo++;
							}
							
						}
						if(optionTwoTotal>21 && aceInOptionTwo!=0) {
							optionTwoTotal -= 10;
							aceInOptionTwo--;
						}	
			    		
			    	}
			    	
			    	if(optionOneTotal>optionTwoTotal && optionOneTotal <=21)
			    	{
			    		
			    	   playerTotal = optionOneTotal;
			    		
			    	}
			    	else if(optionTwoTotal>optionOneTotal && optionTwoTotal<=21)
			    	{
			    		
			    			playerTotal = optionTwoTotal;
			    		
			    	}
			    	else if (optionOneTotal <21 && optionTwoTotal >21)
			    	{
			    		playerTotal = optionOneTotal;
			    	}
			    	else if (optionTwoTotal<21 &&optionOneTotal>21)
			    	{
			    		playerTotal = optionTwoTotal;
			    	}
			    	else if(optionOneTotal >21 && optionTwoTotal >21)
			    	{
			    		playerTotal = 22;
			    	}
			    	System.out.println("your final total is: " + playerTotal);
			    }
			    else
			    {
			    	playerCanSplit = false;
			    }	
			}



			//Player play portion
			boolean another_card = true;
			while (playerTotal < 21 && another_card && !playerCanSplit)
			{
				if(!isConsole)
				{
					String result = null;
					if(sc.hasNext())
					{
					  result = sc.next();
					}
					else
					{
						System.out.println("missing input");
						System.exit(0);
					}
					if(result.equals("S"))
					{
						another_card = false;
						System.out.println("player stand");
					}
					else if (result.equals("H"))
					{
						another_card = true;
						System.out.println("player hit");
					}
				}
				else
				{
					another_card = Hit(playerTotal, console);
				}
				
				
				
				if (playerTotal > 21 || playerTotal == 21 || !another_card)
				{
					break;	
				}
				else 
				{
					
					Card newCard = new Card("10","K");
					if(!isConsole)
					{
						String c = null;
						if(sc.hasNext())
						{
							c = sc.next();
						}
						else
						{
							System.out.println("missing input");
							System.exit(0);
						}
						newCard = newDeck.drawTheCardFromDeckAndCheck(c.substring(1),c.substring(0, 1));
						//newCard = new Card(c.substring(1),c.substring(0, 1));
						if(!newCard.iSPoker())
						{
							System.out.println("Input file is not correct");
							System.exit(0);	
						}
						playersCards.add(newCard);
						
					}
					else
					{
						newCard = newDeck.drawCard(playersCards);
					}
					newCard.printCard();
					playerTotal += newCard.getValue();
					if(newCard.getValue() ==11)
					{
						aceInPlayerHand++;
					}
					
				}
				if(playerTotal>21 && aceInPlayerHand!=0) {
					playerTotal -= 10;
					aceInPlayerHand--;
				}	
			}
			
			
			
			while (dealerTotal < 17 && playerTotal <= 21)
			{
				if(dealersCards.size()==2 && dealersCards.get(0).getName().equals(dealersCards.get(1).getName())&& dealerTotal<17)
				 {
					 System.out.println("dealer split");
					 List<Card> dealerOptionOne = new ArrayList<Card>();
				     List<Card> dealerOptionTwo = new ArrayList<Card>();
				     int aceInDealerOptionOne = 0;
				     int aceInDealerOptionTwo = 0;
				     int dealerOptionOneTotal = 0;
				     int dealerOptionTwoTotal = 0;
				     dealerOptionOne.add(dealersCards.get(0));
				     dealerOptionOne.add(dealersCards.get(1));
				     dealerOptionOneTotal += dealersCards.get(0).getValue();
				     dealerOptionTwoTotal += dealersCards.get(1).getValue();
				     if(dealersCards.get(0).getValue()==11)
				     {
				    	 aceInDealerOptionOne++;
				    	 aceInDealerOptionTwo++;
				     }
				     
				     System.out.println("dealer dealing with first option");
				     System.out.println("In option one, dealer has:");
				     dealersCards.get(0).printCard();   
				     while(dealerOptionOneTotal<17 && playerTotal<21)
				     {
				    	System.out.println("Dealer showing: " + dealerOptionOneTotal);
				    	Card aNewDealerCard1 = new Card("10", "K");
				    	if(!isConsole)
				    	{
				    		String a = null;
				    		if(sc.hasNext())
							{
								a = sc.next();
							}
							else
							{
								System.out.println("missing input");
								System.exit(0);
							}
				    		aNewDealerCard1 = newDeck.drawTheCardFromDeckAndCheck(a.substring(1),a.substring(0, 1));

				    		//aNewDealerCard1 = new Card(a.substring(1),a.substring(0, 1));
				    		if(!aNewDealerCard1.iSPoker())
							{
								System.out.println("Input file is not correct");
								System.exit(0);	
							}
				    		
				    	}
				    	else
				    	{
				    		aNewDealerCard1 = newDeck.cards.remove(0);
				    	}
				    	System.out.println("Dealer gets: ");
				    	aNewDealerCard1.printCard();
				    	dealerOptionOneTotal += aNewDealerCard1.getValue();
				    	dealerOptionOne.add(aNewDealerCard1);
				    	if(aNewDealerCard1.getValue() == 11)
				    	{
				    		aceInDealerOptionOne++;
				    	}
				    	if(aceInDealerOptionOne!=0 && dealerOptionOneTotal>21)
				    	{
				    		dealerTotal -= 10;
				    		aceInDealerOptionOne--;
				    	}
				     }
				     System.out.println("dealer dealing with second option");
					 System.out.println("In option two, dealer has:");
					 dealersCards.get(1).printCard();
					 while(dealerOptionTwoTotal<17 && playerTotal<21)
					 {
						 System.out.println("Dealer showing: " + dealerOptionTwoTotal);
						 Card aNewDealerCard2 = new Card("10", "K");
						 if(!isConsole)
						 {
							 String a = null;
							 if(sc.hasNext())
								{
									a = sc.next();
								}
								else
								{
									System.out.println("missing input");
									System.exit(0);
								}
							 aNewDealerCard2 = newDeck.drawTheCardFromDeckAndCheck(a.substring(1),a.substring(0, 1));

							 //aNewDealerCard2 = new Card(a.substring(1),a.substring(0, 1));
							 if(!aNewDealerCard2.iSPoker())
								{
									System.out.println("Input file is not correct");
									System.exit(0);	
								}
						 }
						 else
						 {
							 aNewDealerCard2 = newDeck.cards.remove(0);
					     }
						 System.out.println("Dealer gets: ");
					     aNewDealerCard2.printCard();
					     dealerOptionTwoTotal += aNewDealerCard2.getValue();
					     dealerOptionTwo.add(aNewDealerCard2); 
					     if(aNewDealerCard2.getValue() == 11)
					     {
					    	 aceInDealerOptionTwo++;
					     }
					     
					     if(aceInDealerOptionTwo!=0 && dealerOptionTwoTotal>21)
					     {
					    	 dealerOptionTwoTotal -= 10;
					    	 aceInDealerOptionTwo--;
					     }
					 }
					 if(dealerOptionOneTotal>dealerOptionTwoTotal && dealerOptionOneTotal<=21)
					 {
						 dealerTotal = dealerOptionOneTotal;
					 }
					 else if(dealerOptionTwoTotal>dealerOptionOneTotal && dealerOptionTwoTotal<=21)
					 {
						 dealerTotal = dealerOptionTwoTotal;
					 }
					 else if(dealerOptionOneTotal<=21&&dealerOptionTwoTotal>21)
					 {
						 dealerTotal = dealerOptionOneTotal;
					 }
					 else if(dealerOptionTwoTotal<=21&&dealerOptionOneTotal>21)
					 {
						 dealerTotal = dealerOptionTwoTotal;
					 }
					 else if(dealerOptionTwoTotal>=21 &&dealerOptionOneTotal>21)
					 {
						 dealerTotal = 22;
					 }
					 System.out.println("dealer final score is: " + dealerTotal);
					 break;
				}
				
				System.out.println("Dealer showing: " + dealerTotal);
				Card dealerCard = new Card("10","K");
				if(!isConsole)
				{
					if(dealersCards.size()==1)
					{
						dealerCard = newDeck.drawTheCardFromDeckAndCheck(dealerSecondHandCard.substring(1),dealerSecondHandCard.substring(0, 1));

						//dealerCard = new Card(dealerSecondHandCard.substring(1),dealerSecondHandCard.substring(0, 1)); 
						if(!dealerCard.iSPoker())
						{
							System.out.println("Input file is not correct");
							System.exit(0);	
						}
						dealersCards.add(dealerCard);
					}
					else
					{

						String s = null;
						if(sc.hasNext())
						{
							s = sc.next();
						}
						else
						{
							System.out.println("missing input");
							System.exit(0);
						}
						dealerCard = newDeck.drawTheCardFromDeckAndCheck(s.substring(1),s.substring(0, 1));

						//dealerCard = new Card(s.substring(1),s.substring(0, 1));
						if(!dealerCard.iSPoker())
						{
							System.out.println("Input file is not correct");
							System.exit(0);	
						}
						dealersCards.add(dealerCard);
					}
				}
				else
				{
					dealerCard = newDeck.drawCard(dealersCards);
				}
				System.out.println("Dealer gets: ");
				dealerCard.printCard();
				dealerTotal += dealerCard.getValue();
				if(dealerCard.getValue()==11)
				{
					aceInDealerHand++;
				}
				if(aceInDealerHand!=0 && dealerTotal>21)
				{
					dealerTotal-=10;
					aceInDealerHand--;
				}
			}

			//Decide who wins and whether to play another round
			System.out.println();
			money += winCheck(playerTotal, dealerTotal, roundBet);
			play = playAgain(console, money);
		}
	}	
//-----------------------------------------------------------------------------------------------------------------	  

	  public static void intro(int money) {
			System.out.println("Welcome to BlackJack!");
			System.out.println();
			System.out.println("You have: $" + money);
	   }	  
//-----------------------------------------------------------------------------------------------------------------	  	  
	  public static int betAmount(int money, Scanner console) {
			System.out.println("How much would you like to bet?");
			int bet = Math.abs(console.nextInt());
			while(bet > money || bet < 10){
				if (bet < 10) 
				{
					System.out.println("There is a minimum bet of $10");
				} 
				else 
				{
					System.out.println("You don't have that much money.");
				}
				System.out.println("How much would you like to bet?");
				bet = console.nextInt();
			}
			return bet;
		}
//-----------------------------------------------------------------------------------------------------------------	  
	  public static boolean Hit(int total, Scanner console){
			boolean ans = false;
			System.out.println();
			System.out.println("You have: " + total); 
			System.out.println("Do you want to hit? (y/Y or n/N)");
	        String answer = console.next();
	        if (answer.indexOf("y") == 0 || answer.indexOf("Y") == 0) {
	            ans = true;
	        } else if (answer.indexOf("n") == 0 || answer.indexOf("N") == 0) {
	            ans = false;
	        }	else {
	            System.out.println();
	            ans = false;
	        }
			return ans;
		}	

//-----------------------------------------------------------------------------------------------------------------	  	  
	  public static boolean playAgain(Scanner console, int money){
			boolean ans;
			System.out.println("You have: $" + money);
			if (money == 0) {
				System.out.println("You're out of money.  House wins.");
				ans = false;
				return ans;
			} 
			System.out.println("Do you want to play again?(y/Y or n/N)");
			String answer = console.next();
	      if (answer.indexOf("y") == 0 || answer.indexOf("Y") == 0) {
	      	ans = true;
				return ans;
	      } else if (answer.indexOf("n") == 0 || answer.indexOf("N") == 0) {
	            ans = false;
					if (money > 100) {
						System.out.println("Congratulations! You won: $" + (money - 100));
					} else {
						System.out.println("You lost: $" + (100 - money));
					}
					return ans;
	      } else {
	      	System.out.println();
	         ans = false;
	      }
			return ans;
		}
//-----------------------------------------------------------------------------------------------------------------	  
	  public static int winCheck(int total, int dealer, int to_play) {
			int gains_losses = 0;
			if (total == 21) {
				if(dealer == 21)
				{
					System.out.println("Dealer is Black Jack also! Dealer win");
					gains_losses = -1 * to_play;
				}
				else {
					System.out.println("You have: " + total);
					System.out.println("You got BlackJack!  You win!");
					gains_losses = 2 * to_play;
					
				}
				
			} else if (total > 21) {
				System.out.println("You have: " + total);
				System.out.println("You bust");
				gains_losses = -1 * to_play;
			} else if (total == dealer) {
				if(total == 21 && dealer ==21)
				{
					System.out.println("Dealer is BlackJack! Dealer win");
					gains_losses = -1 * to_play;
				}
				else {
					System.out.println("You have: " + total);
					System.out.println("Dealer has: " + dealer);
					System.out.println("Push.");
					gains_losses = 0;
					
				}
				
				
			} else if (dealer > 21) {
				System.out.println("Dealer has: " + dealer);
				System.out.println("Dealer busts.  You win!");
				gains_losses = 2 * to_play;
			} else if (total < dealer) {
				System.out.println("You have: " + total);
				System.out.println("Dealer has: " + dealer);
				System.out.println("Dealer wins.");
				gains_losses = -1 * to_play;
			} else {
				System.out.println("You have: " + total);
				System.out.println("Dealer has: " + dealer);
				System.out.println("You beat the dealer!");
				System.out.println("You win!");
				gains_losses = 2 * to_play;
			}
			return gains_losses;
		}
//---------------------------------------------------------------------
	  public static boolean isBlackJack(int total)
	  {
		  boolean isBJ = false;
		  if(total ==21)
		  {
			  isBJ = true;
		  }
		  return isBJ;
		  
	  }

}
