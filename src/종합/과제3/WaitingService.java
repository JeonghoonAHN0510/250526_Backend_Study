package 종합.과제3;

import java.util.Scanner;

public class WaitingService { // WaitingService class start
    public static void main(String[] args) { // main start
        WaitingController controller = new WaitingController();     // WaitingController 객체 생성
        for ( ; ; ){ // 무한루프 start
            // 중복 출력문
            System.out.println("=========== 맛집 대기 시스템 ===========");
            System.out.println("       1.대기 등록 | 2.대기 현황");
            System.out.println("======================================");
            System.out.print("선택 : ");
            Scanner scan = new Scanner(System.in);                  // Scanner로 입력받기
            int option = scan.nextInt();                            // 입력받은 값을 option에 저장
            if ( option == 1 ){         // 1을 입력한다면
                // 사용자로부터 전화번호와 인원수 입력받고 변수에 저장하기
                System.out.print("전화번호 : ");    String phone = scan.next();
                System.out.print("인원수 : ");      int count = scan.nextInt();
                // addWaiting() 메소드를 호출하면서, 입력받은 값들을 인자로 전달
                boolean result = controller.addWaiting( phone, count );
                if ( result ){ System.out.println("[안내] 대기 등록이 완료되었습니다."); }    // true면 등록 완료
                else { System.out.println("[경고] 더 이상 대기 등록을 할 수 없습니다."); }     // false면 등록 실패
            }else if ( option == 2 ){   // 2를 입력한다면
                // 기본적인 출력문 출력
                System.out.println("============= 대기 현황 =============");
                Waiting[] waitings = controller.getWaitingList();   // getWaitingList() 메소드 호출하여 배열 반환받기
                for ( int i = 0; i < waitings.length; i++){         // waitings 배열을 순회하면서
                    if ( waitings[i] != null ){                     // null이 아닌 값을 발견하면
                        System.out.printf("%d. 연락처 : %s - 인원 : %d명\n", i+1, waitings[i].phone, waitings[i].count);
                        System.out.println("------------------------------------");
                    }
                }
            }else {                     // 유효성 검사
                System.out.println("[경고] 잘못된 선택입니다. 다시 입력해주세요");
            }
        } // 무한루프 end
    } // main end
} // WaitingService class end
