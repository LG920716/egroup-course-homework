package Account;
public class SavingAccount extends Account {

    public SavingAccount(long balance){
        //因為SavingAccount不是Account所以要用super取得balance
        super(balance);
    }

    //繼承可以複寫父類的函式
    public void withdraw(long amount) {
        //balance一樣無法直接取得 所以要用geter來取得
        if(amount >0 &&getBalance()-amount>=0){
            super.withdraw(amount);
        }
    }

    public static void main(String[] args) {
        Account aAccount = new Account(10000);
        Account bAccount = new Account(30000);
        // 因為封裝的概念 所以外面的class沒辦法直接動到balance 要透過別的函式來動到balance
        // bAccount.balance+=10000;
        bAccount.deposit(10000);
        aAccount.deposit(-100);
        aAccount.withdraw(6000);
        System.out.println(aAccount.getBalance());
        System.out.println(bAccount.getBalance());

        // Account.setInterestRate(.005);
        // aAccount.calculateInterestRate();
        // bAccount.calculateInterestRate();
        System.out.println(aAccount.getBalance());
        System.out.println(bAccount.getBalance());
    }
}
