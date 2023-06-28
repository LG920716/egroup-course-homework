package Trip;

//抽象讓function可以不用先定義 可以且必須在子類別定義 而且抽象類別不能被new出來
//子物件只能繼承一個父物件
public abstract class Trip implements Rental{
    private String name;
    private int days;
    private int miles;

    public Trip(String name, int days, int miles) {
        this.name = name;
        this.days = days;
        this.miles = miles;
    }

    public String getName() {
        return name;
    }

    public int getDays() {
        return days;
    }

    public int getMiles() {
        return miles;
    }

    //這個方法使我要印出這個物件時自動轉字串 不然他會印出記憶體位置
    public String toString() {
        return name + ": " + days + "days, " + miles + "miles, " + getCharge();
    }

    public abstract double getCharge();
}
