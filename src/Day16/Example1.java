package Day16;

public class Example1 {
    public static void main(String[] args) {
        /*
        [ 예외처리 ]
        1. 시스템 오류 : 시스템이 종료되는 심각한 수준의 문제
        2. 예외 : 개발자가 구현한 로직이나 사용자의 영향으로 인한 문제
        3. 예외 종류
            1) 일반예외 : 컴파일(실행)될 때, '예외 처리 코드' 여부 검사를 하는 예외
                - 사용처 : 입출력, 네트워크, 파일, JBDC(자바-DB연동), 자바 외부통신
                - Class.forName( ), Thread.sleep( )
            2) 실행예외 : 컴파일(실행)될 때, '예외 처리 코드' 여부 검사를 하지 않는 예외
                - 프로그램 실행 도중에 발생하는 예외 -> 개발자의 경험에 의존
        4. 예외란?
            - 예외/오류 발생 시, 코드를 고치는 것이 아니라 흐름 제어하는 것( if와 비슷 )
            - 프로그램을 24시간 중단없이 실행하기위한 안전한 로직 구현
        5. 예외클래스
            1) ClassNotFoundException   : 클래스를 못찾았을 때, 발생되는 정보를 저장하는 예외클래스
            2) InterruptedException     : 흐름이 중단되었을 때, 발생되는 정보를 저장하는 예외클래스
        6. 사용법
            try{ 예외가 발생할 수도 있는 코드/일반예외 }
            catch( 예외클래스명 매개변수명 ){ 지정한 예외발생 시, 처리할 코드 }


        */
        // 강제로 예외를 발생시켜서 예제 확인
        // [1] 일반예외 : 예외가 있던/없던 무조건 예외처리를 해야한다.
        try{                                        // 1. 일반예외 발생 코드를 try{}로 감싼다.
            Class.forName("java.lang.String");      // Class.forName( 클래스경로 ); -> 해당 경로의 클래스를 읽어오는 함수
        }catch ( ClassNotFoundException e ){        // 2. catch( 예외클래스명 매개변수명 ){ }에서 예외 발생시 처리할 코드
            System.out.println("[예외발생] String 클래스가 없습니다.");
        } // try end

        // [2] 일반예외 + 예외발생
        try{
            Class.forName("java.lang.String2");     // String2 클래스는 존재하지 않기 때문에
        }catch ( ClassNotFoundException e ){        // 예외가 발생하여 코드 실행
            System.out.println("[예외발생] String2 클래스가 없습니다. " + e );
        } // try end

        // [3] 일반예외
        try{
            Thread.sleep( 1000 );                   // 코드 실행을 1초간 일시정지 함수
        }catch ( InterruptedException e ){
            System.out.println("[예외발생] sleep 도중에 오류 발생");
        } // try end

        // [4] 실행예외
        // NullPointerException : 객체가 없는데 객체에 접근연산자를 사용하면 발생하는 예외
        try{
            String str1 = "강호동";
            System.out.println( str1.length() );        // 문자열.length() : 문자열 길이 반환 함수
            String str2 = null;                         // 자바에서 null이란? 변수가 참조하는 값/객체가 없다.
            System.out.println( str2.length() );
        }catch ( NullPointerException e ){
            System.out.println("[예외발생] 객체가 없어서 .length() 사용 불가능");
        } // try end


        // [5]



    } // main end
} // class end


/* 복습
[ 상속 ]
1. (상위)클래스로부터 (하위)클래스에게 (멤버변수/메소드)를 물려주는 행위
2. 특징
    1) 하위클래스가 객체(인스턴스)를 생성하면, 상위클래스의 객체도 생성된다.
    2) 다형성
        (1) 하위클래스 타입에서 상위클래스 타입으로 변환 가능(자동 타입변환)
        (2) 상위클래스 타입에서 하위클래스 타입으로 변환 가능(강제 타입변환)
3. 사용법  extends
    class 하위클래스 extends 상위클래스{ }

[ 인터페이스 ]
1. 인터페이스로부터 구현체가 추상메소드를 물려받아 구현하는 행위
2. 특징
    1) 상수와 추상메소드를 갖는다. -> 생성자가 없어서 자체적으로 객체를 생성할 수 없다.
    2) 다형성
        (1) 인터페이스를 구현한 클래스 타입에서 인터페이스 타입으로 변환 가능(자동 타입변환)
3. 사용법  implements
    interface 인터페이스명{ }
    class 구현클래스 implements 인터페이스명1, 인터페이스명2 { }

[ 다형성 ]
1. 다양한 형태/타입을 갖는 성질
   -> 값/객체를 변경하는 것이 아님
2. 상속 / 인터페이스로 표현 가능
3. 오버라이딩 : 상속 / 인터페이스에서 물려받은 메소드를 구현(인터페이스)/재구현(상속)하는 행위
   -> 타입 간 중복된 메소드가 존재할 경우, 오버라이딩된 메소드가 최우선으로 실행된다.
4. 다형성 확인 : A instanceof B -> true/false

[ 인스턴스(객체) ]
1. 인스턴스는 클래스(설계도)를 기반으로 메모리를 생성한다.
2. 인스턴스의 멤버변수를 메모리에 각각 생성한다.
3. 클래스의 메소드는 모든 인스턴스가 공유한다.
------------------------------------------------------------------------------
스택(메모리) : 메소드는 객체들이 공유하여 사용한다.
class Member{
    int age;
    void event(){ }
}

힙(메모리) : 객체를 생성하면, 멤버변수는 힙에 각각 생성된다.
new Member; -> int age = 10;
new Member; -> int age = 30;
*/