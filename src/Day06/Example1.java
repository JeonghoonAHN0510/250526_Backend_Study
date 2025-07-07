package Day06; // package 현재 .java 파일의 폴더 위치

import java.util.Arrays;

public class Example1 { // class start
    public static void main(String[] args) { // main start
        /*
        [ 배열 ]
        1. 정의 : *동일한* 자료형(타입) 데이터 여러개를 순서대로 저장하는 타입
        2. 특징
            1) 동일한 자료형 : 서로 다른 자료형의 데이터를 같은 배열에 저장할 수 없다.
            2) 고정 길이    : 배열은 한 번 생성되면 길이를 수정할 수 없다.
            3) 요소 초기값   : 요소의 초기값이 없으면 자동으로 배정
                (1) 정수 : 0
                (2) 실수 : 0.0
                (3) 논리 : false
                (4) 배열 : null
        3. 사용법
            1) 선언(생성)
                (1) new 타입[길이];     , int[] 배열명 = new int[3];               -> int 타입의 길이가 3인 배열 선언
                (2) { 값1, 값2, 값3 }   , double[] 배열명 = { 3.14, 5.1, 75.45 };  -> double 타입의 길이기 3인 배열 선언
            2) 호출
                (1) 배열명                     -> 배열의 주소값 반환
                (2) Arrays.toString( 배열명 )  -> 배열 내 요소값들을 문자열로 반환
                (3) 배열명[인덱스]              -> 배열 인덱스값 반환
                (4) 배열명.length              -> 배열 길이 반환
            3) 수정
                (1) 배열명 = new 타입[];        -> 전체 배열 초기화
                (2) 배열명[인덱스] = 새로운 값;   -> 특정 인덱스값 수정
            4) 삭제 / 추가
                (1) 특정한 요소 삭제 / 추가는 존재하지 않는다.
                    -> 자바 배열은 고정 길이이므로 중간에 요소를 변경할 수 없다.
                (2) 배열에 추가하려면, 새 배열을 선언하고 대입하는 형태로 추가한다.
            5) 배열의 반복문
                (1) 일반 for문
                for ( int i = 0; i < 배열.length; i++){ };
                (2) 향상된 for문 -> 배열 내 요소값 하나씩 변수에 대입 반복
                for ( 타입 변수명 : 배열명 ){ };
        */

        // [1] int 배열 선언 : 선언
        int[] array1 = new int[3];// 이름이 array1인 int 타입의 길이가 3인 배열 선언

        // [2] String 배열 선언 : 선언 + 초기화
        String[] array2 = { "봄", "여름", "가을", "겨울" };// 이름이 array2인 String 타입의 길이가 4이고 값이 ~~인 배열 선언

        // [3] 배열 주소값 반환
        System.out.println( array1 );                   // 객체의 주소값 반환 : [I@4c873330
        System.out.println( array2 );                   // 객체의 주소값 반환 : [Ljava.lang.String;@119d7047

        // [4] 배열 내 요소값들 문자열로 반환
        System.out.println( Arrays.toString(array1) );  // 배열 내 요소값들을 문자열로 반환 : [0, 0, 0]
        System.out.println( Arrays.toString(array2) );  // 배열 내 요소값들을 문자열로 반환 : [봄, 여름, 가을, 겨울]

        // [5] 특정 인덱스값 반환
        System.out.println( array1[0] );                // 배열 인덱스값 반환 : 0
        System.out.println( array2[0] );                // 배열 인덱스값 반환 : 봄

        // [6] 배열 길이 구하기
        System.out.println( array1.length );            // 배열의 길이 반환 : 3
        System.out.println( array2.length );            // 배열의 길이 반환 : 4

        // [7] 특정한 요소 값 수정
        array1[0] = 10;                                 // array1[0]의 값을 10으로 수정
        System.out.println( array1[0] );                // 수정된 값 반환 : 10
        array2[0] = "spring";                           // array2[0]의 값을 "spring"으로 수정
        System.out.println( array2[0] );                // 수정된 값 반환 : spring

        // [8] 배열 범위 밖은 수정 / 삭제가 불가능하다.
      //array1[3] = 40;                                 // 오류 발생 : Index 3 out of bounds for length 3

        // [9] 일반 for문
        for ( int i = 0; i < array1.length; i++){       // i는 0부터 array의 마지막 인덱스까지 1씩 증가
            int value = array1[i];                      // value에 array의 각 값 저장
            System.out.println( value );                // value 출력
        }

        // [10] 향상된 for문
        for ( String value : array2 ){                  // value에 array2의 각 값 저장 반복
            System.out.println( value );                // value 출력
        }

    } // main end
} // class end
