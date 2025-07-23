package 종합.예제10;

import 종합.예제10.controller.BoardController;
import 종합.예제10.view.BoardView;

public class AppStart {
    public static void main(String[] args) {
        // view없이 기능 테스트
        // boolean test = BoardController.getInstance().boardWrite("테스트내용", "테스트작성자");
        // System.out.println( test );     // true(성공) / false(실패)

        // 0. 메인화면 호출
        BoardView.getInstance().mainPrint();

    } // main end
} // class end
