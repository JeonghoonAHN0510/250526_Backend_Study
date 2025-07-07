package 종합.예제3;

import java.util.Scanner;

public class BoardService3 { // BoardService3 class start
    public static void main(String[] args) { // main start
        // Board[] 배열 변수 선언 -> 다양한 속성을 하나의 클래스로 설계하자.
        Board[] boards = new Board[100];        // boards 변수에 Board객체 100개를 저장 가능한 배열 자료 생성
        for ( int i = 0; i < boards.length; i++){
            boards[i] = new Board();            // i번째 boards 초기화
        }
        for ( ; ; ){ // 무한루프 start
            // Scanner를 객체에 저장
            Scanner scan = new Scanner(System.in);
            // 반복적인 문구 출력
            System.out.println("============= My Community =============");
            System.out.println("        1.게시물쓰기 | 2.게시물출력");
            System.out.println("========================================");
            System.out.print("선택 : ");
            int option = scan.nextInt(); // 입력받은 값을 option에 저장
            if ( option == 1 ){         // 1을 선택하면
                // 내용과 작성자를 입력받기
                System.out.print("내용 : ");  String content = scan.next();
                System.out.print("작성자 : "); String writer = scan.next();
                // 빈 공간 찾기
                boolean check = false;      // false : 출력 실패, true : 출력 성공
                for ( int i = 0; i < boards.length; i++){   // boards 배열 순회
                    if ( boards[i].content == null ){       // i번째 boards의 content가 null이라면
                        boards[i].content = content;
                        boards[i].writer = writer;          // 비어있는 곳에 입력받은 값을 저장하고
                        check = true;                       // 체크 바꾸기
                        break;
                    }
                }
                if ( check ){
                    System.out.println("[안내] 글쓰기 성공");
                }else {
                    System.out.println("[경고] 게시물을 등록할 공간이 부족합니다.");
                }
            }else if ( option == 2 ){   // 2를 선택하면
                System.out.println("============= 게시물 목록 =============");   // 기본 출력문 출력
                for( int i = 0; i < boards.length; i++){    // boards 순회
                    if ( boards[i].content != null ){       // i번째 boards의 content가 null이 아니면
                        // 작성자 및 내용 출력
                        System.out.printf("작성자 : %s\n", boards[i].writer);
                        System.out.printf("내용 : %s\n", boards[i].content);
                        System.out.println("------------------------------------");
                    }
                }
            }else {                     // 1도 2도 아니면
                System.out.println("잘못된 선택입니다. 다시 입력해주세요.");
            }
        } // 무한루프 end
    } // main end
} // BoardService3 class end
