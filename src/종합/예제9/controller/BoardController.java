package 종합.예제9.controller;

import 종합.예제9.model.dao.BoardDao;
import 종합.예제9.model.dto.BoardDto;

import java.util.ArrayList;

public class BoardController {
    // 싱글톤 만들기
    private BoardController(){}
    private static final BoardController instance = new BoardController();
    public static BoardController getInstance() {
        return instance;
    } // func end

    // controller는 dao만 호출할 수 있다.
    private BoardDao boardDao = BoardDao.getInstance();


    // 1. 등록 메소드
    // 메소드명 : boardWrite
    // 매개변수 : String content, String writer
    // 반환값 : true -> boolean
    public boolean boardWrite( String content, String writer ){
        // 1) 매개변수를 dto객체로 선언
        BoardDto boardDto = new BoardDto( content, writer );
        // 2) 유효성 검사(선택)
        // 3) dao에게 저장할 객체를 전달하여 결과받기
        boolean result = boardDao.boardWrite( boardDto );
        // 4) 결과를 view에게 리턴하기
        return result;
    } // func end

    // 2. 전체조회 메소드
    // 메소드명 : boardPrint
    // 매개변수 : X
    // 반환값 : boardDB -> ArrayList<BoardDto>
    public ArrayList<BoardDto> boardPrint(){
        // 1) dao에게 매개변수없이 모든 dto 정보 요청하여 받기
        ArrayList<BoardDto> result = boardDao.boardPrint();
        // 2) 결과를 view에게 리턴하기
        return result;
    } // func end
} // class end
