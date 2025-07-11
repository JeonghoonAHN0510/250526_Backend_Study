package 종합.예제7.model.dao;

// BoardDao의 역할 : 실제 데이터가 존재하는 데이터베이스에 접근하는 기능(CRUD)

import 종합.예제7.model.dto.BoardDto;

public class BoardDao {
    // 추후에 데이터베이스로 설계할 예정
    private BoardDto[] boardDB = new BoardDto[100];
    // 1. 등록 처리 메소드 : Controller로부터 DB에 저장할 객체를 받아서 저장
    // 매개변수 : BoardDto
    // 반환값 : boolean
    public boolean boardWrite( BoardDto BoardDto ){
        for ( int i = 0; i < boardDB.length; i++){  // 배열 순회
            if ( boardDB[i] == null ){              // i번째 값이 비어있으면
                boardDB[i] = BoardDto;              // i번째 값에 객체 대입
                return true;                        // 저장 성공 -> true 반환
            } // if end
        } // for end
        return false;                               // 저장 실패 -> false 반환
    } // func end
    // 2. 조회 처리 메소드 : Controller로부터 모든 DB를 반환
    // 매개변수 : X
    // 반환값 : BoardDto[]

}
