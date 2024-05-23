package chapter17.ex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LiveCoding {
    public static void main(String[] args) {

        //일단 이름이 array인 배열 크기 5인 배열에 숫자 1~5까지 만들기
        int[] array = {1,2,3,4,5};

        //이름이 array1 배열크기 5개만있고 값은 안넣은거를 만들어주세요 자료형은 int
        int[] array1 = new int[5];

        //for 문을 사용해서 array를 한개씩 출력
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }

        //이번에는 세로로 보기 싫어서 배열의 원소를 한줄에 보고싶어요 [1,2,3,4,5]
        System.out.println(Arrays.toString(array));

        // alist1이라는 Integer 타입의 ArrayList를 만들어주세요.
        List<Integer> alist1 = new ArrayList<Integer>();

        // 123을 처음부터 각각 넣어주세요.
        alist1.add(1);
        alist1.add(2);
        alist1.add(3);

        //1번째 인덱스에 alist1을 넣고 예상값을 알려주세요 [1,1,2,3,2,3]
        alist1.addAll(1,alist1);

        //alist1을 Arrays.tostring() 형식처럼 나오게 출력해주세요.
        System.out.println(alist1.toString());

        //위의 꺼랑 똑같이 나오는데 코드길이를 짧게 해주세요
//        System.out.println(alist1);

        //alist1의 사이즈를 보여주세요
        System.out.println(alist1.size());

        //alist1의 원소가 2인 거를 지워주세요
        alist1.remove(new Integer(2)); //하나만 지워짐, 빨간줄 뜨는데 실행됨!
        System.out.println(alist1);

        //alist1의 3번째 인덱스값을 보여주세요
        System.out.println(alist1.get(3));

        //alist1을 배열로 만들어주세요.
        Object[] arr = alist1.toArray();

        //Integer타입을써서 배열크기를 6개짜리로 만들어볼까요
        Integer[] arr2 = alist1.toArray(new Integer[6]);
        System.out.println(arr2); // 주소값 그쵸그쵸.
        System.out.println(Arrays.toString(arr2));
    }
}
