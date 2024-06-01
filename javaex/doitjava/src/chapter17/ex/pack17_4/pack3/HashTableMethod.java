package chapter17.ex.pack17_4.pack3;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class HashTableMethod {
    public static void main(String[] args) {
        Map<Integer, String> hTable1 = new Hashtable<Integer, String>();

        //데이터 추가
        Map<Integer, String> hMap1 = new HashMap<Integer, String>();
        //1. put(K key, V value)
        hMap1.put(2, "나다라");
        hMap1.put(1, "가나다");
        hMap1.put(3, "다라마");
        System.out.println(hMap1.toString());

        //2. putAll(Map<? extends K, ? extends V> m)
        Map<Integer, String> hmap2 = new HashMap<Integer, String>();
        hmap2.putAll(hMap1);
        System.out.println(hmap2.toString());

        //데이터 변경
        //3. replace(K key, V value)
        hmap2.replace(1, "가가가");
        hmap2.replace(4, "라라라"); // key = 4 인 엔트리가 없어서 동작X
        System.out.println(hmap2.toString());

        //4. replace(K key, V oldValue, V newValue)
        hmap2.replace(1, "가가가", "나나나");
        hmap2.replace(2, "다다다", "라라라"); //해당 엔트리 없어서 동작X
        System.out.println(hmap2.toString());

        //데이터 정보 추출
        //5. V get(Object key)
        System.out.println(hmap2.get(1)); // 나나나
        System.out.println(hmap2.get(2)); // 나다라
        System.out.println(hmap2.get(3)); // 다라마

        //6. containsKey(Object value)
        System.out.println(hmap2.containsKey(1)); // true
        System.out.println(hmap2.containsKey(5)); // false

        //7. containsValue(Object value)
        System.out.println(hmap2.containsValue("나나나")); //true
        System.out.println(hmap2.containsValue("다다다")); //false

        //8. Set<K> keySet()
        Set<Integer> keySet = hmap2.keySet();
        System.out.println(keySet.toString()); //[1,2,3]

        //9. Set<Map.Entry<K,V>> entrySet()
        Set<Map.Entry<Integer, String>> entrySet = hmap2.entrySet();
        System.out.println(entrySet); // [1=나나나, 2=나다라, 3=다라마]

        //10. size()
        System.out.println(hmap2.size()); //3

        //데이터 삭제
        //11. remove(Obejct key)
        hmap2.remove(1);
        hmap2.remove(4); // 동작X
        System.out.println(hmap2.toString()); // {2=나다라, 3=다라마}

        //12. remove(Object key, Object value)
        hmap2.remove(2, "나다라");
        hmap2.remove(3, "다다다"); // 동작X
        System.out.println(hmap2.toString()); // {3=다라마}

        //13. clear()
        hmap2.clear();
        System.out.println(hmap2.toString()); // {}
    }
}
