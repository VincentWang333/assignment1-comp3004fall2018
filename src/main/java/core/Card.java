package core;

public class Card {
	private int value;
	private String name;
	private String suite;
	private boolean ace;
	public Card(String name,String suite)
	{
		this.name = name;
		this.suite = suite;
		this.value = determineCardValue(name);
	}
	private int determineCardValue(String name2) {
		int value = 0;
		try{
			value = Integer.parseInt(name.substring(0,1));
			return value;
		} catch (NumberFormatException e){
			if (name.charAt(0) == 'K' || name.charAt(0) == 'J' || name.charAt(0) == 'Q' || name.charAt(0) == '0'){
				value = 10;
			} else if (name.charAt(0) =='A'){
				value = 11;
				this.ace = true;
			} else {
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
