
    hashCode(), equals() -> Object클래스의 메서드 -> 모든 클래스 내에 포함.
    Object는 모든 클래스의 최상위 클래스이므로 모든 클래스에 포함.

```java
class H {}
public class Test {
    public static void main(String[] args) {
        H h = new H();
        System.out.println(h);
    }
}
```
    오브젝트를 상속한 Test 클래스
    특별히 오버라이딩 하지 않으면, Object의 메서드를 그대로 가짐.

    실행결과 : chapter17.ex.pack17_3_0.H@b4c966a
    객체를 넣어서 출력하면, 패키지명.클래스명@해쉬코드

-------

    해쉬코드는 객체(위치)를 기반으로 생성된 고유값 (실제 번지와는 다름)
    위치를 기반으로 해쉬코드가 만들어졌으니, 위치가 바뀌면 해쉬코드도 달라진다.


---------------

    equals()
    Object의 equals()는 == 등가연산이랑 동일한 연산임. (-> 저장번지 비교)
    실제로 보면 equals()는 == 를 호출한 게 전부.

```java
//오버라이딩하지 않으면 equals()와 == 는 항상 같은 결과
A a1 = new A(3);
A a2 = new A(3);
System.out.println(a1 == a2); //false
System.out.println(a1.equals(a2)); //false
```

    등가연산자는 스택을 비교하는 것
    스택은 값이 아닌 번지를 저장. (위치를 저장)

-------------

```java
Integer aa1 = new Integer(3);
Integer aa2 = new Integer(3);
System.out.println(aa1 == aa2);
System.out.println(aa1.equals(aa2));

String s1 = new String("저그");
String s2 = new String("저그");
System.out.println(s1 == s2);
System.out.println(s1.equals(s2));
```

---------

    실행결과 : false, true, false, true.
    이건 오버라이딩을 한 거임.

-----------------

    1단계: hashcode()값이 같은 지 확인
    2단계: equals()결과가 true 인지 확인