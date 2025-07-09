package 종합.예제5;

import java.util.Scanner;

public class BoardService5 { // BoardService5 class start
    public static void main(String[] args) { // main start

        for ( ; ; ){ // 무한루프 start
            // 반복적인 메뉴 출력
            System.out.println("============= My Community =============");
            System.out.println("        1.게시물쓰기 | 2.게시물출력");
            System.out.println("========================================");
            System.out.print("선택 : ");
            Scanner scan = new Scanner(System.in);      // Scanner로 입력받고
            int option = scan.nextInt();                // 입력받은 값을 option에 저장
            if ( option == 1 ){ // if start
                // 내용과 작성자 입력받기
                System.out.print("내용 : ");       String content = scan.next();
                System.out.print("작성자 : ");     String writer = scan.next();
            }else {
                System.out.println("============= 게시물 목록 =============");
            } // if end
        } // 무한루프 end
    } // main end
} // BoardService5 class end
