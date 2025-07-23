package Day18;

public class Example1 {
    public static void main(String[] args) {
        // 1. DB 연동 확인
        UserDao userDao = UserDao.getInstance();

        // 2. 연동된 DB에 insert 실행
        userDao.userInsert();

        // 3. 연동된 DB에 매개변수가 있는 insert 실행
        userDao.userInsert2( "강호동", 30 );
        userDao.userInsert2( "신동엽", 20 );

        // 4. 연동된 DB에 select 실행
        userDao.userSelect();

    } // main end
} // class end
