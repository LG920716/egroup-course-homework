package Account;

public class Account {

    // private變數是各自獨立的 但有static會讓全部的變數共用這個變數
    // 這個技巧也叫封裝(使用private)
    private long balance;
    // private static double interestRate = .006;

    // public static void setInterestRate(double interestRate) {
    //     Account.interestRate = interestRate;
    // }

    public Account(long balance) {
        this.balance = balance;
    }// 建構子

    public void withdraw(long amount) {
        if (amount > 0 && balance - amount >= 0) {
            balance -= amount;
        }
    }

    public void deposit(long amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // public void calculateInterestRate() {
    // 在非靜態方法中可以使用靜態變數 在靜態方法中可以呼叫非靜態方法
    // balance += (balance * interestRate);
    // }

    public long getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        Account aAccount = new Account(10000);
        Account bAccount = new Account(30000);
        aAccount.deposit(10000);
        System.out.println(aAccount.getBalance());
        System.out.println(bAccount.getBalance());

        // Account.setInterestRate(.005);
        // aAccount.calculateInterestRate();
        // bAccount.calculateInterestRate();
        // System.out.println(aAccount.getBalance());
        // System.out.println(bAccount.getBalance());
    }
}
