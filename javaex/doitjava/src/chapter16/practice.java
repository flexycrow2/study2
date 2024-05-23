package chapter16;

class MyGeneric <T> {
    T t;
    public T get() {
        return t;
    }

    public void set(T t) {
        this.t = t;
    }
}

class D {
    @Override
    public String toString() {
        return "클래스 D 객체";
    }
}

class B {
    @Override
    public String toString() {
        return "클래스 B 객체";
    }
}
public class practice {
    public static void main(String[] args) {

        D a_in = new D();
        B b_in = new B();

        MyGeneric<D> mg1 = new MyGeneric<D>();
        mg1.set(a_in);
        D a_out = mg1.get();
        System.out.println(a_out);

        MyGeneric<B> mg2 = new MyGeneric<B>();
        mg2.set(b_in);
        B b_out = mg2.get();
        System.out.println(b_out);
    }
}
