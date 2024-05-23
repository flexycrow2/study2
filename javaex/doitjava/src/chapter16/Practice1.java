package chapter16;

class F {
    public void method1(){
        System.out.println("다예님 이번주는 클밍 어디가요.");
    }
}

class G {
    public int method2(int a, int b){
        return a + b;
    }
}

public class Practice1 {
    public static void main(String[] args) {
        F f = new F();
        f.method1();

        G g = new G();
        g.method2(1,2);
        System.out.println(g.method2(1,2));
    }
}
