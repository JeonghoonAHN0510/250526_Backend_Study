package Day03;

public class Example1 { // class start
    public static void main(String[] args) { // main start
        /*
         [ 조건문(if) ]
         1. 조건에 따라 결과를 제어
         2. 종류
             1) if ( 조건문 ) { 참일 때 명령어 }; -> 중괄호 생략 가능
             2) if ( 조건문 ) {
                        참일 때 명령어1;
                        참일 때 명령어2;
                    }   -> 명령어 2개 이상이면 중괄호 생략 불가능
             3) if ( 조건문 ) {
                        참일 때 명령어;
                    }else {
                        거짓일 때 명령어;
                    }
             4) if ( 조건문1 ) {
                        참1일 때 명령어;
                    }else if ( 조건문2 ){
                        참2일 때 명령어;
                    }else if ( 조건문3 ){
                        참3일 때 명령어;
                    }else {
                        거짓일 때 명령어;
                    }
             5) if ( 조건문1 ) {
                        if ( 조건문2 ){
                            참2일 때 명령어;
                        }else {
                            거짓2일 때 명령어;
                        }
                    }else {
                        거짓1일 때 명령어;
                    }

         3. 주의할 점
            1) 조건문에는 true / false만 가능하다.
            2) 중괄호 주의하기!!
            3) 조건문은 *하나*의 결과값만 반환한다.
        */
        // [1]
        int 온도 = 5;
        if ( 온도 <= 10 ) {
            System.out.println("외투를 입는다.");
        }
        // [2]
        int 나이 = 20;
        if ( 나이 >= 19 ){
            System.out.println("성인입니다.");
            System.out.println("19세 이상입니다.");
        }
        // [3]
        boolean 회원검사 = false;
        if ( 회원검사 == true ){
            System.out.println("안녕하세요. 회원님");
        }else {
            System.out.println("비회원입니다.");
        }
        // [4]
        int 지갑 = 1750;
        if ( 지갑 >= 3000 ){
            System.out.println("택시 탑승");
        }else if ( 지갑 >= 1700 ){
            System.out.println("버스 탑승");
        }else if ( 지갑 >= 1200 ){
            System.out.println("자전거 탑승");
        }else {
            System.out.println("걸어간다");
        }
        // [5]
        int age = 25;
        char gender = 'w'; // 여자
        if ( age >= 19 ) {
            System.out.println("[성인]");
            if ( gender == 'w' ){       // 문자열이 아닌 문자라서 == 비교 가능 / 문자열이라면 .equals() 사용
                System.out.println("[성인여성]");
            }else {
                System.out.println("[성인남성]");
            }
        }else {
            System.out.println("[미성년자]");
        }
        // [*]
        if ( 지갑 >= 3000 ){
            System.out.println("택시 탑승2");
        }
        if ( 지갑 >= 1700 ){
            System.out.println("버스 탑승2");
        }
        if ( 지갑 >= 1200 ){
            System.out.println("자전거 탑승2");
        }
    } // main end
} // class end
