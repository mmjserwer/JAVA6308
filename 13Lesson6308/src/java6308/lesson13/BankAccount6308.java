package java6308.lesson13;

public class BankAccount6308 {

    private String bankID;
    private Double balance;

    public BankAccount6308(String bankID, Double balance) {
        this.bankID = bankID;
        this.balance = balance;
    }

    public String getBankID() {
        return bankID;
    }

    public void setBankID(String bankID) {
        this.bankID = bankID;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
