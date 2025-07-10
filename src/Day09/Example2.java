package Day09;

class D{
 // final int 최종변수;         -> 초기값이 없어 오류 발생 o
    final int 최종변수 = 10; // -> 초기값이 있어 오류 발생 x
    // static 변수 만들기
    static int 비멤버변수;   // new로 객체 생성 안 해도 사용가능
    // 상수 만들기
    public static final int 상수 = 10;    // 객체없이 사용하는 수정 불가능한 int 타입의 변수
    // [5] static 메소드가 아닌 메소드에서 static 유/무 메소드 호출 차이
    void 멤버메소드1(){}
    static void 비멤버메소드(){}
    void 멤버메소드2(){
        멤버메소드1();   // 가능
        비멤버메소드();  // 가능
    }
}

public class Example2 { // class start

    // static이 아닌 메소드
    void 멤버메소드(){}
    // static 메소드
    static void 비멤버메소드(){}

    public static void main(String[] args) { // main start
 // 어디서나 사용 가능한/객체 없이 사용 가능한/리턴값 없는/main이라는 함수
        /*
        [ final ]
        - 고정(수정 불가능한) 상태를 정의할 때 사용되는 키워드
        - 호출 가능 / 수정 불가능
        1. 사용법 : final 타입 멤버변수;
        2. 주의할점 : 초기값이 무조건 존재해야 한다.

        [ static ]
        - 프로그램 컴파일(실행)될 때 메모리에 할당되고, 프로그램이 종료될 때 메모리가 삭제되는 키워드
        - 객체 생성을 안 해도 사용이 가능함(= new로 생성 안 해도 됨)
        -> static을 사용하면, 클래스명.메소드명();으로 사용가능하다 -> 객체를 생성 안 해도 된다는 뜻
        - 실행 중에 변화가 없는 상태를 정의할 때 사용되는 키워드
        1. 사용법 : static 타입 멤버변수;    -> static변수라고 부름
        2. 주의할점 : 멤버변수(객체 내 변수) vs static변수(우선할당..? -> 객체 생성 안 해도 사용가능)
            -> 프로그램 내 *1개만* 존재( 객체마다 존재하는 것이 아님 )

        [ 상수 ]
        - 변하지 않는 변수
        1. 사용법 : public static final 타입 상수명;
        2. 주의할점
            1) 수정 불가능
            2) 프로그램 내 *1개만* 존재
            3) 상수명으론 대문자 사용

        [ static 유/무가 중요한 이유 ]
        - static으로 선언된 메소드는 같은 클래스 내의 일반 메소드를 호출할 수 없다.
        class Test {
            static void main3(){ }
            void main2(){ }
            static void main1(){
                main2();    -> 불가능 -> main1이 우선할당되면서 main2가 누군지 모른다.
                            -> 해결방법1) 객체를 생성하여 객체를 통해 static이 아닌 메소드를 호출한다.
                            -> new Test().main2(); -> 가능!!
                main3();    -> 가능   -> main1이 우선할당되면서 main3도 우선할당돼서 누군지 안다.
            }
        }
        */

        // [1] final 멤버변수 호출
        D d = new D();
        System.out.println( d.최종변수 );   // 호출 가능
     // d.최종변수 = 20;                       수정 불가능

        // [2] static 변수 호출 -> 클래스명.static변수명;
        System.out.println( D.비멤버변수 );  // 객체 없이 호출 가능
        D.비멤버변수 = 10;                   // 객체 없이 수정 가능
        System.out.println( d.비멤버변수 );  // 객체 생성하고 객체로 static변수 사용 가능

        // [3] 상수 호출    -> 클래스명.상수명;
        System.out.println( D.상수 );

        // [4] static 메소드 내에서 static 유/무 메소드 호출 차이
     // 멤버메소드();    -> static 메소드가 아니라서 누군지 모름
        비멤버메소드();//-> static 메소드라 객체없이 가능
        Example2 exam = new Example2(); // 객체 생성
        exam.멤버메소드();               // 가능 -> 객체를 생성했기 때문에 객체를 이용해서 가능

        // [5] static 메소드가 아닌 메소드에서 static 유/무 메소드 호출 차이


    } // main end
} // class end
