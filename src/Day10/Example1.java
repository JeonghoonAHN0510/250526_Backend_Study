package Day10;

// 싱글톤 만들기
class Controller{ // class start
    // 1) 기본 생성자를 private로 만들기
    private Controller(){}
    // 2) private static final로 객체를 선언한다.
    // -> private여도 같은 클래스면 사용이 가능하다.
    private static final Controller controller = new Controller();
    // 3) public static으로 getInstance 메소드를 선언한다.
    public static Controller getInstance() {
        return controller;
    }
} // class end



public class Example1 { // class start
    public static void main(String[] args) { // main start
        // 4) 싱글톤 불러오기 : 클래스명.getInstance();
        Controller.getInstance();

    } // main end
} // class end
