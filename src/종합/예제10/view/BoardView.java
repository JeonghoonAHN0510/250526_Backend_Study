package 종합.예제10.view;

public class BoardView {
    // 싱글톤 만들기
    private BoardView(){}
    private static final BoardView instance = new BoardView();
    public static BoardView getInstance() {
        return instance;
    } // func end

} // class end
