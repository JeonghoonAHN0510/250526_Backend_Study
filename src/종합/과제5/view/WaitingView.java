package 종합.과제5.view;

import 종합.과제5.controller.WaitingController;
import 종합.과제5.model.dto.WaitingDto;

import java.util.Scanner;

public class WaitingView {
    // 싱글톤 만들기
    private WaitingView(){}
    private static final WaitingView view = new WaitingView();
    public static WaitingView getInstance() {
        return view;
    } // func end

    // Scanner 객체 만들기 -> 멤버변수는 private
    private Scanner scan = new Scanner(System.in);

    // WaitingController 객체 만들기 -> 멤버변수는 private
    private WaitingController controller = WaitingController.getInstance();

    // 메인 view 생성
    public void view(){
        for ( ; ; ){
            // 반복되는 안내문 출력
            System.out.println("=========== 맛집 대기 시스템 ===========");
            System.out.println("       1.대기 등록 | 2.대기 현황");
            System.out.println("======================================");
            System.out.print("입력 : ");      int option = scan.nextInt();
            if ( option == 1 ){
                option1();
            }else if ( option == 2 ){
                option2();
            } // if end
        } // for end
    } // func end
    public void option1(){
        System.out.print("전화번호 : ");        String phone = scan.next();
        System.out.print("인원수 : ");          int count = scan.nextInt();
        // 입력받은 값을 controller에게 전달 후 결과 저장
        boolean result = controller.waitingRegis( phone, count);
        if ( result ){
            System.out.println("[안내] 대기 등록이 완료되었습니다.");
        }else {
            System.out.println("[경고] 대기 등록에 실패하였습니다.");
        }
    }
    public void option2(){
        System.out.println("============== 대기 현황 ==============");
        // controller를 통해 배열 받기
        WaitingDto[] waitings = controller.waitingPrint();
        for ( int i = 0; i < waitings.length; i++){
            if ( waitings[i] != null ){
                System.out.printf("%d. 연락처 : %s - 인원 : %d명\n",  i + 1, waitings[i].getPhone(), waitings[i].getCount() );
                System.out.println("------------------------------------");
            } // if end
        } // for end
    }



} // class end
