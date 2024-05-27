package chapter17.ex.pack17_3.pack3;

import java.util.HashSet;
import java.util.Set;

class A {
    int data;
    public A(int data){
        this.data = data;
    }
}
public class Test1 {
    public static void main(String[] args) {
        //equals(): 오버라이딩 X + hashcode(): 오버라이딩 X
        Set<A> hashset1 = new HashSet<>();
        A a1 = new A(3);
        A a2 = new A(3);
        System.out.println(a1 == a2);       //false
        System.out.println(a1.equals(a2));  //false
//        System.out.println(a1.data);
//        System.out.println(a2.data);
        System.out.println(a1.hashCode() + " " +a2.hashCode()); //189568618 793589513

        hashset1.add(a1);
        hashset1.add(a2);
        System.out.println(hashset1.size());    //2(다른객체)
    }
}
