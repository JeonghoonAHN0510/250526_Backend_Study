package 종합.과제8.controller;

import 종합.과제8.model.dao.WaitingDao;
import 종합.과제8.model.dto.WaitingDto;

import java.util.ArrayList;

public class WaitingController {
    // 싱글톤 만들기
    private WaitingController(){}
    private static final WaitingController instance = new WaitingController();
    public static WaitingController getInstance() {
        return instance;
    } // func end

    // dao 싱글톤 가져오기
    WaitingDao waitingDao = WaitingDao.getInstance();


    // 1. 대기 등록 기능
    // 메소드명 : waitingRegis
    // 매개변수 : String wphone, int wcount
    // 반환값 : true(성공)/false(실패) -> boolean
    public boolean waitingRegis ( String wphone, int wcount ){
        // 1. 유효성 검사

        // 2. 객체 생성
        WaitingDto waitingDto = new WaitingDto( wphone, wcount );
        // 3. 객체를 dao에게 전달 후, 결과 받기
        boolean result = waitingDao.waitingRegis( waitingDto );
        // 4. 결과를 view에게 전달
        return result;
    } // func end

    // 2. 대기현황 조회 기능
    // 메소드명 : waitingList
    // 매개변수 : X
    // 반환값 : ArrayList<WaitingDto>
    public ArrayList<WaitingDto> waitingList(){
        // 1. 유효성 검사

        // 2. 객체 생성

        // 3. dao에게 전달 후, 결과 받기
        ArrayList<WaitingDto> result = waitingDao.waitingList();
        // 4. 결과를 view에게 전달
        return result;
    } // func end

    // 3. 대기 삭제 기능
    // 메소드명 : waitingDelete
    // 매개변수 : int wno
    // 반환값 : true(성공)/false(실패) -> boolean
    public boolean waitingDelete( int wno ){
        // 1. 유효성 검사

        // 2. 객체 생성

        // 3. dao에게 전달 후, 결과 받기
        boolean result = waitingDao.waitingDelete( wno );
        // 4. 결과를 view에게 전달
        return result;
    } // func end

    // 4. 대기 수정 기능
    // 메소드명 : waitingUpdate
    // 매개변수 : int wno, int wcount
    // 반환값 : true(성공)/false(실패) -> boolean
    public boolean waitingUpdate( int wno, int wcount ){
        // 1. 유효성 검사

        // 2. 객체 생성
        WaitingDto waitingDto = new WaitingDto( wno, wcount );
        // 3. dao에게 전달 후, 결과 받기
        boolean result = waitingDao.waitingUpdate( waitingDto );
        // 4. 결과를 view에게 전달
        return result;
    } // func end
} // class end
