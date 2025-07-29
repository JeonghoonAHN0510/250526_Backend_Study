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
        1. 문자열 생성법
            1) "문자열"                : 큰 따옴표를 이용한 문자열 생성
            2) new String("문자열")    : new String() 생성자를 이용한 문자열 생성
        2. 문자열 비교법
            1) 문자열A == 문자열B         : "리터럴" 문자만 비교 가능 / 주소값 비교
            2) 문자열A.equals("문자열B")  : 객체가 가지는 값 비교
        3. 주요 메소드
            1) 문자열A.concat("문자열B")  : 문자열 연결 메소드
            2) String.format("형식문자", 문자열A ) : 지정한 형식으로 문자열 반환 메소드
            3) StringBuilder 변수명 = new StringBuilder(); : 문자열 연결 클래스
               -> 객체를 하나만 사용하기 때문에, 메모리 효율성이 좋다.(코딩 테스트에서 유용)
            4) 문자열A.charAt( 인덱스 )   : 지정한 인덱스의 문자 1개 반환 메소드
            5) 문자열A.length()          : 지정한 문자열의 문자개수 반환 메소드
            6) 문자열A.replace( 기존문자열, 새로운문자열 )    : 지정한 문자열 내 기존문자열 **1개**를 새로운문자열로 바꾼 후 반환 메소드( 치환이랑 비슷 )
               문자열A.replaceAll( 기존문자열, 새로운문자열 ) : 지정한 문자열 내 **모든** 기존문자열을 새로운문자열로 바꾼 후 반환 메소드
            7) 문자열A.subString( 시작인덱스, 끝인덱스 )     : 지정한 문자열 내 시작인덱스부터 끝인덱스 -1까지 문자열 반환 메소드
            8) 문자열A.split( "구분문자" )                 : 지정한 문자열 내 구분문자 기준으로 잘라서 배열로 반환
            9) 문자열A.indexOf("찾을문자열")               : 지정한 문자열 내 찾을문자열의 최초 인덱스 번호 반환(만약 없다면, -1 반환)
            10) 문자열A.contains("찾을문자열")             : 지정한 문자열 내 찾을문자열의 존재를 boolean로 반환(찾으면 true, 없으면 false)
            11) 문자열A.getBytes()                       : 지정한 문자열을 byte[] 타입으로 반환
                <----> new String( byte[] ) : 지정한 byte[]을 String으로 타입 변환
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

        // 5) .charAt( 인덱스 ) : 지정한 인덱스 번호의 문자 1개 반환
        char gender = "112233-1122334".charAt(7);
        System.out.println( gender );               // '1' 출력
        // [활용] nextChar() 존재 X -> 문자1개 입력 : scan.next().charAt(0);

        // 6) .length() : 문자열 내 문자수 반환
        System.out.println( "112233-1122334".length() );    // 길이 : 14, 인덱스 : 0 ~ 13

        // 7) .replace( 기존문자열, 새로운문자열 ) : 지정한 문자열 내 기존문자열 **1개**를 새로운문자열로 바꾼 후 반환( 치환이랑 비슷 )
        // .replaceAll( 기존문자열, 새로운문자열 ) : 지정한 문자열 내 **모든** 기존문자열을 새로운문자열로 바꾼 후 반환
        String str7 = "자바프로그래밍".replace( "자바", "JAVA" );
        System.out.println( str7 );
        // [활용] HTML 줄바꿈 <br> -----> JAVA 줄바꿈 \n
        String htmlData = "유재석<br>안녕하세요.";
        String javaData = htmlData.replaceAll( "<br>", "\n" );
        System.out.println( javaData );

        // 8) .subString( 시작인덱스, 끝인덱스 ) : 시작인덱스부터 끝인덱스 - 1 까지 문자열 반환
        String str8 = "112233-1122334".substring( 0, 6 );       // 0번 인덱스부터 (6 - 1)인덱스까지 문자열 반환
        System.out.println( str8 );
        String str9 = "112233-1122334".substring( 7 );          // 7번 인덱스부터 마지막인덱스까지 문자열 반환
        System.out.println( str9 );
        // [활용] 차량번호 조회 : 123가 4567, 차량번호.subString( 차량번호.length() - 4 );
        String str10 = "123가 4567";
        System.out.println( str10.substring( str10.length() - 4 ));   // '4567' 출력

        // 9) .split( "구분문자" ) : 지정한 문자열 내 구분문자 기준으로 잘라서 배열로 반환
        String str11 = "112233-1122334";
        String[] str12 = str11.split("-");      // '112233' '1122334'
        for ( String str : str12 ){
            System.out.println( str );
        } // for end
        // [활용1] CSV 형식 다루기 : 쉼표로 속성을 구분하고, \n으로 줄바꿈을 구분한다.
        // [활용2] 날짜 구분 : 연/월/일
        // [활용3] 주소 구분 : 시 군 구 동...

        // 10) .indexOf("찾을문자열") : 지정한 문자열 내 찾을문자열의 최초 인덱스 번호 반환(만약 없다면, -1 반환)
        int findIndex = "자바 프로그래밍 언어".indexOf("프로");
        System.out.println( findIndex );        // '3' 출력
        // [활용] 검색기능 구현

        // 11) .contains("찾을문자열") : 지정한 문자열 내 찾을문자열의 존재를 boolean로 반환(찾으면 true, 없으면 false)
        boolean findBool = "자바 프로그래밍 언어".contains("프로");
        System.out.println( findBool );         // 'true' 출력
        // [활용] 검색기능 구현

        // 12) .getBytes() : 지정한 문자열을 byte[] 타입으로 반환
        byte[] bytes = "자바 프로그래밍 언어".getBytes();
        System.out.println( Arrays.toString( bytes ));
        // [활용] 파일처리, 네트워크 통신...


    } // main end
} // class end
