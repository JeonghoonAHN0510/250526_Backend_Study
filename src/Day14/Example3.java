package Day14;

public class Example3 {
    public static void main(String[] args) {
        /*
        [ 다형성 ] : 다양한 타입을 갖는 성질
        [ 인터페이스 ]
        1. 정의 : 서로 다른 시스템이나 장치 사이에서 정보를 주고받는 접점/경계면(?)
        2. 생활 속 예시
            키보드     : 서로 다른 프로그램들을 하나의 키보드로 조작
            TV 리모콘  : LG, 삼성 등 서로 다른 회사의 TV를 하나의 리모콘으로 조작
            키오스크   : 병원, 휴게소, 카페 등 서로 다른 업체를 하나의 키오스크로 조작
        3. 목적 : 서로 다른 장치 사이에서 동일한 목적으로 기능을 서로 다르게 작동
        4. 특징
            1) 객체 호환성을 높이고 다형성 구현
            2) 서로 다른 클래스 사이에 중간 매개 역할
        5. 사용법
            - interface 인터페이스명{ }
        6. 인터페이스의 멤버
            1) 상수
            2) 추상 메소드
        7.    상속     vs       구현(인터페이스)
            extends             implements
           객체생성가능          객체생성불가능(생성자가 없어서)
         하나의 상위클래스        여러개의 인터페이스
          오버라이딩(선택)        오버라이딩(필수)

        */
        // [1] 인터페이스로 객체 만들기 -> 불가능(인터페이스엔 생성자가 없음)
        // TestInterface ti = new TestInterface();

        // [3] 상수 불러오기 -> 타입.상수명
        System.out.println( TestInterface.value2 );

        // [5] 추상메소드 불러오기
        // 추상메소드는 구현이 없으면 사용 불가능
        // TestInterface.method2();


        // [6] 클래스가 인터페이스의 추상메소드 구현
        new Tool();
        Tool tool1 = new Tool();
        tool1.method2();            // 가능

        TestInterface tool2 = new Tool();
        tool2.method2();;           // 가능



    } // main end
} // class end

// class 클래스명 implements 인터페이스명{}
// 지정한 인터페이스의 추상메소드를 구현하기 전까지 오류 발생
class Tool implements TestInterface{
    // 1. 추상메소드 구현하기
    // 추상메소드와 선언부를 동일하게 구성하고 실행문은 자유롭게 구현
    public void method2(){
        System.out.println("추상메소드1 구현 완료");
    } // func end

    // 2. 추상메소드 구현하기
    public boolean method3( int a ) {
        System.out.println("추상메소드2 구현 완료");
        return a > 10;
    } // func end
} // class end
