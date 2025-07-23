package 종합.예제10;

import 종합.예제10.controller.BoardController;
import 종합.예제10.model.dto.BoardDto;
import 종합.예제10.view.BoardView;

import java.util.ArrayList;

public class AppStart {
    public static void main(String[] args) {
        // [view없이 기능 테스트]
        // * 등록 기능 테스트
        // boolean test = BoardController.getInstance().boardWrite("테스트내용", "테스트작성자");
        // System.out.println( test );     // true(성공) / false(실패)

        // * 전체조회 기능 테스트
        // ArrayList<BoardDto> result = BoardController.getInstance().boardPrint();
        // System.out.println( result );

        // * 삭제 기능 테스트
        // boolean test = BoardController.getInstance().boardDelete( 41 );
        // System.out.println( test );

        // * 수정 기능 테스트
        // boolean test = BoardController.getInstance().boardUpdate( 40, "수정테스트중" );
        // System.out.println( test );

        // 0. 메인화면 호출
        BoardView.getInstance().mainPrint();

    } // main end
} // class end
