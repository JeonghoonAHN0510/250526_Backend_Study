package Day07;

public class Example1 { // Example1 class start
    public static void main(String[] args) { // main start
        /*
        [ 메소드(멤버함수) ]
        1. 정의 : 하나의 기능을 수행하는 일련의 코드
        2. 생성(선언) 방법
            반환타입 메소드명( 타입 매개변수1, 타입 매개변수2 ){
                실행코드;
                return 반환값; (생략가능)
            }
        3. 용어
            1) 메소드명 : 임의로 작성하되 카멜표기법 권장
            2) 매개변수 : 메소드 실행 시, 메소드 안으로 들어오는 값을 저장하는 변수
                (1) 매개변수가 없을 수도 있다. -> 없으면 반환타입으로 void 사용
                (2) 매개변수의 타입과 인수값의 타입이 일치해야한다.
            3) 반환타입 : 메소드 실행 후, 결과를 반환하는 값의 타입
            4) 반환값 : 메소드 실행 후, 결과를 반환하는 값
                (1) 반환타입과 반환값의 타입이 일치해야한다.
                (2) 반환값은 항상 자료 1개만 존재
                (3) 반환값이 없을 떄는 반환타입으로 void 사용
            5) 인수값 : 메소드 실행 시, 메소드에게 전달하는 값   인수값 ---대입---> 매개변수
        4. 호출 방법
            1) 호출하려는 메소드가 다른 클래스일 때
               (1) 메소드를 갖고있는 클래스 객체 생성   클래스명 객체명 = new 클래스명();
               (2) 객체를 이용한 메소드 호출           객체명.메소드명();
        5. 멤버변수와의 비교
            1) 멤버변수 : 객체마다 할당
            2) 메소드 : 객체들이 공유해서 사용
        */

        // [1] 클래스에서 메소드 선언
        // [2] 다른 클래스 내 메소드 호출하기
        // 1. 호출하고자 하는 메소드를 갖고있는 클래스 객체 생성
        Calculator cal1 = new Calculator();
        // 2. 객체를 이용한 메소드 호출
        cal1.getPi();       // 객체명.메소드명();
        // 3. 반환값이 있으면 변수에 저장
        double result = cal1.getPi();      // 반환값이 double 이므로 저장되는 변수 타입도 double
        System.out.println( result );
        // 4. 매개변수 x, 반환값 x
        cal1.powerOn();
            // 여러 객체들간의 멤버변수 주의점
            // -> 객체마다 멤버변수는 각각 생성된다.
        Calculator cal2 = new Calculator();
        System.out.println( cal1.isPowerOn );       // cal1의 powerOn();을 했기 때문에 true
        System.out.println( cal2.isPowerOn );       // 아무 것도 안했기 때문에          false
        // 5. 매개변수 o, 반환값 x
        cal1.printSum( 3, 5 );  // x = 3, y = 5 저장 -> "8" 출력
     // cal1.printSum( 3.14, 5.1 ); -> 인수값과 매개변수 타입이 불일치하면 오류 발생
        cal2.printSum( 1, 2 );  // x = 1, y = 2 저장 -> "계산기의 전원이 꺼져있습니다." 출력
        // 6. 매개변수 o, 반환값 o     -> 반환값이 있으면, 주로 변수에 저장
        int result2 = cal1.add( 10, 3 );        // 반환값이 int이므로 저장되는 변수 타입도 int
        System.out.println( result2 );

    } // main end
} // Example1 class end
