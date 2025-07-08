package Day07;

public class Calculator { // Calculator class start
    // 클래스 구성요소 : 멤버변수, 메소드, 생성자
    // 멤버변수
    boolean isPowerOn = false;      // 계산기의 전원 상태

    // 메소드
    // 1) 매개변수 x, 반환값 o
    double getPi( ){
        // double : 반환타입, 반환값의 타입이 실수라서
        // getPi  : 메소드명, 카멜표기법 권장
        // ( )    : 매개변수
        return 3.141592;
        // return : 반환값,  메소드를 호출했던 곳으로 반환
    }
    // 2) 매개변수 x, 반환값 x
    void powerOn(){
        // void : 반환타입, 반환값이 없다는 의미
        System.out.println("계산기 전원을 켭니다.");
        isPowerOn = true;
        // isPowerOn : 해당 메소드를 호출한 각 객체의 멤버변수
    }
    // 3) 매개변수 o, 반환값 x
    void printSum(int x, int y){
        // void : 반환타입, 반환값이 없다는 의미
        // int x, int y : 메소드 실행 시, 정수 2개를 저장하는 변수
        if ( isPowerOn ){               // 전원이 true면
            int sum = x + y;
            System.out.println( sum );
            return; // 생략 가능
        }else {
            System.out.println("계산기의 전원이 꺼져있습니다.");
            return; // 생략 가능
        }
    }
} // Calculator class end
