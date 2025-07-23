package 종합.과제8.model.dao;

import 종합.과제8.model.dto.WaitingDto;

import java.sql.*;
import java.util.ArrayList;

public class WaitingDao {
    // 싱글톤 만들기
    private WaitingDao(){
        connectDB();
    } // func end
    private static final WaitingDao instance = new WaitingDao();
    public static WaitingDao getInstance() {
        return instance;
    } // func end

    // 0. DB 연동 메소드 : Dao가 생성될 때, 실행
    private String DB_URL = "jdbc:mysql://localhost:3306/assignment8";  // 연동할 DB 서버의 주소 = jdbc:mysql://IP주소:PORT번호/DB명
    private String DB_ID = "root";                                      // DB 서버의 계정명
    private String DB_PWD = "1234";                                     // DB 서버의 비밀번호
    private Connection conn;
    public void connectDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection( DB_URL, DB_ID, DB_PWD );
        } catch ( ClassNotFoundException e ) {
            System.out.println( e );
        } catch (SQLException e ){
            System.out.println( e );
        } // try-catch end
    } // func end

    // 1. 대기 등록 기능
    // 메소드명 : waitingRegis
    // 매개변수 : WaitingDto
    // 반환값 : true(성공)/false(실패) -> boolean
    public boolean waitingRegis (WaitingDto waitingDto){
        try {
            // 1. SQL 작성
            String SQL = "insert into waiting ( wphone, wcount ) values ( ?, ? )";
            // 2. SQL 기재 : PreparedStatement
            PreparedStatement ps = conn.prepareStatement( SQL );
            // 3. SQL 매개변수 대입 : ps.setXXX()
            ps.setString( 1, waitingDto.getWphone() );
            ps.setInt( 2, waitingDto.getWcount() );
            // 4. SQL 실행 : ps.executeUpdate() -> int 반환
            int count = ps.executeUpdate();
            // 5. SQL 결과 반환 및 리턴
            if ( count == 1 ){
                return true;
            }else {
                return false;
            } // if end
        } catch ( SQLException e ){
            System.out.println( e );
        } // try-catch end
        return false;
    } // func end

    // 2. 대기현황 조회 기능
    // 메소드명 : waitingList
    // 매개변수 : X
    // 반환값 : ArrayList<WaitingDto>
    public ArrayList<WaitingDto> waitingList(){
        // 반환할 리스트 생성
        // -> 왜 메소드 안에서? 이 메소드가 실행될 때만 필요한 리스트니깐 지역변수로 선언
        ArrayList<WaitingDto> list = new ArrayList<>();
        try {
            // 1. SQL 작성
            String SQL = "select * from waiting";
            // 2. SQL 기재 : PreparedStatement
            PreparedStatement ps = conn.prepareStatement( SQL );
            // 3. SQL 매개변수 대입
            // 4. SQL 실행 : ps.executeQuery() -> ResultSet 반환
            ResultSet rs = ps.executeQuery();
            // 5. SQL 결과 반환 및 리턴
            // 5-1) rs 순회 : rs.next() 각 레코드를 하나씩 순회
            while ( rs.next() ){
                // 5-2) 각 레코드의 값을 추출하여 WaitingDto 객체 생성
                WaitingDto waitingDto = new WaitingDto( rs.getInt("wno"), rs.getString("wphone"), rs.getInt("wcount") );
                // 5-3) 생성한 객체를 반환할 리스트에 추가
                list.add( waitingDto );
            } // while end
        } catch ( SQLException e ){
            System.out.println( e );
        } // try-catch end
        // 추출한 리스트 반환
        return list;
    } // func end

    // 3. 대기 삭제 기능
    // 메소드명 : waitingDelete
    // 매개변수 : int wno
    // 반환값 : true(성공)/false(실패) -> boolean
    public boolean waitingDelete( int wno ){
        try {
            // 1. SQL 작성
            String SQL = "delete from waiting where wno = ? ";
            // 2. SQL 기재 : PreparedStatement
            PreparedStatement ps = conn.prepareStatement( SQL );
            // 3. SQL 매개변수 대입 : ps.setXXX()
            ps.setInt( 1, wno );
            // 4. SQL 실행 : ps.executeUpdate() -> int 반환
            int count = ps.executeUpdate();
            // 5. SQL 결과 반환 및 리턴
            if ( count == 1 ){
                return true;
            }else {
                return false;
            } // if end
        } catch ( SQLException e ){
            System.out.println( e );
        } // try-catch end
        return false;
    } // func end

    // 4. 대기 수정 기능
    // 메소드명 : waitingUpdate
    // 매개변수 : WaitingDto
    // 반환값 : true(성공)/false(실패) -> boolean
    public boolean waitingUpdate( WaitingDto waitingDto ){
        try {
            // 1. SQL 작성
            String SQL = "update waiting set wcount = ? where wno = ? ";
            // 2. SQL 기재 : PreparedStatement
            PreparedStatement ps = conn.prepareStatement( SQL );
            // 3. SQL 매개변수 대입 : ps.setXXX()
            ps.setInt( 1, waitingDto.getWcount() );
            ps.setInt( 2, waitingDto.getWno() );
            // 4. SQL 실행 : ps.executeUpdate() -> int 반환
            int count = ps.executeUpdate();
            // 5. SQL 결과 반환 및 리턴
            if ( count == 1 ){
                return true;
            }else {
                return false;
            } // if end
        } catch ( SQLException e ){
            System.out.println( e );
        } // try-catch end
        return false;
    } // func end
} // class end
