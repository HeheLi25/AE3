//Yirong_Li	2458304L

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.GridLayout;

/*
 * This is the main view of the program. 
 * It extends JFrame.
 * The Frame is a rectangle that is split to four part.
 * ---------------------------
 * | textPanel |    empty    |
 * |-----------|-------------|
 * | cardPanel | buttonPanel |
 * ---------------------------
 * So the layout should be GridLayout(2,2).
 */
public class MachineFrame extends JFrame {
	
	Controller controller;	//Controller.
	CardDrawer cardDrawer;	//Model1.
	BalanceManager balanceManager;	//Model2.
	
	//The three panels shown as the graph above.
	TextPanel textPanel;
	CardPanel cardPanel;
	ButtonPanel buttonPanel;
	
	public MachineFrame(){
		/*Create models and a controller. 
		 *Gives itself to the controller, so the controller can also get access to the models and the view.  
		 */
		cardDrawer = new CardDrawer();
		balanceManager = new BalanceManager();
		controller = new Controller(this);
		
		// Standard JFrame features.
		setSize(800,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(300,200);
		setTitle("Fruit Machine!");
		setLayout(new GridLayout(2,2)); 
		/*
		 * Panel at the top-left corner is the "TextPanel" that contains the texts shows for players.
		 * It includes three parts.
		 * Show different texts during the game.
		 */
		textPanel= new TextPanel();
		add(textPanel);//
		/*
		 * Panel at the top-right corner is empty.
		 */
		add(new JPanel());
		/*
		 * Panel at the bottom-left corner is the "CardPanel" that contains 3 cards.
		 * It gets the cards from CardDrawer. 
		 */
		cardPanel = new CardPanel(cardDrawer.getCards());
		add(cardPanel);
		/*
		 * Panel at the bottom-right corner is the "ButtonPanel" that contains 2 buttons.  
		 */
		buttonPanel = new ButtonPanel(controller);
		add(buttonPanel);
	}
	
	/*
	 * The method endGame() disable the spin button and enable the newGame button
	 * It is called by the controller when the game should be end. 
	 */
	public void endGame(){
		buttonPanel.spin.setEnabled(false);
		buttonPanel.newGame.setEnabled(true);
	}
	
	/*
	 * The method resetGame() will refresh all the panels by calling their methods.
	 * The cardDrawer and balanceManager will be refresh, set the three cards and the balance to default.
	 * (See the methods in the panel classes and the model classes)
	 */
	public void resetGame(){
		cardDrawer.refresh();	//Initialize cards in the cardDrawer.
		cardPanel.updateCards(cardDrawer.getCards());	//Update the cardPannel using new cards.
		balanceManager.initGame();	//Initialize the balanceManager.
		textPanel.updateText(balanceManager.getBalance(), "Welcome!", "");	//Initialize the textPanel.
		//Button enable and disable. 
		buttonPanel.spin.setEnabled(true);	
		buttonPanel.newGame.setEnabled(false);
	}
	
	/*
	 * This updateCard() method allows the cardPanel to show three new random card. 
	 * It calls the draw() method in cardDrawer, get three random cards.
	 * Then update the cardPanel with the new cards by calling updateCards() method of the cardPanel. 
	 */
	public void updateCard(){
		cardDrawer.draw();
		cardPanel.updateCards(cardDrawer.getCards());
	}
	
	/*
	 * This updateText(int,String,String) method update the text panel with new sentences in each round of the game.
	 * It takes the new balance and two sentence as the input parameter, and pass it to the textPanel.
	 */
	public void updateText(int balance, String s1, String s2){
		textPanel.updateText(balance, s1, s2);
	}

}
