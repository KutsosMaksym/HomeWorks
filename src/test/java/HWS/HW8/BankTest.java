package HWS.HW8;

import org.testng.annotations.Test;

public class BankTest {
    @Test
    public void checkAccountLimit() {
        Bank bank = new Bank(3);
        Bank.Account account1 = bank.createAccount(12003, 100);
        Bank.Account account2 = bank.createAccount(12004, 205);
        Bank.Account account3 = bank.createAccount(12005, 350);
        Bank.Account account4 = bank.createAccount(12006, 70);
        for (Bank.Account account : bank.accountsList) {
            System.out.println("Account number " + account.number + " balance: " + account.balance);
        }
    }

    @Test
    public void checkReplenishmentOperation() {
        Bank bank = new Bank(3);
        Bank.Account account1 = bank.createAccount(123, 250);
        System.out.println("Account number " + account1.number + " balance: " + account1.balance);
        Bank.Transactions transactions = bank.new Transactions();
        transactions.accountReplenishment(123, 10);
        System.out.println("Account number " + account1.number + " balance: " + account1.balance);
        transactions.accountReplenishment(123, -5);
        System.out.println("Account number " + account1.number + " balance: " + account1.balance);
    }

    @Test
    public void checkWithdrawOperation() {
        Bank bank = new Bank(3);
        Bank.Account account = bank.createAccount(12300, 250);
        Bank.Transactions transactions = bank.new Transactions();
        System.out.println("Account number " + account.number + " balance: " + account.balance);
        transactions.accountWithdraw(12300, 5);
        System.out.println("Account number " + account.number + " balance: " + account.balance);
        transactions.accountWithdraw(12300, 300);
        transactions.accountWithdraw(99999, 300);
        System.out.println("Account number " + account.number + " balance: " + account.balance);
    }

    @Test
    public void checkTransactionsLog() {
        Bank bank = new Bank(3);
        Bank.Account account1 = bank.createAccount(12003, 100);
        Bank.Account account2 = bank.createAccount(12004, 205);
        Bank.Transactions transactions = bank.new Transactions();
        transactions.accountReplenishment(12003, 10);
        transactions.accountWithdraw(12004, 20);
        transactions.accountWithdraw(12004, 30);
        transactions.accountWithdraw(12003, 40);
        transactions.accountWithdraw(12004, 50);
        for (String transaction : bank.transactionsLog) {
            System.out.println(transaction);
        }
    }

    @Test
    public void checkTransactionNumberValidation() {
        Bank bank = new Bank(3);
        Bank.Account account1 = bank.createAccount(123, 250);
        Bank.Transactions transactions = bank.new Transactions();
        transactions.accountReplenishment(321, 15);
        transactions.accountWithdraw(777777, 15);
        System.out.println("Account number " + account1.number + " balance: " + account1.balance);
    }
}
