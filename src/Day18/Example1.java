package Day18;

public class Example1 {
    public static void main(String[] args) {
        // 1. DB 연동 확인
        UserDao userDao = UserDao.getInstance();

        // 2. 연동된 DB에 insert 실행
        userDao.userInsert();

    } // main end
} // class end
