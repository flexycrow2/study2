
# 16장 제네릭

### 16.1 제네릭 클래스와 제네릭 인터페이스
    
    클래스와 인터페이스를 내부 멤버에서 활용하는 클래스를 작성하고자 할 때
    - 제공되는 클래스, 인터페이스만큼 많은 가짓수의 클래스를 생성해야함.

    동일한 이름의 메서드가 다양한 타입의 입력매개변수를 가질 수 있도록 하려면
    -입력매개변수 타입의 수만큼 오버로딩을 수행해야함.

    *이럴 때 필요한 문법 요소가 '제네릭'

-----------------
0. 제네릭 없이 사과와 연필을 저장할 수 있는 클래스 생성


    pack1 예제
--------------------
    새로운 상품이 추가될 때마다 클래스를 새로 생성?
    1개의 상품 클래스로 모든 타입의 상품을 저장하고 관리할 수 없나?

1. 필드를 모든 자바 클래스의 최상위 클래스인 Object 타입으로 선언.

-----------------

    주의점:
    데이터를 저장할 때엔 상관 없지만 저장된 데이터를 각각의 타입으로 꺼낼 때
    저장된 형태로 캐스팅 해야함.

-----------------

```java
class Apple{}
class Pencil{}
class Goods {
    private Object object = new Object();

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
public class Solution1_usingObject {
    public static void main(String[] args) {
        Goods goods1 = new Goods();
        goods1.setObject(new Apple());
        Apple apple = (Apple) goods1.getObject();

        Goods goods2 = new Goods();
        goods2.setObject(new Pencil());
        Pencil pencil = (Pencil) goods2.getObject();

        //Goods goods3 = new Goods();
        //goods3.setObject(new Apple());
        //Pencil pencil2 = (Pencil) goods3.getObject();
    }
}
```

    필드 자체가 Object타입 -> get()메서드로 가져오는 것도 Object타입.
    Apple로 객체 생성, pencil 객체로 캐스팅하면 ClassCastException. 발생.

    *약한 타입 체크
    잘못된 타입 캐스팅에도 문법 오류를 발생시키지 않는 것을 말함.
    (잘못된 캐스팅은 실행 예외 발생, 프로그램은 강제 종료)

------

    >정리
    각 상품마다 클래스 생성 대신 최상위 클래스 Object타입의 필드를 선언하면
    모든 타입의 상품을 저장할 수 있는 클래스를 생성할 수 있음!
    get()메서드로 가져온 경우 각각의 타입으로 다운캐스팅을 수행해야함.
    (약한 타입 체크만 가능) -> 실행 예외 발생, 프로그램 강제종료 가능성이 있음

    -이런 문제를 해결할 수 있는 개념이 '제네릭'

----------------

### 16.2 제네릭의 문법

    >제네릭을 사용하면
    모든 타입의 상품을 저장할 수 있음
    잘못된 캐스팅을 할 때 문법 오류를 발생시켜 잘못된 캐스팅으로 발생할 수 있는 문제를 사전에 예방
    *강한 타입 체크
------------

```java
접근 지정자 class (interface) 클래스명<T> {
    
}
```
```java
접근 지정자 class (interface) 클래스명<K,V> {
    
}
```
---------------------
    이런 식으로 쓸 수 있고, 변수명과 의미는 아래와 같음

    T - 타입
    K - 키
    V - 값
    N - 숫자
    E - 원소
------------------------
실제 예시
```java
public class Myclass<T> {
    private T t;
    public T get() {
        retrun t;
    }
    public void set(T t){
        this.t = t;
    }
}
```
```java
public interface MyInterface<K, V> {
    public abstract void setKey(K k);
    public abstract void setValue(V v);
    public abstract K getKey();
    public abstract V getValue();
}
```
--------------------
제네릭 타입 변수 1개 가진 제네릭 클래스의 선언, 활용
```java
package chapter16.ex.pack16_2.pack1;

class MyClass<T> {
    private T t;

    public T get() {
        return t;
    }

    public void set(T t) {
        this.t = t;
    }
}
public class SinggleGenericArgument {
    public static void main(String[] args) {
        MyClass<String> mc1 = new MyClass<String>();
        mc1.set("안녕");
        System.out.println(mc1.get());

        MyClass<Integer> mc2 = new MyClass<>();
        mc2.set(100);
        System.out.println(mc2.get());

        //MyClass<Integer> mc3 = new MyClass<>();
        //mc3.set("하이");
    }
}
```
----------------
    *******
    입출력이 각각 객체를 생성할 때 정해진 타입으로 확정되기 때문에
    setter 메서드 사용할 때 입력 타입을 정확히 확인할 수 있음(강한 타입 체크)
    출력 또한 해당 타입으로 리턴되기 때문에 다운캐스팅이 필요하지 않음

