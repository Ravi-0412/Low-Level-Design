package Expense;

import java.util.List;

import Model.BalanceSheetController;
import Split.ExpenseSplit;
import Split.Split;
import Split.SplitFactory;
import User.User;

// for creating and updating expense in 'BalanceSheet'
public class ExpenseController {

 BalanceSheetController balanceSheetController;

 public ExpenseController(){
     balanceSheetController = new BalanceSheetController();
 } 

 public Expense createExpense(String expenseId, String description, double expenseAmount,
                              List<Split> splitDetails, ExpenseSplitType splitType, User paidByUser){
	 
	 // first getting the object of 'SplitType'
     ExpenseSplit expenseSplit = SplitFactory.getSplitObject(splitType);
     // validate the expense
     expenseSplit.validateSplitRequest(splitDetails, expenseAmount);
     // Create expense
     Expense expense = new Expense(expenseId, expenseAmount, description, paidByUser, splitType, splitDetails);
     // update the balance sheet for this expense
     balanceSheetController.updateUserExpenseBalanceSheet(paidByUser, splitDetails, expenseAmount);

     return expense;
 }
}
