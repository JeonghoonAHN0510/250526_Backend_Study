package Day21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example4 {
    public static void main(String[] args) {
        /*
        [ 스레드풀 ]
        1. 정의 : 미리 일정 개수의 스레드를 생성하고, 필요에 따라 재사용하는 방식
        2. 방식 : 작업이 들어올 때마다 새로운 스레드가 아닌 기존 스레드를 이용한다.
        3. 효과 : 스레드 재사용, 자원 효율성, 과부하 방지...
        4. 구조 : 작업 요청을 '큐'라는 자료구조로 배치하여, 순서대로 스레드풀에서 대기중인 스레드에게 작업 배정
            * 큐 : 자료의 데이터들을 선입선출로 처리하는 방식
            * 스택 : 자료의 데이터들을 후입선출로 처리하는 방식
        5. 사용처 : 톰캣(자바웹클래스), JDBC, 업로드/다운로드, 채팅
        6. 사용법
            1) ExecutorService executorService = Executors.newFixedThreadPool( 스레드풀에 저장할 스레드수 );
        7. 특징
            1) 스레드의 작업 순서는 정할 수 없다.
            2) 스레드풀에 저장된 스레드수만큼 스레드가 실행되는 것을 반복한다.
        */
        // [1] 작업스레드 배정하기
        // ExecutorService executorService = Executors.newFixedThreadPool( 스레드풀에 저장할 스레드수 );
        ExecutorService executorService = Executors.newFixedThreadPool( 3 );
        // [2] 3개 스레드를 생성하고, 반복문을 이용하여 스레드풀에 넣기
        for ( int i = 1; i <= 3; i++ ){
            String name = "Thread" + i;
            // [3] 익명 구현체를 이용하여 스레드 생성
            Runnable runnable = new Runnable(){
                @Override
                public void run() {
                    try {
                        Thread.sleep( 2000 );
                    } catch ( Exception e ){
                        System.out.println( e );
                    }
                    System.out.println("Task Thread : " + name );
                } // func end
            }; // 익명구현체 end
            // [4] 생성된 스레드를 스레드풀에 넣기(등록) : .submit
            executorService.submit( runnable );
        } // for end
        // [5] 스레드풀 종료 -> 저장된 모든 스레드도 포함
        executorService.shutdown();
    } // main end
} // class end
