package 종합.예제5;

import java.util.Scanner;

public class BoardService5 { // BoardService5 class start
    public static void main(String[] args) { // main start

        // BoardController 객체 생성 -> 클래스 내 메소드를 호출하기 위해서
        BoardController bc = new BoardController();

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
                boolean result = bc.doPost( content, writer );      // BoardController 클래스 내 메소드를 이용하여 배열에 저장
                if ( result ){
                    System.out.println("[안내] 글쓰기 성공");
                }else {
                    System.out.println("[경고] 글쓰기 실패");
                }
            }else {
                System.out.println("============= 게시물 목록 =============");
                Board[] boards = bc.doGet();
                for ( int i = 0; i < boards.length; i++){
                    if ( boards[i] != null ){
                        System.out.printf("작성자 : %s\n", boards[i].writer);
                        System.out.printf("내용 : %s\n", boards[i].content);
                        System.out.println("------------------------------------");
                    }
                }
            } // if end
        } // 무한루프 end
    } // main end
} // BoardService5 class end