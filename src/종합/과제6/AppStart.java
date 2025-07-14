package 종합.과제6;

import 종합.과제6.view.WaitingView;

public class AppStart {
    public static void main(String[] args) {
        // view 싱글톤 가져오기
        WaitingView view = WaitingView.getInstance();
        // 메인화면 출력 메소드
        view.index();
    } // main end
} // class end
