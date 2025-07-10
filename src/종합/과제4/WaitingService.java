package 종합.과제4;

import java.util.Scanner;

public class WaitingService { // WaitingService class start
    public static void main(String[] args) { // main start
        for( ; ; ){
            // 반복되는 안내문 출력
            System.out.println("=========== 맛집 대기 시스템 ===========");
            System.out.println("       1.대기 등록 | 2.대기 현황");
            System.out.println("======================================");
            // Scanner를 통해 입력값 받기
            Scanner scan = new Scanner(System.in);
            System.out.print("입력 : ");      int option = scan.nextInt();
            // 입력값에 따른 출력
            if ( option == 1 ){         // 1을 선택하면
                // 전화번호와 인원수 입력받기
                System.out.print("전화번호 : ");        String phone = scan.next();
                System.out.print("인원수 : ");          int count = scan.nextInt();
                // static으로 생성하여, 객체를 생성하지 않아도 클래스명.메소드명()으로 접근 가능
                boolean result = WaitingController.addWaiting( phone, count);
                if ( result ){  // 저장에 성공했다면
                    System.out.println("[안내] 대기 등록이 완료되었습니다.");
                }else {         // 저장에 실패했다면
                    System.out.println("[경고] 대기 등록에 실패하였습니다.");
                }
            }else if ( option == 2 ){   // 2를 선택하면
                // 기본적인 출력문 출력
                System.out.println("============== 대기 현황 ==============");
                // static으로 생성하여, 객체를 생성하지 않아도 접근 가능
                Waiting[] waitings = WaitingController.getWaitingList();
                for ( int i = 0; i < waitings.length; i++){     // 배열 순회하고
                    Waiting waiting = waitings[i];
                    if ( waiting != null ){                     // 저장된 대기 찾으면 출력
                        // waiting.phone 으로 접근 불가능 -> private로 선언돼서
                        System.out.printf("%d. 연락처 : %s - 인원 : %d명\n", i+1, waiting.getPhone(), waiting.getCount());
                        System.out.println("------------------------------------");
                    } // if end
                } // for end
            } // if end
        } // 무한루프 end
    } // main end
} // WaitingService class end
