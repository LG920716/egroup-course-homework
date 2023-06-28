package Account;

public class Hello {

    public static void main(String[] args) {
        System.out.println("Hello");
        staticHello();
        Hello hello = new Hello();
        hello.sayHello();
    }

    // 這裡在教的是有static就會變成靜態方法 不需要new成一個物件就可以使用
    public static void staticHello() {
        System.out.println("Say hello in static");
    }

    // 像是這個我們就可以看到第六行 這個沒有static的方法就需要先被new出來才可以使用 而且要用hello.{方法名稱}才能使用
    public void sayHello() {
        System.out.println("say hello");
        staticHello();
    }
}