package chapter17.ex.pack17_3_0;

class A {
    int data;
    public A(int data) {
        this.data = data;
    }
}
class H {}
public class Test {
    public static void main(String[] args) {
        H h = new H();
        System.out.println(h);

        A a1 = new A(3);
        A a2 = new A(3);
        System.out.println(a1 == a2);
        System.out.println(a1.equals(a2));

        Integer aa1 = new Integer(3);
        Integer aa2 = new Integer(3);
        System.out.println(aa1 == aa2);
        System.out.println(aa1.equals(aa2));

        String s1 = new String("저그");
        String s2 = new String("저그");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}
