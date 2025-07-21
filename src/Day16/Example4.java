package Day16;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Example4 {
    public static void main(String[] args) {
        try {

            // [1] 키보드로부터 입력받은 텍스트를 저장
            // 1. 키보드로부터 입력받기
            Scanner scan = new Scanner(System.in);
            System.out.print("저장할 내용 : ");        String str = scan.next();
            // 2. 저장할 파일 경로 지정
            String path = "./src/Day16/test2.txt";      // 임의의 파일명과 경로 지정
            // 3. 파일 쓰기 객체 생성
            FileOutputStream fout = new FileOutputStream( path );
            // 4. 입력받은 문자열을 바이트로 변환( 문자열.getBytes(); )
            // 왜? -> Stream은 바이트만 읽기/쓰기 가능하다.
            byte[] bytes = str.getBytes();
            // 5. 변환된 바이트배열을 내보내기( .write(바이트배열); )
            fout.write( bytes );

            // [2] 파일로부터 텍스트 호출하기
            // 1. 파일 정보 객체 -> File 클래스 : 지정한 파일의 정보를 제공하는 객체
            // File file = new File( 파일경로 );
            File file = new File( path );
            System.out.println( file.isFile() );        // .isFile()        : 파일 경로여부 반환( true/false )
            System.out.println( file.exists() );        // .exists()        : 파일 존재여부 반환( true/false )
            System.out.println( file.getName() );       // .getName()       : 파일 이름 반환
            System.out.println( file.length() );        // .length()        : 파일 용량 반환(byte) -> long 타입으로 반환
         // file.delete();                              // .delete()        : 지정한 경로의 파일 삭제 메소드
         // file.createNewFile();                       // .createNewFile() : 지정한 경로에 파일 생성 메소드

            // 2. 파일이 존재할 경우
            if ( file.exists() ){
                // 3. 파일 입력 객체 생성
                FileInputStream fin = new FileInputStream( path );
                // 4. 읽어온 바이트들을 저장할 바이트배열 생성
                byte[] bytes1 = new byte[ (int) file.length() ];        // 배열길이는 int타입만 가능
                // 5. 읽어오기
                fin.read( bytes1 );
                // 6. 읽어온 바이트배열을 문자열로 변환
                String str1 = new String( bytes1 );
                System.out.println( str1 );
            } // if end

        }catch ( Exception e ){
            System.out.println("[예외발생]");
        } // try-catch end
    } // main end
} // class end
