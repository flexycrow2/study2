package chapter17.ex.pack17_2.pack3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddEx {
    public static void main(String[] args) {

        //데이터 추가하기 - add()
        List<Integer> aList1 = new ArrayList<Integer>();
        //add(E element)
        aList1.add(3);
        aList1.add(4);
        aList1.add(5);
        System.out.println(aList1.toString()); // [3,4,5]
        //add(int index, E element)
        aList1.add(1, 6);
        System.out.println(aList1.toString()); // [3,6,4,5]

        //addAll(Collection<? extends E> c)
        List<Integer> aList2 = new ArrayList<Integer>();
        aList2.add(1);
        aList2.add(2);
        aList2.addAll(aList1);                      // aList1 = [3,6,4,5]
        System.out.println(aList2.toString());      // [1,2,3,6,4,5] 추가한 데이터가 뒤쪽에 한 번에 추가

        //addAll(index, Collection<? extends E> c)
        List<Integer> aList3 = new ArrayList<Integer>();
        aList3.add(1);
        aList3.add(2);
        aList3.addAll(1, aList3);             // 특정 위치에 리스트 객체를 통째로 추가(자신의 데이터를 추가할 수도 있음)
        System.out.println(aList3.toString());      // [1,1,2,2]

        //데이터 변경하기 - set()
        //set(int index, E element): aList3 = [1,1,2,2]
        aList3.set(1, 5);
        aList3.set(3, 6);
        //aList3.set(5,7)                           // IndexOutOfBoundsException
        //특정 위치에 데이터를 추가하는 용도로는 set()메서드를 사용할 수 없음.
        System.out.println(aList3.toString());      // [1,5,2,6]

        //데이터 삭제하기 - remove(), clear()
        //remove(int index): aList3 = [1,5,2,6]
        aList3.remove(1);
        System.out.println(aList3.toString());      // [1,2,6]
        //remove(Object o)
        aList3.remove(new Integer(2));        // 정수값 2를 원소로 갖는 객체가 지워짐
        System.out.println(aList3.toString());      // [1,6]
        //clear()
        aList3.clear();                             // 모든 데이터 한 번에 삭제
        System.out.println(aList3.toString());      // []

        //데이터 정보 추출하기 - isEmpty(), size(), get(int index)
        //isEmpty() : 데이터의 존재 여부 - 데이터가 한 개도 없을 때 true 리턴
        //size() : 저장 데이터의 개수
        //get(int index) : 특정 위치의 데이터값
        //isEmpty() aList3 = []
        System.out.println(aList3.isEmpty());       // true
        //size()
        aList3.add(1);
        aList3.add(2);
        aList3.add(3);
        System.out.println(aList3.toString());          // [1,2,3]
        System.out.println("size: " + aList3.size());   // size : 3
        //get(int index)
        System.out.println("0번째: " + aList3.get(0));    // 0번째 : 1
        System.out.println("1번째: " + aList3.get(1));    // 1번째 : 2
        System.out.println("2번째: " + aList3.get(2));    // 2번째 : 3
        for(int i = 0; i < aList3.size(); i++){
            System.out.println(i + "번째: " + aList3.get(i));
        }

        //배열로 변환하기 - toArray(), toArray(T[] t)
        //toArray() aList3 = [1,2,3]
        Object[] object = aList3.toArray();
        System.out.println(Arrays.toString(object));  // [1,2,3]
        //toArray(T[] t)
        Integer[] integer1 = aList3.toArray(new Integer[0]);
        System.out.println(Arrays.toString(integer1));  // [1,2,3]
        //toArray(T[] t)
        Integer[] integer2 = aList3.toArray(new Integer[5]);
        System.out.println(Arrays.toString(integer2));  // [1,2,3,null,null)
    }
}
