package 종합.과제5.controller;

import 종합.과제5.model.dao.WaitingDao;
import 종합.과제5.model.dto.WaitingDto;

public class WaitingController {
    // 싱글톤 만들기
    private WaitingController(){}
    private static final WaitingController controller = new WaitingController();
    public static WaitingController getInstance() {
        return controller;
    } // func end

    // WaitingDao 객체 가져오기 -> 멤버변수는 private
    private WaitingDao waitingDao = WaitingDao.getInstance();

    // 1. 등록 처리 메소드 : view -> controller -> dao
    // -> view로부터 값을 받아 -> dao에게 전달하고 -> 결과값을 받아 -> view에게 return
    public boolean waitingRegis( String phone, int count ){
        // dto 객체 만들기
        WaitingDto waitingDto = new WaitingDto( phone, count);
        // dao에게 객체 전달( WaitingDao 객체를 만들어놔서 바로 사용 )
        boolean result = waitingDao.WaitingRegis( waitingDto );
        // 결과값을 view에게 전달
        return result;
    } // func end
    // 2. 출력 처리 메소드
    public WaitingDto[] waitingPrint(){
        WaitingDto[] result = waitingDao.WaitingPrint();
        return result;
    } // func end
} // class end
