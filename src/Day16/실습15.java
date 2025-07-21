package Day16;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class 실습15 {
    public static void main(String[] args) {
        // [문제 1] 파일에 일기 쓰기
        // 1. FileOutputStream을 사용하여 src 폴더 내에  파일을 생성하세요.
        // 2. "오늘 날씨는 맑았다. 자바 공부는 재미있다." 라는 문자열을 바이트로 변환하여 파일에 쓰세요.
        // 3. try-catch를 사용하여 예외 처리하세요.
        // 1) 파일 경로를 지정하고
        String path = "src/Day16/diary.txt";
        try {
            // 2) 지정한 경로에 파일에 접근하기(출력 객체를 이용하여)
            FileOutputStream fout = new FileOutputStream( path );
            // 3) .write(바이트배열); : 지정한 파일에 바이트배열 저장
            fout.write( "오늘 날씨는 맑았다. 자바 공부는 재미있다.".getBytes());
        }catch ( Exception e ){
            System.out.println("[예외발생]");
        } // try-catch end

        // [문제 2] 파일에 작성된 일기 읽기
        // 1. FileInputStream을 사용하여 문제 1에서 생성한 src/diary.txt 파일을 읽어오세요.
        // 2. 읽어온 바이트 데이터를 String으로 변환하여 콘솔에 출력하세요.
        try {
            // 지정한 경로의 파일의 정보를 제공하는 객체 생성
            File file = new File( path );
            // 지정한 경로에 파일이 존재한다면
            if ( file.exists() ){
                // 지정한 경로 파일에 접근하기(입력 객체를 이용하여)
                FileInputStream fin = new FileInputStream( path );
                // 읽어온 바이트를 저장할 바이트배열 선언
                byte[] bytes = new byte[ (int) file.length() ];
                // .read(바이트배열) : 지정한 경로로부터 정보를 읽어와 바이트배열에 저장
                fin.read( bytes );
                // 가져온 바이트배열을 문자열에 저장
                String str = new String(bytes);
                // 문자열 출력
                System.out.println( str );
            } // if end
        }catch ( Exception e ){
            System.out.println("[예외발생]");
        } // try-catch end

        // [문제 3] File 클래스로 파일 정보 확인하기
        // 1. File 객체를 src/diary.txt 경로로 생성하세요.
        // 2. .exists(), .getPath(), .getName(), .length() 메소드를 각각 사용하여 해당 파일의 존재 여부, 경로, 이름, 크기(바이트)를 출력하세요.
        File file = new File("src/Day16/diary.txt");
        System.out.println( file.exists() );        // 지정한 경로에 파일 존재여부 반환
        System.out.println( file.getPath() );       // 지정한 파일의 경로 반환
        System.out.println( file.getName() );       // 지정한 파일의 이름 반환
        System.out.println( file.length() );        // 지정한 파일의 용량 반환 -> byte(long 타입으로)

        // [문제 4] 방문 로그 누적 기록하기
        // 1. FileOutputStream을 사용하여 src/visit_log.txt 파일을 여세요.
        // 2. Scanner로 방문자 이름을 입력받아, "OOO님이 방문했습니다.\n" 형식의 문자열을
        // visit_log.txt 파일의 기존 내용 뒤에 추가하세요.
        // 3. 프로그램을 여러 번 실행하여 방문 기록이 계속 누적되는지 확인하세요.
        // 1) 사용자로부터 입력받을 수 있게 입력 객체 선언
        Scanner scan = new Scanner(System.in);
        try {
            // 1) 파일 경로를 지정하고
            String path4 = "src/Day16/visit_log.txt";
            // 2) 파일 정보 객체 생성
            File file4 = new File( path4 );
            // 3) 파일이 존재한다면
            if ( file4.exists() ){
                // 4) 입력 객체를 이용하여 파일에 접근
                FileInputStream fin = new FileInputStream( path4 );
                // 5) 읽어온 바이트들을 저장할 바이트배열 생성
                byte[] bytes = new byte[ (int)file4.length() ];
                // 6) .read()를 이용하여 읽어오기
                fin.read( bytes );
                // 7) 읽어온 기존 바이트배열을 문자열로 변환
                String str = new String( bytes );
                System.out.println( str );
                // 8) 저장할 파일 쓰기 객체 생성
                FileOutputStream fout = new FileOutputStream( path4 );
                // 9) 사용자로부터 입력받기
                System.out.print("이름 : ");      String name = scan.next();
                String visit = name + "님이 방문했습니다.\n";
                // 10) 입력받은 문자열을 기존 문자열(str)에 더하기
                str += visit;
                // 11) 더한 문자열을 파일에 저장하기 : .write(바이트배열);
                fout.write( str.getBytes() );
            } // if end
        }catch ( Exception e ){
            System.out.println("[예외발생]");
        } // try-catch end

        // [문제 5] 연락처를 CSV 형식으로 파일에 저장하기
        // 1. Scanner를 사용하여 사용자로부터 이름, 전화번호, 사는 도시를 순서대로 입력받으세요.
        // 2. 입력받은 데이터들을 쉼표(,)로 연결하여 하나의 String으로 만드세요. (예: "유재석,010-1234-5678,서울")
        // 3. 해당 문자열을 contacts.csv 파일에 저장하세요. (줄바꿈 문자 \n 포함)
        System.out.print("이름 : ");          String name = scan.next();
        System.out.print("전화번호 : ");       String phone = scan.next();
        System.out.print("사는도시 : ");       String city = scan.next();
        String data = name + "," + phone + "," + city + "\n";
        try {
            // 저장할 파일 경로 지정
            String path5 = "src/Day16/contacts.csv";
            // 파일 정보 객체 생성
            File file5 = new File( path5 );
            if ( file5.exists() ){
                // 읽어올 파일 객체 생성
                FileInputStream fin = new FileInputStream( path5 );
                // 저장할 바이트배열 생성
                byte[] bytes = new byte[ (int) file5.length() ];
                // 읽어오기
                fin.read( bytes );
                // 읽어온 바이트배열을 문자열로 저장
                String str = new String( bytes );
                System.out.println( str );
                // 파일 쓰기 객체 생성
                FileOutputStream fout5 = new FileOutputStream( path5 );
                // 입력받은 문자열을 기존 문자열에 더하기
                str += data;
                // 더한 문자열을 바이트로 변환하여 파일에 저장
                fout5.write( str.getBytes() );
            } // if end
        }catch ( Exception e ){
            System.out.println("[예외발생]");
        } // try-catch end

        // [문제 6] 영화 감상평을 파일에 저장하기
        // 1. Scanner를 사용하여 사용자로부터 좋아하는 영화 제목과 감상평을 한 줄로 입력받으세요.
        // 2. 입력받은 내용을 src 폴더 내의 src/movie_review.txt 파일에 저장하세요.
        System.out.print("제목 : ");          String title = scan.next();
        System.out.print("감상평 : ");        String review = scan.next();
        String movieReview = title + "," + review + "\n";
        // 저장할 파일 경로 지정
        String path6 = "src/Day16/movie_review.txt";
        try {
            // 파일 정보 객체 생성
            File file6 = new File( path6 );
            if ( file6.exists() ){
                // 읽어올 파일 객체 생성
                FileInputStream fin = new FileInputStream( path6 );
                // 저장할 바이트배열 생성
                byte[] bytes = new byte[ (int) file6.length() ];
                // 읽어오기
                fin.read( bytes );
                // 읽어온 바이트배열을 문자열에 저장
                String str = new String( bytes );
                System.out.println( str );
                // 파일 쓰기 객체 생성
                FileOutputStream fout6 = new FileOutputStream( path6 );
                // 입력받은 문자열을 기존 문자열에 더하기
                str += movieReview;
                // 더한 문자열을 바이트로 변환하여 파일에 저장
                fout6.write( str.getBytes() );
            } // if end
        }catch ( Exception e ){
            System.out.println("[예외발생]");
        } // try-catch end

        // [문제 7] 저장된 감상평 파일 읽기
        // 1. 문제 3에서 생성된 src/movie_review.txt 파일의 내용을 읽어오세요.
        // 2. File 클래스의 .length()를 사용하여 파일 크기만큼 바이트 배열을 선언하고,
        // 파일 전체를 한 번에 읽어오세요.
        // 3. 읽어온 내용을 콘솔에 출력하세요.
        try {
            File file7 = new File( path6 );
            if ( file7.exists() ){
                // 파일 입력 객체 생성
                FileInputStream fin = new FileInputStream( path6 );
                // 읽어온 바이트들을 저장할 바이트객체 생성
                byte[] bytes = new byte[ (int) file7.length() ];
                // 읽어오기
                fin.read( bytes );
                // 읽어온 바이트 배열을 문자열로 변환하여 출력
                System.out.println( new String(bytes) );
            } // if end
        }catch ( Exception e ){
            System.out.println("[예외발생]");
        } // try-catch end

        // [문제 8] 공공데이터 CSV 파일 읽고 분석하기
        // 1. **공공데이터포털(data.go.kr)**에서 '부평구_인구현황'을 검색하여 CSV 파일을 다운로드하고,
        // src 폴더에 bupyeong_population.csv 라는 이름으로 저장하세요.
        // 2. FileInputStream을 사용하여 해당 파일을 읽어오세요.
        // (주의: 한글 깨짐 방지를 위해 new String(bytes, "EUC-KR") 사용)
        // 3. 읽어온 전체 내용을 줄바꿈(\n) 기준으로 분리하여 String 배열에 저장하세요.
        // 4. for문을 사용하여 배열의 각 줄(각 동의 인구 정보)을 순회하며,
        // '행정기관'과 '총인구수'만 추출하여 "동별: [ 동별 ], 총 인구: [ 인구수(계) ]명" 형식으로 출력하세요.
        try {
            String path8 = "src/Day16/bupyeong_population.csv";
            File file8 = new File(path8);
            if ( file8.exists() ){
                // 해당 파일 읽어오기
                FileInputStream fin = new FileInputStream( path8 );
                // 바이트배열을 용량만큼 선언
                byte[] bytes = new byte[ (int) file8.length() ];
                // 바이트를 읽어서 배열에 저장
                fin.read( bytes );
                // 읽어온 바이트배열을 문자열로 변환
                String str = new String( bytes, "EUC-KR" );
                // CSV 분해하기
                String[] 동데이터 = str.split("\n");
                // 행정기관과 총인구수 추출하기
                for ( int i = 0; i < 동데이터.length; i++ ){
                    String row = 동데이터[i];
                    String[] 열데이터 = row.split(",");
                    System.out.printf("동별 : [ %s ], 총 인구수 : [ %s ] 명\n", 열데이터[0], 열데이터[1] );
                } // for end
            } // if end
        } catch ( Exception e ){
            System.out.println("[예외발생]");
        } // try-catch end
    } // main end
} // class end
