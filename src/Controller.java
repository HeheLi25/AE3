//Yirong_Li	2458304L

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * This is the controller class.
 * It implements the actionListener interface, so that it contains a actionPerfromed method to operate the actions from the view.
 */
public class Controller implements ActionListener{
	private MachineFrame view; //It takes the view from the constructor and store it in the attribute.
	//Through the view attribute, the controller can get access to the model objects that stores in the view object.
	
	//Constructor takes the view as parameter and stores it. 
	public Controller(MachineFrame view){ 
		this.view = view;
	}
	

	/*
	 * @Override
	 * The actionPerformed method takes the actionEvent from the view and take actions.
	 * The actions are from spin button or newGame button.
	 */
	public void actionPerformed(ActionEvent e) {
		/*
		 * When the event is from spin button, the cards should be randomly draw.
		 * Then the card panel and the text panel should be update depends on the random cards.
		 * Also, balance should be check and see whether the game should end or not. 
		 */
		if(e.getSource() == view.buttonPanel.spin){
			view.updateCard();	// Calls the updateCard method in the view. Display three new random cards.
			int sameCards = view.cardDrawer.cardCompare();	// Check the constitution of the three cards.
			int jokers = view.cardDrawer.checkJoker();	// Count the number of jokers in the three cards.
			String s1 = view.balanceManager.changeBalance(jokers, sameCards); // Get the sentences to be display on the textPanel through changeBalance method. 
			String s2 = view.balanceManager.checkEnd();	// Check whether the game should be ended. (Return empty String if not)
			if(!s2.equals("")){
				view.endGame(); // End game if needed. 
			}
			view.updateText(view.balanceManager.getBalance(), s1, s2); 
		}
		if(e.getSource() == view.buttonPanel.newGame){
			view.resetGame();	//Reset the game if newGame button is clicked. 
		}
		
	}
	

}
