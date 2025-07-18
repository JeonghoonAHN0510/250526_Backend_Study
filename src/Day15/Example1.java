package Day15;

// 인터페이스란? 상수와 추상메소드를 갖는 하나의 타입
// interface 인터페이스명{ }
interface 키보드{
    // 1. 상수 : 초기값 필수
    public static final String 제조사 = "인텔";
    String 제조일 = "2025-07-18";  // public static final 생략 가능

    // 2. 추상메소드 : 구현부를 제외한 선언부만 선언
    public abstract void aKey();
    void bKey();                // public abstract 생략 가능

} // interface end

// 구현체란? 인터페이스의 추상메소드를 구현하는 클래스
// class 클래스명 implements 인터페이스명{ }
class 격투게임 implements 키보드{
    // implements한 경우, 무조건 구현해야한다. -> 오버라이딩 해야한다.
    // Ctrl + SpaceBar 또는 우클릭 [생성]으로 자동완성
    @Override
    public void aKey() {
        System.out.println("[공격]");
    } // func end
    @Override
    public void bKey() {
        System.out.println("[방어]");
    } // func end
} // class end

class 축구게임 implements 키보드{
    @Override
    public void aKey() {
        System.out.println("[슈팅]");
    } // func end
    @Override
    public void bKey() {
        System.out.println("[태클]");
    } // func end
} // class end


public class Example1 {
    public static void main(String[] args) {
        // [1] 인터페이스는 객체 생성을 할 수 없다. -> 생성자가 없기 때문에
        // new 키보드(); -> 불가

        // [2] 인터페이스 타입의 변수 선언은 가능
        키보드 myKeyBoard;                // 변수 선언은 했지만, 내용물이 없다.

        // [3] 구현체 대입
        myKeyBoard = new 격투게임();      // 격투게임 구현체 대입
        myKeyBoard.aKey();              // [공격] 출력
        myKeyBoard.bKey();              // [방어] 출력

        // [4] 구현체 바꾸기 -> 키보드는 그대로 사용 ( 다형성을 이용 )
        myKeyBoard = new 축구게임();      // 축구게임 구현체 대입
        myKeyBoard.aKey();              // [슈팅] 출력
        myKeyBoard.bKey();              // [태클] 출력

        // [5] 익명구현체 : 클래스없이 객체 만들기
        // 인터페이스타입 변수 = new 인터페이스명(){ 구현 };
        키보드 yourKeyBoard = new 키보드() {
            // 클래스 선언 없이 [여기]에서 구현
            @Override
            public void aKey() {
                System.out.println("[키보드A]");
            } // func end
            @Override
            public void bKey() {
                System.out.println("[키보드B]");
            } // func end
        }; // interface end -> 여기는 세미콜론 필수!!!!!!!!

        // [6] 익명구현체로 메소드 실행
        yourKeyBoard.aKey();            // [키보드A] 출력
        yourKeyBoard.bKey();            // [키보드B] 출력

    } // main end
} // class end
