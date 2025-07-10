package 종합.예제6;

// BoardController의 목적 : 기능 + 제어 담당
public class BoardController { // class start
    // 1. 멤버변수
    private static final Board[] boards = new Board[100];
        // private : 현재 클래스에서만 접근 가능
        // static  : 객체 없이 접근 가능하게 해주는 키워드
        // final   : 수정이 불가능하게 하는 키워드
    // 2. 생성자
    // 3. 메소드
    // 1) 등록 메소드
        // 메소드명 : doPost
        // 매개변수 : 내용, 작성자
        // 반환값 : 성공(ture)/실패(false) -> boolean
    public static boolean doPost( String content, String writer ){
        // public : 다른 클래스에서 접근 가능
        // (1) 매개변수로 객체 선언
        Board board = new Board( content, writer );
        // (2) 배열 내(boards)에서 빈공간을 찾아서 생성한 객체 대입
        for ( int i = 0; i < boards.length; i++){
            if ( boards[i] == null ){
                boards[i] = board;
                return true;            // 저장 성공하여 true 반환
            } // if end
        } // for end
        return false;                   // 저장 실패하여 false 반환
    }
    // 2) 조회 메소드
        // 메소드명 : doGet
        // 매개변수 : X
        // 반환값 : boards -> Board[]
    public static Board[] doGet(){
        return boards;
    }
} // class end
