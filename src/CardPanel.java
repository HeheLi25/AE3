//Yirong_Li	2458304L

import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class CardPanel extends JPanel{
	public CardComponent c1;
	public CardComponent c2;
	public CardComponent c3;
	
	/* This is the cardPanel. It is the bottom-left corner of the main JFrame. 
	 * Part of the view. 
	 * It extends JPanel.
	 * The Panel is consist of 3 cards. Each card is one "cardComponent", which is also a JPanel. 
	 * -----------------
	 * |   _   _   _   |
	 * |  |1| |2| |3|  |
	 * |  |_| |_| |_|  |
	 * |               |
	 * -----------------
	 */
	public CardPanel(Card[] cards){
		Border thisBorder = BorderFactory.createEmptyBorder(0,30,40,0);	//Use border to control the position of the components.
		this.setBorder(thisBorder);
		this.setLayout(new GridLayout(0,3));
		c1 = new CardComponent(cards[0]);	//CardComponent is another class that extends JPanel. One CardComponent contains one card.
		this.add(c1);
		c2 = new CardComponent(cards[1]);
		this.add(c2);
		c3 = new CardComponent(cards[2]);
		this.add(c3);;	
	}
	
	/*
	 * The updateCard method takes a card array as input, then show each card in each CardComponent.
	 */
	public void updateCards(Card[] cards){
		c1.updateCard(cards[0]);
		c2.updateCard(cards[1]);
		c3.updateCard(cards[2]);
	}
	
}
