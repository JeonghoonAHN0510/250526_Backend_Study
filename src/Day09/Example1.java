package Day09;

import Day09.Package1.A;
import Day09.Package2.C;

public class Example1 {
    public static void main(String[] args) {
        /*
        [ 접근 제한자 ]
        1. 정의 : 클래스, 멤버변수, 생성자, 메소드 등에 접근(호출,사용)하는 것을 제한한다.
        2. 종류
            1) public       : 프로젝트 폴더 내 어디서든 접근 가능
            2) private      : 현재 클래스에서만 접근 가능
            3) (default)    : 같은/하위 패키지에서만 접근 가능, 일반적으로 키워드 선언 x
            4) protected    : 같은/하위 패키지에서만 접근 가능, 상속관계에서는 예외
        3. 사용법
            1) 멤버변수 타입 앞에서 선언
            -> 접근제한자 타입 변수명;
            2) 생성자명 앞에서 선언
            -> 접근제한자 생성자명(){ }
            3) 클래스명 앞에서 선언
            -> 접근제한자 class 클래스명{ }
            -> 클래스에서는 private 불가능
            4) 메소드 반환타입 앞에서 선언
            -> 접근제한자 반환타입 메소드명( ){ }
        4. 사용 이유 - 캡슐화 특징을 가짐 -> 알약처럼 내부 감추기 기능
            -> 실무에서는 보안이 필요한 접근에서 필수로 사용된다.(비정상적인 접근 차단)
        [ 패키지 ]
        1. 정의 : 파일들을 저장하는 공간, 식별자 역할
            -> 폴더와 같은 개념
        2. 주의할 점 : 같은 패키지 내에서 같은 클래스명은 존재할 수 없다
            -> 다른 패키지라면 같은 클래스명이 존재할 수 있다.
        3. 사용법
            import : 같은 패키지가 아닌 다른 패키지의 클래스를 가져오는 키워드
                import 경로.클래스명;
                -> 자동완성하면 자동 import 생성
                -> 같은 패키지 내 클래스는 import 필요 없음
                -> java.lang 패키지는 생략 가능(System, String ... )
        [ getter and setter ]
        1. 정의 : 클래스 내 private 멤버변수를 다른 클래스가 사용할 수 있도록하는 정의 함수
        2. 저장/대입 목적 : setter
            public void set멤버변수명( 타입 매개변수 ){
                this.멤버변수명 = 매개변수;
            }
        3. 호출/반환 목적 : getter
            public 반환타입 get멤버변수명( ){
                return 멤버변수명;
            }
        */
        // [1] 하위 Package1 폴더 내 A클래스 접근
        A a = new A();
        System.out.println( a.공개변수 );   // 가능
     // System.out.println( a.비공개변수 );  // 오류발생 -> private는 현재 클래스에서만 접근 가능
     // System.out.println( a.일반변수 );   // 오류발생 -> default는 같은/하위 클래스에서만 접근 가능

        // [2] 하위 Package2 폴더 내 C클래스 접근
        C c = new C();
     // System.out.println( c.비공개변수 );  // 오류발생
        System.out.println( c.반환메소드() );// 가능 -> private 변수도 우회해서 사용하면 가능
     // c.저장메소드( 3 );                   // 오류발생 -> 메소드가 private라서
    } // main end
} // class end
