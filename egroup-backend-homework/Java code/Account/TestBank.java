package Account;


public class TestBank {
    public static void main(String[] args) {
        Bank myBank = new Bank(2);
        Bank yourBank = new Bank(2);
        myBank.addAccount(10000);
        myBank.addAccount(20000);
        yourBank.addAccount(30000);
        yourBank.addAccount(40000);
        System.out.println("myBank帳戶餘額");
        myBank.displayAllAccount();
        System.out.println("yourBank帳戶餘額");
        yourBank.displayAllAccount();

        //計算兩家銀行的利息
        myBank.calculateInterest();
        yourBank.calculateInterest();

        System.out.println("myBank計算利息後帳戶餘額");
        myBank.displayAllAccount();
        System.out.println("yourBank計算利息後帳戶餘額");
        yourBank.displayAllAccount();
    }
}