------------------

--------------------
제네릭 타입 변수 2개 가진 제네릭 클래스의 선언, 활용
```java
package chapter16.ex.pack16_2.pack2;

class KeyValue<K,V> {
    private K key;
    private V value;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
public class TwoGenericArguments {
    public static void main(String[] args) {
        KeyValue<String, Integer> kv1 = new KeyValue<>();
        kv1.setKey("사과");
        kv1.setValue(1000);
        String key1 = kv1.getKey();
        int value1 = kv1.getValue();
        System.out.println("key: " + key1 + " value: " + value1);

        KeyValue<Integer, String> kv2 = new KeyValue<>();
        kv2.setKey(404);
        kv2.setValue("Not Found(요청한 페이지를 찾을 수 없습니다.)");
        int key2 = kv2.getKey();
        String value2 = kv2.getValue();
        System.out.println("key: " + key2 + " value: " + value2);

        KeyValue<String, Void> kv3 = new KeyValue<>(); //void는 해당 제네릭 타입 변수의 필드를 사용하지 않는다는 의미
        kv3.setKey("키 값만 사용");
        String key3 = kv3.getKey();
        System.out.println("key: " + key3);
    }
}
```
----------------

    사과, 연필 예제에서 하고 싶었던 것
    
    1. 추가 클래스 생성 없이 어떤 상품도 저장 및 관리할 수 있어야 함 - Object 타입으로 선언 가능.
    2. setter메서드에 잘못된 객체를 입력했을 때 바로 문법 체크 가능 
       getter 메서드의 리턴 타입도 다운캐스팅이 필요 없어야함. - 제네릭으로 가능.

----------------

```java
package chapter16.ex.pack16_2.pack3;

class Apple {}
class Pencil {}
class Goods<T> {
    private T t;

    public T get() {
        return t;
    }

    public void set(T t) {
        this.t = t;
    }
}

public class Solution2_Generic {
    public static void main(String[] args) {
        Goods<Apple> goods1 = new Goods<>();
        goods1.set(new Apple());
        Apple apple = goods1.get();

        Goods<Pencil> goods2 = new Goods<>();
        goods2.set(new Pencil());
        Pencil pencil = goods2.get();

        Goods<Apple> goods3 = new Goods<>();
        goods3.set(new Apple());
        //Pencil pencil2 = goods3.get();
    }
}
```
---------------
    실제 제네릭 타입을 생략하면 Object가 대입된 것으로 간주해 객체 생성
    A a = new A();
    A<Object> a = new A<Object>();

--------------------

### 16.3 제네릭 메서드

    제네릭 메서드
    - 일반 클래스 내부의 특정 메서드만 제네릭으로 선언 가능.
    - 리턴 타입 또는 입력매개변수의 타입을 제네릭 타입 변수로 선언

    *
    제네릭 클래스 - 객체 생성 시점에 타입을 지정
    제네릭 메서드 - 호출되는 시점에 실제 제네릭 타입을 지정

-------------------
```java
# 제네릭 타입 변수 명이 1개일때
    
접근 지정자 <T> T 메서드명 (T t){
    
}
```
```java
# 제네릭 타입 변수 명이 2개일때

접근 지정자 <T, V> T 메서드명 (T t, V v){

}
```
```java
# 매개변수에만 제네릭이 사용됐을 때

접근 지정자 <T> void 메서드명 (T t){

}
```
```java        
# 리턴 타입에만 제네릭이 사용됐을 때

접근 지정자 <T> T 메서드명 (int a){

}
```
-------------------
598페이지...?

    >제네릭 메서드 호출
    참조 객체.<실제 제네릭 타입>메서드명(입력매개변수);

---------------------

    public <T> method(T t) {
        return t;
    }

    ex)Integer 대입 메서드 호출할 때
    - 참조객체.<Integer>method1(100) : 이렇게 사용해야함.
    - 참조객체.method1(100) : 입력매개변수를 보고 제네릭 타입 변수의 실제 타입을 예측할 수 있기 때문에 제네릭 타입 변수 생략 가능

