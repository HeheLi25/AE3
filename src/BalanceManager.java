//Yirong_Li	2458304L

/*
 * This is a BalanceManager class that includes the balance and the methods that operate the balance.
 * Part of the Model.  
 */
public class BalanceManager {
	private int balance; //The only attribute is the balance. 
	//During the game, only one BalanceManager is created. The balance is always updating. 

	//The constructor set the balance to the default value. 
	public BalanceManager(){	
		balance = 100;
	}	
	// Balance getter. 
	public int getBalance(){	
		return balance;
	}
	//Balance setter. 
	public void setBalance(int b){
		balance = b;
	}
	/*
	 * Balance initializer, set balance to the default value.
	 * It is called every time when the game is restarted.
	 */
	public void initGame(){
		balance = 100;
	}
	
	/*
	 * Method checkEnd() checks the balance and see whether the game should be end or not.
	 * This is called in every round during the game. 
	 * If the game should be ended, it returns the sentence that should be shown.
	 * Else it returns a empty String, as what should be shown when the game hasn't end yet. 
	 */
	public String checkEnd(){
		if(balance >= 150) return "You win!";
		else if(balance < 0) return "You lose...";
		else return "";
	}
	
	/*
	 * Method changeBalance(int,int) change the balance depends on the situation.
	 * The input parameters are the number of jokers and the numbers of same cards there are in this round.
	 * Depends on the parameters, the balance will be changed as requested.
	 * Then the responding sentence will be return as a String. 
	 */
	public String changeBalance(int jokers, int sameCards){
		String s = "";
		if(jokers != 0){
			int lose = jokers*25;
			balance -= lose;
			s = jokers+" jokers - you lose "+ lose +" points";
		}else{
			if(sameCards == 2) {
				balance = balance + 20;
				s = "2 of a kind - you win 20 points";
			}else if (sameCards == 1){
				s = "Balance unchanged.";
			}else if (sameCards > 2) {
				balance = balance + 50;
				s = "3 of a kind - you win 50 points";
			}
		}return s;
	}
	


}
