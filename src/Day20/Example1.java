package Day20;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

class BookDto{

} // class end
class BoardDto{
    public String toString() {
        return "BoardDto{}";
    } // func end
} // class end

public class Example1 {
    public static void main(String[] args) {
        /*
        - 리터럴 값/자료 : 10, 'a', 5.22
        - 타입 : 값을 분류하는 종류
            1. 기본타입 : 8가지 , 리터럴 값 , 소문자로 시작(int)]
                    -> 자바에서 기본으로 제공하는 타입
                    int a = 3;      -> 3 자료를 int로 분류
                    double b = 3;   -> 3 자료를 double로 분류
                VS
            2. 참조타입 : 배열/클래스/인터페이스 , 인스턴스 값 , 대문자로 시작(Integer)
                    -> 개발자가 만든 타입 또는 라이브러리
                    MemberDto c = new MemberDto();
        [ 클래스 ]
        - 기본타입에 존재하지 않는 새로운 타입을 설계하기 위해서

        [ 라이브러리 ]
        - 미리 만들어진 클래스들

        [ 자바의 기본 클래스 ]
        1. Object 클래스 : 모든 객체의 조상 / 모든 인스턴스는 Object로부터 상속받는다.
            -> 모든 자료를 저장할 수 있는 타입
            1) .toString()      : 객체의 주소값 반환
            2) .equals()        : 객체의 값 비교 결과 반환
                ==              : 객체의 주소 비교 결과 반환
            3) .hashCode()      : 객체의 해시값 반환
        2. Class 클래스 : 클래스의 정보를 담는 클래스
            -> 리플랙션 : 실행 중 객체 할당, 멤버분석
            1) Class.forName()      : 실행 중, 지정한 클래스를 불러오는 함수
            2) .getFields()         : 지정한 인스턴스의 모든 멤버변수를 배열로 반환
            3) .getConstructors()   : 지정한 인스턴스의 모든 생성자를 배열로 반환
            4) .getMethods()        : 지정한 인스턴스의 모든 메소드를 배열로 반환
        3. Wrapper 클래스 : 8가지 기본타입을 참조타입으로 변환
            -> 기본타입은 메소드가 없어서, 참조타입으로 변환하여 다양한 기능을 제공받는다.
            종류 : Byte, Short, Integer, Long, Boolean, Float, Double, Character
            1) XXX.parseXXX("문자열") : "문자열"을 XXX 타입으로 변환
            2) String.valueOf(자료) : 자료를 "문자열"로 변환
        */

        // [1] Object 클래스
        // 1) Object 타입은 모든 타입에 상속하므로 타입변환이 가능하다.
        Object o1 = 3;                      // 정수를 Object로 분류할 수 있다.
        Object o2 = 3.14;                   // 실수를 Object로 분류할 수 있다.
        Object o3 = true;                   // 논리를 Object로 분류할 수 있다.
        Object o4 = "object";               // 문자열을 Object로 분류할 수 있다.
        Object o5 = new Object();           //
        Object o6 = new int[]{ 1, 2, 3 };   //
        // 2) Object 타입의 주요 메소드
        Object o7 = new BookDto();
        Object o8 = new BoardDto();
            // (1) .toString() : 인스턴스의 주소 반환(기본값) / 생략 가능
        System.out.println( o7 );                   // 생략하면, 주소 반환
        System.out.println( o7.toString() );        // 기본값으로, 인스턴스의 주소 반환
        System.out.println( o8.toString() );        // 오버라이딩되어서, 주소 대신에 지정한 문자 반환
            // (2) .equals() : 주소가 갖는 값 비교
            //        VS  == : 주소값 비교
        Object o9 = new BookDto();
        System.out.println( o9 );                   // Day20.BookDto@3b9a45b3
        Object o10 = new BookDto();
        System.out.println( o10 );                  // Day20.BookDto@7699a589
        Object o11 = o9;                            // o11에 o9 대입
        System.out.println( o9 == o10 );            // 주소값 비교 -> false
        System.out.println( o9.equals(o10) );       // 주소가 갖는 값 비교 -> false
        System.out.println( o9 == o11 );            // 주소값 비교 -> true
        System.out.println( o9.equals(o11));        // 주소가 갖는 값 비교 -> true
        String str1 = new String("유재석");
        String str2 = new String("유재석");
        System.out.println( str1 == str2 );         // 주소값 비교 -> false
        System.out.println( str1.equals(str2) );    // 주소가 갖는 값 비교 -> true
            // (3) .hashCode() : 객체의 주소값을 정수로 반환
        System.out.println( str1.hashCode() );
        System.out.println( str2.hashCode() );
        System.out.println( o9.hashCode() );
        System.out.println( o11.hashCode() );
        System.out.println( o10.hashCode() );

        System.out.println("========================================================================");
        // [2] Class 클래스
        String str = new String();
        Class c1 = str.getClass();
        System.out.println( c1 );                   // class java.lang.String

        Integer value = 3;
        Class c2 = value.getClass();
        System.out.println( c2 );                   // class java.lang.Integer
            // (1) Class.forName("클래스경로") : 지정한 클래스 경로에서 클래스를 불러오는 함수
            //     -> 지정한 클래스 경로에서 불러오기 실패하면, 예외 발생
        try {
            Class.forName("java.lang.String");
        } catch ( ClassNotFoundException e ){
            System.out.println( e );
        } // try-catch end
        System.out.println("========================================================================");
            // (2) .getFields() : 지정한 클래스의 멤버변수명을 배열로 반환
        Field[] fields = c1.getFields();
        for ( Field field : fields ){
            System.out.println( field );
        } // for end
        System.out.println("========================================================================");
            // (3) .getConstructors() : 지정한 클래스의 생성자를 배열로 반환
        Constructor[] constructors = c1.getConstructors();
        for ( Constructor constructor : constructors ){
            System.out.println( constructor );
        } // for end
            // (4) .getMethods() : 지정한 클래스의 메소드를 배열로 반환
        System.out.println("========================================================================");
        Method[] methods = c1.getMethods();
        for ( Method method : methods ){
            System.out.println( method );
        } // for end
        System.out.println("========================================================================");
        // [3] Wrapper 클래스
        int value1 = 100;               // 자료 : 100, 타입 : int
        Integer value2 = 100;           // 자료 : 100, 타입 : Integer
            // (1) 언박싱 / 오토박싱
        Integer value3 = value1;        // int -> Integer : 오토박싱
        int value4 = value2;            // Integer -> int : 언박싱
            // (2) 문자열 -> 기본타입 변환
        int value5 = Integer.parseInt( "100" );             // "100" -> 100
        double value6 = Double.parseDouble( "3.14" );       // "3.14" -> 3.14
        float value7 = Float.parseFloat( "3.14" );          // "3.14" -> 3.14
        byte value8 = Byte.parseByte( "100" );              // "100" -> 100
        short value9 = Short.parseShort( "100" );           // "100" -> 100
        long value10 = Long.parseLong( "100" );             // "100" -> 100
        boolean value11 = Boolean.parseBoolean( "true" );   // "true" -> true
            // (3) 기본타입 -> 문자열 변환
        String s1 = 100 + "";                   // 방법1 : 자료 + ""
        String s2 = String.valueOf( 100 );      // 방법2 : String.valueOf( 자료 )

    } // main end
} // class end
