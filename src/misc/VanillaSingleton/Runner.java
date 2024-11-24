package misc.VanillaSingleton;

import java.io.Serializable;

class VanillaSingleton implements Cloneable, Serializable {

    //    private static instance
    private static VanillaSingleton instance;

    //    private constructor
    private VanillaSingleton() {
//        protection against reflection
        if (instance == null) {
            throw new RuntimeException("Single instance already created!");
        }
    }

    //    single getInstance method to get access to the object
    public static VanillaSingleton getInstance() {
        if (instance == null) {
            synchronized (VanillaSingleton.class) {
                if (instance == null) {
                    instance = new VanillaSingleton();
                }
            }
        }
        return instance;
    }

    //    protection against Serialization/De-Serialization
    protected Object readResolve() {
        return instance;
    }

    //    protection against cloning
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton cloning is not allowed");
    }
}

public class Runner {
    public static void main(String[] args) {
        VanillaSingleton s1 = VanillaSingleton.getInstance();
        VanillaSingleton s2 = VanillaSingleton.getInstance();
        System.out.println(s1.hashCode() == s2.hashCode());
    }
}
