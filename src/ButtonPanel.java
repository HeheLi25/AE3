//Yirong_Li	2458304L

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

/* This is the buttonPanel. It is the bottom-right corner of the main JFrame. 
 * Part of the view. 
 * It extends JPanel.
 * The Panel is consist of 2 buttons. One is the spin button and another is the newGame button. 
 * ------------------
 * |  ------------  |
 * |  |   spin   |  |
 * |  ------------  |
 * |  | New Game |  |
 * |  ------------  |
 * ------------------
 */
public class ButtonPanel extends JPanel{
	JButton spin;
	JButton newGame;
	
	//The constructor get the controller so that it can set the actionListener to the controller. 
	public ButtonPanel(Controller controller){
		Border border = BorderFactory.createEmptyBorder(50,90,90,90);
		this.setLayout(new GridLayout(0,1)); //This allows the buttons to stand in a column.
		this.setBorder(border);
	    Font f = new Font("Times New Roman", Font.PLAIN, 28);
		spin = new JButton("Spin");
		spin.setFont(f);
		spin.setEnabled(true);
		spin.addActionListener(controller);//The actionPerformer is in the controller.
		newGame = new JButton("New Game");
		newGame.setFont(f);
		newGame.setEnabled(false);	//Initially the newGame button is disabled.
		newGame.addActionListener(controller);//The actionPerformer is in the controller.
		this.add(spin);
		this.add(newGame);
	}

}
