package chapter18.ex.pack18_1.pack1;

interface A {
    void abc();
}

class B implements A {
    @Override
    public void abc() {
        System.out.println("메서드 내용 1");
    }
}

public class OOPvsFP {
    public static void main(String[] args) {
        //1. 객체 지향 프로그래밍 문법 1
        A a1 = new B();
        a1.abc(); // 메서드 내용

        //2. 객체 지향 프로그래밍 문법 2(익명 이너 클래스 사용)
        A a2 = new A() {
            @Override
            public void abc() {
                System.out.println("메서드 내용 2");
            }
        };
        a2.abc(); // 메서드 내용

        //3. 함수형 프로그래밍 문법(람다식), 람다식은 익명 이너 클래스의 축약된 형태.
        A a3 = () -> {
            System.out.println("메서드 내용 3");
        };
        a3.abc();

        //약식 표현
        //1. 중괄호 안의 실행문이 1개일 때 중괄호 생략 가능
        A aa1 = () -> {
            System.out.println("테스트");
        };
        A aa2 = () -> System.out.println("테스트");

        //2. 매개변수 타입을 생략 가능하고, 매개변수가 1개일 때 () 생략 가능
        //A aa3 = (int a) -> { };
        //A aa4 = (a) -> { };
        //A aa5 = a -> { };
        //A aa6 = int a -> { };

        //3. return 구문만 포함할 때 return 생략 가능
        //A aa7 = (int a, int b) -> {return a + b};
        //A aa8 = (int a, int b) -> a + b;
        //A aa9 = (int a, int b) -> {a + b}; //X, return 생략할 때 중괄호 반드시 함께 생략
    }
}
