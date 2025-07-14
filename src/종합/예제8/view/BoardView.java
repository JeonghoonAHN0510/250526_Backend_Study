package 종합.예제8.view;

import 종합.예제8.controller.BoardController;
import 종합.예제8.model.dto.BoardDto;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardView {
    // 1. 싱글톤 만들기
    // 1단계 : 기본 생성자를 private로 선언한다
    private BoardView(){}
    // 2단계 : private static final로 객체를 생성한다.
    private static final BoardView view = new BoardView();
    // 3단계 : getInstance 메소드를 선언한다.
    public static BoardView getInstance() {
        return view;
    }

    // 2. controller 싱글톤 가져오기
    private BoardController controller = BoardController.getInstance();

    // Scanner 객체 생성
    private Scanner scan = new Scanner(System.in);

    // 3. 등록 입출력 구현
    public void addBoard(){
        // 1) 게시물 내용과 작성자 입력받기
        System.out.print("내용 : ");      String content = scan.next();
        System.out.print("작성자 : ");     String writer = scan.next();
        // 2) controller에게 입력받은 값을 인수로 전달 후, 결과 리턴받기
        boolean result = controller.addBoard(content, writer);
        // 3) 리턴에 따른 출력문
        if ( result ){
            System.out.println("[안내] 글쓰기 성공");
        }else {
            System.out.println("[경고] 글쓰기 실패");
        } // if end
    } // func end

    // 4. 게시물 전체조회기능 구현
    public void getBoardList(){
        // 1) controller에게 요청 후 결과 리턴받기
        ArrayList<BoardDto> result = controller.getBoardList();
        System.out.println("============= 게시물 목록 =============");
        // for ( int i = 0; i < result.size(); i++)
        for ( BoardDto board : result ){
            System.out.println("작성자 : " + board.getWriter());
            System.out.println("내용 : " + board.getContent());
            System.out.println("------------------------------------");
        } // for end
    } // func end

    // 5. 메인화면 구현
    public void index(){
        for ( ; ; ){
            // 반복적인 메인화면 출력
            System.out.println("============= My Community =============");
            System.out.println("         1.게시물쓰기 | 2.게시물출력");
            System.out.println("========================================");
            // 사용자로부터 입력받기
            System.out.print("선택 : ");      int option = scan.nextInt();
            if ( option == 1 ){         // 1을 선택한다면
                addBoard();             // 게시물 등록 메소드
            }else if ( option == 2 ){   // 2를 선택한다면
                getBoardList();         // 게시물 출력 메소드
            } // if end
        } // for end
    } // func end
} // class end
