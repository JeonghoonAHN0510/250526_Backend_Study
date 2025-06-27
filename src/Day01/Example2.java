package Day01;  // 현재 .java가 위치한 폴더명

import java.util.Scanner;

public class Example2 { // class start : 모든 자바코드는 클래스 안에 존재
    // (1) main 함수 선언
    public static void main(String[] args) { // main start
        // (2) 리터럴 : 프로그래밍 언어들이 미리 정의한 데이터
            // JS는 ''와 ""의 구분이 없지만, Java는 구분이 있다
            // 리터럴의 모든 정수는 int, 모든 실수는 double
        // (3) 출력함수 : System.out.print( );  세미콜론 필수!!
            // JS : console.log( );            세미콜론 선택!!
        // (4) 함수실행 : ctrl + shift + F10
        System.out.println( 3 );        // 리터럴 3 출력
        System.out.println( 3.14 );     // 리터럴 3.14 출력
        System.out.println( '김' );     // 리터럴 '김' 출력
        System.out.println( "유재석" );  // 리터럴 "유재석" 출력
        System.out.println( true );     // 리터럴 true 출력
        // (5) 자료형 타입           * 기본 자료형 vs 참조 자료형
            // 정수 : byte , short , int(*) , long
            // 실수 : float , double(*)
            // 문자 : char        문자열 : String
            // 논리 : boolean
        // (6) 리터럴 값을 변수(*하나의 자료를 저장*)에 대입하기.
        // 사용법 : 자료형 변수명 = 리터럴;
            // 1) boolean 타입 : true false만 저장
        boolean bool1 = true;
        boolean bool2 = false;
        // boolean bool3 = 3; -> 리터럴 3은 boolean에 저장 불가능
        System.out.println( bool1 );
        System.out.println( bool2 );
            // 2) char 타입 : ''로 감싼 문자 1개
        char ch1 = 'A';
        // char ch2 = 'ABC'; -> 문자열 여러개 저장 불가능
        // char ch3 = "A";   -> ""로 감싼 자료 저장 불가능
        System.out.println( ch1 );
            // 3) String 클래스타입 : ""로 감싼 문자 여러개
        String str1 = "ABC";
        // String str2 = 'ABC'; -> ''로 감싼 자료 저장 불가능
        System.out.println( str1 );
            // 4) byte 타입 : 정수 -128 ~ +127      -> 1byte 저장
        byte b1 = 100;
        // byte b3 = 300; -> byte의 저장 허용 범위를 벗어남
            // 5) short 타입 : 정수 +-30,000 정도       -> 2byte 저장
        short s1 = 32000;
        // short s2 = 50000; -> short의 저장 허용 범위를 벗어남
            // 6) int 타입 : 정수 +-21억 정도        -> 4byte 저장
        int i1 = 2100000000;
        // int i2 = 2500000000; -> int의 저장 허용 범위를 벗어남
            // 7) long 타입 : 정수 +-21억 이상       -> 8byte 저장 / 리터럴 뒤에 l/L
        System.out.println( i1 );
        // long l1 = 3000000000; -> 키보드로 입력한 모든 값은 리터럴
        long l2 = 3000000000L;
        System.out.println( l2 );
            // 8) double 타입 : 실수 소수점 17자리까지 표현, 실수리터럴
        double d1 = 0.123456789123456789;
        System.out.println( d1 ); // 17자리를 넘어선 자리는 잘려서 출력됨
            // 9) float 타입 : 실수 소수점 8자리까지 표현, 리터럴 뒤에 f/F
        float f1 = 0.123456789123456789f;
        System.out.println( f1 );;

        // 주의점 : double과 Double은 다름

    } // main end
} // class end
