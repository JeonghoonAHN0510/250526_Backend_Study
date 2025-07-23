package 종합.예제10.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class BoardDao {
    // 싱글톤 만들기
    private BoardDao(){
        connectDB();
    } // func end
    private static final BoardDao instance = new BoardDao();
    public static BoardDao getInstance() {
        return instance;
    } // func end

    // 0. DB 연동 메소드 : Dao가 생성될 때, 실행
    private String DB_URL = "jdbc:mysql://localhost:3306/exam10";   // 연동할 DB 서버의 주소 = jdbc:mysql://IP주소:PORT번호/DB명
    private String DB_ID = "root";                                  // DB 서버의 계정명
    private String DB_PWD = "1234";                                 // DB 서버의 비밀번호
    private Connection conn;
    private void connectDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection( DB_URL, DB_ID, DB_PWD );
        } catch (Exception e) {
            System.out.println( e );
        } // try-catch end
    } // func end


} // class end
