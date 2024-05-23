package chapter17.ex;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

public class JavaEx {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
//        for(int i = 0; i < array.length; i++){
//            System.out.println(array[i]);
//        }

//        System.out.println(Arrays.toString(array));
        //배열에 있는 원소를 다 출력해줌.

        List<Integer> aList = new ArrayList<Integer>();
        aList.add(1);
        aList.add(2);
        aList.add(3);

        System.out.println(aList.toString());
        System.out.println(aList);
    }
}
