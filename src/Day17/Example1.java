package Day17;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.List;

public class Example1 {
    public static void main(String[] args) {
        /*
        [OpenCSV 라이브러리]
            목적 : CSV 규칙에 따른 자동 분해/분리 -> split의 유효성 검사를 안해도 된다.
            각종 라이브러리 공유 : https://mvnrepository.com/
            -> 프로젝트할 때, 라이브러리의 버전을 통일해야한다.
            (1) OpenCSV 2.3 : https://mvnrepository.com/artifact/net.sf.opencsv/opencsv/2.3
            (2) .jar 다운로드 후 패키지에 넣기
            (3) .jar 우클릭 후 [라이브러리로 추가]하기
        */

        // [1] OpenCSV 라이브러리 사용해보기
        // CSVReader : CSV를 읽어오는 클래스
            // CSVReader 변수명 = new CSVReader( reader객체 );
            // FileReader fileReader = new FileReader( path , Charset.forName("EUC-KR") );
            // .readAll() : 데이터를 List<String[]>로 반환해주는 메소드
        // CSVWriter : CSV에 쓰는 클래스
            // CSVWriter 변수명 = new CSVwriter( writer객체 );
            // FileWriter fileWriter = new FileWriter( path );
            // .writeAll( list<>객체 ) : list객체를 CSV로 내보내는 메소드
        try {
            // 1. 파일 경로 지정
            String path = "src/Day17/인천광역시 부평구 맛있는 집.csv";
            // 2. 파일 읽기모드(FileReader) 객체 생성 -> 예외처리 + 한글 인코딩( Charset.forName("EUC-KR") )
            FileReader fileReader = new FileReader( path , Charset.forName("EUC-KR") );
            // 3. CSVReader 클래스를 이용한 file 읽어오기
            CSVReader csvReader = new CSVReader( fileReader );
            // 4. .readAll() : 데이터를 List<String[]>로 반환해주는 메소드
            List<String[]> inData = csvReader.readAll();
            System.out.println( inData );
            // 5. 반복문을 이용한 순회
            for ( int i = 0; i < inData.size(); i++ ){
                String[] row = inData.get(i);
                System.out.printf("업소명 : %s , 지정메뉴 : %s \n", row[1], row[3]);
            } // for end
        }catch ( Exception e ){
            System.out.println("[예외발생]");
        } // try-catch end
    } // main end
} // class end

/*
[ 복습 ]
- 파일처리 목적 : 자바 밖의 저장소로 영구저장이 가능하다.
- 출력(자바 ---> 외부) : FileOutputStream
    1. 파일 경로 지정
        String path = "src/Day17";
    2. 출력 객체 생성 -> 일반예외 발생 -> 무조건 예외처리(try ~ catch)
        FileOutputStream fileOut = new FileOutputStream(path);
    3. 출력할 내용을 바이트배열로 변환 -> 왜 바이트로? -> Stream은 바이트 단위로 이동
        byte[] bytes = str.getBytes();
    4. 바이트배열 내보내기 -> 일반예외 발생 -> 무조건 예외처리(try ~ catch)
        fileOut.write( bytes );

- 입력(자바 <--- 외부) : FileInputStream
    1. 파일 경로 지정
    2. 입력 객체 생성 -> 일반예외 발생 -> 무조건 예외처리(try ~ catch)
        FileInputStream fileIn = new FileInputStream(path);
    3. 파일 객체 생성
        File file = new file( path );
    4. 가져올 바이트를 저장할 바이트배열 선언 -> 파일의 크기(long 타입)을 int로 변환하여 배열 선언
        byte[] bytes = new byte[ (int) file.length() ];
    5. 읽어온 바이트를 바이트배열에 저장 -> 일반예외 발생 -> 무조건 예외처리(try ~ catch)
        fileIn.read( bytes );
    6. 읽어온 바이트배열을 문자열로 변환
        String str = new String( bytes );
*/