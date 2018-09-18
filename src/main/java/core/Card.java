package core;

public class Card {
	private int value;
	private String name;
	private String suite;
	private boolean ace;
	public Card(String name,String suite)
	{
		transferCardName(name,suite);
		this.value = determineCardValue(this.name);
	}
	
	
	public void transferCardName(String name, String suite)
	{
		if(name == "K")
		{
			this.name = "King";
		}
		else if(name == "Q")
		{
			this.name = "Queen";
		}
		else if(name == "J")
		{
			this.name = "Jack";
		}
		else if(name == "A")
		{
			this.name = "Ace";
		}
		else
		{
			this.name = name;
		}
		
		
		
		
		
		if(suite == "S")
		{
			this.suite = "Spades";
		}
		else if(suite == "C")
		{
			this.suite = "Cubes";
		}
		else if(suite == "H")
		{
			this.suite = "Hearts";
		}
		else if(suite == "D")
		{
			this.suite = "Diamonds";
		}
		else
		{
			this.suite = suite;
		}
		
		
	}
	private int determineCardValue(String name2) {
		int value = 0;
		try{
			if(name=="10")
			{
				value = 10;
			}
			else
			   value = Integer.parseInt(name.substring(0,1));
			return value;
		} catch (NumberFormatException e){
			if (name.charAt(0) == 'K' || name.charAt(0) == 'J' || name.charAt(0) == 'Q'){
				value = 10;
			} else if (name.charAt(0) =='A'){
				value = 11;
				this.ace = true;
			} 
			else {
				value = Integer.parseInt(name.substring(0, 1)); 
			}
			return value;
		}
	}
	public int getValue() {
		return this.value;
	}
	public boolean isAce() {
		return ace;
	}
	 public void printCard(){
		   System.out.println(this.name + " of " + this.suite);
	   	}


}
