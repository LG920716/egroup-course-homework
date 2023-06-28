package Account;
public class Bank {

    public enum AccountType {
        regular, saving
    }

    // 儲存所有Account
    private Account allAccounts[];
    // 目前帳戶數
    private int count = 0;
    // 做多只能有這麼多帳戶
    private int maxAccount;
    private static double interestRate = .006;

    public Bank(int maxAccount) {
        this.maxAccount = maxAccount;
        allAccounts = new Account[maxAccount];
    }

    public void addAccount(long balance) {
        // allAccounts[count] = new Account(balance);
        addAccount(balance, AccountType.regular);
    }

    //overloading 一樣的function名字 但會因為參數不同呼叫不同function
    public void addAccount(long balance, AccountType type) {
        if (count < maxAccount) {
            switch (type) {
                case saving:
                    allAccounts[count] = new SavingAccount(balance);
                    break;
                default:
                    allAccounts[count] = new Account(balance);
            }
            count++;
        }
    }

    public void calculateInterest() {
        for (int i = 0; i < count; i++) {
            long balance = allAccounts[i].getBalance();
            long interest = Math.round(balance * interestRate);
            allAccounts[i].deposit(interest);
        }
    }

    public void displayAllAccount() {
        for (int i = 0; i < count; i++) {
            System.out.println(allAccounts[i].getBalance());
        }
    }

    public static void main(String[] args) {
        Bank myBank = new Bank(2);
        myBank.addAccount(100);
        myBank.addAccount(200);
        myBank.addAccount(300);
        myBank.displayAllAccount();
    }
}
