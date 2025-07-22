package 종합.과제7.model.dao;

import 종합.과제7.model.dto.WaitingDto;

import java.io.File;
import java.util.ArrayList;

public class WaitingDao {
    // 싱글톤 만들기
    private WaitingDao(){}
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
    // CSV 파일 경로 지정
    private String path = "src/종합/과제7";
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
        // 1) CSV 정보를 받아와서

        // 2) CSV를 .readAll(); 하여 List 배열로 바꾸고

        // 3) List 배열을 순회하면서 row 데이터를 객체에 저장하고

        // 4) 생성한 객체를 리스트에 저장

    } // func end

    // [3] CSV 출력(저장) 함수
    public void saveCSV(){

    } // func end
} // class end
