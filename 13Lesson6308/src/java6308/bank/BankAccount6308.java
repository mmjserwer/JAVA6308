package java6308.bank;

public class BankAccount6308 {
    private String bankID;
    private int balance;

    public BankAccount6308(String bankID, int balance) {
        this.bankID = bankID;
        this.balance = balance;
    }

    public String getBankID() {
        return bankID;
    }

    public void setBankID(String bankID) {
        this.bankID = bankID;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
