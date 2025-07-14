package 종합.과제6.model.dao;

import 종합.과제6.model.dto.WaitingDto;

import java.util.ArrayList;

public class WaitingDao {
    // 1. 싱글톤 만들기
    private WaitingDao(){}
    private static final WaitingDao dao = new WaitingDao();
    public static WaitingDao getInstance() {
        return dao;
    }

    // ArrayList 만들기
    ArrayList<WaitingDto> waitingList = new ArrayList<>();

    // 2. 등록기능 메소드
    // 메소드명 : waitingRegis
    // 매개변수 : String phone, int count
    // 반환값 : true/false -> boolean
    public boolean waitingRegis ( String phone, int count ){
        // 초기 반환값 설정
        boolean result = false;
        // 매개변수를 넣을 객체 생성
        WaitingDto waitingDto = new WaitingDto( phone, count);
        // 객체를 ArrayList에 넣기
        waitingList.add(waitingDto);
        // 넣기 성공했으면 반환값 true
        result = true;
        // 최종 반환
        return result;
    } // func end

    // 3. 등록현황 출력 메소드
    // 메소드명 : waitingPrint
    // 매개변수 : X
    // 반환값 : waitingList -> ArrayList<WaitingDto>
    public ArrayList<WaitingDto> waitingPrint(){
        return waitingList;
    } // func end
} // class end