---------------------
제네릭 타입 생략가능한걸 확인
```java
package chapter16.ex.pack16_3.pack1;

class GenericMethods{
    public <T> T method1(T t){
        return t;
    }
    public <T> boolean method2(T t1, T t2){
        return t1.equals(t2);
    }
    public <K,V> void method3(K k, V v){
        System.out.println(k + ":" + v);
    }
}

public class GenericMethod {
    public static void main(String[] args) {

        GenericMethods gm = new GenericMethods();

        String str1 = gm.<String>method1("안녕");
        String str2 = gm.method1("안녕"); //입력매개변수로 타입 유추 가능해서 제네릭 타입 지정 생략가능.
        System.out.println(str1);
        System.out.println(str2);

        boolean bool1 = gm.<Double>method2(2.5, 2.5);
        boolean bool2 = gm.method2(2.5, 2.5);
        System.out.println(bool1);
        System.out.println(bool2);

        gm.<String, Integer>method3("국어", 80);
        gm.method3("국어", 80);
    }

}
```
-------------------------

    제네릭 메서드의 제네릭 타입 변수는 메서드가 호출되는 시점에 결정
    제네릭 메서드를 정의하는 시점에서는 아직 어떤 타입이 입력될 지 알 수 없음
    특정 타입에 포함되어 있는 메서드는 사용할 수 없음.

    - 어떤 타입이 제네릭 타입 변수로 확정되더라도 항상 사용할 수 있는 메서드만 제네릭 메서드 내부 에서 사용 가능
    - 어떤 상황이든 제네릭 타입의 입력매개변수 객체 내부에서는 Object에게 상속받은 메서드만 활용할 수 있음

-------------------------

### 16.4 제네릭 타입 범위 제한

    제네릭클래스, 제네릭메서드는 각각 객체를 생성할 때, 메서드를 호출할 때 제네릭 타입을 지정
    그때그때 다양한 타입을 처리할 수 있는 장점이 있음.

    ex)
    사과, 배, 딸기 - 과일 클래스 상속
    연필, 지우개, 볼펜 - 문구 클래스 상속

    과일 종류만 저장 관리,문구류만 저장 관리 클래스 생성하고 싶을 때
    제네릭은 모든 타입이 올 수 있어서 기능 구현이 불가

------------------------

    이런 기능을 구현하려면 제네릭 타입으로 올 수 있는 실제 타입의 종류를 제한해야 함.
    -> 제네릭 타입의 범위 제한
-----------------------------------
1. 제네릭 클래스의 타입 제한


    <제네릭 타입 변수 extends 상위 클래스>처럼 제네릭 타입으로 대입 될 수 있는 최상위 클래스를 extends로 함께 정의
    - 클래스/인터페이스 모두 항상 extends -> 최상위 클래스/인터페이스로 지정한다는 뜻
    
```java
package chapter16.ex.pack16_4.pack1;

class A{}
class B extends A{}
class C extends B{}

class D <T extends B> { //B,C만 올 수 있음
    private T t;
    
    public T get() {
        return t;
    }
    
    public void set(T t) {
        this.t = t;
    }
}

public class BoundedTypeOfGenericClass {
    public static void main(String[] args) {
        //D<A> d1 = new D<>();
        D<B> d2 = new D<>();
        D<C> d3 = new D<>();
        D d4 = new D(); // D<B> d4 = new D<>();

        d2.set(new B());
        d2.set(new C());

        //d3.set(new B()); // d3는 객체 생성할 때 제네릭 타입으로 C 지정.
        d3.set(new C());

        d4.set(new B());
        d4.set(new C());
    }
}
```
-----------------------------------
2. 제네릭 메서드의 타입 제한

    
    <제네릭 타입 변수 extends 상위 클래스>와 같이 최상위 타입 정의.
    제네릭 클래스일 때와 동일한 타입 제한 방식 적용

    *제네릭 메서드에서 중요한 것은 메서드 내부에서 사용할 수 있는 메서드의 종류
    타입을 제한하지 않을 때엔 Object메서드만 사용 가능.
    <T extends String>처럼 표현하면 모든 타입의 최상위 타입이 String이기 때문에
    해당 제네릭의 메서드 내부에서 String 객체의 멤버를 사용할 수 있음

--------------------------

    String은 자식 클래스를 생성할 수 없는 final 클래스
    실제 제네릭 타입으로 올 수 있는 것은 String 밖에 없음

