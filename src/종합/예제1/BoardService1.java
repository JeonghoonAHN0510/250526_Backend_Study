package 종합.예제1;

import java.util.Scanner;

public class BoardService1 { // class start
    public static void main(String[] args) { // main start
        // step1 : 반복적인 메인 화면 출력
        // step2 : 입력에 따른 화면 출력
        // step3 : 기능별 필요한 메모리 설계
        // step4 : 각 기능별 세부 코드 구현
        String content1 = null;      String writer1 = null;
        String content2 = null;      String writer2 = null;
        String content3 = null;      String writer3 = null;
        // 이것들 왜 밖에서 선언? 무한루프 안에서 선언하면 계속 초기화돼서 출력이 안 됨.
       for ( ; ; ){ // 무한루프 시작
           // Scanner를 통해 입력값 받기
           Scanner scan = new Scanner(System.in);
           // 반복적인 메인 화면 출력
           System.out.println("============= My Community =============");
           System.out.println("        1.게시물쓰기 | 2.게시물출력");
           System.out.println("========================================");
           System.out.print("선택 : ");
           int option = scan.nextInt();
           if ( option == 1 ){  // 입력값이 1이라면
               System.out.print("내용 : ");
               String content = scan.next();                          // 내용 입력값을 content에 저장
               System.out.print("작성자 : ");
               String writer = scan.next();                           // 작성자 입력값을 writer에 저장
               if ( content1 == null && writer1 == null ){          // content1과 writer1이 비어있으면
                   content1 = content; writer1 = writer;
                   System.out.println("[안내] 글쓰기 성공");
               }else if ( content2 == null && writer2 == null ){    // content2와 writer2이 비어있으면
                   content2 = content; writer2 = writer;
                   System.out.println("[안내] 글쓰기 성공");
               }else if ( content3 == null && writer3 == null ){    // content3과 writer3이 비어있으면
                   content3 = content; writer3 = writer;
                   System.out.println("[안내] 글쓰기 성공");
               }else {                                              // 비어있는 공간이 없다면
                   System.out.println("[경고] 게시물을 등록할 공간이 부족합니다.");  // 경고문 출력
               }
           }else if ( option == 2 ){    // 입력값이 2라면
               System.out.println("============= 게시물 목록 =============");    // 반복 화면 출력
               // 왜 if ~ else if 안씀?? 출력값이 여러개니깐 if if if로 가야함
               if ( content1 != null ){                                         // content1에 값이 있다면
                   // (writer1은 안 봐도 괜찮음 / 왜? content1에 값이 있다는 것은 writer1도 당연히 있을 것이기 때문에
                   // 정확하게 하려면 content1 != null || writer1 != null 해도 될 듯( 위 content1 == null && writer1 == null 과 똑같음 )
                   System.out.printf("작성자 : %s\n", writer1);                 // writer1 출력
                   System.out.printf("내용 : %s\n", content1);                  // content1 출력
                   System.out.println("------------------------------------");
               }
               if ( content2 != null ){                                         // content2에 값이 있다면
                   System.out.printf("작성자 : %s\n", writer2);                  // writer2 출력
                   System.out.printf("내용 : %s\n", content2);                   // content2 출력
                   System.out.println("------------------------------------");
               }
               if ( content3 != null ){                                         // content3에 값이 있다면
                   System.out.printf("작성자 : %s\n", writer3);                  // writer3 출력
                   System.out.printf("내용 : %s\n", content3);                   // content3 출력
                   System.out.println("------------------------------------");
               }
               if ( content1 == null && content2 == null && content3 == null ){ // 다 null이라면
                   System.out.println("[경고] 출력할 게시물이 없습니다.");                 // 출력할 게시물이 없으므로, 경고문 출력
               }
           }else {                                                              // 입력값이 1도 2도 아니면
               System.out.println("[경고] 잘못된 선택입니다.");                           // 경고문 출력
           } // if 끝
       } // 무한루프 끝
    } // main end
} // class end

