package 종합.과제6.view;

import 종합.과제6.controller.WaitingController;
import 종합.과제6.model.dto.WaitingDto;

import java.util.ArrayList;
import java.util.Scanner;

public class WaitingView {
    // 1. 싱글톤 만들기
    private WaitingView(){}
    private static final WaitingView view = new WaitingView();
    public static WaitingView getInstance() {
        return view;
    }

    // 2. controller 싱글톤 가져오기
    WaitingController controller = WaitingController.getInstance();

    // Scanner 객체 생성
    Scanner scan = new Scanner(System.in);

    // 3. 등록 입출력 구현 - waitingRegis
    public void waitingRegis(){
        // 사용자로부터 입력받기
        System.out.print("전화번호 : ");    String phone = scan.next();
        System.out.print("인원수 : ");      int count = scan.nextInt();
        // 입력값에 따른 결과값 받기
        boolean result = controller.waitingRegis( phone, count );
        // 결과값에 따른 출력
        if ( result ){  // 등록을 성공한다면
            System.out.println("[안내] 대기 등록이 완료되었습니다.");
        }else {         // 등록을 실패한다면
            System.out.println("[경고] 대기 등록이 실패하였습니다.");
        } // if end
    } // func end

    // 4. 등록현황 전체 출력 구현 - waitingPrint
    // 반환값 : waitingList -> ArrayList<WaitingDto>
    public void waitingPrint(){
        System.out.println("============= 대기 현황 =============");
        ArrayList<WaitingDto> waitingList = controller.waitingPrint();
        for ( int i = 0; i < waitingList.size(); i++){
            WaitingDto waiting = waitingList.get(i);
            System.out.printf("%d. 연락처 : %s - 인원 : %d명\n", i + 1, waiting.getPhone(), waiting.getCount());
        } // for end
    } // func end

    // 5. 메인화면 구현
    public void index(){
        for ( ; ; ){ // 무한루프 시작
            // 반복적인 메인화면 출력
            System.out.println("=========== 맛집 대기 시스템 ===========");
            System.out.println("       1.대기 등록 | 2.대기 현황");
            System.out.println("======================================");
            // 사용자로부터 선택받기
            System.out.print("선택 : ");      int option = scan.nextInt();
            // 선택에 따른 출력
            if ( option == 1 ){         // 1을 선택하면
                waitingRegis();         // 등록 메소드
            }else if ( option == 2 ){   // 2를 선택하면
                waitingPrint();         // 출력 메소드
            } // if end
        } // 무한루프 end
    } // func end
} // class end
