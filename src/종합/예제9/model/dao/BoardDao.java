package 종합.예제9.model.dao;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import 종합.예제9.model.dto.BoardDto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {
    // 싱글톤 만들기 : 지정한 클래스 내 하나의 객체를 만들고, 프로그램 내 하나의 객체만 존재하게 하는 것.
    private BoardDao(){
        // 싱글톤 생성 시, CSV 로드
        openCSV();
    } // func end
    private static final BoardDao instance = new BoardDao();
    public static BoardDao getInstance() {
        return instance;
    } // func end

    // DB 대신할 리스트 선언 -> 추후엔 사용하지 않을 예정
    ArrayList<BoardDto> boardDB = new ArrayList<>();

    // 1. 등록 메소드
    // 메소드명 : boardWrite
    // 매개변수 : BoardDto boardDto
    // 반환값 : true -> boolean
    public boolean boardWrite ( BoardDto boardDto ){
        // 1) DB(리스트)에 DTO를 저장한다.
        boardDB.add( boardDto );
        // * CSV 저장
        saveCSV();
        // 2) 성공 시, true 반환
        return true;
    } // func end

    // 2. 전체조회 메소드
    // 메소드명 : boardPrint
    // 매개변수 : X
    // 반환값 : boardDB -> ArrayList<BoardDto>
    public ArrayList<BoardDto> boardPrint(){
        return boardDB;
    } // func end

    //================================================================
    // CSV 파일 경로 지정
    private String path = "src/종합/예제9/data.csv";

    // [1] CSV 파일 연동 메소드 : 싱글톤 생성 시, CSV 로드
    public void openCSV(){
        // 1) 파일 객체 생성
        File file = new File( path );
        // 2-1) 만약에 파일이 존재하면
        if ( file.exists() ){
            // 3-1) 정보 불러오기
            loadCSV();
        } else {  // 2-2) 파일이 존재하지 않으면
            // 3-2) 지정한 경로에 파일 생성 - .createNewFile();
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println( e );
            } // try-catch end
        } // if end
    } // func end

    // [2] CSV 호출(입력) 메소드
    public void loadCSV(){
        try {
            // 1) FileReader 이용한 읽기모드 객체 생성
            FileReader fileReader = new FileReader( path );
            // 2) CSVReader에 FileReader를 대입하여 CSV 객체 생성
            CSVReader csvReader = new CSVReader( fileReader );
            // 3) .readAll()를 통해 모든 정보를 읽어오기
            List<String[]> inData = csvReader.readAll();
            // 4) 반복문을 이용한 행 순회
            for ( String[] row : inData ){
                String content = row[0];
                String writer = row[1];
                // 5) 각 열들을 하나의 dto로 생성
                BoardDto boardDto = new BoardDto( content, writer );
                // 6) 생성된 dto를 리스트에 저장
                boardDB.add( boardDto );
            } // for end
            // 7) CSVReader 객체를 안전하게 닫기 -> 메모리 누수를 방지 -> 파일객체는 자동 초기화보단 직접 초기화가 안전 (용량이 크기 때문에)
            csvReader.close();
        }catch ( Exception e ){
            System.out.println( e );
        } // try-catch end
    } // func end

    // [3] CSV 저장(출력) 메소드
    public void saveCSV(){
        try {
            // 1) FileWriter 파일 쓰기모드 객체 생성
            FileWriter fileWriter = new FileWriter( path );
            // 2) CSVWriter에 FileWriter를 대입하여 CSV 객체 생성
            CSVWriter csvWriter = new CSVWriter( fileWriter );
            // 3) 빈 리스트 생성
            List<String[]> outData = new ArrayList<>();         // ArrayList(구현체), List(인터페이스)
            // 4) 현재 모든 정보(boardDB)를 outData에 담기
            for ( BoardDto boardDto : boardDB ){
                // 5) dto 하나씩 내용과 작성자를 row에 담기.
                String[] row = { boardDto.getContent(), boardDto.getWriter() };
                // 6) outData에 담기
                outData.add( row );
            } // for end
            // 7) outData를 CSV 내보내기를 한다.
            csvWriter.writeAll( outData );
            // 8) 안전하게 객체 닫기
            csvWriter.close();
        } catch ( Exception e ){
            System.out.println( e );
        } // try-catch end
    } // func end
} // class end
