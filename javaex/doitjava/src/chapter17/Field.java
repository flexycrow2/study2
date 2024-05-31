package chapter17;

class A {
    int m = 3;
    int n = 4;
    void work1(){
        int k = 5;
        System.out.println(k);
        work2(3);
    }

    void work2(int i){
        int j = 4;
        System.out.println(i + j);
    }
}

public class Field {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = a1;

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a1.equals(a2));
////        System.out.println(a.m);
////        System.out.println(a.n);
//        a.work1();
    }
}
