package Day17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Data Access Object : 데이터 접근 객체
public class Dao {
    // 싱글톤 만들기
    private Dao (){
        // Dao객체가 생성될 때, DB 연동
        connectDB();
    }
    private static final Dao instance = new Dao();
    public static Dao getInstance() {
        return instance;
    }

    // DB 연동에 필요한 정보 : 서버주소, 계정명, 비밀번호
    private String DB_URL = "jdbc:mysql://localhost:3306/mydb0722";
    private String DB_ID = "root";
    private String DB_PWD = "1234";
    // DB 연동 결과를 갖는 인터페이스 생성
    private Connection conn;

    // 1. 연동 함수
    public void connectDB(){
        try {
            // mysql 드라이버 클래스 불러오는 함수
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection( DB_URL, DB_ID, DB_PWD );
            System.out.println("[데이터베이스 연동 성공]");

        } catch ( ClassNotFoundException e ){
            System.out.println("[MYSQL 드라이브 로드 실패]");
        } catch ( SQLException e ){
            System.out.println("[데이터베이스 연동 실패]");
        } // try-catch end

    } // func end

    // 2. 등록 함수

    // 3. 전체조회 홤수

} // class end
