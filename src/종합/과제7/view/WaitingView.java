package 종합.과제7.view;

import 종합.과제7.controller.WaitingController;
import 종합.과제7.model.dto.WaitingDto;

import java.util.ArrayList;
import java.util.Scanner;

public class WaitingView {
    // 싱글톤 만들기
    private WaitingView(){}
    private static final WaitingView instance = new WaitingView();
    public static WaitingView getInstance() {
        return instance;
    } // func end

    // controller에 접근하기 위해 controller 싱글톤에 접근
    WaitingController waitingController = WaitingController.getInstance();

    // 입력 객체 생성
    Scanner scan = new Scanner(System.in);

    // 1. 메인화면
    public void index(){
        for ( ; ; ){
            System.out.println("=========== 맛집 대기 시스템 ===========");
            System.out.println("       1.대기 등록 | 2.대기 현황");
            System.out.println("=====================================");
            System.out.print("선택 : ");          int option = scan.nextInt();
            if ( option == 1 ){
                waitingRegis();
            }else if ( option == 2 ){
                waitingPrint();
            } // if end
        } // 무한루프 end
    } // func end

    // 2. 등록화면
    public void waitingRegis(){
        System.out.print("전화번호 : ");        String phone = scan.next();
        System.out.print("인원수 : ");          int count = scan.nextInt();
        boolean result = waitingController.waitingRegis( phone, count );
        if ( result ){
            System.out.println("[안내] 대기 등록이 완료되었습니다.");
        } else {
            System.out.println("[안내] 대기 등록에 실패하였습니다.");
        } // if end
    } // func end

    // 3. 대기명단 출력화면
    public void waitingPrint(){
        System.out.println("============= 대기 현황 =============");
        ArrayList<WaitingDto> waitingDB = waitingController.waitingPrint();
        for ( WaitingDto waitingDto : waitingDB ){
            System.out.printf("연락처 : %s - 인원 : %d\n", waitingDto.getPhone(), waitingDto.getCount());
            System.out.println("------------------------------------");
        } // for end
    } // func end
} // class end
