package Day16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Example3 {
    public static void main(String[] args) {
        /*
        [ 파일 입출력 클래스 ] -> 무조건 예외처리 발생
        1. 파일 쓰기/출력/내보내기 방법( 자바 ---> 외부 )
            - FileOutputStream
                1) .write( 바이트배열 ) : 지정한 바이트배열을 지정된 파일로 쓰기 메소드
        2. 파일 읽기/입력/가져오기 방법( 자바 <--- 외부 )
            - FileInputStream
                1) .read( 바이트배열 ) : 지정한 바이트배열에 읽어온 파일들을 저장 메소드
        3. 목적 : 자바 내의 모든 메모리는 영구저장이 아니다.
        [ Stream ]
            - 컴퓨터 내 데이터/자료가 다니는 통로
            - 스트림은 **바이트 단위**로 이동
            - 1bit = 0/1;
            - 1byte = 8bit;
            - 영문/특수문자 : 1글자당 1byte
            - 한글        : 1글자당 3byte

        [ 문자열 관련 메소드 ]
            1. "문자열".getBytes()      : 문자열을 바이트배열로 반환 메소드
            2. new String( 바이트배열 )  : 바이트배열을 문자열로 반환 메소드
            3. "문자열".equals("문자열")  : 문자열 비교결과 반환 메소드

        */
        // [1] 파일 쓰기
        // (1) 파일 경로 설정
        String path = "./src/Day16/test1.txt";           // 파일의 위치, 상대경로 또는 절대경로
        // (2) 파일 출력 객체 생성 -> 무조건 일반예외 발생
            // FileOutputStream 변수명 = new FileOutputStream(파일경로);
        // (3) 예외처리 하기
        try {
            FileOutputStream fileOutput = new FileOutputStream(path);
            // (4) 파일에 쓰기 -> .write( 바이트데이터 ); -> 무조건 일반예외 발생
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
