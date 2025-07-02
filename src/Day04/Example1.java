package Day04;

import java.util.Scanner;

public class Example1 { // class start
    public static void main(String[] args) { // main start
        /*
        [ 반복문 ]
        1. 조건에 따른 결과가 충족(true)했을 때 코드 반복 실행
        2. 형태
            for( 초기값; 조건문; 증감식 ){
                실행문;
            }
            - 초기값 : 반복문에서 사용되는 변수 / 주로 반복횟수 체크 / int i = 1;
            - 조건문 : 반복변수의 조건문       / 주로 반복횟수 제한 / i <= 10
            - 증감식 : 반복변수의 증감식                         / i++
            - 실행문 : 조건 충족 시 실행되는 코드/명령어
        3. 실행순서
            초기값 (-> 조건문 -> 실행문 -> 증감식) -> 조건이 true면 반복, 조건이 false면 반복문 종료
        4. for 중첩 가능 : 상위 for 1회 반복마다, 하위 for 전체 반복
        5. 주요 키워드
            1) break;    : 가장 가까운 반복문 종료/탈출
            2) continue; : 가장 가까운 반복문의 증감식으로 이동
        6. 무한루프
            1) for ( ; ; ){ }
            2) while(true){ }
        */

        // [1] 1부터 5까지 출력
        for ( int i = 1; i <= 5; i++){
            System.out.println( i );
        }
        // [2] for 중첩 - 구구단으로 구현
        for ( int i = 2; i <= 9; i++){
            System.out.printf("%d단 시작\n", i);
            for ( int j = 1; j <= 9; j++){
                System.out.printf("%d X %d = %d\n", i, j, i * j);
            }
        }
        // [3] break; - 1부터 10까지 출력, 만약에 5를 찾으면 반복 종료
        for ( int i = 1; i <= 10; i++){
            if ( i == 5 ){  // 만약에 i가 5면
                break;      // 반복 종료
            }
            System.out.println( i );
        }
        // [4] continue; - 1부터 10까지 출력, 만약에 5를 찾으면 출력 생략
        for ( int i = 1; i <= 10; i++){
            if ( i == 5 ){  // 만약에 i가 5면
                continue;   // 아래 코드 생략하고 증감식으로 이동
            }
            System.out.println( i );
        }
        // [5] for( ; ; ){ } - 무한루프 + 조건에 따른 종료가 있어야 종료
        for ( ; ; ){
            System.out.print("무한입력[종료 : x ] : ");
            String input = new Scanner(System.in).next();   // 키보드로부터 입력받아 input에 저장
                if ( input.equals("x") ){                   // 입력받은 값이 x면
                break;                                      // 반복 종료
            }
        }
    } // main end
} // class end
