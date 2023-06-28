package Account;

public class TestAccount {
    public static void main(String[] args) {
        Account aAccount = new Account(10000);
        Account bAccount = new Account(30000);
        // 因為封裝的概念 所以外面的class沒辦法直接動到balance 要透過別的函式來動到balance
        // bAccount.balance+=10000;
        bAccount.deposit(10000);
        aAccount.deposit(-100);
        aAccount.withdraw(12000);
        System.out.println(aAccount.getBalance());
        System.out.println(bAccount.getBalance());

        // Account.setInterestRate(.005);
        // aAccount.calculateInterestRate();
        // bAccount.calculateInterestRate();
        System.out.println(aAccount.getBalance());
        System.out.println(bAccount.getBalance());
    }
}
