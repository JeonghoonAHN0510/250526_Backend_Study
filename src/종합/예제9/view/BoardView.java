package 종합.예제9.view;

import 종합.예제9.controller.BoardController;
import 종합.예제9.model.dto.BoardDto;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardView {
    // 싱글톤 만들기
    private BoardView(){}
    private static final BoardView instance = new BoardView();
    public static BoardView getInstance(){
        return instance;
    } // func end

    // 입력 객체 생성 -> 여러 메소드에서 사용할 것이기 때문에 메소드 밖에서 선언
    private Scanner scan = new Scanner( System.in );

    // BoardController 싱글톤 가져오기 : controller의 메소드를 사용하기 위해서
    private BoardController boardController = BoardController.getInstance();

    // 1. 메인화면
    public void index(){
        for( ; ; ){
            System.out.println("========================");
            System.out.println("   1. 등록 | 2. 전체조회");
            System.out.println("========================");
            System.out.print("선택 : ");      int option = scan.nextInt();
            if ( option == 1 ){
                // 1번을 선택하면, 등록화면 출력
                boardWrite();
            }else if ( option == 2 ){
                // 2번을 선택하면, 전체조회 출력
                boardPrint();
            } // if end
        } // 무한루프 end
    } // func end

    // 2. 등록화면
    public void boardWrite(){
        // 1) 사용자로부터 입력받기
        System.out.print("내용 : ");      String content = scan.next();
        System.out.print("작성자 : ");     String writer = scan.next();
        // 2) controller에게 입력받은 값을 전달하고 결과받기
        boolean result = boardController.boardWrite( content, writer );
        // 3) 결과에 따른 출력
        if ( result ){
            System.out.println("등록 성공");
        } else {
            System.out.println("등록 실패");
        } // if end
    } // func end

    // 3. 전체조회화면
    public void boardPrint(){
        // 1) controller에게 요청 후 결과받기
        ArrayList<BoardDto> result = boardController.boardPrint();
        // 2) 결과를 반복하여 출력
        for ( BoardDto boardDto : result ){
            System.out.println("작성자 : " + boardDto.getWriter());
            System.out.println("내용 : " + boardDto.getContent());
            System.out.println("--------------------------------");
        } // for end
    } // func end

} // class end
