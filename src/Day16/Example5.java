package Day16;

import java.io.File;
import java.io.FileInputStream;

public class Example5 {
    public static void main(String[] args) {
        // 공공데이터포털에서 CSV 파일 다루기
        // CSV란? 데이터들간의 속성을 ,(쉼표)로 구분하고 행 구분은 \n으로 구분한다.
        // 공공데이터포털에서 CSV 파일 다운로드 후, 현재 패키지에 저장( 인천광역시 부평구 맛있는 집.csv )

        try {
            // 1. 파일 존재 여부 확인
            String path = "src/Day16/인천광역시 부평구 맛있는 집.csv";
            File file = new File( path );
            System.out.println( file.exists() );        // 지정한 경로에 파일 존재여부 확인(true/false)
            // 2. 존재하면 파일 읽어오기
            if ( file.exists() ){                       // 파일이 존재하면
                // 3. 파일 입력객체 생성
                FileInputStream fin = new FileInputStream( path );
                // 4. 읽어온 바이트를 저장할 바이트배열을 용량만큼 선언
                byte[] bytes = new byte[ (int) file.length() ];
                // 5. 바이트를 읽어서 배열에 저장
                fin.read( bytes );
                // 6. 읽어온 바이트를 문자열로 변환
                // "EUC-KR" : 파일 내 (한글) 인코딩이 안 될 경우 -> String 생성자 인수로 추가
                String str = new String( bytes, "EUC-KR" );
                System.out.println( str );
                // 7. CSV 분해하기
                // 속성(열)구분 : ,(쉼표)      행 구분 : \n
                // .split("구분문자") : 지정한 구분문자를 기준으로 쪼개서 배열로 반환하는 메소드
                    // System.out.println( str.split("\n")[0] );                   // 1번째 행 출력
                    // System.out.println( str.split("\n")[1].split(",")[1] );     // 2번째 행의 2번째 열 출력
                //-------------------------------------------------------------------------------------------
                String[] 행데이터 = str.split("\n");            // 행 단위로 쪼개서 배열에 저장
                for ( int i = 0; i < 행데이터.length; i++ ){
                    String row = 행데이터[i];
                        // System.out.println( row );                  // 한 줄(행/row)씩 출력
                    String[] 열데이터 = row.split(",");           // 행을 열 단위로 쪼개서 배열에 저장
                        // System.out.println( 열데이터[1] );            // 업소면
                        // System.out.println( 열데이터[3] );            // 지정메뉴
                } // for end
            } // if end
        }catch ( Exception e ){
            System.out.println("[예외발생]" + e );
        } // try-catch end
    } // main end
} // class end
