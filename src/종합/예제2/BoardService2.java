package 종합.예제2;

import java.util.Scanner;

public class BoardService2 { // class start
    public static void main(String[] args) { // main start

        // 메모리 설계
        // BoardService1에서는 총 게시물 3개 저장     , 변수
        // BoardService2에서는 총 게시물 100개 저장   , 변수 + 배열
        String[] contents = new String[100];        // 문자열(String) 총 100개를 저장할 수 있는 배열 선언
        String[] writers = new String[100];         // 문자열(String) 총 100개를 저장할 수 있는 배열 선언
        for ( ; ; ){                // 무한루프 시작
            Scanner scan = new Scanner(System.in);
            System.out.println("============= My Community =============");
            System.out.println("        1.게시물쓰기 | 2.게시물출력");
            System.out.println("========================================");
            System.out.print("선택 : ");      // 기본 반복 출력
            int option = scan.nextInt();
            if ( option == 1 ){ // if1 start , 1번 선택하면
                System.out.print("내용 : ");
                String content = scan.next();
                System.out.print("작성자 : ");
                String writer = scan.next();        // 내용과 작성자를 입력받고
                int count = 0;                      // 글쓰기성공 : 1, 공간부족 : 0 -> boolean으로 하는 것이 좋을 것 같다.
                for ( int i = 0; i < contents.length; i++ ){    // 인덱스가 필요하므로, 향상된 for문 X
                    if ( contents[i] == null ){     // null인 공간을 찾으면
                        contents[i] = content;      // 입력받은 내용과 작성자를 저장하고
                        writers[i] = writer;
                        System.out.println("[안내] 글쓰기 성공");
                        count = 1;                  // count 변경
                        break;
                    }
                }
                if ( count == 0 ){                  // count가 0이면(= 글쓰기를 성공 못했다면 = 글쓰기 공간이 부족하다면)
                    System.out.println("[경고] 게시물을 등록할 공간이 부족합니다.");
                }
            } else if ( option == 2 ){ // if2 start, 2번을 선택했다면
                System.out.println("============= 게시물 목록 =============");
                for ( int i = 0; i < contents.length; i++){
                    if ( contents[i] != null ){                         // i번째 공간이 null이 아니면(= 입력된 값이 있다면)
                        System.out.printf("작성자 : %s\n", writers[i]);  // 입력된 작성자 출력
                        System.out.printf("내용 : %s\n", contents[i]);   // 입력된 내용 출력
                        System.out.println("------------------------------------");
                    } else {        // null인 공간이 나오면(= 입력된 값이 없다면)
                        break;      // 반복문 종료
                    }
                }
            } else { // option이 1도 2도 아니면(= 입력값이 잘못됐다면)
                System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        } // 무한루프 종료
    } // main end
} // class end
