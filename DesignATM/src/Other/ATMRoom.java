package Other;

public class ATMRoom {
    ATM atm;
    User user;

    public static void main(String args[]) {

        ATMRoom atmRoom = new ATMRoom();
        atmRoom.initialize();  // it will initialize all required things one by one 

        atmRoom.atm.printCurrentATMStatus();
        atmRoom.atm.getCurrentATMState().insertCard(atmRoom.atm, atmRoom.user.card);
        atmRoom.atm.getCurrentATMState().authenticatePin(atmRoom.atm, atmRoom.user.card, 112211);
        atmRoom.atm.getCurrentATMState().selectOperation(atmRoom.atm, atmRoom.user.card, TransactionType.CASH_WITHDRAWAL);
        atmRoom.atm.getCurrentATMState().cashWithdrawal(atmRoom.atm, atmRoom.user.card, 4900);
        atmRoom.atm.printCurrentATMStatus();


    }
    
    // 1st it should set the balance in atm
    private void initialize() {

        //create ATM
        atm = ATM.getATMObject();
        atm.setAtmBalance(10000, 10,20,10);

        //Now create user since ATMRoom has user associated with him
        this.user = createUser();
    }

    private User createUser(){

        User user = new User();
        
        // after creating user create card since user has 'card' associated with him
        user.setCard(createCard());
        return user;
    }

    private Card createCard(){

        Card card = new Card();
        // Now create bankAccount since card has 'BankAccount' associated with him
        card.setBankAccount(createBankAccount());
        return card;
    }
    
    private UserBankAccount createBankAccount() {

        UserBankAccount bankAccount = new UserBankAccount();
        bankAccount.balance = 8000;

        return bankAccount;

    }

}