package 종합.과제2;

import java.util.Scanner;

public class 종합과제2 { // 종합과제2 class start
    public static void main(String[] args) { // main start
        Waiting[] waitings = new Waiting[100];
        for ( ; ; ){ // 무한루프 start
            // 사용자에게 메뉴를 보여주고
            System.out.println("=========== 맛집 대기 시스템 ===========");
            System.out.println("       1.대기 등록 | 2.대기 현황");
            System.out.println("======================================");
            // Scanner를 통해 원하는 기능의 번호를 입력받기
            Scanner scan = new Scanner(System.in);
            System.out.print("선택 : ");  int option = scan.nextInt();
            if ( option == 1 ){         // 입력값이 1이라면
                // 전화번호와 인원수를 입력받기
                System.out.print("전화번호 : ");    String number = scan.next();
                System.out.print("인원수 : ");      int count = scan.nextInt();
                // Waiting 객체를 생성하여
                Waiting waiting = new Waiting();
                // 입력받은 값을 각 멤버변수에 대입
                waiting.number = number;    waiting.count = count;
                // 상태확인 변수 선언
                boolean check = false;      // true : 예약 성공     false : 예약 실패
                // 배열에서 빈공간 찾기
                for ( int i = 0; i < waitings.length; i++){     // waitings 배열 순회
                    if ( waitings[i] == null ){                 // i번째 waitings가 비어있다면
                        waitings[i] = waiting;
                        check = true;
                        break;
                    }
                }
                if ( check ){
                    System.out.println("[안내] 대기 등록이 완료되었습니다.");
                }else{
                    System.out.println("[경고] 더 이상 대기 등록을 할 수 없습니다.");
                }
            }else if ( option == 2 ){   // 입력값이 2라면
                System.out.println("============= 대기 현황 =============");
                // 비어있지 않은 공간 찾기
                for ( int i = 0; i < waitings.length; i++){     // waitings 배열 순회
                    if ( waitings[i] != null ){                 // i번째 waitings가 null이 아니라면
                        System.out.printf("%d. 연락처 : %s - 인원 : %d명\n", i+1, waitings[i].number, waitings[i].count);
                        System.out.println("------------------------------------");
                    }
                }
            }else {                     // 입력값이 1도 2도 아니면
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        } // 무한루프 end
    } // main end
} // 종합과제2 class end
