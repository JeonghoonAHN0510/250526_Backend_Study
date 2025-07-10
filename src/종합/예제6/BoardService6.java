package 종합.예제6;

import java.util.Scanner;

public class BoardService6 { // BoardService5 class start
    public static void main(String[] args) { // main start
        // static으로 구성된 메소드는 객체 생성을 안 해도 된다.
        // -> 클래스명.메소드()로 접근 가능

        for ( ; ; ){ // 무한루프 start
            // 반복적인 메뉴 출력
            System.out.println("============= My Community =============");
            System.out.println("        1.게시물쓰기 | 2.게시물출력");
            System.out.println("========================================");
            System.out.print("선택 : ");
            Scanner scan = new Scanner(System.in);                  // Scanner로 입력받고
            int option = scan.nextInt();                            // 입력받은 값을 option에 저장
            if ( option == 1 ){ // if start
                // 내용과 작성자 입력받기
                System.out.print("내용 : ");       String content = scan.next();
                System.out.print("작성자 : ");     String writer = scan.next();
                // 클래스명.static메소드명(); 으로 접근 가능
                boolean result = BoardController.doPost( content, writer );
                if ( result ){
                    System.out.println("[안내] 글쓰기 성공");
                }else {
                    System.out.println("[경고] 글쓰기 실패");
                }

            }else if ( option == 2 ) {
                System.out.println("============= 게시물 목록 =============");
                Board[] boards = BoardController.doGet();
                for ( int i = 0; i < boards.length; i++){
                    Board board = boards[i];
                    if ( board != null ){
                        // board.content : 불가능 -> private로 선언됐기 때문에 -> getter 메소드를 통해 접근
                        System.out.println("작성자 : " + board.getWriter());
                        System.out.println("내용 : " + board.getContent());
                        System.out.println("------------------------------------");
                    } // if end
                } // for end
            } // if end
        } // 무한루프 end
    } // main end
} // BoardService5 class end