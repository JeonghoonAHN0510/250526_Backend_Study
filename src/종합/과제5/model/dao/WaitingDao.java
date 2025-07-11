package 종합.과제5.model.dao;

// DAO : 실제 데이터가 존재하는 데이터베이스에 접근하는 기능

import 종합.과제5.model.dto.WaitingDto;

public class WaitingDao {
    // 싱글톤 만들기
    private WaitingDao(){}
    private static final WaitingDao dao = new WaitingDao();
    public static WaitingDao getInstance() {
        return dao;
    } // func end

    // 배열 선언 -> 멤버변수는 private
    private WaitingDto[] waitingDtos = new WaitingDto[100];

    // 등록 처리 메소드 -> controller로부터 받은 값을 저장하고 -> 결과값을 controller에게 return
    // 매개변수 : WaitingDto
    // 반환값 : boolean
    public boolean WaitingRegis( WaitingDto waitingDto ){
        for ( int i = 0; i < waitingDtos.length; i++ ){
            if ( waitingDtos[i] == null ){
                waitingDtos[i] = waitingDto;
                return true;
            } // if end
        } // for end
        return false;
    } // func end

    // 반환 처리 메소드
    // 매개변수 : x
    // 반환값 : WaitingDto[]
    public WaitingDto[] WaitingPrint(){
        return waitingDtos;
    }
} // class end
