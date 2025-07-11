package 종합.예제7.view;

import java.util.Scanner;

// View의 역할 : 게시판 관련 입출력 클래스

public class BoardView { // class start
    // 싱글톤으로 만들기
    // 1단계 : 기본 생성자를 private로 선언한다
    private BoardView(){}
    // 2단계 : private static final로 객체를 생성한다.
    private static final BoardView view = new BoardView();
    // 3단계 : getInstance 메소드를 선언한다.
    public static BoardView getInstance() {
        return view;
    }

    // * 여러 메소드에서 사용할 입력 객체를 '멤버변수'로 선언
    private Scanner scan = new Scanner(System.in);
    // 1. 메인 view 생성 : 최초로 보이는 화면
    public void index(){
        for( ; ; ){
            System.out.println("============= My Community =============");
            System.out.println("        1.게시물쓰기 | 2.게시물출력");
            System.out.println("========================================");
            System.out.print("선택 : ");       int option = scan.nextInt();
            if ( option == 1 ){
                boardWrite();
            }else if ( option == 2 ){
                boardPrint();
            }
        }
    }
    // 2. 등록 view 생성
    public void boardWrite(){
        System.out.print("내용 : ");      String content = scan.next();
        System.out.print("작성자 : ");     String writer = scan.next();
        System.out.println("[안내] 글쓰기 성공");
    }
    // 3. 조회 view 생성
    private void boardPrint(){
        System.out.println("============= 게시물 목록 =============");
        System.out.println("작성자 : ");
        System.out.println("내용 : ");
        System.out.println("------------------------------------");
    }
} // class end
