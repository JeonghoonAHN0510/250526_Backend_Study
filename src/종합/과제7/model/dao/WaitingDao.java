package 종합.과제7.model.dao;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import 종합.과제7.model.dto.WaitingDto;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WaitingDao {
    // 싱글톤 만들기
    private WaitingDao(){
        // 싱글톤 생성 시, CSV 로드
        openCSV();
        // 싱글톤 생성 시, DB 연동
        connectDB();
    } // func end
    private static final WaitingDao instance = new WaitingDao();
    public static WaitingDao getInstance() {
        return instance;
    } // func end

    // DB를 대신할 리스트 생성
    ArrayList<WaitingDto> waitingDB = new ArrayList<>();

    // 1. 대기등록 메소드
    // 메소드명 : waitingRegis
    // 매개변수 : waitingDto
    // 반환값 : boolean
    public boolean waitingRegis( WaitingDto waitingDto ){
        // 1) waitingDto를 DB에 저장한다
        waitingDB.add( waitingDto );
        // CSV 저장
        saveCSV();
        // DB 저장
        insertDB( waitingDto );
        // 2) 결과를 리턴한다.
        return true;
    } // func end

    // 2. 대기현황 출력 메소드
    // 메소드명 : waitingPrint
    // 매개변수 : X
    // 반환값 : waitingDB -> ArrayList<WaitingDto>
    public ArrayList<WaitingDto> waitingPrint(){
        // 1) waitingDB 리턴
        return waitingDB;
    } // func end

    //==========================================================
    // DB 연동에 필요한 멤버변수 : 서버주소, 계정명, 비밀번호
    private String DB_URL = "jdbc:mysql://localhost:3306/mydb0722";
    private String DB_ID = "root";
    private String DB_PWD = "1234";
    // DB 연동 결과를 갖는 인터페이스 생성
    private Connection conn;
    // 1. DB 연동 함수 -> 싱글톤 객체가 생성될 때 실행
    public void connectDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("[MYSQL 드라이브 로드 성공]");
            conn = DriverManager.getConnection( DB_URL, DB_ID, DB_PWD );
            System.out.println("[데이터베이스 연동 성공]");
        } catch ( ClassNotFoundException e ){
            System.out.println("[MYSQL 드라이브 로드 실패]");
        } catch ( SQLException e ){
            System.out.println("[데이터베이스 연동 실패]");
        } // try-catch end
    } // func end
    // 2. DB에 insert 함수
    public void insertDB( WaitingDto waitingDto ){
        try {
            String phone = waitingDto.getPhone();
            int count = waitingDto.getCount();
            String SQL = "insert into waiting values (\"" + phone + "\", " + count + ");";
            System.out.println( SQL );
            PreparedStatement ps = conn.prepareStatement( SQL );
            ps.execute();
        } catch ( SQLException e ){
            System.out.println("[데이터베이스 저장 실패]");
        } // try-catch end
    } // func end


    //==========================================================
    // CSV 파일 경로 지정
    private String path = "src/종합/과제7/data.csv";
    // [1] CSV 파일 연동 함수
    public void openCSV(){
        // 1) 파일 객체 생성
        File file = new File( path );
        // 2-1) 파일이 존재하면
        if ( file.exists() ){
            // 3-1) 정보 불러오기 -> loadCSV();
            loadCSV();
        }else { // 2-2) 파일이 존재하지 않으면
            // 3-2) 파일 생성 .createNewFile(); -> 일반예외 -> try-catch
            try {
                file.createNewFile();
            } catch ( Exception e ){
                System.out.println( e );
            } // try-catch end
        } // if end
    } // func end

    // [2] CSV 입력(호출) 함수
    public void loadCSV(){
        try {
            // 1) CSV 정보를 받아와서
            FileReader fileReader = new FileReader( path );
            CSVReader csvReader = new CSVReader( fileReader );
            // 2) CSV를 .readAll(); 하여 List 배열로 바꾸고
            List<String[]> inDate = csvReader.readAll();
            System.out.println( inDate );
            // 3) List 배열을 순회하면서 row 데이터를 객체에 저장하고
            for ( String[] row : inDate ){
                String phone = row[0];
                int count = Integer.parseInt(row[1]);
                WaitingDto waitingDto = new WaitingDto( phone, count );
                // 4) 생성한 객체를 리스트에 저장
                waitingDB.add( waitingDto );
            } // for end
            csvReader.close();
        } catch ( Exception e ){
            System.out.println( e );
        } // try-catch end
    } // func end

    // [3] CSV 출력(저장) 함수
    public void saveCSV(){
        try {
            // 1) 파일 쓰기모드 객체 생성
            FileWriter fileWriter = new FileWriter( path );
            // 2) CSV 객체 생성
            CSVWriter csvWriter = new CSVWriter( fileWriter );
            // 3) 빈 리스트 생성
            List<String[]> outData = new ArrayList<>();
            // 4) 모든 정보를 빈 리스트에 담기
            for ( WaitingDto waitingDto : waitingDB ){
                // 5) dto 내용을 row에 담기
                String count = Integer.toString(waitingDto.getCount());
                String[] row = { waitingDto.getPhone(), count };
                // 6) outData에 담기
                outData.add( row );
            } // for end
            System.out.println( outData );
            // 7) 저장된 데이터를 내보닌다.
            csvWriter.writeAll( outData );
            csvWriter.close();
        } catch ( Exception e ){
            System.out.println( e );
        } // try-catch end
    } // func end
} // class end
