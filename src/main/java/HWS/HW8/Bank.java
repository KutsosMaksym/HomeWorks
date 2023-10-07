package HWS.HW8;

import java.util.ArrayList;

public class Bank {
    private Transactions transactions;
    int accountsQuantityLimit;
    ArrayList<Account> accountsList = new ArrayList<>();
    ArrayList<String> transactionsLog = new ArrayList<>();

    Bank(int accountsQuantityLimit) {
        this.accountsQuantityLimit = accountsQuantityLimit;
    }

    public void createAccount(int number, double balance) {
        if (accountsList.size() == accountsQuantityLimit) {
            System.out.println("Impossible to create new account with number:" + number + ", the limit of accounts has been reached.");
        }
        if (isAccountNumberExists(number)) {
            System.out.println("Impossible to create new account with number: " + number + ". Account with such number already exists.");
        }
        accountsList.add(new Account(number, balance));
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

            for (Account account : accountsList) {
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
            for (Account account : accountsList) {
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

    public void returnAccountsInfo() {
        for (Bank.Account account : accountsList) {
            System.out.println("Account number " + account.number + " balance: " + account.balance);
        }
    }

    public void returnAccountInfo(int number) {
        if (!isAccountNumberExists(number))
            System.out.println("Account with number " + number + " doesn't exist");
        for (Account account : accountsList) {
            if (account.number == number) {
                System.out.println("Account number " + account.number + " balance: " + account.balance);
            }
        }
    }

    public void transactionsLogInfo() {
        for (String transaction : transactionsLog) {
            System.out.println(transaction);
        }
    }
}