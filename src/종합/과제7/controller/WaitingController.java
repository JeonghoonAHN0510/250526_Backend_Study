package 종합.과제7.controller;

import 종합.과제7.model.dao.WaitingDao;

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

    } // func end


    // 2. 대기현황 출력 메소드
    // 메소드명 : waitingPrint
    // 매개변수 : X
    // 반환값 : waitingDB -> ArrayList<WaitingDto>



} // class end
