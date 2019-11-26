//Yirong_Li	2458304L

/*
 * This is the class only contains the main method to run the fruit machine.
 */

public class FruitMachine{
	public static void main(String[] args){
		/*
		 * Only view is created in the main method. 
		 * The model and the controller are created in the constructor of view. 
		 */
		MachineFrame m = new MachineFrame();
		m.setVisible(true);
	}


}
