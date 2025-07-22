package Day17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Example2 {
    public static void main(String[] args) {
        /*
        [ JDBC ] : Java DataBase Connect(자바 데이터베이스 연동)
        1. 준비
            1) JDBC MYSQL 라이브러리 다운로드 : https://dev.mysql.com/downloads/connector/j/
            2) [Platform Independent] -> [Platform Independent (Architecture Independent), ZIP Archive]
            3) [mysql-connector-j-9.3.0.jar] -> 프로젝트 폴더로 이동 -> [라이브러리 추가]
        2. 연동코드

        3. 핵심 JDBC 인터페이스
           -> 인터페이스가 사용되는 이유 : 각기 다른 데이터베이스 회사들의 구현체를 조작하기 위해서
            1) Connection : 데이터베이스 연동
                (1) DB 서버와 자바 연동
                    DriverManager.getConnection( 서버주소, 계정명, 비밀번호 );
                    -> Connection conn = DriverManager.getConnection( 서버주소, 계정명, 비밀번호 );
                (2) 연동된 DB에 SQL 기재 메소드 -> 기재된 PreparedStatement 반환
                    .prepareStatement( SQL문법 );
                    -> PreparedStatement ps = conn.prepareStatement( SQL문법 );
            2) PreparedStatement : SQL 실행 조작
                (1) 기재된 SQL 실행 메소드
                    ps.executeQuery();      SELECT 문법 실행 -> ResultSet 타입 반환
                    -> ResultSet rs = ps.executeQuery();
                    ps.executeUpdate();     INSERT, UPDATE, DELETE 문법 실행 -> int 타입 반환
                    -> int count = ps.executeUpdate();
            3) ResultSet : SQL 실행 결과 조작
                (1) SQL 결과 조작 메소드
                    rs.next();               조회된 레코드들 중에서 다음 레코드로 이동시키는 메소드
                    re.getXXX( 속성명 );       현재 레코드에서 지정한 속성명의 값 반환 메소드
                    -> XXX : 적절한 자바 타입

        */
        // [1] 자바와 데이터베이스 연동
        try {
            // 1) MYSQL에서 지원하는 연동 Driver 클래스 가져오기 -> 예외처리 필수
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            System.out.println("[JDBC MYSQL 드라이버 가져오기 성공]");
            // 2) DB 연동 후, 연동결과를 같는 인터페이스 -> Connection -> import java.sql.Connection;
            // 3) DB 연동 클래스(구현체) : DriverManager
            // 4) DB 연동 메소드 : .getConnection( 서버주소, 계정명, 비밀번호 );
            // 데이터베이스 서버 주소 : jdbc:mysql://ip주소:port번호/데이터베이스명
            String DB_URL = "jdbc:mysql://localhost:3306/mydb0722";     // 데이터베이스 서버 주소
            String DB_ID = "root";                                      // 데이터베이스 계정명
            String DB_PWD = "1234";                                     // 데이터베이스 비밀번호
            Connection connection = DriverManager.getConnection( DB_URL, DB_ID, DB_PWD );
            System.out.println("[데이터베이스 연동 성공]");

            //================================================================================
            // [2] 자바에서 insert 문법 사용해보기
            // 5) SQL 작성
            String sql = "insert into test values ('안녕하세요')";
            // 6) 작성한 SQL을 연동된 인터페이스에 대입 -> prepareStatement( sql );
            // -> 연동된 DB에 SQL 기재 준비 -> 반환타입 : PreparedStatement
            PreparedStatement ps = connection.prepareStatement( sql );
            // 7) 기재된 SQL 실행 -> .execute();
            ps.execute();

        } catch ( ClassNotFoundException e ){
            System.out.println("[JDBC 드라이버 가져오기 실패]");
        } catch ( SQLException e ){
            System.out.println("[데이터베이스 연동 실패]");
        } // try-catch end
    } // main end
} // class end
