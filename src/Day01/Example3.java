package Day01;  // 패키지명

public class Example3 { // class start
    public static void main(String[] args) { // main start
        /*
        [ 출력함수 ]
            System  : 시스템 관련 기능을 제공하는 클래스
            out     : 출력 관련 객체 반환
            (1) System.out.print();     : 출력 함수
            (2) System.out.println();   : 출력 후 줄바꿈 함수
            (3) System.out.printf();    : 정해진 형식에 맞게 출력 함수 f(format)
                [ printf 형식 ]
                %c : 문자 위치          %s : 문자열 위치
                %d : 정수 위치          %f : 실수 위치
                [ printf 자릿수 맞춤 ]
                %자릿수d   : 자릿수만큼 자릿수 차지, 만일 비어있으면 공백, 우쪽 정렬
                %-자릿수d  : 자릿수만큼 자릿수 차지, 만일 비어있으면 공백, 좌쪽 정렬
                %0자릿수d  : 자릿수만큼 자릿수 차지, 만일 비어있으면 0 채움
                %전체자릿수.소수점자릿수f : (소수점포함) 전체 자릿수만큼 자릿수 차지

            sout + enter : System.out.println(); 자동완성
            souf + enter : System.out.printf();  자동완성

        [ 이스케이프 문자 ]
            \n : 줄바꿈 처리
            \t : 들여쓰기 처리
            \\ : \ 출력
            \' : ' 출력
            \" : " 출력

        */
        // [1]
        System.out.println("자바안녕1");    // 자료 출력 후 줄바꿈 처리
        System.out.println("자바안녕2");    // 자료 출력 후 줄바꿈 처리
        System.out.print("자바안녕3");      // 자료 출력만
        System.out.print("자바안녕4");      // 자료 출력만
        System.out.printf("\n%s", "자바안녕5");

        // [2]
        String name = "유재석";    // String(문자열타입) / name(변수명) / =(대입) / "유재석"(자료) ;
        int age = 40;             // int(정수타입) / age(변수명) / =(대입) / 40(자료) ;
        System.out.printf("\n저는 %s이고 나이는 %d입니다.\n", name, age );
                        // "==========형식==========", 변수명, 변수명
        System.out.println("저는 "+name+"이고 나이는 "+age+"입니다.");    // + 연결 연산자 이용

        System.out.printf("저는 %s이고 나이는 %6d입니다.\n", name, age);
        // %6d  : 6자리 안에 정수 표현, 우측정렬
        System.out.printf("저는 %s이고 나이는 %-6d입니다.\n", name, age);
        // %-6d : 6자리 안에 정수 표현, 좌측정렬
        System.out.printf("저는 %s이고 나이는 %06d입니다.\n", name, age);
        // %06d : 6자리 안에 정수 표현, 빈자리 0 채우기
        System.out.printf("저는 %s이고 신장은 %5.2f입니다.\n", name, 188.257);
        // %5.2f : 5자리 안에 실수 표현, 소수점 2자리까지

        // [3] 이스케이프 문자
        System.out.println("안녕1\n안녕2");     // \n : 줄바꿈 처리
        System.out.println("안녕3\t안녕4");     // \t : 들여쓰기 처리
        System.out.println("안녕5\\안녕6");     // \\ : \ 출력
        System.out.println("'안녕7'");       // \' : ' 출력
        System.out.println("\"안녕8\"");       // \" : " 출력

    } // main end
} // class end
