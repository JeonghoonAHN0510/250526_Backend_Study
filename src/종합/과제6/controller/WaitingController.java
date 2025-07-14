package 종합.과제6.controller;

import 종합.과제6.model.dao.WaitingDao;
import 종합.과제6.model.dto.WaitingDto;

import java.util.ArrayList;

public class WaitingController {
    // 1. 싱글톤 만들기
    private WaitingController(){}
    private static final WaitingController controller = new WaitingController();
    public static WaitingController getInstance() {
        return controller;
    }

    // 2. dao 싱글톤 가져오기
    WaitingDao dao = WaitingDao.getInstance();

    // 3. 등록기능 메소드
    // 메소드명 : waitingRegis
    // 매개변수 : String phone, int count
    // 반환값 : true/false -> boolean
    public boolean waitingRegis( String phone, int count ){
        // 초기 반환값 설정
        boolean result = false;
        // view로부터 값을 받아, dao에게 값 전달 후, 결과 반환받기
        result = dao.waitingRegis( phone, count);
        // 최종 결과괎 반환
        return result;
    } // func end

    // 4. 등록현황 출력 메소드
    // 메소드명 : waitingPrint
    // 매개변수 : X
    // 반환값 : waitingList -> ArrayList<WaitingDto>
    public ArrayList<WaitingDto> waitingPrint (){
        return dao.waitingPrint();
    } // func end
} // class end
