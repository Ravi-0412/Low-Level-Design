package Model;

import java.util.List;
import java.util.Map;

import Split.Split;
import User.User;

public class BalanceSheetController {

    public void updateUserExpenseBalanceSheet(User expensePaidBy, List<Split> splits, double totalExpenseAmount){

        // 1) update the total amount paid by the user in his balanceSheet i.e 'UserExpenseBalanceSheet'
    	// 1.1) Get the 'UserExpenseBalanceSheet' object
        UserExpenseBalanceSheet paidByUserExpenseSheet = expensePaidBy.getUserExpenseBalanceSheet();
        // 1.2) Update the value of total amount paid by him
        paidByUserExpenseSheet.setTotalPayment(paidByUserExpenseSheet.getTotalPayment() + totalExpenseAmount);
        
        // Now update the expense of each user in this split
        for(Split split : splits) {
        	
        	// Get the user from split
            User userOwe = split.getUser();
            // Get the 'UserExpenseBalanceSheet' object for use 'userOwe'
            UserExpenseBalanceSheet oweUserExpenseSheet = userOwe.getUserExpenseBalanceSheet();
            // Get the amount that this user will give to user who has paid for this split
            double oweAmount = split.getAmountOwe();

            if(expensePaidBy.getUserId().equals(userOwe.getUserId())){
            	// Agar bill yhi user pay kiya h, then is user ka 'TotalExpense' update kar do.
                paidByUserExpenseSheet.setTotalYourExpense(paidByUserExpenseSheet.getTotalYourExpense()+oweAmount);
            }
            else {
            	// Agar different user h then 

                // 1) Jo paid kiya h uska 'getBack' amount update kar do
                paidByUserExpenseSheet.setTotalYouGetBack(paidByUserExpenseSheet.getTotalYouGetBack() + oweAmount);
                
                // now 'userOwe' and jo user paid kiya h uska 'owe' and 'getBack' update kar do.
                Balance userOweBalance;  
                if(paidByUserExpenseSheet.getUserVsBalance().containsKey(userOwe.getUserId())) {
                	// agar ''userOwe' jo user paid kiya h uske saath already amount unsettled h then usi me update karna h

                    userOweBalance = paidByUserExpenseSheet.getUserVsBalance().get(userOwe.getUserId());
                }
                else {
                	// nya key-value 'UserVsBalance' me dalenge jo user paid kiya h uske liye.
                    userOweBalance = new Balance();
                    paidByUserExpenseSheet.getUserVsBalance().put(userOwe.getUserId(), userOweBalance);
                }
                // Ab jo use pay kiya h wo uska 'geBack' update kar do for 'userOwe'
                userOweBalance.setAmountGetBack(userOweBalance.getAmountGetBack() + oweAmount);


                //update the balance sheet of owe user
                oweUserExpenseSheet.setTotalYouOwe(oweUserExpenseSheet.getTotalYouOwe() + oweAmount);
                oweUserExpenseSheet.setTotalYourExpense(oweUserExpenseSheet.getTotalYourExpense() + oweAmount);
                
                // Ab 'userOwe' ke liye bhi 'oweAmount' update kar jo , jaise upper kiye h paid user ke kiye 'getBack'
                Balance userPaidBalance;
                if(oweUserExpenseSheet.getUserVsBalance().containsKey(expensePaidBy.getUserId())){
                    userPaidBalance = oweUserExpenseSheet.getUserVsBalance().get(expensePaidBy.getUserId());
                }
                else{
                    userPaidBalance = new Balance();
                    oweUserExpenseSheet.getUserVsBalance().put(expensePaidBy.getUserId(), userPaidBalance);
                }
                userPaidBalance.setAmountOwe(userPaidBalance.getAmountOwe() + oweAmount);
            }
        }
    }

    public void showBalanceSheetOfUser(User user){

        System.out.println("---------------------------------------");

        System.out.println("Balance sheet of user : " + user.getUserId());

        UserExpenseBalanceSheet userExpenseBalanceSheet =  user.getUserExpenseBalanceSheet();

        System.out.println("TotalYourExpense: " + userExpenseBalanceSheet.getTotalYourExpense());
        System.out.println("TotalGetBack: " + userExpenseBalanceSheet.getTotalYouGetBack());
        System.out.println("TotalYourOwe: " + userExpenseBalanceSheet.getTotalYouOwe());
        System.out.println("TotalPaymnetMade: " + userExpenseBalanceSheet.getTotalPayment());
        for(Map.Entry<String, Balance> entry : userExpenseBalanceSheet.getUserVsBalance().entrySet()){

            String userID = entry.getKey();
            Balance balance = entry.getValue();

            System.out.println("userID:" + userID + " YouGetBack:" + balance.getAmountGetBack() + " YouOwe:" + balance.getAmountOwe());
        }

        System.out.println("---------------------------------------");

    }
}
