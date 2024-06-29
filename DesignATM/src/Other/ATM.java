package Other;

import ATMStates.ATMState;
import ATMStates.IdleState;

public class ATM {
	
	private static ATM atmObject = new ATM(); //Singleton: eager initialization
    								// to initialise all the things related to atm
	
	// we have to keep track of current state of atm then, only we can decide which operation we can perform.
	ATMState currentATMState;
	
	// we also have to keep track of balance in atam and different types of denomination available.
	private int atmBalance;
	private int noOfFiveHundredNotes;
	private int noOfTwoHundredNotes;
	private int noOfOneHundredNotes;
	
	private ATM() {
	}
	
	// we have to set the current state and return the current state at each state
    public void setCurrentATMState(ATMState currentATMState) {
        this.currentATMState = currentATMState;
    }

    public ATMState getCurrentATMState() {
        return currentATMState;
    }
    
    // as we have made 'atmObject' as singleton.
    public static ATM getATMObject() {
        atmObject.setCurrentATMState(new IdleState());
        return atmObject;
    }

    public int getAtmBalance() {
        return atmBalance;
    }
    
    // setting amount and diff types of denomination available
    public void setAtmBalance(int atmBalance, int noOfFiveHundredNotes, int noOfTwoHundredNotes, int noOfOneHundredNotes) {
        this.atmBalance = atmBalance;
        this.noOfFiveHundredNotes= noOfFiveHundredNotes;
        this.noOfTwoHundredNotes = noOfTwoHundredNotes;
        this.noOfOneHundredNotes = noOfOneHundredNotes;
    }

    public int getNoOfFiveHundredNotes() {
        return noOfFiveHundredNotes;
    }
    
    public int getNoOfTwoHundredNotes() {
        return noOfTwoHundredNotes;
    }

    public int getNoOfOneHundredNotes() {
        return noOfOneHundredNotes;
    }

    public void deductATMBalance(int amount) {
        atmBalance = atmBalance - amount;
    }

    public void deductTwoHundredNotes(int number) {
    	noOfTwoHundredNotes = noOfTwoHundredNotes - number;
    }

    public void deductFiveHundredNotes(int number) {
        noOfFiveHundredNotes = noOfFiveHundredNotes - number;
    }

    public void deductOneHundredNotes(int number) {
        noOfOneHundredNotes = noOfOneHundredNotes - number;
    }

    public void printCurrentATMStatus(){
        System.out.println("Balance: " + atmBalance);
        System.out.println("500Notes: " + noOfFiveHundredNotes);
        System.out.println("200Notes: " + noOfTwoHundredNotes);
        System.out.println("100Notes: " + noOfOneHundredNotes);

    }
}
