package 종합.과제4;

public class WaitingController { // WaitingController class start
    // 1. 멤버변수 -> private로 선언
    private static final Waiting[] waitings = new Waiting[100];
    // 2. 생성자

    // 3. 메소드
    // 1) 대기 등록 메소드
    // 메소드명 : addWaiting
    // 매개변수 : String phone, int count
    // 반환값 : 성공/실패 -> boolean
    public static boolean addWaiting(String phone, int count){
        Waiting waiting = new Waiting( phone, count );      // 매개변수로 받은 값들을 이용하여 객체 생성
        for ( int i = 0; i < waitings.length; i++ ){
            if ( waitings[i] == null ){     // 빈 공간을 찾으면
                waitings[i] = waiting;      // 생성한 객체를 저장
                return true;                // 저장 성공하여 true 반환
            }
        }
        return false;                       // 저장 실패하여 false 반환
    }
    // 2) 대기 조회 메소드
    // 메소드명 : getWaitingList
    // 매개변수 : X
    // 반환값 : waitings -> Waiting[]
    public static Waiting[] getWaitingList(){
        return waitings;
    }
} // WaitingController class end
