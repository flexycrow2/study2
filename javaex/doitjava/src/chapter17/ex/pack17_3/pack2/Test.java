package chapter17.ex.pack17_3.pack2;

import java.util.Objects;

class A extends Object {}
public class Test {
    public static void main(String[] args) {
        A a = new A();
        System.out.printf("%x", a.hashCode());      //해시코드
        System.out.println();
        System.out.println(a.toString());           //패키지명.클래스명@해시코드

        System.out.println(Objects.hash(1, 2, 3));
        System.out.println(Objects.hash(2, 1, 3));
        System.out.println(Objects.hash("안녕"));
        System.out.println(Objects.hash("방가"));

        // 등가연산자(==), equals()메서드
        // 등가연산자(==)는 스택 메모리값을 동등 비교

    }
}
