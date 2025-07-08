package 종합.예제4;

public class BoardController { // BoardController class start
    Board[] boards = new Board[100];                // Board 객체 100개를 저장할 수 있는 배열
    // doPost 메소드 -> 매개변수 o, 반환값 o -> boolean (매개변수)
    boolean doPost(String content, String writer){  // doPost 메소드 start
        Board board = new Board();                  // Board 객체를 생성하고
        // 매개변수로 받은 값들을 객체의 멤버 변수에 저장한다.
        board.content = content;
        board.writer  = writer;
        boolean check = false;                      // 저장성공 : true, 저장실패 : false
        for ( int i = 0; i < boards.length; i++){   // boards 배열을 순회하여
            if ( boards[i] == null ){               // 빈 공간을 찾으면
                boards[i] = board;                  // 생성된 객체를 저장한다.
                check = true;
            }
        }
        if ( check ){ return true; }
        else { return false; }
    } // doPost 메소드 end
    // doGet 메소드 -> 매개변수 x, 반환값 o -> Board[] ( )
    Board[] doGet(){ // doGet 메소드 start
        return boards;
    } // doGet 메소드 end
} // BoardController class end
