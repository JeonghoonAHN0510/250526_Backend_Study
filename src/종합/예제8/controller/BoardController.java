package 종합.예제8.controller;

import 종합.예제8.model.dao.BoardDao;
import 종합.예제8.model.dto.BoardDto;

import java.util.ArrayList;

public class BoardController {
    // 1. 싱글톤 만들기
    // 1단계 : 기본 생성자를 private로 선언한다
    private BoardController(){}
    // 2단계 : private static final로 객체를 생성한다.
    private static final BoardController controller = new BoardController();
    // 3단계 : getInstance 메소드를 선언한다.
    public static BoardController getInstance() {
        return controller;
    }

    // 2. dao 싱글톤 가져오기
    private BoardDao boardDao = BoardDao.getInstance();

    // 3. 등록기능 구현
    public boolean addBoard( String content, String writer ){
        boolean result = false;
        // 1) Dao에게 매개변수 전달하고, 결과값 받기
        result = boardDao.addBoard( content, writer );

        return result;
    } // func end

    // 4. 게시물 전체조회기능 구현
    public ArrayList<BoardDto> getBoardList(){
        // 1) dao에게 요청 후, 게시물을 반환받아 view에게 전달한다.
        return boardDao.getBoardList();
    } // func end
    
} // class end
