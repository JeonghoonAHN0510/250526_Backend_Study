package 종합.과제7.model.dao;

import 종합.과제7.model.dto.WaitingDto;

import java.util.ArrayList;

public class WaitingDao {
    // 싱글톤 만들기
    private WaitingDao(){}
    private static final WaitingDao instance = new WaitingDao();
    public static WaitingDao getInstance() {
        return instance;
    } // func end

    // DB를 대신할 리스트 생성
    ArrayList<WaitingDto> waitingDB = new ArrayList<>();

    // 1. 대기등록 메소드
    // 메소드명 : waitingRegis
    // 매개변수 : waitingDto
    // 반환값 : boolean
    public boolean waitingRegis( WaitingDto waitingDto ){
        // 1) waitingDto를 DB에 저장한다
        waitingDB.add( waitingDto );

        // 2) 결과를 리턴한다.
        return true;
    } // func end


    // 2. 대기현황 출력 메소드
    // 메소드명 : waitingPrint
    // 매개변수 : X
    // 반환값 : waitingDB -> ArrayList<WaitingDto>


} // class end
