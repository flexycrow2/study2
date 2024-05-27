package chapter17.ex.pack17_3.pack5;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class C{
    int data;
    public C(int data){
        this.data = data;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof C){
            if (this.data ==((C) obj).data){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(data);  //data
//        return (new Integer(data)).hashCode();
//        return data;
    }
}

public class Test3 {
    public static void main(String[] args) {
        Set<C> hashSet3 = new HashSet<>();
        C c1 = new C(3);
        C c2 = new C(3);
        System.out.println(c1 == c2);                               //false
        System.out.println(c1.equals(c2));                          //true
        System.out.println(c1.hashCode()+ " " + c2.hashCode());     //3 3
        hashSet3.add(c1);
        hashSet3.add(c2);
        System.out.println(hashSet3.size());                        //1(같은 객체)
    }
}
