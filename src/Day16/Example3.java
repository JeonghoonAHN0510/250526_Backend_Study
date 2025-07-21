package Day16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Example3 {
    public static void main(String[] args) {
        /*
        [ 파일 입출력 클래스 ]
        1. 파일 쓰기/출력/내보내기 방법( 자바 ---> 외부 )
            - FileOutputStream

        2. 파일 읽기/입력/가져오기 방법( 자바 <--- 외부 )
            - FileInputStream
        */
        // [1] 파일 쓰기
        // (1) 파일 경로 설정
        String path = "./src/Day16/test1.txt";           // 파일의 위치, 상대경로 또는 절대경로
        // (2) 파일 출력 객체 생성 -> 무조건 일반예외 발생
            // FileOutputStream 변수명 = new FileOutputStream(파일경로);
        // (3) 예외처리 하기
        try {
            FileOutputStream fileOutput = new FileOutputStream(path);
            // (4) 파일에 쓰기 -> .write( 바이트데이터 ); -> 무조건 일반예외 발
            // "문자열".getBytes() - 문자열 -> 바이트 배열 변환 함수
            fileOutput.write("자바에서 작성한 텍스트입니다.".getBytes());
        }catch ( FileNotFoundException e ){
            System.out.println("[예외발생] 파일이 존재하지 않습니다." + e );
        } catch ( IOException e ) {
            System.out.println("[예외발생] 입출력 도중에 오류가 발생하였습니다." + e );
        }

        // [2] 파일 읽기
        // (1) 위에서 선언한 path
        // (2) 파일 입력 객체 생성 -> 무조건 일반예외 발생
        // FileInputStream 변수명 = new FileInputStream(파일경로);
        try {
            FileInputStream fileInput = new FileInputStream( path );
            // (3) 읽어온 바이트들을 저장할 배열 선언
            byte[] bytes = new byte[42];            // 42바이트를 저장할 배열 준비
            // (4) 읽어오기 -> .read( 바이트배열 );
            fileInput.read( bytes );
            // (5) 읽어온 바이트 확인 -> new String(바이트배열);
            System.out.println( new String(bytes) );
        }catch ( FileNotFoundException e ){
            System.out.println("[예외발생] 파일이 존재하지 않습니다." + e );
        } catch ( IOException e ) {
            System.out.println("[예외발생] 파일 읽기에 문제가 발생하였습니다. " + e );
        }


    } // main end
} // class end
