# 17장 컬렉션 프레임워크

    *컬렉션
    여러 데이터를 수집해 놓은 자료구조
    데이터 저장공간의 크기가 동적으로 변화
    데이터의 개수가 시간적으로 변할 때 유용

### 17.1 컬렉션 프레임워크의 개념과 구조

    *컬렉션이란
    컬렉션은 동일한 타입을 묶어 관리하는 자료구조를 말함

    *배열과의 차이
    데이터의 저장용량을 동적으로 관리할 수 있음
    배열은 생성 시점에 저장 공간의 크기를 확정, 추후에 변경 불가
    컬렉션의 저장 공간은 데이터의 개수에 따라 얼마든지 동적으로 변화할 수 있음.
--------------------

    *라이브러리
    '단순히 연관된' 클래스와 인터페이스들의 묶음

----------------------

    *프레임워크
    클래스,인터페이스를 '생성하는 과정에서 설계의 원칙 또는 구조에 따라
    클래스 또는 인터페이스를 설계'하고, 이렇게 설계된 클래스와 인터페이스를 묶어 놓은 개념
    
----------------------


    *컬렉션 프레임워크
    컬렉션과 프레임워크가 조합된 개념으로
    리스트,스택,큐,트리 등의 자료구조에 정렬,탐색 등의 알고리즘을 구조화해 놓은 프레임워크

----------------------
    
    -> 여러 개의 데이터 묶음 자료를 효과적으로 처리하기 위해 구조화된 클래스,인터페이스의 모음
    List<E>, Set<E>, Map<K,V>
    + 확장,조합한 Stack<E>, Queue<E>

-----------------

### 17.2 List<E> 컬렉션 인터페이스

    *List<E>
    배열과 가장 비슷한 구조를 지니고 있는 자료구조
    
--------------
    
    *배열과 리스트의 차이점
    가장 큰 차이점은 저장 공간의 크기가 고정적인지 동적으로 변화하는지.

---------------

```java
public class Array {
    public static void main(String[] args) {
        String[] array = new String[] {"가","나","다","라","마","바","사"};
        array[2] = null;
        array[5] = null;
        System.out.println(array.length);
    }
}
```

---------------

```java
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
```

---------------

```java
package chapter17.ex.pack17_2.pack1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayVsList {
    public static void main(String[] args) {
        String[] array = new String[]{"가", "나", "다", "라", "마", "바", "사"};
        System.out.println(array.length);
        array[2] = null;
        array[5] = null;
        System.out.println(array.length);
        System.out.println(Arrays.toString(array));
        System.out.println();

        List<String> aList = new ArrayList<>();
        System.out.println(aList.size());
        aList.add("가");
        aList.add("나");
        aList.add("다");
        aList.add("라");
        aList.add("마");
        aList.add("바");
        aList.add("사");
        System.out.println(aList.size());
        aList.remove("다");
        aList.remove("바");
        System.out.println(aList.size());
        System.out.println(aList);
    }
}
```
---------------
List<E> 인터페이스 구현 클래스 생성자로 동적 컬렉션 객체 생성

    *List<E> 객체 생성
    List<E>는 인터페이스여서 객체를 스스로 생성할 수 없음
    객체 생성하기 위해 List<E>를 상속받아 자식클래스를 생성하고,
    생성한 자식 클래스를 이용해 객체를 생성해야함

    하지만, 컬렉션 프레임워크를 이용할 때는 직접 인터페이스를 구현하지 않아도 됨.
    (컬렉션 프레임워크 안에 이미 각각의 특성 및 목적에 따른 클래스가 구현되어 있기 때문)

-------------------

    List<E> 인터페이스를 구현한 대표적인 클래스의 종류

    1. ArrayList<E>
    2. Vector<E>
    3. LinkedList<E>

    이 구현 클래스들을 이용해서 List<E> 객체를 생성할 수 있음

-----------------

    List<E> 자체가 제네릭 인터페이스이므로 이를 상속한 자식 클래스들도 제네릭 클래스
    객체를 생성할 때 제네릭의 실제 타입을 지정해야함.
    객체를 생성할 때엔 일반적으로 기본 생성자 사용.(초기 저장 용량을 매개변수로 포함하고 있는 생성자 사용도 가능)
    
    **LinkedList<E>는 기본 생성자만 존재

-----------------

    저장 용량은 실제 데이터의 개수를 나타내는 저장 공간의 크기(size())와는 다른 개념.
    저장 용량 : 데이터를 저장하기 위해 미리 할당해 놓은 메모리의 크기

    ex)
    List<E>는 기본 생성자를 사용해 객체를 생성하면 기본으로 10만큼의 저장 용량을 내부에 확보해 놓음
    이후 데이터가 추가되어 저장 용량이 더 필요하면 자바 가상 머신이 저장 용량을 자동으로 늘림

    자식 클래스로 객체를 생성할 때는 각각의 클래스 타입으로 선언할 수 있음
    다형적 표현에 따라 부모 타입인 List<E> 타입으로 선언할 수도 있음

