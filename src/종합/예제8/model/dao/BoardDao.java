package 종합.예제8.model.dao;

import 종합.예제8.model.dto.BoardDto;

import java.util.ArrayList;

public class BoardDao {
    // 1. 싱글톤 만들기
    // 1단계 : 기본 생성자를 private로 선언한다
    private BoardDao(){}
    // 2단계 : private static final로 객체를 생성한다.
    private static final BoardDao dao = new BoardDao();
    // 3단계 : getInstance 메소드를 선언한다.
    public static BoardDao getInstance() {
        return dao;
    }

    // 2. BoardDto 객체를 저장할 ArrayList 선언
    private ArrayList<BoardDto> BoardDB = new ArrayList<>();

    // 3. 등록기능 구현 -> API 명세서를 보고 구성
    public boolean addBoard( String content, String writer ){
        boolean result = false;
        // 1) 매개변수의 값을 객체화
        BoardDto boardDto = new BoardDto( content, writer );
        // 2) ArrayList에 생성한 객체 대입하기
        BoardDB.add( boardDto );
        // 3) 성공 시, result에 true(성공) 대입
        result = true;

        return result;
    } // func end

    // 4. 게시물 전체조회 기능 구현
    public ArrayList<BoardDto> getBoardList(){
        // 1) controller에게 리스트 반환하기.
        return BoardDB;
    } // func end
} // class end
