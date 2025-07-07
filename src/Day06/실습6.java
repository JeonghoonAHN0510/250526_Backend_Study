package Day06;

import java.util.Arrays;
import java.util.Scanner;

public class 실습6 { // class start
    public static void main(String[] args) { // main start
        //[문제 1] 정수 5개(10, 20, 30, 40, 50)를 저장할 수 있는 int 타입의 배열 numbers를 선언과 동시에 초기화하세요.
        //배열의 2번 인덱스에 저장된 값을 콘솔에 출력하세요.
        int[] numbers = { 10, 20, 30, 40, 50 };             // 선언과 동시에 초기화(값을 대입)
        // vs int[] numbers = new int[5];                   // 배열 numbers 선언만
        System.out.println( numbers[2] );                   // 30 출력

        //[문제 2] String 타입의 데이터를 3개 저장할 수 있는 배열 season을 new 키워드를 사용하여 생성하세요.
        //각 인덱스에 "봄", "여름", "가을" 값을 순서대로 할당하세요.
        //Arrays.toString()을 사용하여 배열의 모든 요소를 한 번에 출력하세요.
        String[] season = new String[3];                    // String 타입의 길이가 3인 배열 season을 선언
        season[0] = "봄";
        season[1] = "여름";
        season[2] = "가을";
        System.out.println( Arrays.toString(season) );

        //[문제 3] 다음과 같은 과일 배열이 있습니다. for 반복문을 사용하여 배열의 모든 요소를 하나씩 콘솔에 출력하시오.
        String[] fruits = {"사과", "바나나", "포도", "딸기"};
        for( String value : fruits ){                       // 향상된 for문을 이용하기
            System.out.println( value );
        }

        //[문제 4] 다음 학생들의 점수가 담긴 배열이 있습니다. for 반복문을 사용하여 모든 점수의 합계와 평균을 계산하여 콘솔에 출력하시오.
        //요구 조건: 평균은 소수점까지 정확하게 계산되어야 합니다.
        int[] scores = {85, 92, 78, 65, 95};
        int sum = 0;
        for ( int value : scores ){
            sum += value;
        }
        double average = sum / scores.length;
        System.out.printf("합계 : %d\n", sum);
        System.out.printf("평균 : %f\n", average);

        //[문제 5] 점수 배열에서 100점 만점자가 처음 나타나면, "100점 만점자를 찾았습니다!"라고 출력하고 반복문을 즉시 종료하는 프로그램을 작성하시오.
        int[] scores5 = {77, 82, 100, 54, 96};
        for ( int value : scores5 ){ // 향상된 for문을 이용하고
            if ( value == 100 ){     // 100점을 찾으면
                System.out.println("100점 만점자를 찾았습니다!");
                break;               // 반복문 종료
            }
        }

        //[문제 6] 다음 배열에서 'A'형 혈액형을 가진 사람이 몇 명인지 for 반복문을 통해 세고, 그 수를 콘솔에 출력하시오.
        String[] bloodTypes = {"A", "B", "O", "AB", "A", "B", "A"};
        int count = 0;                          // count를 0으로 초기화
        for ( String value : bloodTypes ){      // 향상된 for문을 이용하여 배열을 순회하고
            if ( value.equals("A") ){           // 값이 A라면
                count++;                        // count 1 증가
            }
        }
        System.out.printf("'A'형 혈액형을 가진 사람 : %d명\n", count);

        //[문제 7] 주어진 숫자 배열에서 가장 큰 값을 찾아 콘솔에 출력하는 프로그램을 작성하시오.
        int[] numbers7 = {23, 5, 67, 12, 88, 34};
        int max = 0;
        for ( int value : numbers7 ){
            if ( max < value ){
                max = value;
            }
        }
        System.out.println( max );
        //[문제 8] products(상품 목록)와 stock(재고 수량) 배열이 있습니다.
        //Scanner를 이용해 사용자로부터 구매할 상품명과 수량을 입력받아, 재고가 충분하면 "구매 완료!"를 출력하고 재고를 차감하세요.
        //재고가 부족하면 "재고가 부족합니다."를, 없는 상품이면 "없는 제품명입니다."를 출력합니다.
        String[] products = {"볼펜", "노트", "지우개"};
        int[] stock = {10, 5, 20};
        Scanner scan = new Scanner(System.in);          // 입력 객체를 생성하여 변수(scan)에 저장
        System.out.print("구매할 상품을 입력하세요 : ");    // 상품명을 입력받아
        String productInput = scan.next();              // productInput에 저장
        System.out.print("구매할 수량을 입력하세요 : ");    // 구매수량을 입력받아
        int stockInput = scan.nextInt();                // stockInput에 저장
        int count8 = 0;                                 // 제품 있는지 확인용 count8 선언
        for ( int i = 0; i < products.length; i++ ){    // 배열 products 순회 -> 인덱스가 필요하기 때문에 향상된 for문 X
            if ( products[i].equals(productInput) ){    // 입력받은 상품명과 같은 상품을 찾으면
                if ( stock[i] >= stockInput ){          // 재고 수량이 입력받은 수량보다 크면
                    stock[i] -= stockInput;             // 재고 차감
                    System.out.println("구매 완료!");     // "구매 완료!" 출력
                }else {
                    System.out.println("재고가 부족합니다.");
                }
                count8++;
            }
        }
        if ( count8 == 0 ){                         // 없는 제품이면( count8이 0이면 )
            System.out.println("없는 제품명입니다.");
        }
//[문제 9] 주어진 영화 이름과 평점 배열을 이용하여, 각 영화의 평점을 별(★, ☆)로 시각화하여 출력하는 프로그램을 작성하시오.
//요구 조건: 각 영화의 평점(10점 만점)만큼 꽉 찬 별(★)을, 나머지 점수만큼 빈 별(☆)을 출력합니다.
//예시: 평점이 8점이면 ★★★★★★★★☆☆ (총 10개의 별)
//출력 예시:
//히든페이스      ★★★★★★★★☆☆
//위키드         ★★★★☆☆☆☆☆☆
//글래디에이터2  ★★★★★★★☆☆☆
//청설          ★★★★★★☆☆☆☆
        String[] movieNames = {"히든페이스", "위키드", "글래디에이터2", "청설"};
        int[] movieRatings = {8, 4, 7, 6};
        for ( int i = 0; i < movieNames.length; i++){       // movieNames 전체 순회
            String movieName = movieNames[i];               // i번쨰 영화 이름 추출
            System.out.print( movieName );                  // 이름 출력
            int movieRating = movieRatings[i];              // i번째 영화 평점 추출
            for ( int j = 1; j <= 10; j++){                 // 평점 10개 출력할건데
                if ( j <= movieRating ){                    // 평점보다 작으면
                    System.out.print("★");                 // "★" 출력
                }else {                                     // 평점보다 커지면
                    System.out.print("☆");                 // "☆" 출력
                }
            }
            System.out.println();                           // 줄바꿈 처리
        }
        //[문제 10] 차량별 주차 시간 데이터가 주어졌을 때, 아래의 요금 규정에 따라 각 차량이 지불해야 할 최종 주차 요금을 계산하여 출력하시오.
        //요금 규정:
        //기본 요금: 최초 30분까지 1,000원
        //추가 요금: 30분 초과 시, 매 10분마다 500원씩 추가
        //일일 최대 요금: 20,000원 (아무리 오래 주차해도 20,000원을 초과할 수 없음)
        //출력 예시:
        //210어7125: 65분 주차, 최종 요금: 2500원
        //142가7415: 30분 주차, 최종 요금: 1000원
        //888호8888: 140분 주차, 최종 요금: 6500원
        //931나8234: 420분 주차, 최종 요금: 20000원
        String[] carNumbers = {"210어7125", "142가7415", "888호8888", "931나8234"};
        int[] usageMinutes = {65, 30, 140, 420};
        for ( int i = 0; i < carNumbers.length; i++){                   // carNumbers 순회
            String car = carNumbers[i];                                 // i번째 carNumbers 추출
            int usage = usageMinutes[i];                                // i번째 usageMinutes 추출
            System.out.printf("%s : %d분 주차, 최종 요금 : ", car, usage);
            if ( usage <= 30 ){                                         // 주차 시간이 30분 이하면
                System.out.println("1000원");                            // 기본요금 1000원 출력
            }else {                                                     // 30분 초과면
                int add = (( usage - 30 ) / 10) * 500 + 1000;           // 추가 요금을 계산해서
                if ( add >= 20000 ){                                    // 20000원이 넘으면
                    System.out.println("20000원");                      // 최대요금 20000원 출력
                }else {                                                 // 안 넘으면
                    System.out.printf("%d원\n", add);                   // 계산된 추가요금 출력
                }
            }
        }

    } // main end
} // class end