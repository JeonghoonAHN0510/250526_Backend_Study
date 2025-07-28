package Day21;

import java.awt.*;

class 작업스레드1 implements Runnable{
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    public void run() {
        for ( int i = 1; i <= 5; i++ ){
            toolkit.beep();
            try {
                Thread.sleep( 1000 );           // Thread.sleep( ms ) : ms 만큼 현재 스레드만큼 일시정지시킨다
            } catch ( Exception e ){
                System.out.println( e );
            } // try-catch end
        } // for end
    } // func end
} // class end

class 작업스레드2 extends Thread{
    @Override
    public void run() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for ( int i = 1; i <= 5; i++ ){
            toolkit.beep();
            try {
                Thread.sleep( 1000 );
            } catch ( Exception e ){
                System.out.println( e );
            } // try-catch end
        } // for end
    } // func end
} // class ned

public class Example1 {
    public static void main(String[] args) {
        /*
        - 프로그램 : 코드(명령어)들의 집합
        - 프로세스 : 실행중인 프로그램
        - 스레드 : 프로세스 내에서 실행되는 작업 단위
        - 멀티 태스킹 : 두 가지 이상의 작업을 동시에 처리
        - 멀티 프로세스 : 운영체제가 여러개의 프로세스를 동시에 처리
            -> 프로그램 단위의 멀티 태스킹
        - 멀티 스레드 : 하나의 프로그램 내 멀티 태스킹
            스레드(1차선 도로)
             vs
            멀티 스레드(다차선 도로)

        [ 스레드 ] - Thread
        1. 정의 : 하나의 프로세스 내에서 실행되는 작업 단위, 실행 흐름의 단위
        2. 목적 : 코드(명령어)를 읽고, CPU가 명령어를 처리한다.
        3. 자바에서의 스레드
            1) main 메소드 : public static void main( String[] args ){ }
        4. 사용법
            1) 자바 프로그램은 항상 main 메소드로부터 실행 흐름이 시작된다.

        [ 멀티 스레드 ] - Multi Thread
        1. 정의 : 메인 스레드 외의 새로운 작업 스레드를 생성하여 동시 작업하는 것.
        2. 목적 : 병렬처리, 동시에 여러 작업을 수행하기 위하여
        3. 사용처 : 웹/앱, 동기화/비동기화, 채팅/JDBC
        4. 사용법
            1) 익명 구현체
               Thread thread = new Thread( new Runnable(){ public void run(){} }; )
            2) 구현체
               구현 클래스를 생성한 뒤, Thread thread = new Thread( 구현 클래스 );
            3) 상속 -> 상속은 클래스당 1번
               상속 클래스를 생성한 뒤, 상속받은 메소드를 구현한 뒤, 상속클래스명 변수명 = new 상속클래스명();
        5. 주요 클래스/인터페이스
            1) Thread 클래스
                (1) start 메소드 : 구현된 run 메소드를 실행하는 메소드
            2) Runnable 인터페이스
                (1) run 추상메소드 : 작업 스레드가 실행하는 최초 시작점
        */
        Toolkit toolkit = Toolkit.getDefaultToolkit();          // java ui를 제공하는 패키지 ( java.awt )
        // [1] 단일 스레드
        // 1) 출력 5번
        for ( int i = 1; i <= 5; i++ ){
            System.out.println("[1] main 스레드가 읽어주는 코드 " + i);
            try {
                Thread.sleep( 1000 );           // Thread.sleep( ms ) : ms 만큼 현재 스레드만큼 일시정지시킨다
            } catch ( Exception e ){
                System.out.println( e );
            } // try-catch end
        } // for end
        // 2) 소리 5번
        for ( int i = 1; i <= 5; i++ ){
            toolkit.beep();                     // '띵' 소리 제공 메소드
            try {
                Thread.sleep( 1000 );           // Thread.sleep( ms ) : ms 만큼 현재 스레드만큼 일시정지시킨다
            } catch ( Exception e ){
                System.out.println( e );
            } // try-catch end
        } // for end

        // [2] 멀티 스레드 : 익명 구현체로 생성
        // 익명 구현체 : 인터페이스 타입을 클래스 없이 직접 구현
        // 2) 소리 5번 : 익명 구현체로 구현 -> new 인터페이스타입(){ 추상메소드 구현 };
        Runnable runnable = new Runnable(){
            // 추상메소드 구현
            public void run() {
                for ( int i = 1; i <= 5; i++ ){
                    toolkit.beep();
                    try {
                        Thread.sleep( 1000 );
                    } catch ( Exception e ){
                        System.out.println( e );
                    } // try-catch end
                } // for end
            } // func end
        };
        Thread thread = new Thread( runnable );     // run을 구현한 runnable 타입을 Thread 생성자에 대입
        thread.start();                             // 작업 스레드 실행
        // 2) 출력 5번
        for ( int i = 1; i <= 5; i++ ){
            System.out.println("[2] main 스레드가 읽어주는 코드 " + i);
            try {
                Thread.sleep( 1000 );
            } catch ( Exception e ){
                System.out.println( e );
            } // try-catch end
        } // for end

        // [3] 멀티 스레드 : 구현체로 생성
        // 1) 소리 5번
        작업스레드1 작업스레드1 = new 작업스레드1();
        Thread thread1 = new Thread( 작업스레드1 );
        thread1.start();

        // 2) 출력 5번
        for ( int i = 1; i <= 5; i++ ){
            System.out.println("[3] main 스레드가 읽어주는 코드 " + i);
            try {
                Thread.sleep( 1000 );
            } catch ( Exception e ){
                System.out.println( e );
            } // try-catch end
        } // for end

        // [4] 멀티 스레드 : 상속으로 구현
        // 1) 소리 5번
        작업스레드2 thread2 = new 작업스레드2();
        thread2.run();

        // 2) 출력 5번
        for ( int i = 1; i <= 5; i++ ){
            System.out.println("[1] main 스레드가 읽어주는 코드 " + i);
            try {
                Thread.sleep( 1000 );           // Thread.sleep( ms ) : ms 만큼 현재 스레드만큼 일시정지시킨다
            } catch ( Exception e ){
                System.out.println( e );
            } // try-catch end
        } // for end

    } // main end
} // class end
