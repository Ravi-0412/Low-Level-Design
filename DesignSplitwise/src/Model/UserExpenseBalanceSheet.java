package Model;

import java.util.HashMap;
import java.util.Map;

import User.User;


import java.util.HashMap;
import java.util.Map;

public class UserExpenseBalanceSheet {

    Map<String, Balance> userVsBalance;   // String: userId . ye user ko kis person(userId) ko kitna dena ya lena h
    double totalYourExpense;   // tmhara kitna total expense hua after contribution of bills

    double totalPayment;      // tm total kitna payment kiye

    double totalYouOwe;      // total tm kitna doge
    double totalYouGetBack;  // total tmko kitna milega

    public UserExpenseBalanceSheet(){

        userVsBalance = new HashMap<>();
        totalYourExpense = 0;
        totalYouOwe = 0;
        totalYouGetBack = 0;
    }

    public Map<String, Balance> getUserVsBalance() {
        return userVsBalance;
    }

    public double getTotalYourExpense() {
        return totalYourExpense;
    }

    public void setTotalYourExpense(double totalYourExpense) {
        this.totalYourExpense = totalYourExpense;
    }

    public double getTotalYouOwe() {
        return totalYouOwe;
    }

    public void setTotalYouOwe(double totalYouOwe) {
        this.totalYouOwe = totalYouOwe;
    }

    public double getTotalYouGetBack() {
        return totalYouGetBack;
    }

    public void setTotalYouGetBack(double totalYouGetBack) {
        this.totalYouGetBack = totalYouGetBack;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }
}