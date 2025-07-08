package 종합.과제3;

public class WaitingController { // WaitingController class start
    // 멤버변수
    Waiting[] waitings = new Waiting[100];
    // addWaiting 메소드 -> 매개변수 o, 반환값 o -> boolean addWaiting(매개변수){ }
    boolean addWaiting(String phone, int count){ // addWaiting 메소드 start
        Waiting waiting = new Waiting();                // Waiting 객체를 생성하고
        waiting.phone = phone;  waiting.count = count;  // 매개변수로 받은 값들을 객체의 멤버변수에 저장
        for ( int i = 0; i < waitings.length; i++){     // waitings 배열을 순회하면서
            if ( waitings[i] == null ){                 // 빈 공간을 찾으면
                waitings[i] = waiting;                  // 생성된 객체를 저장
                return true;                            // 저장 성공 시 true 반환
            }
        } // for end
        return false;                                   // 저장 실패 시 false 반환
    } // addWaiting 메소드 end

    // getWaitingList 메소드 -> 매개변수 x, 반환값 o -> Waiting[] getWaitingList(){ }
    Waiting[] getWaitingList(){
        return waitings;            // 배열 전체를 반환
    }
} // WaitingController class end