----------------

```java
import java.util.ArrayList;
import java.util.Vector;

List<제네릭 타입지정>참조 변수 = new ArrayList<제네릭타입 지정>();
List<제네릭 타입지정>참조 변수 = new Vector<제네릭타입 지정>();
List<제네릭 타입지정>참조 변수 = new LinkedList<제네릭타입 지정>();

ArrayList<제네릭 타입지정>참조 변수 = new ArrayList<제네릭타입 지정>();
Vector<제네릭 타입지정>참조 변수 = new Vector<제네릭타입 지정>();
LinkedList<제네릭 타입지정>참조 변수 = new LinkedList<제네릭타입 지정>();

List<Integer> aList1 = new ArrayList<Integer>(); //capacity = 10
List<Integer> aList2 = new ArrayList<Integer>(30); //capacity = 30
Vector<String> aList3 = new Vector<String>(); //capacity = 10
List<MyWork> aList4 = new LinkedList<MyWork>(20); //오류. LinkedList는 capacity 지정 불가
```

---------------------
Arrays.aslist() 메서드를 이용해 정적 컬렉션 객체 생성

    List<E> 객체를 생성하는 다른 방법은 Arrays 클래스의 asList(T..) 정적 메서드 사용하는 것
    내부적으로 배열을 먼저 생성하고, 이를 List<E>로 래핑. 포장만 해놓은 것
    따라서 내부 구조는 배열과 동일하므로 컬렉션 객체인데도 저장 공간으 크기를 변경할 수 없음

------------------

```java
List<제네릭 타입 지정> 참조 변수 = Arrays.asList(제네릭 타입 저장 데이터);

List<Integer> aList1 = Arrays.asList(1,2,3,4);
aList1.set(1,7); // [1 7 3 4]
aList1.add(5); // 오류(UnsupportedOperationException)
aList1.remove(0); // 오류(UnsupportedOperationException)
```

-----------------

    구현 클래스로 객체를 생성했을 때와 달리 데이터의 추가(add()), 삭제(remove())가 불가능
    하지만, 저장 공간의 크기를 변경하지 않는 데이터의 변경(set())은 가능.
    
    -> 고정된 개수의 데이터를 저장하거나 활용할 때 주로 사용.
    (대표적인 예 : 요일(월,화,수,목,금,토,일))

----------------------
```java
package chapter17.ex.pack17_2.pack2;

import java.util.*;

public class CreateListObject {
    public static void main(String[] args) {
        //1. List 구현 클래스의 생성자를 사용해 객체 생성
        List<Integer> aList1 = new ArrayList<>();   // capacity = 10
        List<Integer> aList2 = new ArrayList<>(30); // capacity = 30
        List<Integer> aList3 = new Vector<>(); // capacity = 10
        List<Integer> aList4 = new Vector<>(30); // capacity = 30
        List<Integer> aList5 = new LinkedList<>(); // capacity = 10
        //List<Integer> aList6 = new LinkedList<>(30); // 저장 용량 지정 불가

        //2. Arrays 클래스의 정적 메서드 활용
        List<Integer> aList7 = Arrays.asList(1, 2, 3, 4);
        List<String> aList8 = Arrays.asList("안녕", "방가");
        aList7.set(1, 7);
        aList8.set(0, "감사");
        //aList7.add(5); //불가능
        //aList8.remove(0); //불가능
        System.out.println(aList7);
        System.out.println(aList8);
    }
}
```
--------------------------

    *List<E>의 주요 메서드
    List<E>에는 데이터 추가, 변경, 삭제, 리스트 데이터 정보 추출, 리스트 배열 변환등의 추상 메서드가 정의되어 있음

-----------------

    *ArrayList<E> 구현 클래스
    ArrayList<E>는 대표적인 List<E> 구현 클래스
    List<E>가 지니고 있는 대표적 특징인 데이터를 인덱스로 관리하는 기능, 저장 공간을 동적으로 관리하는 기능을 그대로 지님

    List<E> 인터페이스를 구현한 구현 클래스
    배열처럼 수정(collect)한 원소(element)를 인덱스(index)로 관리하며 저장 용량(capacity)을 동적 관리

------------------
ArrayList<E> 구현 클래스 예시

```java
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

```

-----------------
Vector<E> 구현 클래스

    ArrayList<E>와의 차이점
    Vector<E>의 주요 메서드는 동기화 메서드로 구현되어 있으므로 멀티 쓰레드에 적합하도록 설계되어 있음

    *동기화 메서드   
    하나의 공유 객체를 2개의 쓰레드가 동시에 사용할 수 없도록 만든 메서드
    메서드를 동기화하지 않으면 작업을 동시에 수행해 작업이 충돌하는 상황이 발새할 수 있음

    정리하면
    Vector<E>는 ArrayList<E>와 동일한 기능을 수행하지만, 멀티 쓰레드에서 사용할 수 있도록 기능이 추가된 것
    싱글 쓰레드에서는 무겁고 많은 리소스를 차지하는 Vector<E> 대신 ArrayList<E>를 쓰는 게 효율적

