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
	
	public String getName() {
		return this.name;
	}
	public String getSuite()
	{
		return this.suite;
	}
	
	public Card readCard(String nameInFile, String suiteInFile)
	{
		String tempName;
		String tempSuite;
		if(nameInFile.equals("K"))
		{
			tempName = "King";
		}
		else if(nameInFile.equals("Q"))
		{
			tempName = "Queen";
		}
		else if(nameInFile.equals("J"))
		{
			tempName = "Jack";
		}
		else if(nameInFile.equals("A"))
		{
			tempName = "Ace";
		}
		else
		{
			tempName = name;
		}
		
		
		
		if(suiteInFile.equals("S"))
		{
			tempSuite = "Spades";
		}
		else if(suiteInFile.equals("C"))
		{
			tempSuite = "Cubes";
		}
		else if(suiteInFile.equals("H"))
		{
			tempSuite = "Hearts";
		}
		else if(suiteInFile.equals("D"))
		{
			tempSuite = "Diamonds";
		}
		else
		{
			tempSuite = suite;
		}		
		Card aCard = new Card(tempName, tempSuite);
		return aCard;
		
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
			if(name.equals("10"))
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
				System.out.println("situation 2");
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
	 
	 public boolean iSPoker()
	 {
		 boolean result = true;
		 if(this.suite.equals("Hearts") || this.suite.equals("Spades") || this.suite.equals("Cubes")  || this.suite.equals("Diamonds"))
		 {
			 result = true;
		 }
		 else
		 {
			 result = false;
		 }
		 if(this.name.equals("Ace") || this.name.equals("2") || this.name.equals("3") || this.name.equals("4") || this.name.equals("5") 
			|| this.name.equals("6") || this.name.equals("7") || this.name.equals("8") || this.name.equals("9")|| this.name.equals("10") || this.name.equals("Jack") || this.name.equals("Queen") || this.name.equals("King"))
		 {
			 result = true;
			
		 }
		 else
		 {
			 result = false;
		 }
		 
		 
		 
		 return result;
	 }


}
