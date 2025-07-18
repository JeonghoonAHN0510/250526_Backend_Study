package Day15.projectFeedback.controller;

import Day15.projectFeedback.model.dao.UserDao;

public class UserController {
    // 싱글톤 만들기
    private UserController(){}
    private static final UserController instance = new UserController();
    public static UserController getInstance(){
        return instance;
    }
    // dao 부르기
    UserDao userDao = UserDao.getInstance();

    // 로그인 기록 남기기
    private int loginMno = 0;       // 0 : 로그인 X, 1 : 1번 회원, 2 : 2번 회원.....
    public int getLoginMno() { return loginMno; }
    public void setLoginMno(int loginMno) { this.loginMno = loginMno; }
    // 공통으로 사용해야할 변수나 메소드를 항상 생각하고 같이 공유해아한다.

    // 1. 회원가입 메소드
    // 기능설명 :
    // 메소드명 : 회원가입
    // 매개변수 : String uId, String uPwd, String uName, String uPhone
    // 반환값 : int -> 0 : 성공 / 1 : 실패
    public int 회원가입 (String uId, String uPwd, String uName, String uPhone){
        // 유효성 검사 or 데이터 타입 검증을 controller에서 진행
        // soutp + soutm + soutv 로 프린트를 찍으면서 확인

        return userDao.회원가입( uId, uPwd, uName, uPhone );
    } // func end

    // 2. 로그인 메소드
    // 기능설명 :
    // 메소드명 : 로그인
    // 매개변수 : String uId, String uPwd
    // 반환값 : int -> 0 : 성공 / 1 : 실패
    public int 로그인( String uId, String uPwd ){
        int result = userDao.로그인( uId, uPwd );

        // 만약에 로그인 성공 시, 로그인 했다는 증거를 남겨야한다.
        if ( result == 0 ){
            int result2 = userDao.회원번호조회( uId );
            if ( result2 != 0 ){
                loginMno = result2;
            } // if end
        } // if end
        return result;
    } // func end

    // 3. 로그아웃 메소드
    // 기능설명 :
    // 메소드명 : 로그아웃
    // 매개변수 : X
    // 반환값 : X
    public void 로그아웃(){
        loginMno = 0;
        return;
    } // func end
} // class end
