package chapter17.ex.pack17_5;

import java.util.Stack;

public class StackMethod {
    public static void main(String[] args) {

        //LIFO : 나중에 입력된 데이터가 먼저 출력되는 것

        Stack<Integer> s = new Stack<Integer>();
        //1. E push(E element)
        s.push(2);
        s.push(3);
        s.push(5);
        s.push(7); //7,5,3,2

        //2. E peek();
        System.out.println(s.peek()); //7 뽑고 데이터는 살아있어요. 걍 확인.
        System.out.println(s.size()); //4
        System.out.println();

        //3. search(Object o)
        System.out.println(s.search(7)); //1
        System.out.println(s.search(5)); //2
        System.out.println(s.search(3)); //3
        System.out.println(s.search(2)); //4
        System.out.println(s.search(9)); //해당 데이터 없으면 -1 리턴
        System.out.println();

        //4. E pop()
        System.out.println(s.pop()); //뽑고 없애요.
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.empty());
        System.out.println(s.pop());

        //5. boolean empty()
        System.out.println(s.empty());
    }
}
