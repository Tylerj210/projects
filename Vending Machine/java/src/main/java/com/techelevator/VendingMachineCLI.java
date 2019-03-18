package com.techelevator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**************************************************************************************************************************
*  This is your Vending Machine class
*  
*  You code should be placed in here
***************************************************************************************************************************/
import com.techelevator.view.Menu;

public class VendingMachineCLI {

	//private VendingMachine vm = new VendingMachine();  // <------ run load inventory method in the constructor
	
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE      = "Purchase";
	private static final String MAIN_MENU_OPTION_ADD_FUNDS = "Add Funds";
	private static final String MAIN_MENU_OPTION_GET_BALANCE = "Current Balance";
	private static final String MAIN_MENU_OPTION_GET_CHANGE = "Change Return";
	private static final String MAIN_MENU_OPTION_EXIT          = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
													    MAIN_MENU_OPTION_PURCHASE,
													    MAIN_MENU_OPTION_ADD_FUNDS,
													    MAIN_MENU_OPTION_GET_BALANCE,
													    MAIN_MENU_OPTION_GET_CHANGE,
													    MAIN_MENU_OPTION_EXIT
													 
													    };
	
	private static Map<String, Item> inventory = new TreeMap<String, Item>();
	private DollarAmount balance = new DollarAmount(0);
	// set up scanner with file path
	//File inventory = new File(vendingmachine.csv);
	
	
	
	
	
	
	
	private Menu menu;   // Menu object to be used by an instance of this class
	
	public VendingMachineCLI(Menu menu) throws FileNotFoundException {  // Constructor - user will pas a menu for this class to use
		this.menu = menu; // Make the Menu the user object passed, our Menu
		loadInventory();
		
	}
	
	public void run() throws FileNotFoundException {
		while(true) {   // loop until user indicates they want to exit
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			
			
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {

				displayItems();
				
			} else if(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase - good place for a method
			}
			
			else if(choice.equals(MAIN_MENU_OPTION_ADD_FUNDS)) {
				// do purchase - good place for a method
			}
			
			else if(choice.equals(MAIN_MENU_OPTION_GET_BALANCE)) {
				System.out.println("Your current balance is: ");
			}
			
			else if(choice.equals(MAIN_MENU_OPTION_GET_CHANGE)) {
				// do purchase - good place for a method
			}
			
				else if(choice.equals(MAIN_MENU_OPTION_EXIT)) {
					// do end of program processing - good place for a method
					return;  // exit the process (ie. shut down the vending machine)
			}
		}
	}

private void displayItems() throws FileNotFoundException {

	Set <String> slotList = inventory.keySet();
		for(String slotNum : slotList) {
			System.out.println(slotNum.toString() + " | " + inventory.get(slotNum).toString());
			
			//Item item = inventory.get(slotNum);
			//System.out.println(slotNum + " | " + item + " - " + item.getPrice());
		}
	
	
	
	
	
	
	
	
	/*File inventoryInputFile = new File("vendingmachine.csv");
	Scanner fileScan = new Scanner(inventoryInputFile);
	while(fileScan.hasNextLine()) {
		String line = fileScan.nextLine();
		String[] selections =  line.split("\\|");
		System.out.println(selections[0] + " | " + selections [1] + " - " + selections [2]);
	
	}
		*/
	

	}

private void loadInventory() throws FileNotFoundException {
	File fileInput = new File("vendingmachine.csv");
	Scanner fileScan = new Scanner(fileInput);	
	while(fileScan.hasNextLine()) {
		String line = fileScan.nextLine();
		String[] parts =  line.split("\\|");
		double price = Double.parseDouble(parts[2]);
		Item item = new Item(parts[0], parts[1], price, parts[3], 5);
		inventory.put(parts[0], item);
	}
}
//getINventory()
//feedMoney()
//returnChange()
//purchase()


/*************************************************************************************************************************
*  This is the application program to instantiate a Vending Machine as start it running
*  
*  DO NOT PUT ANY NEW CODE HERE!
 * @throws FileNotFoundException 
***************************************************************************************************************************/
	
	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out);          // Instantiate a menu for Vending Machine to use
		VendingMachineCLI cli = new VendingMachineCLI(menu);  // Instantiate a Vending Machine passing it the Menu object to use
		cli.run();                                            // Tell the Vending Machine to start running
	}
}
