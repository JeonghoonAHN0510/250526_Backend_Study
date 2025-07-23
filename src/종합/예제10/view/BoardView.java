package 종합.예제10.view;

import 종합.예제10.controller.BoardController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BoardView {
    // 싱글톤 만들기
    private BoardView(){}
    private static final BoardView instance = new BoardView();
    public static BoardView getInstance() {
        return instance;
    } // func end

    // 입력 객체 생성
    private Scanner scan = new Scanner(System.in);

    // boardController 인스턴스 가져오기
    private BoardController boardController = BoardController.getInstance();

    // 0. 메인화면 출력
    public void mainPrint(){
        for ( ; ; ){
            try {
                System.out.println("==================== 비회원 게시판 ====================");
                System.out.println("      1. 등록 | 2. 전체조회 | 3. 삭제 | 4. 수정");
                System.out.println("=====================================================");
                System.out.print("선택 : ");          int choose = scan.nextInt();
                if ( choose == 1 ){             // 등록을 선택하면
                    boardWritePrint();          // 등록화면 출력
                }else if ( choose == 2 ){       // 전체조회를 선택하면

                }else if ( choose == 3 ){       // 삭제를 선택하면

                }else if ( choose == 4 ){       // 수정을 선택하면

                }else {                         // 없는 번호를 선택하면
                    System.out.println("[경고] 존재하지 않는 번호입니다.");
                } // if end
            } catch ( InputMismatchException e ){
                System.out.println("[경고] 입력 타입이 일치하지 않습니다. 다시 입력하세요.");
                // 잘못된 데이터 지우기 : 입력에 따른 입력객체 초기화
                scan = new Scanner(System.in);
            } catch ( Exception e ){
                System.out.println("[경고] 관리자에게 문의하세요. <admin@admin.admin>");
            } // try-catch end
        } // 무한루프 end
    } // func end

    // 1. 등록화면 출력
    public void boardWritePrint(){
        // 1. 입력받기
        scan.nextLine();        // 진짜 nextLine()을 위한 의미없는 nextLine();
        System.out.print("내용 : ");          String bcontent = scan.nextLine();  // nextLine() : 띄어쓰기 가능, 앞에 의미없는 .nextLine()이 필요
        System.out.print("작성자 : ");         String bwriter = scan.next();       // next() : 띄어쓰기 불가능
        // 2. controller에게 전달하고, 결과받기
        boolean result = boardController.boardWrite( bcontent, bwriter );
        // 3. 결과에 따른 출력하기
        if ( result ){
            System.out.println("[안내] 게시물 작성 성공");
        }else {
            System.out.println("[안내] 게시물 작성 실패");
        } // if end
    } // func end




} // class end
