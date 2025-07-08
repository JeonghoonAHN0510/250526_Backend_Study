package Day07;

public class ParkingLot { // ParkingLot class start
    // 매개변수 o, 반환값 o -> int ~~(매개변수)
    int calculateFee( int time ){
        if ( time <= 30 ){  // 30분까지
            return 1000;    // 기본요금 1000원 반환
        }else {             // 30분 초과 시
            int fee = (time - 30) / 10 * 500 + 1000;   // 10분마다 500원 추가
            if ( fee >= 20000){     // 20000원이 넘는다면
                return 20000;       // 20000원 반환
            }else {                 // 20000원 안 넘으면
                return fee;         // 계산된 요금 반환
            }
        }
    }
} // ParkingLot class end
