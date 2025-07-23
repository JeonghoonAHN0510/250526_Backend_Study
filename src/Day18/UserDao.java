package Day18;

import java.sql.*;

// DAO : Data Access Object(데이터 접근 객체)
public class UserDao {
    // 0. 싱글톤 : 주로 프로그램 내 하나의 객체를 표현할 때 사용
    // -> MVC 패턴에서 싱글톤을 사용하는 계층 : View / Controller / DAO   -> 왜? 기능은 1개만 있어도 재사용이 가능하다.
    // -> 싱글톤을 사용하지않는 계층 : DTO(Data Transfer Object)         -> 왜? 데이터는 1개만 존재하지 않는다. -> 각 요청마다 다른 데이터를 가져야한다.
    private UserDao(){ connectDB(); }
    private static final UserDao instance = new UserDao();
    public static UserDao getInstance() {
        return instance;
    } // func end

    // 1. 데이터베이스 연동 함수(메소드) : Dao가 생성될 때, 실행
    private String DB_URL = "jdbc:mysql://localhost:3306/mydb0723"; // 연동할 DB 서버의 주소 = jdbc:mysql://IP주소:PORT번호/DB명
    private String DB_ID = "root";                                  // DB 서버의 계정명
    private String DB_PWD = "1234";                                 // DB 서버의 비밀번호
    private Connection conn;                                        // DB 연동 결과를 조작하는 인터페이스, import 주의
    public void connectDB(){
        try {
            // 1) MYSQL 드라이버 불러오기
            Class.forName("com.mysql.cj.jdbc.Driver");                      System.out.println("[MYSQL 드라이버 불러오기 성공]");
            // 2) MYSQL DB 서버 연동
            conn = DriverManager.getConnection( DB_URL, DB_ID, DB_PWD );    System.out.println("[DB 서버 연동 성공]");
        } catch ( ClassNotFoundException e ){
            System.out.println("[MYSQL 드라이버 불러오기 실패]");
        } catch ( SQLException e ){
            System.out.println("[DB 서버 연동 실패]");
        } // try-catch end
    } // func end

    // 2. 연동 이후, 테이블 조작(DML)
    // 1) user 테이블에 INSERT 하기
    public boolean userInsert(){
        try {
            // 1. SQL 작성
            String sql = "insert into user( uname, uage ) values ( '유재석', 40 );";
            // 2. SQL 기재 : PreparedStatement ps변수명 = conn.prepareStatement( SQL문법 );
            PreparedStatement ps = conn.prepareStatement( sql );
            // 3. SQL 실행 : int 변수명 = ps변수명.excuteUpdate();
            int count = ps.executeUpdate();     // SQL 실행 결과, 몇개의 레코드를 insert했는지 반환
            // 4. SQL 결과 확인
            System.out.println( "Insert한 레코드 수 : " + count );
            if ( count >= 1 ) {
                return true;
            }else {
                return false;
            } // if end
        } catch ( Exception e ){
            System.out.println( e );
            return false;
        } // try-catch end
    } // func end

    // 2) user 테이블에 INSERT 하기 - 매개변수를 사용하여
    public boolean userInsert2( String uname, int uage ){
        try {
            // 1. SQL 작성 : ?(SQL에 들어갈 매개변수)
            String sql = "insert into user ( uname, uage ) values ( ? , ? );";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement( sql );
            // 3. SQL 매개변수 대입
            // ps.setXXX( ?번호, 값 ) -> ?에 값을 XXX 타입으로 대입
            ps.setString( 1, uname );           // SQL 문법 안에 첫번째 ?에 uname을 String 타입으로 대입
            ps.setInt( 2, uage );               // SQL 문법 안에 두번째 ?에 uage를 int 타입으로 대입
            // 4. SQL 실행
            int count = ps.executeUpdate();
            // 5. SQL 결과 확인
            System.out.println( "Insert한 레코드 수 : " + count );
            if ( count >= 1 ){
                return true;
            }else {
                return false;
            } // if end
        } catch ( Exception e ){
            System.out.println( e );
            return false;
        } // try-catch end
    } // func end

    // 3) user 테이블에 SELECT 하기
    public void userSelect(){
        try {
            // 1. SQL 작성
            String sql = "select * from user;";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement( sql );
            // 3. SQL 매개변수 대입 -> 없으면 생략

            // 4. SQL 실행 : SELECT -> executeQuery(); -> 조회 결과 테이블 반환
            // Resultset 변수명 = ps.executeQuery();
            ResultSet rs = ps.executeQuery();
            // 5. SQL 결과 확인
            // rs.next()              : 조희결과에서 레코드/행/가로줄 하나씩 조회
            // rs.getXXX("속성명")     : 현재 레코드의 속성명에 해당하는 값 반환
            while ( rs.next() ){        // 다음 레코드가 존재하지 않을 때까지 반복
                // 현재 순회중인 레코드의 속성값 반환
                System.out.printf("번호 : %d, 이름 : %s, 나이 : %d \n",
                        rs.getInt(1),       // 1번째 열의 값을 int로 반환
                        rs.getString(2),    // 2번째 열의 값을 String으로 반환
                        rs.getInt(3) );     // 3번째 열의 값을 int로 반환
                // 현재 순회중인 레코드의 속성값을 dto로 구성
                // CSV/DB : 테이블처럼 행과 열로 구성
                // JAVA   : 객체지향 구성 -> 행과 열이 없음 -> 레코드 1개 : 객체 1개, 레코드 여러개 : 배열
            } // while end
        } catch ( Exception e ){
            System.out.println( e );
        } // try-catch end
    } // func end
} // class end