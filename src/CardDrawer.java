//Yirong_Li	2458304L

import java.util.Random;

/*
 * This is a card drawer.
 * Part of the Model.
 * Random cards can be generate through this class.
 * The only attribute is a card array.
 */
public class CardDrawer {
	private Card[] cards;

	public CardDrawer(){
		// In the constructor, the refresh method is called to set the card array to default.
		// (Refresh method see below.)
		refresh();
	}
	
	//Card array getter. 
	public Card[] getCards() {
		return cards;
	}
	/*
	 * The refresh method set the card array to three fixed cards.
	 * "King", "Queen" and "Jack", the default group of cards. 
	 */
	public void refresh(){
		cards = new Card[3];
		cards[0] = new Card("King");
		cards[1] = new Card("Queen");
		cards[2] = new Card("Jack");
	}
	
	/*
	 * The draw() method draw 3 cards randomly by using ramdomCard() method 3 times.
	 * It put the random cards into the Card[] attribute.
	 * randomCard method see below.
	 */
	public void draw(){
		Card[] c = new Card[3];
		for(int i = 0; i < 3; i++) c[i] = randomCard();
		this.cards = c;
	}
	/*
	 * This method randomCard() generates a random card using random number.
	 * It returns the random card. 
	 */	
	public Card randomCard(){
		Random r = new Random();
		int randInt = r.nextInt(5);
		if(randInt == 0) return new Card("King");
		else if(randInt == 1) return new Card("Queen");
		else if(randInt == 2) return new Card("Jack");
		else if(randInt == 3)return new Card("Ace");
		else return new Card("Joker");
	}
	/*
	 * This method cardCompare() compares the cards in Card[], see whether there are same cards.
	 * If Joker appears, return 1. 
	 * If there is no Joker and no other cards are the same, also return 1.
	 * If there are two same cards, return 2.
	 * If there are three same cards, return 4.(this is probably not smart, but it works... ;D) 
	 */	
	public int cardCompare(){
		int counter = 1;
		for(int i = 0; i < 3; i++){
			if(cards[i].toString().equals("Joker")) return 1;
			for(int j = i+1; j<3; j++){
				if(cards[i].toString().equals(cards[j].toString()))
					counter ++;
			}
		}return counter;
	}
	/*
	 * This method checkJocker() checks how many Jokers there are in the cards.	
	 */
	public int checkJoker(){
		int counter = 0;
		for(int i = 0; i < 3; i++){
			if(cards[i].toString().equals("Joker")) counter ++;
		}return counter;
	}
	

}
