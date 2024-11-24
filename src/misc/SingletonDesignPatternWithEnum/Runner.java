package misc.SingletonDesignPatternWithEnum;

enum Singleton {

    INSTANCE;

    public void perform() {
        System.out.println("Performing some task.! hashcode = " + this.hashCode());
    }

}

public class Runner {
    public static void main(String[] args) {
//        Enum is immune to Reflection, Serialization and clone and by default a Singleton
        Singleton s1 = Singleton.INSTANCE;
        Singleton s2 = Singleton.INSTANCE;
        s1.perform();
        s2.perform();
        System.out.println(s1.hashCode() == s2.hashCode());
    }
}
