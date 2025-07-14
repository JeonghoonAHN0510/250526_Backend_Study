package 종합.예제8.view;

import 종합.예제8.controller.BoardController;

public class BoardView {
    // 1. 싱글톤 만들기
    // 1단계 : 기본 생성자를 private로 선언한다
    private BoardView(){}
    // 2단계 : private static final로 객체를 생성한다.
    private static final BoardView view = new BoardView();
    // 3단계 : getInstance 메소드를 선언한다.
    public static BoardView getInstance() {
        return view;
    }
    // 2. controller 싱글톤 가져오기
    private BoardController controller = BoardController.getInstance();

    // 3.


    
    
} // class end
