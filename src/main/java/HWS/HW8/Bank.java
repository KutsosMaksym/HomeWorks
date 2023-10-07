package HWS.HW8;

import java.util.ArrayList;
import java.util.Iterator;

public class Bank {
    private Transactions transactions;
    int accountsQuantityLimit;
    ArrayList<Account> accountsList = new ArrayList<>();
    ArrayList<String> transactionsLog = new ArrayList<>();

    Bank(int accountsQuantityLimit) {
        this.accountsQuantityLimit = accountsQuantityLimit;
    }

    public Account createAccount(int number, double balance) {
        if (accountsList.size() == accountsQuantityLimit) {
            System.out.println("Impossible to create new account with number:" + number + ", the limit of accounts has been reached.");
            return null;
        }
        if (isAccountNumberExists(number)) {
            System.out.println("Impossible to create new account with number: " + number + ". Account with such number already exists.");
            return null;
        }
        accountsList.add(new Account(number, balance));
        return accountsList.get(accountsList.size() - 1);
    }


    class Account {
        int number;
        double balance;

        private Account(int number, double balance) {
            this.number = number;
            this.balance = balance;
        }
    }

    public Transactions createTransactions() {
        return this.transactions = new Transactions();
    }

    public Transactions getTransactions() {
        return this.transactions;
    }

    public void accountReplenishment(int number, double sum) {
        this.transactions.accountReplenishment(number, sum);
    }

    public void accountWithdraw(int number, double sum) {
        this.transactions.accountWithdraw(number, sum);
    }

    private class Transactions {
        void accountReplenishment(int number, double sum) {
            if (!isAccountNumberExists(number)) {
                System.out.println("There are no such account number " + number);
                return;
            }
            if (sum <= 0) {
                System.out.println("Sum of replenishment should be more than 0");
                return;
            }
            Iterator<Account> iterator = accountsList.iterator();
            while (iterator.hasNext()) {
                Account account = iterator.next();
                if (account.number == number) {
                    account.balance += sum;
                    transactionsLog.add("Replenishment" + " +" + sum + ". Account number: " + account.number + ". New balance: " + account.balance);
                    return;
                }
            }
        }

        void accountWithdraw(int number, double sum) {
            if (!isAccountNumberExists(number)) {
                System.out.println("There are no such account number " + number);
                return;
            }
            if (sum <= 0) {
                System.out.println("Sum of withdraw should be more than 0");
                return;
            }
            Iterator<Account> iterator = accountsList.iterator();
            while (iterator.hasNext()) {
                Account account = iterator.next();
                if (account.number == number) {
                    if (account.balance < sum) {
                        System.out.println("Not enough money in the account for the operation");
                        return;
                    }
                    account.balance -= sum;
                    transactionsLog.add("Withdraw" + " -" + sum + ". Account number: " + account.number + ". New balance: " + account.balance);
                    return;
                }
            }
        }

    }

    private Boolean isAccountNumberExists(int number) {
        return accountsList.stream().anyMatch(p -> p.number == number);
    }
}
