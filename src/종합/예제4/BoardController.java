package 종합.예제4;

public class BoardController { // BoardController class start
    // 1. 멤버변수 선언
    Board[] boards = new Board[100];                // Board 객체 100개를 저장할 수 있는 배열

    // 2. doPost 메소드 -> 매개변수 o, 반환값 o -> boolean 메소드명(매개변수){ }
    boolean doPost(String content, String writer){  // doPost 메소드 start
        Board board = new Board();                  // Board 객체를 생성하고
        // 매개변수로 받은 값들을 객체의 멤버 변수에 저장한다.
        board.content = content;
        board.writer  = writer;
        boolean check = false;                      // 저장성공 : true, 저장실패 : false
        for ( int i = 0; i < boards.length; i++){   // boards 배열을 순회하여
            if ( boards[i] == null ){               // 빈 공간을 찾으면
                boards[i] = board;                  // 생성된 객체를 저장한다.
                check = true;                       // 저장성공으로 바꾸고
                break;                              // 반복문 종료
            }
        }
        if ( check ){ return true; }                // 저장성공하면 true 반환
        else { return false; }                      // 저장실패하면 false 반환
        // -> 여기서는 그냥 if 안에서 return true;하고 밖에서 return false; 해도 된다!!!!
        // -> 왜냐면 return은 그대로 함수 종료이기 때문에, 저장성공하면 return true하고 종료되고
        // -> boards를 다 순회해도 저장을 못하면 그대로 밖에 있는 return false가 실행되기 때문이다
    } // doPost 메소드 end

    // 3. doGet 메소드 -> 매개변수 x, 반환값 o -> Board[] 메소드명( ){ }
    Board[] doGet(){ // doGet 메소드 start
        return boards;
    } // doGet 메소드 end
} // BoardController class end
