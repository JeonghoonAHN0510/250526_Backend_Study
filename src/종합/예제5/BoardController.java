package 종합.예제5;

public class BoardController { // BoardController class start
    // 게시물 기능 제어 담당
    // 0. 게시물 배열 생성
    Board[] boards = new Board[100];
    // 1. 게시물 등록 기능 -> 입력받은 자료를 받아서 객체를 생성하여 배열에 저장
    // 메소드명 : doPost
    // 매개변수 : 게시물 내용, 게시물 작성자 -> String content, String writer
    // 반환값 : 성공/실패 -> boolean
    boolean doPost( String content, String writer ){
        // 1. 생성자를 이용한 객체 만들기
        Board board = new Board( content, writer);
        // 2. 배열 내 빈 공간을 찾아서 -> 생성된 객체 대입
        for ( int i = 0 ; i < boards.length; i++){
            if ( boards[i] == null ){   // 만약 i번째 요소가 null이면
                boards[i] = board;      // i번째 요소에 생성한 board 객체 대입
                return true;            // return -> 메소드 반환값이면서 메소드의 종료를 의미.
            } // if end
        } // for end
        return false;                   // 저장을 실패했을 때, false 반환
    }

    // 2. 게시물 출력 기능 -> 객체들을 가지고 있는 배열 호출
    // 메소드명 : doGet
    // 매개변수 : X
    // 반환값 : boards -> Board[]
    Board[] doGet(){
        return boards;
    }

} // BoardController class end

// 각 담당 클래스가 필요한 이유
// 복잡한 코드를 담당/역할을 나누어 유지보수 및 관리를 한다.
// -> 역할이 많아지면, 각 역할을 맡는 클래스를 나눠서 관리하면 편해진다.