--------------

    List<Integer> aList1 = new ArrayList<Integer>();
    이것을
    List<Integer> vector1 = new Vector<Integer>(); 로 쓰면돼

--------------
LinkedList<E> 구현 클래스

    ArrayList<E>처럼 메서드를 동기화하지 않았기 때문에 싱글 쓰레드에서 사용하기에 적합
    
    LinkedList<E> vs ArrayList<E>와 차이점

    1. LinkedList<E>는 저장 용량을 매개변수로 갖는 생성자가 없기 때문에 객체를 생서할 때 저장 용량을 지정할 수 없음

--------------

```java
import java.util.LinkedList;
import java.util.List;

List<E> aLinkedList1 = new LinkedList<Integer>();   // O
List<E> aLinkedList1 = new LinkedList<Integer>(20);   // X
```

--------------

    2. 내부적으로 데이터를 저장하는 방식이 다름.

    ArrayList<E>가 모든 데이터를 위치 정보(인덱스)의 값으로 저장한다면
    LinkedList<E>는 앞뒤 객체의 정보를 저장함 -> 모든 데이터가 서로 연결된 형태로 관리

-----------------

    List<Integer> aList1 = new ArrayList<Integer>();
    이것을
    List<Integer> vector1 = new Vector<Integer>(); 로 쓰면돼
    이것을
    List<Integer> linkedlist1 = new LinkedList<Integer>(); 로 쓰면돼

----------------

    ArrayList<E>와 LinkedList<E> 성능 비교

    ArrayList<E> 객체에 데이터를 중간에 추가하게 되면
    이후의 모든 데이터가 한 칸씩 데이터가 밀려남.
    밀려나는 모든 데이터의 위치 정보를 수정해야한다는 것을 의미

    LinkedList<E>는 앞뒤 객체 정보만을 저장하고 있음
    어딘가에 값이 추가되면
    값이 추가된 위치의 앞뒤 데이터 정보만 수정하면됨

------------

    LinkedList<E>는 ArrayLiset<E>와 비교해서 장점만 있나?
    
    아니다.
    LinkedList에서는 각 원소가 자신의 인덱스 정보를 따로 갖고 있지 않음
    특정 인덱스 위치의 값을 가져오기 위해서는 앞에서부터 차례대로 번호를 세어가면서 인덱스의 위치를 찾아야함

    반면에
    ArrayList는 데이터 자체가 인덱스 번호를 갖고 있으므로 특정 위치의 데이터를 빠르게 찾을 수 있음

----------------

    정리하면
    LinkedList<E> : 데이터 추가, 삭제 시 속도가 빠름
    ArrayList<E> : 데이터 검색 시 속도가 빠름

--------------------

```java
package chapter17.ex.pack17_2.pack4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListVsLinkedList {
    public static void main(String[] args) {
        //1. 데이터 추가 시간 비교
        List<Integer> aList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        long startTime = 0, endTime = 0;

        //1-1. ArrayList 데이터 추가 시간
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            aList.add(0, i);
        }
        endTime = System.nanoTime();
        System.out.println("ArrayList 데이터 추가 시간 = " + (endTime - startTime) + " ns");

        //1-2. LinkedList 데이터 추가 시간
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            linkedList.add(0, i);
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList 데이터 추가 시간 = " + (endTime - startTime) + " ns");

        //2-1 ArrayList 데이터 검색 시간
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            aList.get(i);
        }
        endTime = System.nanoTime();
        System.out.println("ArrayList 데이터 검색 시간 = " + (endTime - startTime) + " ns");

        //2-2 LinkedList 데이터 검색 시간
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            linkedList.get(i);
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList 데이터 검색 시간 = " + (endTime - startTime) + " ns");

        //3-1 ArrayList 데이터 제거 시간
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            aList.remove(0);
        }
        endTime = System.nanoTime();
        System.out.println("ArrayList 데이터 제거 시간 = " + (endTime - startTime) + " ns");

        //3-2 LinkedList 데이터 wprj 시간
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            linkedList.remove(0);
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList 데이터 제거 시간 = " + (endTime - startTime) + " ns");
    }
}
```


-------------------

    currentTimeMills(), nanoTime()

    System.currentTimeMills()
    - 1970년 1월 1일 00시 00분과 현재 시간으 차이를 ms(밀리초,1/1000초) 단위로 리턴(long)하는 메서드
    
    System.nanoTime()
    - 현재의 시간정보와는 관계 없으며, 상대적인 시간 차이를 나노초 단위로 구하는데 사용되는 메서드
    - 모듈의 앞뒤에 System.nanoTime()메서드를 호출해 시간 정보를 나노초 단위로 추출한 후 실행 시간의 차잇값을 이용해 측정

----------------------


    
    