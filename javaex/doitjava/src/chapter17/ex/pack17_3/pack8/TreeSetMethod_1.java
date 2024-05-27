package chapter17.ex.pack17_3.pack8;

import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetMethod_1 {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 50; i > 0; i -= 2) {
            treeSet.add(i);
        }
        System.out.println(treeSet.toString());

        //데이터 검색
        //1. first() - Set 원소 중 가장 작은 원솟값 리턴
        System.out.println(treeSet.first());

        //2. last() - Set 원소 중 가장 큰 원솟값 리턴
        System.out.println(treeSet.last());

        //3. lower(E element) - 매개변수로 입력된 원소보다 작은, 가장 큰 수
        System.out.println(treeSet.lower(26));

        //4. higher(E element) - 매개변수로 입력된 원소보다 큰, 가장 작은 수
        System.out.println(treeSet.higher(26));

        //5. floor(E element) - 매개변수로 입력된 원소보다 같거나 작은 가장 큰 수
        System.out.println(treeSet.floor(25));
        System.out.println(treeSet.floor(26));

        //6. ceiling(E element) - 매개변수로 입력된 원소보다 같거나 큰 가장 작은 수
        System.out.println(treeSet.ceiling(25));
        System.out.println(treeSet.ceiling(26));

        System.out.println();

        //데이터 꺼내기
        //7. pollFirst() - Set 원소들 중 가장 작은 원솟값을 꺼내 리턴
        int treeSetSize = treeSet.size();
        System.out.println("treeSetSize: " + treeSetSize);
        for (int i = 0; i < treeSetSize; i++) {
            System.out.println(treeSet.pollFirst() + " ");
        }
        System.out.println("treeSetSize: " + treeSet.size());

        //8. pollLast() - Set 원소들 중 가장 큰 원솟값을 꺼내 리턴
        for (int i = 50; i > 0; i -= 2) {
            treeSet.add(i);
        }
        treeSetSize = treeSet.size();
        System.out.println(treeSetSize);
        for(int i = 0; i < treeSetSize; i++){
            System.out.print(treeSet.pollLast() + " ");
        }
        System.out.println();
        System.out.println(treeSet.size());

        //---------------------

        for (int i = 50; i > 0; i -= 2) {
            treeSet.add(i);
        }

        //데이터 부분 집합 생성
        //9. SortedSet<E> headSet(E toElement) - toElement 미만인 모든 원소로 구성된 Set을 리턴(toElement 미포함)
        SortedSet<Integer> sSet = treeSet.headSet(20);
        System.out.println(sSet.toString());

        //10. NavigableSet<E> headSet(E toElement, boolean inclusive) - true면 toElement포함, false면 미포함
        NavigableSet<Integer> nSet = treeSet.headSet(20,false);
        System.out.println(nSet.toString());

        nSet = treeSet.headSet(20, true);
        System.out.println(nSet.toString());

        //11. SortedSet<E> tailSet(E element) - fromElement 초과/이상인 모든 원소로 구성된 Set을 리턴 - true면 fromElement 포함, false면 미포함
        sSet = treeSet.tailSet(20);
        System.out.println(sSet.toString());

        //12. NavigableSet<E> tailSet(E toElement, boolean inculsive)
        nSet = treeSet.tailSet(20, false);
        System.out.println(nSet.toString());
        nSet = treeSet.tailSet(20, true);
        System.out.println(nSet.toString());

        //13. SortedSet<E> subSet(E fromElement, E toElement)
        sSet = treeSet.subSet(10, 20);
        System.out.println(sSet.toString());

        //14. NavigableSet<E> subSet(E fromElement, boolean frominclusive, E toElement, boolean toinclusive)
        nSet = treeSet.subSet(10, true, 20, false);
        System.out.println(nSet.toString());
        nSet = treeSet.subSet(10, false, 20, true);
        System.out.println(nSet.toString());

        //데이터 정렬
        //15. NavigableSet<E> descendingSet() - 현재의 정렬 기준(오름차순,내림차순)을 바꾸는 메서드.
        System.out.println(treeSet);
        NavigableSet<Integer> descendingSet = treeSet.descendingSet();
        System.out.println(descendingSet);
        descendingSet = descendingSet.descendingSet();
        System.out.println(descendingSet);
    }
}
