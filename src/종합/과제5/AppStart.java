package 종합.과제5;

import 종합.과제5.view.WaitingView;

public class AppStart { // class start
    public static void main(String[] args) { // main start

        // WaitingView에서 싱글톤 객체 가져와 실행하기
        WaitingView.getInstance().view();

    } // main end
} // class end
