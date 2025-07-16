package Day13;

// 자바의 모든 클래스는 자동으로 extends Object되므로, 자바는 100% 객체지향이다.
class A {
    A(){ System.out.println("A 객체 생성"); }   // A 클래스 생성자
} // class end
// A의 부모 : Object, 자식 : B / C, 자손 : D / E

class B extends A { // B는 A로부터 상속을 받는다.
    B(){ System.out.println("B 객체 생성"); }   // B 클래스 생성자
} // class end
// B의 부모 : A, 자식 : D

class C extends A { // C는 A로부터 상속을 받는다.
    C(){ System.out.println("C 객체 생성"); }   // C 클래스 생성자
} // class end
// C의 부모 : A, 자식 : E

class D extends B { // D는 B로부터 상속을 받는다.
    D(){ System.out.println("D 객체 생성"); }   // D 클래스 생성자
} // class end
// D의 부모 : B

class E extends C { // E는 C로부터 상속을 받는다.
    E(){ System.out.println("E 객체 생성"); }   // E 클래스 생성자
} // class end
// E의 부모 : C

public class Example2 {
    public static void main(String[] args) {
        System.out.println("==========");
        // (1) A 객체 생성 시, 총 객체 수 : 2개(Object, A)
        A a = new A();      // Object -> A
        System.out.println("==========");

        // (2) B 객체 생성 시, 총 객체 수 : 3개(Object, A, B)
        B b = new B();      // Object -> A -> B
        System.out.println("==========");

        // (3) C 객체 생성 시, 총 객체 수 : 3개(Object, A, C)
        C c = new C();      // Object -> A -> C
        System.out.println("==========");

        // (4) D 객체 생성 시, 총 객체 수 : 4개(Object, A, B, D)
        D d = new D();      // Object -> A -> B -> D
        System.out.println("==========");

        // (5) E 객체 생성 시, 총 객체 수 : 4개(Object, A, C, E)
        E e = new E();      // Object -> A -> C -> E
        System.out.println("==========");

        // (6) 자동 타입변환
        A a1 = b;           // b(객체)는 A 타입으로 변환 가능
        Object obj1 = b;    // b(객체)는 Object 타입으로 변환 가능
     // B b2 = c;           // c(객체)는 B 타입을 모른다. -> 형제클래스 간 변환 불가능

        // (7) 강제 타입변환
        B b2 = (B) a1;      // a1(객체)는 B 타입으로 강제 변환 가능 -> a1의 태생이 B 타입이기때문에
        A a2 = e;           // 자동 타입변환
        C c1 = (C) a2;      // a2(객체)는 C 타입으로 강제 변환 가능 -> a2의 태생이 E 타입이기때문에
     // B b1 = (B) a2;      // a2(객체)는 B 타입으로 강제 변환 불가능 -> a2의 태생이 E 타입이기때문에 B 타입을 모름 -> 문법오류가 아닌 실행오류 발생

        // (8) 인스턴스(객체) 타입 확인 방법
        // -> 객체 instanceof 클래스명 : 객체가 지정한 클래스 타입인지 확인
        System.out.println( a instanceof Object );      // a라는 객체는 Object 타입이야? -> true!
        System.out.println( b instanceof A );           // b라는 객체는 A 타입이야? -> true!
     // System.out.println( e instanceof B );           // e라는 객체는 B 타입이야? -> 아예 실행 불가능
        System.out.println( a2 instanceof C );          // a2라는 객체는 C 타입이야? -> true! -> 태생이 E 타입이라 A C E 가능
        System.out.println( a2 instanceof B );          // a2라는 객체는 B 타입이야? -> false!

        // (9) 상속 활용처
        // 1. 웹/앱 라이브러리
        // 2. 클래스를 정의하다가 다른 클래스와 '멤버변수'가 중복되면 '상속화'
        // vs 코드를 작성하다가 '명령어(코드)'가 중복되면 '메소드화'



    } // main end
} // class end
