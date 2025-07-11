package 종합.예제7.controller;

import 종합.예제7.model.dao.BoardDao;
import 종합.예제7.model.dto.BoardDto;

public class BoardController {
    // 싱글톤 만들기
    private BoardController(){}
    private static final BoardController controller = new BoardController();
    public static BoardController getInstance() {
        return controller;
    }

    // Dao 객체 꺼내오기 -> 여러 메소드에서 사용하려고 멤버변수로 선언
    private BoardDao boardDao = BoardDao.getInstance();

    // 1. 등록 처리 메소드
    // View로부터 전달받은 content/writer를 객체로 구성하여 Dao에게 전달하고
    // 결과를 다시 View에게 전달
    public boolean boardWrite( String content, String writer){
        // 1. 매개변수 객체화
        BoardDto boardDto = new BoardDto( content, writer );
        // 2. Dao에게 객체를 전달 후 결과 받기
        boolean result = boardDao.boardWrite(boardDto);
        // 3. Dao에게 받은 결과를 View에게 전달하기
        return result;
    } // func end
    // 2. 조회 처리 메소드
    public BoardDto[] boardPrint(){
        // Dao에게 게시물 조회 요청 후 반환값 저장
        BoardDto[] result = boardDao.boardPrint();
        // Dao에게 받은 결과를 반환
        return result;
    }
} // class end