---------------------
```java
package chapter16.ex.pack16_4.pack2;

class A {
    public <T extends Number> void method1(T t){
        System.out.println(t.intValue());
    }
}

interface MyInterface{
    public abstract void print();
}

class B {
    public <T extends MyInterface> void method1(T t){
        t.print();
    }
}

public class BoundedTypeOfGenericMethod {
    public static void main(String[] args) {
        A a = new A();
        a.method1(5.8);

        B b = new B();
        b.method1(new MyInterface() {
            @Override
            public void print() {
                System.out.println("print() 구현");
            }
        });
    }
}

```
  

-----------------------  

3.메서드 매개변수일 때 제네릭 클래스의 타입 제한

    method(Goods<A> v)              //제네릭 타입 = A인 객체만 가능
    method(Goods<?> v)              //제네릭 타입 = 모든 타입인 객체 가능
    method(Goods<? extends B> v)    //제네릭 타입 = B, B의 자식 클래스인 객체만 가능
    method(Goods<? super B> v)      //제네릭 타입 = B, B의 부모 클래스인 객체만 가능

-------------------

    A ← B ← C ← D 상속구조. 
    
    Goods<A> 제네릭 타입으로 A만을 지정
    Goods<?> A,B,C,D 타입 모두 ?자리에 올 수 있음
    Goods<? extends B> B, B의 자식 클래스만 가능. 제네릭 타입으로 B,C,D 가능
    Goods<? super B> B, B의 부모 클래스들 가능. 제네릭 타입으로 A, B 지정 가능

---------------------
```java
package chapter16.ex.pack16_4.pack3;

class A {}
class B extends A {}
class C extends B {}
class D extends C {}

class Goods<T> {
    private T t;
    public T get() {
        return t;
    }
    public void set(T t){
        this.t = t;
    }
}

class Test {
    void method1(Goods<A> g) {}
    void method2(Goods<?> g) {}
    void method3(Goods<? extends B> g) {}
    void method4(Goods<? super B> g) {}
}

public class BoundedTypeOfInputArguments {
    public static void main(String[] args) {
        Test t = new Test();
        
        t.method1(new Goods<A>());
        //t.method1(new Goods<B>());
        //t.method1(new Goods<C>());
        //t.method1(new Goods<D>());

        t.method2(new Goods<A>());
        t.method2(new Goods<B>());
        t.method2(new Goods<C>());
        t.method2(new Goods<D>());

        //t.method3(new Goods<A>());
        t.method3(new Goods<B>());
        t.method3(new Goods<C>());
        t.method3(new Goods<D>());

        t.method4(new Goods<A>());
        t.method4(new Goods<B>());
        //t.method4(new Goods<C>());
        //t.method4(new Goods<D>());
    }
}
```
--------------------------------
### 16.5 제네릭의 상속

    부모 클래스가 제네릭 클래스면, 자식 클래스도 제네릭 클래스.
    제네릭 타입 변수를 자식 클래스가 그대로 물려받음

-------------------

    Parent<T>는 하나의 제네릭 타입 변수
    상속 받아 Child1<T>, Child2<T,V> 생성

-------------------
제네릭 클래스의 상속
```java
package chapter16.ex.pack16_5.pack1;

class Parent<T> {
    T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}

class Child1<T> extends Parent<T> {

}

class Child2<T, V> extends  Parent<T>{
    V v;

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }
}
public class InheritanceGenericClass {
    public static void main(String[] args) {
        Parent<String> p = new Parent<>();
        p.setT("부모 제네릭 클래스");
        System.out.println(p.getT());

        Child1<String> c1 = new Child1<>();
        c1.setT("자식 1 제네릭 클래스");
        System.out.println(c1.getT());

        Child2<String, Integer> c2 = new Child2<>();
        c2.setT("자식 2 제네릭 클래스");
        c2.setV(100);
        System.out.println(c2.getT());
        System.out.println(c2.getV());
    }
}

```
--------------------------
제네릭 메서드의 상속

    부모클래스 내의 제네릭 메서드는 그대로 자식 클래스로 상속

    ***래퍼클래스
    기본 자료형을 클래스로 변환해 놓은 것
------------------

```java
package chapter16.ex.pack16_5.pack2;

class Parent {
    <T extends Number> void print(T t) {
        System.out.println(t);
    }
}

class Child extends Parent {

}

public class InheritanceGenericMethod {
    public static void main(String[] args) {

        Parent p = new Parent();
        p.<Integer>print(10);
        p.print(10);

        Child c = new Child();
        c.<Double>print(5.8);
        c.print(5.8);
    }
}

```