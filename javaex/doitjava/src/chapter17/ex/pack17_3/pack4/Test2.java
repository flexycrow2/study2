package chapter17.ex.pack17_3.pack4;

import com.sun.source.tree.UsesTree;

import java.util.HashSet;
import java.util.Set;

class B{
    int data;
    public B(int data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof B){
            if(this.data ==((B)obj).data)
                return true;
        }
        return false;
    }
}

public class Test2 {
    public static void main(String[] args) {
        // equals(): 오버라이딩 O + hashcode() : 오버라이딩 X
        Set<B> hashSet2 = new HashSet<>();
        B b1 = new B(3); //100
        B b2 = new B(3); //200
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b1 == b2);       //false
        System.out.println(b1.equals(b2));  //true
//        System.out.println(b1.data);
//        System.out.println(b2.data);
        System.out.println(b1.hashCode() + " " + b2.hashCode());    //189568618 793589513
        hashSet2.add(b1);
        hashSet2.add(b2);
        System.out.println(hashSet2.size());    //2(다른객체)

    }
}
