package ATMStates;

import Other.ATM;
import Other.Card;

public class IdleState extends ATMState {
	
	// at this state write all the valid operation you can perform

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Card is inserted");
        atm.setCurrentATMState(new HasCardState());
    }
}
