package account;

public class Account {
    private double accountBalance;

    public Account(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public double withdrawMoney(double moneyToWithdraw){
        if (accountBalance > moneyToWithdraw) {
            accountBalance = accountBalance - moneyToWithdraw;
            return moneyToWithdraw;
        } else {
            System.out.println("You do not have enough money to withdraw " + moneyToWithdraw);
            return 0;
        }
    }
}
