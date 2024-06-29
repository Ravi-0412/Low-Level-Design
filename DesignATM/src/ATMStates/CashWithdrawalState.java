package ATMStates;

import AmountWithdrawal.CashWithdrawProcessor;
import AmountWithdrawal.FiveHundredWithdrawProcessor;
import AmountWithdrawal.OneHundredWithdrawProcessor;
import AmountWithdrawal.TwoHundredWithdrawProcessor;
import Other.ATM;
import Other.Card;

public class CashWithdrawalState extends ATMState {

    public CashWithdrawalState() {
        System.out.println("Please enter the Withdrawal Amount");
    }
    
    // will check if we can make this 'amount' with with these denomination & their quantity given
    public boolean isCombinationpossible(ATM atmObject, int amount) {
    	int x = atmObject.getNoOfFiveHundredNotes();
    	int y = atmObject.getNoOfTwoHundredNotes();
    	int z = atmObject.getNoOfOneHundredNotes();
    	// Check with 500 notes
        int no = amount / 500;
        if (no >= x) {
            amount -= x * 500;
            x = 0;
        } else {
            amount -= no * 500;
            x -= no;
        }
        if (amount == 0) {
            return true;
        }

        // Check with 200 notes
        no = amount / 200;
        if (no >= y) {
            amount -= y * 200;
            y = 0;
        } else {
            amount -= no * 200;
            y -= no;
        }
        if (amount == 0) {
            return true;
        }

        // Check with 100 notes
        no = amount / 100;
        if (no >= z) {
            amount -= z * 100;
            z = 0;
        } else {
            amount -= no * 100;
            z -= no;
        }
        if (amount == 0) {
            return true;
        }

        return false;
    }

    public void cashWithdrawal(ATM atmObject, Card card, int withdrawalAmountRequest) {

        if (atmObject.getAtmBalance() < withdrawalAmountRequest) {
            System.out.println("Insufficient fund in the ATM Machine");
            exit(atmObject);
        } else if (card.getBankBalance() < withdrawalAmountRequest) {
            System.out.println("Insufficient fund in the your Bank Account");
            exit(atmObject);
        } else {
        	
        	// first check if this 'withdrawal amount' is possible with the help of these denominations.Do it later
        	// This we can check in 'ATMRoom' also while entering the amount
        	if(!isCombinationpossible(atmObject, withdrawalAmountRequest)) {
        		System.out.println("This amount is not possible to withdraw because these denominations can't form this amount, please try another amount");
        		exit(atmObject);
        		return;
        	}
        			

            card.deductBankBalance(withdrawalAmountRequest);
            atmObject.deductATMBalance(withdrawalAmountRequest);

            //using chain of responsibility for this logic, how many 500 Rs notes, how many 200 Rs notes etc, has to be withdrawal
            CashWithdrawProcessor withdrawProcessor =
                    new FiveHundredWithdrawProcessor(new TwoHundredWithdrawProcessor(new OneHundredWithdrawProcessor(null)));

            withdrawProcessor.withdraw(atmObject, withdrawalAmountRequest);
            exit(atmObject);
        }
    }

    @Override
    public void exit(ATM atmObject) {
        returnCard();
        atmObject.setCurrentATMState(new IdleState());
        System.out.println("Exit happens");
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }
}

