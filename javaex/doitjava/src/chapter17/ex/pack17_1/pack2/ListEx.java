package chapter17.ex.pack17_1.pack2;

import java.util.ArrayList;
import java.util.List;

public class ListEx {
    public static void main(String[] args) {
        List<String> aList = new ArrayList<>();
        aList.add("가");aList.add("나");aList.add("다");aList.add("라");
        aList.add("마");aList.add("바");aList.add("사");
        System.out.println(aList.size());
        aList.remove("다");
        aList.remove("바");
        System.out.println(aList.size());
    }
}
