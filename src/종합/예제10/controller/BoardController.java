package 종합.예제10.controller;

public class BoardController {
    // 싱글톤 만들기
    private BoardController(){}
    private static final BoardController instance = new BoardController();
    public static BoardController getInstance() {
        return instance;
    } // func end

} // class end
