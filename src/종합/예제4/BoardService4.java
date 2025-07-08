package 종합.예제4;

import java.util.Scanner;

public class BoardService4 { // BoardService4 class start
    public static void main(String[] args) { // main start

        BoardController bc = new BoardController();     // BoardController 객체 생성

        for( ; ; ){ // 무한루프 start
            // 반복적인 메뉴 출력
            System.out.println("============= My Community =============");
            System.out.println("        1.게시물쓰기 | 2.게시물출력");
            System.out.println("========================================");
            System.out.print("선택 : ");
            Scanner scan = new Scanner(System.in);      // Scanner로 입력받고
            int option = scan.nextInt();                // 입력받은 값을 option에 저장
            // 입력에 따른 화면 출력
            if ( option == 1 ){         // 1을 선택했을 때
                // 내용과 작성자 입력받기
                System.out.print("내용 : ");      String content = scan.next();
                System.out.print("작성자 : ");     String writer = scan.next();
                // doPost() 메소드 호출하면서, 입력받은 값을 전달
                boolean result = bc.doPost( content, writer );
                if ( result ){                              // true면
                    System.out.println("[안내] 등록 성공");   // 등록 성공
                }else {                                     // false면
                    System.out.println("[경고] 등록 실패");   // 등록 실패
                }
            }else if ( option == 2 ){   // 2를 선택했을 때
                Board[] boards = bc.doGet();                // doGet() 메소드를 호출하면서, boards 배열 반환받기
                System.out.println("============= 게시물 목록 =============");
                for ( int i = 0; i < boards.length; i++ ){  // 반환받은 배열을 순회하면서
                    if ( boards[i] != null ){               // null이 아닌 요소를 발견하면
                        System.out.printf("작성자 : %s\n", boards[i].writer);
                        System.out.printf("내용 : %s\n", boards[i].content);
                        System.out.println("------------------------------------");
                    } // if end
                } // for end
            }else { // 유효성 검사
                System.out.println("[경고] 잘못된 선택입니다. 다시 선택해주세요.");
            }
        } // 무한루프 end




    } // main end
} // BoardService4 class end
