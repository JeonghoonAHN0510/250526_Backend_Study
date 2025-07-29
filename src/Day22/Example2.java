package Day22;

import java.util.ArrayList;
import java.util.Random;

public class Example2 {
    public static void main(String[] args) {
        /*
        [ Random ] 난수 클래스
        1. 사용법
            1) Random 객체 생성
                Random 변수명 = new Random();
            2) 주요 메소드
                (1) .nextInt()                  : int 타입 허용범위 내 난수 생성
                (2) .nextInt( n ) + m           : m부터 n - 1 개의 난수 생성
                (3) .nextInt( n )               : 0부터 n - 1 개의 난수 생성
        */
        // [1] Random 객체 생성
        Random random = new Random();               System.out.println( random );
        
        // [2] int 타입 난수 생성
        int value1 = random.nextInt();              System.out.println("value1 = " + value1);

        // [3] n ~ (m-1) 사이의 난수 생성
        int value2 = random.nextInt( 10 ) + 1;      System.out.println("value2 = " + value2);
        int value3 = random.nextInt( 100 );         System.out.println("value3 = " + value3);

        // [4] 0과 1 사이의 난수 생성 ( double 타입 )
        double value4 = random.nextDouble();        System.out.println("value4 = " + value4);

        // [5] boolean 난수 생성
        boolean value5 = random.nextBoolean();      System.out.println("value5 = " + value5);

        // [활용] 임의의 여러개 데이터 중 데이터 하나 선택 - 추첨
        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("유재석");    nameList.add("강호동");    nameList.add("신동엽");
        int randomIndex = random.nextInt( nameList.size() );
        String value6 = nameList.get( randomIndex );
        System.out.println("value6 = " + value6);

        // [활용] 새로운 비밀번호, 인증코드 문자 난수 표현
        String code = "";                       // 빈 문자열 생성
        for ( int i = 1; i <= 6; i++ ){         // 6자리를 만들기 위한, 6번 순회
            // a : 97 ~ z : 122
            Random ran = new Random();
            int value7 = ran.nextInt( 26 ) + 97;    // 아스키코드를 활용한 알파벳 난수 만들기
            char char1 = (char) value7;     System.out.println( char1 );
            code += char1;
        }
        System.out.println("code = " + code);

        // [활용] 특수문자/정수/알파벳이 섞인 인증코드 만들기
        String pwd = "";
        for ( int i = 1; i <= 6; i++ ){
            int type = random.nextInt( 4 );
            if ( type == 0 ){           // 특수문자
                int value = random.nextInt( 6 ) + 33;
                pwd += (char) value;
            }else if ( type == 1 ){     // 정수
                int value = random.nextInt( 10 );
                pwd += value;
            }else if ( type == 2 ){     // 대문자 알파벳
                int value = random.nextInt( 26 ) + 65;
                pwd += (char) value;
            }else {
                int value = random.nextInt( 26 ) + 97;
                pwd += (char) value;
            } // if end
        } // for end
        System.out.println("pwd = " + pwd);

        // [활용] 난수를 이용한 주사위(1 ~ 6) 만들기
        int dice = random.nextInt( 6 ) + 1;
        System.out.println("dice = " + dice);

        // [활용] 난수를 이용하여 중복없이 로또번호(1 ~ 45) 6자리 만들기
        ArrayList<Integer> lottoList = new ArrayList<>();
        for ( int i = 1; i <= 6; i++ ){
            int lotto = random.nextInt( 45 ) + 1;       // 생성된 로또번호
            if ( lottoList.contains(lotto) ){           // 리스트에 생성된 로또번호가 존재하면
                i--;                                    // i 1 감소
                continue;                               // 아래 실행하지않고 반복문으로
            } // if end
            lottoList.add( lotto );
        } // for end
        System.out.println("lottoList = " + lottoList);

        // [활용] 하나의 문자열에서 추출한 문자로 문자열 난수 생성
        String ranStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        // 1) 문자열 길이 구하기 : length()
        int len = ranStr.length();
        // 2) 문자열 난수 인덱스 생성
        int ranIndex = random.nextInt( len );
        // 3) 난수 인덱스에 위치한 문자 1개 반환
        char ranChar = ranStr.charAt( ranIndex );
        System.out.println("ranChar = " + ranChar);

    } // main end
} // class end
