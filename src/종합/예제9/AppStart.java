package 종합.예제9;

import 종합.예제9.controller.BoardController;
import 종합.예제9.model.dto.BoardDto;

import java.util.ArrayList;

public class AppStart {
    public static void main(String[] args) {
        /*
        [MVC 패턴 순서]
        1. 프로젝트 / 패키지 / 라이브러리 세팅
        2. 우선 작업에 필요한 MVC패턴 클래스 선언
        3. dto를 제외하고 싱글톤 선언
        4. dto에 멤버변수 / 생성자 / 메소드 선언
            생성자 : 기본생성자 / 전체생성자
            메소드 : getter / setter / toString()
        */

        // view 작업 전에 Controller/Dao 테스트
        // 1) 테스트할 controller 싱글톤 가져오기
        BoardController bc = BoardController.getInstance();
        // 2) 단위 기능 테스트
            // (1) 등록 테스트
        boolean result1 = bc.boardWrite( "안녕하세요", "유재석" );
        System.out.println( result1 );
            // (2) 전체조회 테스트
        ArrayList<BoardDto> result2 = bc.boardPrint();
        System.out.println( result2 );



    } // main end
} // class end
