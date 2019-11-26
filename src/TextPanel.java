//Yirong_Li	2458304L

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/*
 * This is the textPanel. It is the top-left corner of the main JFrame. 
 * Part of the view.
 * It extends JPanel.
 * The Panel is consist of 3 labels. 
 * ----------------------
 * | JLabel 1           |
 * | JLabel 2           |
 * | JLabel 3           |
 * ----------------------
 */

public class TextPanel extends JPanel{
	public JLabel l1;
	public JLabel l2;
	public JLabel l3;
	
	public TextPanel(){
		this.setLayout(new GridLayout(0,1));
		
		//The labels are set to the initial text. 
		l1 = new JLabel("Your Balance is 100");
		l2 = new JLabel("Welcome!");
		l3 = new JLabel("");
		//The empty borders is to arrange the lines in a suitable position of the panel. 
		Border thisBorder = BorderFactory.createEmptyBorder(30,40,25,40);
		l1.setBorder(thisBorder);
		l2.setBorder(thisBorder);
		l3.setBorder(thisBorder);
		//Font set to Times new Roman.
		Font f = new Font("Times New Roman", Font.PLAIN, 25);
	    l1.setFont(f);
	    l2.setFont(f);
	    l3.setFont(f);
	    
		this.add(l1);
		this.add(l2);
		this.add(l3);
	}
	
	/*
	 * This method is to change the values of the Panel texts using the given String and balance. 
	 * It is used in every round of the game and when the game is started or ended. 
	 */
	public void updateText(int balance, String changePoint, String finalResult){
		l1.setText("Your Balance is " + balance);
		l2.setText(changePoint);
		l3.setText(finalResult);
	}
}
