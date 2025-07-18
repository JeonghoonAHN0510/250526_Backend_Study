package Day15.projectFeedback.model.dao;

import Day15.projectFeedback.model.dto.UserDto;

import java.util.ArrayList;

public class UserDao {
    // 싱글톤 만들기
    private UserDao(){}
    private static final UserDao instance = new UserDao();
    public static UserDao getInstance(){
        return instance;
    }

    // DB 배열 선언
    private ArrayList<UserDto> userDB = new ArrayList<>();
    // 회원번호 멤버변수
    private int uNo = 0;

    // 1. 회원가입 메소드
    // 기능설명 :
    // 메소드명 : 회원가입
    // 매개변수 : String uId, String uPwd, String uName, String uPhone
    // 반환값 : int -> 0 : 성공 / 1 : 실패
    public int 회원가입 (String uId, String uPwd, String uName, String uPhone){
        // 회원번호 -> 회원가입할 때마다 1씩 증가
        uNo++;
        // 입력받은 값들을 객체화
        UserDto userDto = new UserDto( uNo, uId, uPwd, uName, uPhone );
        // DB에 저장
        userDB.add(userDto);
        return 0;
    } // func end

    // 2. 로그인 메소드
    // 기능설명 :
    // 메소드명 : 로그인
    // 매개변수 : String uId, String uPwd
    // 반환값 : int -> 0 : 성공 / 1 : 실패
    public int 로그인( String uId, String uPwd ){
        // soutm + soutp로 프린트 찍어보기
        System.out.println("UserDao.로그인");
        System.out.println("uId = " + uId + ", uPwd = " + uPwd);

        // 1. DB 순회
        for ( int i = 0; i < userDB.size(); i++){
            UserDto userDto = userDB.get(i);
            // 비교하기
            if ( userDto.getuId().equals( uId ) && userDto.getuPwd().equals(uPwd) ){
                return 0;
            } // if end
        } // for end
        return 1;
    } // func end

    // 3. 아이디로 회원번호 조회 메소드
    // 기능설명 :
    // 메소드명 : 회원번호조회
    // 매개변수 : String uId
    // 반환값 : int -> 각 회원번호
    public int 회원번호조회 ( String uId ){
        for ( int i = 0; i < userDB.size(); i++){
            UserDto userDto = userDB.get(i);
            if ( userDto.getuId().equals(uId) ){
                return userDto.getuNo();
            }
        }
        return 0;
    } // func end


} // class end
