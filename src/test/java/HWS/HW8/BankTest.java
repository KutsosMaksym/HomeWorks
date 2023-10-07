package HWS.HW8;

import org.testng.annotations.Test;

public class BankTest {
    @Test
    public void checkAccountLimit() {
        Bank bank = new Bank(3);
        bank.createAccount(12003, 100);
        bank.createAccount(12004, 205);
        bank.createAccount(12005, 350);
        bank.createAccount(12006, 70);
        bank.returnAccountsInfo();
    }

    @Test
    public void checkReplenishmentOperation() {
        Bank bank = new Bank(3);
        bank.createAccount(123, 250);
        bank.returnAccountInfo(123);
        bank.createTransactions();
        bank.accountReplenishment(123, 10);
        bank.returnAccountInfo(123);
        bank.accountReplenishment(123, -5);
        bank.returnAccountInfo(123);
    }

    @Test
    public void checkWithdrawOperation() {
        Bank bank = new Bank(3);
        bank.createAccount(12300, 250);
        bank.createTransactions();
        bank.returnAccountInfo(12300);
        bank.accountWithdraw(12300, 5);
        bank.returnAccountInfo(12300);
        bank.accountWithdraw(12300, 300);
        bank.accountWithdraw(99999, 300);
        bank.returnAccountInfo(12300);
    }

    @Test
    public void checkTransactionsLog() {
        Bank bank = new Bank(3);
        bank.createAccount(12003, 100);
        bank.createAccount(12004, 205);
        bank.createTransactions();
        bank.accountReplenishment(12003, 10);
        bank.accountWithdraw(12004, 20);
        bank.accountWithdraw(12004, 30);
        bank.accountWithdraw(12003, 40);
        bank.accountWithdraw(12004, 50);
        bank.transactionsLogInfo();
    }

    @Test
    public void checkTransactionNumberValidation() {
        Bank bank = new Bank(3);
        bank.createAccount(123, 250);
        bank.createTransactions();
        bank.accountReplenishment(321, 15);
        bank.accountWithdraw(777777, 15);
        bank.returnAccountInfo(123);
    }
}
