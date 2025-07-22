package 종합.과제7.controller;

import 종합.과제7.model.dao.WaitingDao;
import 종합.과제7.model.dto.WaitingDto;

import java.util.ArrayList;

public class WaitingController {
    // 싱글톤 만들기
    private WaitingController(){}
    private static final WaitingController instance = new WaitingController();
    public static WaitingController getInstance() {
        return instance;
    } // func end

    // dao에 접근하기 위해서 dao 싱글톤에 접근
    WaitingDao waitingDao = WaitingDao.getInstance();

    // 1. 대기등록 메소드
    // 메소드명 : waitingRegis
    // 매개변수 : String phone, int count
    // 반환값 : boolean
    public boolean waitingRegis( String phone, int count ){
        // 1) 입력받은 값을 dto 객체로 만들기
        WaitingDto waitingDto = new WaitingDto( phone, count );
        // 2) 생성한 객체를 dao에게 전달하고, 결과를 받아 view에게 전달
        boolean result = waitingDao.waitingRegis( waitingDto );
        // 3) 결과 리턴
        return result;
    } // func end

    // 2. 대기현황 출력 메소드
    // 메소드명 : waitingPrint
    // 매개변수 : X
    // 반환값 : waitingDB -> ArrayList<WaitingDto>
    public ArrayList<WaitingDto> waitingPrint(){
        // 1) dao로부터 결과를 받아 view에게 전달
        ArrayList<WaitingDto> result = waitingDao.waitingPrint();
        return result;
    } // func end
} // class end
