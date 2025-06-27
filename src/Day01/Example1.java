// 한줄 주석
/*
   여러줄 주석
*/

package Day01;  // 패키지(폴더) : 현재 .java 파일이 위치한 패키지명

public class Example1 {
    // public   : 프로젝트 내 모든 곳에서 호출 가능한 키워드
    // class    : 클래스 선언
    // 클래스명   : 첫 글자를 대문자로 시작
    // { }      : 클래스의 시작과 끝
    // ************ 자바의 모든 코드는 클래스 안에서 작성해야한다 ************
    // * 자바는 컴파일 단위가 무조건 클래스 *
    // 클래스 = 설계도.

    // 비교1
    int a = 10;                 // int 변수 선언
    // System.out.print( a );      // 출력함수 실행 [X]

    // 비교2
        // JS 실행 방법     : HTML 안에 포함된 JS 실행
        // 자바를 실행 방법  : main() 함수가 실행되면서 코드를 순차적으로 읽는다.
    public static void main(String[] args) {
        int b = 20;             // int 변수 선언
        System.out.print( b );  // 출력함수 실행 [O]
    }
}
