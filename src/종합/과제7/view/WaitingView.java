package 종합.과제7.view;

import 종합.과제7.controller.WaitingController;

public class WaitingView {
    // 싱글톤 만들기
    private WaitingView(){}
    private static final WaitingView instance = new WaitingView();
    public static WaitingView getInstance() {
        return instance;
    } // func end

    // controller에 접근하기 위해 controller 싱글톤에 접근
    WaitingController waitingController = WaitingController.getInstance();



} // class end
