package 종합.과제7;

import 종합.과제7.controller.WaitingController;
import 종합.과제7.model.dto.WaitingDto;
import 종합.과제7.view.WaitingView;

import java.util.ArrayList;

public class AppStart {
    public static void main(String[] args) {

//        // view없이 테스트해보기
//        boolean result1 = WaitingController.getInstance().waitingRegis("010-1111-2222", 5 );
//        System.out.println( result1 );
//
//        ArrayList<WaitingDto> result2 = WaitingController.getInstance().waitingPrint();
//        System.out.println( result2 );

        WaitingView.getInstance().index();

    } // main end
} // class end
