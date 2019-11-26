//Yirong_Li	2458304L

/*
 * This is the class of card. 
 * Part of the model.
 * One card contains only one attribute, the type of the card.
 * The type is a String, which is probably "King", "Queen", "Jack", "Ace" or "Joker". 
 */
public class Card {
	private String type;
	
	public Card(String type){ //Constructor gets the type. 
		this.type = type;
	}
/*
 * Override the toString method.
 * toString returns the type of the card. 
 */
	public String toString(){
		return type;
	}	
	

}
