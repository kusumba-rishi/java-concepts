package misc.SingletonWithEnum;

enum Singleton {

    INSTANCE;

    public void process() {
        System.out.println("processing");
    }
}

public class Runner {
    public static void main(String[] args) {
        Singleton s1 = Singleton.INSTANCE;
        Singleton s2 = Singleton.INSTANCE;
        System.out.println(s1.hashCode() == s2.hashCode());
    }
}
