//Yirong_Li	2458304L

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/*
 * This is the panel that contains one card. It is part of the CardPanel. 
 * Part of the view.
 * It extends JPanel.
 * The Panel is consist of 3 cards. Each card is one card 
 * --------
 * |      |
 * | King |
 * |      |
 * |      |
 * --------
 */
public class CardComponent extends JPanel{
	private JLabel cardType; //This label contains the text of the card type.(King/Queen/...)
	
	/*
	 * The constructor get one card object as a input parameter which it will show as a panel. 
	 * The panel has a innerPanel, so that two borders can be set: one for black-line and another is empty. 
	 */
	public CardComponent(Card c){
		JPanel innerPanel = new JPanel(); //Create a innerPanel so that a black-line border can be set for the card.
		innerPanel.setLayout(new GridBagLayout());
		innerPanel.setBackground(Color.yellow);
		Border blackline = BorderFactory.createLineBorder(Color.black);
		innerPanel.setBorder(blackline); 
		
		cardType = new JLabel(c.toString()); //Using Card.toString of the card class to get the type of the card as the text. 
	    Font f = new Font("Times New Roman", Font.PLAIN, 30);
	    cardType.setFont(f);
		innerPanel.add(cardType);
		
		this.setLayout(new BorderLayout());
		this.add(innerPanel);
		Border thisBorder = BorderFactory.createEmptyBorder(10,10,20,10); //The border of the outerPannel(this panel) is set empty to arrange the gap between cards. 
		this.setBorder(thisBorder);	
	}
	
	/*
	 * This is the method that update the card into a new one.
	 * Takes a card object as input parameter.
	 */
	public void updateCard(Card c){
		cardType.setText(c.toString());
	}

}
