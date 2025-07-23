package 종합.과제8.view;

import 종합.과제8.controller.WaitingController;
import 종합.과제8.model.dto.WaitingDto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WaitingView {
    // 싱글톤 만들기
    private WaitingView(){}
    private static final WaitingView instance = new WaitingView();
    public static WaitingView getInstance() {
        return instance;
    } // func end

    // 입력 객체 생성
    Scanner scan = new Scanner(System.in);

    // controller 싱글톤 가져오기
    WaitingController waitingController = WaitingController.getInstance();

    // 0. 메인화면 구현
    public void mainPrint(){
        for( ; ; ){
            try {
                System.out.println("==================== 대기 시스템 ============================");
                System.out.println("      1. 등록 | 2. 전체조회 | 3. 취소 | 4. 수정");
                System.out.println("===========================================================");
                System.out.print("선택 : ");          int choose = scan.nextInt();
                if (choose == 1) {              // 등록을 선택하면
                    regisPrint();
                }else if ( choose == 2 ){       // 전체조회를 선택하면
                    waitingPrint();
                }else if ( choose == 3 ){       // 취소를 선택하면
                    deletePrint();
                }else if ( choose == 4 ){       // 수정을 선택하면
                    updatePrint();
                }else {                     // 다른 번호를 입력하면
                    System.out.println("[경고] 존재하지 않는 번호입니다.");
                } // if end
            } catch ( InputMismatchException e ){                                       // int가 아닌 다른 타입이 입력되면
                System.out.println("[경고] 관리자에게 문의하세요. <admin@admin.admin>");     // 경고문 출력
                scan = new Scanner(System.in);                                          // 잘못된 입력이기에 입력객체 초기화
            } // try-catch end
        } // 무한루프 end
    } // func end

    // 1. 등록 화면 구현 : 등록을 선택했을 때, 실행
    public void regisPrint(){
        // 1. 사용자로부터 입력 받기
        System.out.print("전화번호 : ");        String wphone = scan.next();
        System.out.print("대기인원 : ");        int wcount = scan.nextInt();
        // 2. controller에게 전달하고 결과 받기
        boolean result = waitingController.waitingRegis( wphone, wcount );
        // 3. 결과에 따른 출력하기
        if ( result ){
            System.out.println("[안내] 대기 등록 성공");
        }else {
            System.out.println("[경고] 대기 등록 실패");
        } // if end
    } // func end

    // 2. 전체조회 화면 구현 : 전체조회를 선택했을 때, 실행
    public void waitingPrint(){
        System.out.println("===========================================================");
        // 1. controller에게 전달하고 결과 받기
        ArrayList<WaitingDto> result = waitingController.waitingList();
        // 2. 받은 결과를 순회하여 전체 출력하기
        for ( WaitingDto waitingDto : result ){
            System.out.printf("대기번호 : %d \t 전화번호 : %s \t 대기인원 : %d명\n", waitingDto.getWno(), waitingDto.getWphone(), waitingDto.getWcount() );
            System.out.println("===========================================================");
        } // for end
    } // func end

    // 3. 취소 화면 구현 : 취소를 선택했을 때, 실행
    public void deletePrint(){
        // 1. 사용자로부터 입력받기
        System.out.print("취소할 대기번호 : ");         int wno = scan.nextInt();
        // 2. controller에게 전달하고 결과 받기
        boolean result = waitingController.waitingDelete( wno );
        // 3. 결과에 따른 출력하기
        if ( result ){
            System.out.println("[안내] 취소 성공");
        }else {
            System.out.println("[경고] 취소 실패");
        } // if end
    } // func end

    // 4. 수정 화면 구현 : 수정을 선택했을 때, 실행
    public void updatePrint(){
        // 1. 사용자로부터 입력받기
        System.out.print("수정할 대기번호 : ");         int wno = scan.nextInt();
        System.out.print("수정할 인원수 : ");           int wcount = scan.nextInt();
        // 2. controller에게 전달하고 결과 받기
        boolean result = waitingController.waitingUpdate( wno, wcount );
        // 3. 결과에 따른 출력하기
        if ( result ){
            System.out.println("[안내] 수정 성공");
        }else {
            System.out.println("[경고] 수정 실패");
        } // if end
    } // func end
} // class end
