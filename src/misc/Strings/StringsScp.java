package misc.Strings;

public class StringsScp {
    public static void main(String[] args) {
        String s1 = new String("hello"); // creates a new object in heap
        String s2 = "hello"; // refers to string literal in SCP
        System.out.println(s1 == s2); // since pointing to different references, its false
        System.out.println(s1.intern() == s2); // intern explicitly points to literal in SCP, hence true
        System.out.println(s1.equals(s2)); // content comparison, hence true
    }
}
