package Day15.projectFeedback.view;

import Day15.projectFeedback.controller.UserController;

public class UserView {
    // 싱글톤 만들기
    private UserView(){}
    private static final UserView instance = new UserView();
    public static UserView getInstance(){
        return instance;
    } // func end
    // controller 부르기
    private UserController userController = UserController.getInstance();

    public void index(){
        for( ; ; ){
            System.out.println("----------메인화면----------");
        } // 무한루프 end
    } // func end
} // class end
