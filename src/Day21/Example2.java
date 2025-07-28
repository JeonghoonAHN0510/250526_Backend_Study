package Day21;

import java.time.LocalTime;
import java.util.Scanner;

// [2] 시계 스레드 구현
class 시계스레드 implements Runnable{
    @Override public void run() {
        for ( ; ; ){
            // 1. 현재 시간 출력
            System.out.println(LocalTime.now());
            try {
                // 2. 현재 스레드를 1초간 일시정지
                Thread.sleep( 1000 );
            } catch ( Exception e ){
                System.out.println( e );
            } // try-catch
        } // 무한루프 end
    } // func end
} // class end

// [3] 타이머 스레드 구현
class 타이머스레드 extends Thread{
    boolean state = true;               // 무한루프 실행여부
    @Override public void run() {
        int second = 0;                 // 타이머가 계산하는 초
        for ( ; ; ){
            if ( state == false ){
                break;
            } // if end
            second++;
            System.out.printf("[타이머] %d초\n", second);
            try {
                Thread.sleep( 1000 );
            } catch ( Exception e ){
                System.out.println( e );
            } // try-catch end
        } // 무한루프 end
    } // func end
} // class end

public class Example2 {
    public static void main(String[] args) {
        // [1] 메인 스레드(입력) : public static void main(String[] args){ }

        // [2] 시계 스레드
        시계스레드 시계스레드 = new 시계스레드();          // 구현체
        Thread thread1 = new Thread( 시계스레드 );
        thread1.start();                            // thread 객체가 갖는 구현체 실행

        // [3] 타이머 스레드
        타이머스레드 thread2 = null;
        for ( ; ; ){
            System.out.print("타이머 1)ON 2)OFF : ");
            Scanner scan = new Scanner(System.in);
            int choose = scan.nextInt();
            if ( choose == 1 ){             // 타이머스레드 실행
                thread2 = new 타이머스레드(); // 타이머스레드 객체 생성
                thread2.start();            // 스레드 객체 실행
            }else if( choose == 2 ){        // 타이머 스레드 종료
                if ( thread2 != null ) thread2.state = false;      // 상태 변경을 통해, 스레드 종료
            } // if end
        } // 무한루프 end
    } // main end
} // class end
