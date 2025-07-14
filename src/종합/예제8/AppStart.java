package 종합.예제8;

import 종합.예제8.view.BoardView;

public class AppStart {
    public static void main(String[] args) {

        // view 싱글톤 가져오기
        BoardView view = BoardView.getInstance();
        // 프로그램 실행
        view.index();
        // BoardView.getInstance().index();

    } // main end
} // class end


// https://docs.google.com/spreadsheets/d/1IQKpP2uS_wG5pJMabRPHEgjBoNxTaWqwmbPd2yOyJpk/edit?usp=sharing
// 보면서 새로운 기능으로 다시 만들어보기