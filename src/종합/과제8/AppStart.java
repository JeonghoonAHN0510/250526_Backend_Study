package 종합.과제8;

import 종합.과제8.controller.WaitingController;
import 종합.과제8.model.dao.WaitingDao;
import 종합.과제8.model.dto.WaitingDto;
import 종합.과제8.view.WaitingView;

import java.util.ArrayList;

public class AppStart {
    public static void main(String[] args) {

        // [ VIEW 없이 테스트 ]
        // * 등록 기능 테스트
        // boolean test = WaitingController.getInstance().waitingRegis("010-9999-9999", 99 );
        // System.out.println( test );

        // * 전체조회 기능 테스트
        // ArrayList<WaitingDto> list = WaitingController.getInstance().waitingList();
        // System.out.println( list );

        // * 삭제 기능 테스트
        // boolean test = WaitingController.getInstance().waitingDelete( 42 );
        // System.out.println( test );

        // * 수정 기능 테스트
        // boolean test = WaitingController.getInstance().waitingUpdate( 40, 40 );
        // System.out.println( test );

        // 메인화면 연동
        WaitingView.getInstance().mainPrint();

    } // main end
} // class end
