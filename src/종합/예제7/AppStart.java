package 종합.예제7;

// AppStart의 역할 : 프로그램 시작 클래스( main 함수를 갖는 클래스 )

import 종합.예제7.view.BoardView;

public class AppStart { // class start
    public static void main(String[] args) { // main start
        // BoardView의 index() 메소드 호출 방법
        // 1. static메소드라면 : 클래스명.메소드명()
            // BoardView.index();
        // 2. static메소드가 아니라면 : 객체 생성
            // BoardView view = new BoardView();
            // view.index();
        // 3. 해당 클래스가 싱글톤이면 -> 이 방법 사용!!
        BoardView.getInstance().index();

    } // main end
} // class end
