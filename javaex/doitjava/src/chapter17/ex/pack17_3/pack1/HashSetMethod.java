package chapter17.ex.pack17_3.pack1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetMethod {
    public static void main(String[] args) {
        Set<String> hSet1 = new HashSet<String>();
        //1. add(E element)
        hSet1.add("가");
        hSet1.add("나");
        hSet1.add("가");
        System.out.println(hSet1.toString()); //가, 나

        //2. addAll(Collection<? extends E> c)
        Set<String> hset2 = new HashSet<String>();
        hset2.add("나");
        hset2.add("다");
        hset2.addAll(hSet1);
        System.out.println(hset2.toString()); // 가, 다, 나 - 모든 데이터를 하나의 주머니에 넣어 관리하므로 입력순서와 다르게 출력될 수 있음

        //3. remove(Object o)
        hset2.remove("나");
        System.out.println(hset2.toString());

        //4. clear()
        hset2.clear();
        System.out.println(hset2.toString());

        //5. isEmpty()
        System.out.println(hset2.isEmpty());

        //6. contains(Object o)
        Set<String> hset3 = new HashSet<>();
        hset3.add("가");
        hset3.add("다");
        hset3.add("나");
        System.out.println(hset3.contains("나"));
        System.out.println(hset2.contains("라"));

        //7. size()
        System.out.println(hset3.size());

        //8. iterator()
        //hasNext() - 다음으로 가리킬 원소의 존재여부를 불리언으로 리턴
        //next() - 다음 원소 위치로 가서 읽은 값을 리턴
        Iterator<String> iterator = hset3.iterator();
        // Iterator<E> 객체가 생성되면 이 객체가 가리키고 있는 위치는 첫 원소 위치가 아닌 첫 원소 바로 이전의 위칫값임.
        // 첫 번째 원솟값을 읽으려면 iterator.next()를 실행해야함
        while (iterator.hasNext()){
            System.out.println(iterator.next()+ " ");
        }

        // 8. for-each
        for (String s : hset3) {
            System.out.print(s + " ");
        }
        System.out.println();

        //9. toArray()
        Object[] objArray = hset3.toArray();
        System.out.println(Arrays.toString(objArray));

        //10-1. toArray(T[] t)
        String[] strArray1 = hset3.toArray(new String[0]);
        System.out.println(Arrays.toString(strArray1));

        //10-2. toArray(T[] t)
        String[] strArray2 = hset3.toArray(new String[5]);
        System.out.println(Arrays.toString(strArray2));
    }
}
