package chapter17.ex.pack17_4.pack5;

import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapMethod_1 {
    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
        for (int i = 20; i > 0; i -= 2) {
            treeMap.put(i, i + "번째 데이터");
        }
        System.out.println(treeMap.toString());
        //key값의 크기를 역순으로 입력해도 출력해보면 key 값의 오름차순으로 정렬됨.

        //데이터 검색
        //1. firstKey()
        System.out.println(treeMap.firstKey()); // 2
        //2. firstEntry()
        System.out.println(treeMap.firstEntry()); // 2=2번째 데이터
        //3. lastKey()
        System.out.println(treeMap.lastKey()); // 20
        //4. lastEntry()
        System.out.println(treeMap.lastEntry()); // 20=20번째 데이터
        //5. lowerKey(K key)
        System.out.println(treeMap.lowerKey(11)); // 10
        System.out.println(treeMap.lowerKey(10)); // 8
        //6. higherKey(K key)
        System.out.println(treeMap.higherKey(11)); // 12
        System.out.println(treeMap.higherKey(10)); // 12
        //7. pollFirstEntry() - 꺼내고 삭제.
        System.out.println(treeMap.pollFirstEntry()); //2=2번째 데이터
        System.out.println(treeMap.toString());
        //8. pollLastEntry() - 꺼내고 삭제
        System.out.println(treeMap.pollLastEntry()); //20=20번째 데이터
        System.out.println(treeMap.toString());

        //데이터 부분 집합(subMap)의 생성
        //9. SortedMap<K,V> headMap(K toKey)
        SortedMap<Integer, String> sortedMap = treeMap.headMap(8); //toKey 미만의 key 값
        System.out.println(sortedMap); // {4=4번째 데이터, 6=6번째 데이터}
        //10. NavigableMap<K,V> headMap(K toKey, boolean inclusive)
        NavigableMap<Integer, String> navigableMap = treeMap.headMap(8, true); //true포함, false미포함
        System.out.println(navigableMap); // {4=4번째 데이터, 6=6번째 데이터, 8=8번째 데이터}
        //11. SortedMap<K,V> tailMap<K toKey>
        sortedMap = treeMap.tailMap(14); // fromKey 포함
        System.out.println(sortedMap); // {14=14번째 데이터, 16=16번째 데이터, 18=18번째 데이터}
        //12. NavigableMap<K,V> tailMap(K fromKey, K toKey)
        navigableMap = treeMap.tailMap(14, false); // fromKey 포함true/미포함false
        System.out.println(navigableMap); // {16=16번째 데이터, 18=18번째 데이터}
        //13. SortedMap<K,V> subMap(K fromKey, K toKey)
        sortedMap = treeMap.subMap(6, 10); //fromKey 이상 toKey 미만
        System.out.println(sortedMap); // {6=6번째 데이터, 8=8번째 데이터}
        //14. NavigableMap<K,V> subMap(K fromKey, boolean frominclusive, K toKey, boolean toinclusive)
        navigableMap = treeMap.subMap(6, false, 10, true); //true 포함, false 미포함
        System.out.println(navigableMap); // {8=8번째 데이터, 10=10번째 데이터}

        //데이터 정렬
        //논리 시프트를 이용해 각 비트 위치에서의 값 알아 내기
        //15. NavigableSet<K> descendingKeySet()
        NavigableSet<Integer> navigableSet = treeMap.descendingKeySet(); //현재의 정렬 상태를 바꿈
        System.out.println(navigableSet);                   //[18, 16, 14, 12, 10, 8, 6, 4]
        System.out.println(navigableSet.descendingSet());   //[4, 6, 8, 10, 12, 14, 16, 18]
    }
}
