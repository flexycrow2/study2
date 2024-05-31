package chapter17;

import java.util.Arrays;

public class ForEach {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        for(int i = 0; i < 5; i++){
            System.out.println(array[i]);
        }
        System.out.println(array[1]);

        //[1,2,3,4,5]
        System.out.println(Arrays.toString(array));

        for (int i : array) {   //인덱스 값이 필요없을때.
            System.out.println(i);
        }
    }
}
