package Day22;

import java.util.Arrays;

public class Example1 {
    public static void main(String[] args) {
        /*
        [ String 클래스 ]
        - 자바에서 문자열을 표현하는 방법
        - 컴퓨터는 문자는 알고, 문자열은 모른다.
        - 문자 번역(인코딩) : 바이트 <---번역방법---> 문자
            1. 아스키코드    : 128문자(7비트)를 표현하는 규칙, 영문/숫자/특수문자(한글 지원 X)
            2. 유니코드      : 전세계 공용어(한글 지원 O), 자바가 사용하는 코드
        */
        // [1] 배열을 이용한 문자열 표현
        char char1 = '유';                       // 작은 따옴표로 감싼 문자 1개는 char 타입
        char[] char2 = { '유', '재', '석' };      // 작은 따옴표로 감싼 문자 3개는 char[] 타입

        // [2] char 타입의 아스키코드 10진수
        char char3 = 65;
        System.out.println( char3 );                    // 'A' 출력
        char[] char4 = { 74, 65, 86, 65 };
        System.out.println(Arrays.toString( char4 ));   // [J, A, V, A] 출력
        char char5 = '김';
        System.out.println( (int) char5 );              // '44608' 출력

        // [3] 문자열 리터럴 : " " 큰 따옴표, String 클래스
        String str1 = "유재석";
        String str2 = "유재석";
        String str3 = new String("유재석");
        // - new String을 사용하지않고 문자열을 생성할 경우, 문자열이 동일할 경우 동일한 객체 취급
        // - new String을 사용할 경우, 문자열이 동일하더라도 다른 객체 취급

        // [4] == vs .equals()
        System.out.println( str1 == str2 );             // 'true' 출력
        System.out.println( str1 == str3 );             // 'false' 출력
        // == : 주소값 비교
        System.out.println( str1.equals(str2) );        // 'true' 출력
        System.out.println( str1.equals(str3) );        // 'ture' 출력
        // .equals() : 객체가 가지는 값 비교

        // [5] 주요 메소드
        // 1) A.concat(B) : 문자열 연결 메소드 -> A + B
        String str4 = "자바".concat("프로그래밍");
        System.out.println( str4 );                     // '자바프로그래밍' 출력
        // 2) StringBuilder : 문자열을 단계적으로 연결하는 메소드를 제공하는 클래스
        // -> 객체를 하나만 사용하기 때문에, 메모리 효율성이 좋다.(코딩 테스트에서 유용)
        StringBuilder builder = new StringBuilder();
        builder.append("자바");
        builder.append("프로그래밍");
        System.out.println( builder );                  // '자바프로그래밍' 출력
        // 3) String.format( "형식", 문자열 );
        String str5 = String.format("%s%s", "자바", "프로그래밍");
        System.out.println( str5 );                     // '자바프로그래밍' 출력
        // 4) 연결 연산자 +
        String str6 = "";
        str6 += "자바";       str6 += "프로그래밍";
        System.out.println( str6 );                     // '자바프로그래밍' 출력

        // [활용] SQL 매개변수 대입 -> ?를 통한 setXXX를 사용하자
        String name = "유재석";
        String SQL1 = "insert into table( name ) values ( " + name + " )";              // 비권장
        String SQL2 = String.format("insert into table( name ) values ( %s )", name );  // 비권장
        StringBuilder builder1 = new StringBuilder();
        builder1.append("insert into table( name ) ");
        builder1.append("values ( " + name + " )");

    } // main end
} // class end
