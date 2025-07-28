package Day21;

// (1) 유저1 클래스 [ 작업스레드1 ]
class User1 extends Thread{
    public Calculator calculator;
    @Override public void run() {       // 작업스레드 메소드 구현
        calculator.setMemory( 100 );    // 계산기에 100 넣기
    } // func end
} // class end
// (2) 유저2 클래스 [ 작업스레드2 ]
class User2 extends Thread{
    public Calculator calculator;
    @Override public void run() {       // 작업스레드 메소드 구현
        calculator.setMemory( 200 );    // 계산기에 200 넣기
    } // func end
} // class end
// (3) 계산기 클래스 [ 객체 ]
class Calculator{
    // 멤버변수
    public int memory;
    // 메소드
    // public void setMemory( int memory ){
    public synchronized void setMemory( int memory ){
        this.memory = memory;
        try {
            Thread.sleep( 2000 );           // 2초간 일시정지
        } catch ( Exception e ){
            System.out.println( e );
        } // try-catch end
        System.out.println( this.memory );  // 멤버변수 확인
        // 비동기화 시 : user1 스레드가 2초 일시정지 도중에 user2 스레드가 200 대입
        // 2개 이상의 스레드가 하나의 객체를 사용할 때, 충돌이 일어날 수 있다.
        // -> 동기화하면 순서대로 처리하기 때문에, 충돌이 발생하지 않는다.
    } // func end
} // class end

public class Example3 {
    public static void main(String[] args) {

        /*
        [ 동기화 / 비동기화 ] - synchronized(동기화)
        1. 정의 : 메소드에 lock을 사용하여 메소드를 점령한다.
        2. 목적 : 여러 스레드가 동시에 하나의 객체를 사용하면, 코드(멤버변수) 충돌이 생길 수 있다.
                 -> 호출한 순서대로 처리하여, 코드 충돌을 방지한다.
        3. 동기화  : 한번에 하나의 스레드를 처리 / 처리 순서 보장
           -> 들어오는 순서대로 처리
            vs
           비동기화 : 여러개의 스레드를 동시 처리 / 처리 순서 보장 안됨
           -> 완료된 순서대로 처리
        4. 사용법
            1) 메소드 선언부에 synchronized 추가
            2) synchronized(this){ } 추가

        */

        // 1. 계산기 객체를 *하나* 생성한다.
        Calculator calculator = new Calculator();
        // 2. 하나의 계산기를 2개의 스레드에 대입한다.
        User1 user1 = new User1();
        user1.calculator = calculator;

        User2 user2 = new User2();
        user2.calculator = calculator;
        // * 2개의 스레드가 동일한 (계산기)객체 정보를 갖는다.
        // 3. 스레드 실행
        user1.start();      // user1 : 100 대입 -> 200 -> synchronized -> 100
        user2.start();      // user2 : 200 대입 -> 200 -> synchronized -> 200


    } // main end
} // class end
