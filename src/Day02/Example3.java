package Day02;  // 클래스 파일의 패키지(폴더)명

public class Example3 { // class start
    public static void main(String[] args) { // main start

        // [ 연산자 ]
        int x = 10; int y = -3;
        // 1. 산술 연산자 : +(더하기), -(빼기), *(곱하기), /(나누기), %(나머지)
        // -> 두 항을 연산한 하나의 결과를 반환
        System.out.println( x + y );         // '+'가 '산술 연산자'로 사용되어 '7' 출력
        System.out.println( x - y );         // '13' 출력
        System.out.println( x * y );         // '-30' 출력
        System.out.println( x / y );         // '-3' 출력, 소수점이 안 나오는 이유 : int/int -> int이기 때문에
        System.out.println( 10.0 / -3.0 );   // '-3.333' 출력, double/double -> double
        System.out.println( x % y );         // '1' 출력

        // 2. 연결 연산자 : + - 피연산자 중에 문자열이 포함되면 산술 대신 연결
        // -> 두 항을 연결한 하나의 문자열 반환
        // "문자열" + 10 -> "문자열10"
        System.out.println( x + "개");       // '+'가 '연결 연산자'로 사용되어 "10개" 출력

        // 3. 비교 연산자 : >(초과), <(미만), >=(이상), <=(이하), ==(같다), !=(같지않다)
        // -> 두 항을 비교한 결과를 boolean으로 반환
        System.out.println( x >  y );       // 10 >  -3 , true
        System.out.println( x <  y );       // 10 <  -3 , false
        System.out.println( x >= y );       // 10 >= -3 , true
        System.out.println( x <= y );       // 10 <= -3 , false
        System.out.println( x == y );       // 10 == -3 , false
        System.out.println( x != y );       // 10 != -3 . true

        // 4. 논리 연산자 : &&(이면서), ||(이거나), !(부정)
        System.out.println( x >  10 && x <  20 );   // x는 10보다 크면서 20보다 작다 , false
        System.out.println( y == 10 || y == 20 );   // y는 10이거나 20이다 , false
        System.out.println( !( x > 30 ) );          // x는 30보다 크지않다 , true

        // 5. 증감 연산자 : 변수값에 1 증가 또는 감소, ; 단위로 결정
            // ++변수명 : 선위증가, 변수명++ : 후위증가
            // --변수명 : 선위감소, 변수멍-- : 후위감소
        System.out.println( x++ );      // '10', 출력 전 x = 10, 출력 중 x = 10, 출력 후 x = 11
        System.out.println( ++x );      // '12', 출력 전 x = 11, 출력 중 x = 12, 출력 후 x = 12
        System.out.println( --x );      // '12', 출력 전 x = 12, 출력 중 x = 12, 출력 후 x = 11

        // 6. 복합 대입 연산자
            // += -= *= /= %= : 오른쪽 값을 왼쪽 값에 연산 후 왼쪽 값에 대입
        int z = 30;     // '30' 자료를 왼쪽 변수(z)에 대입
        System.out.println( z );
        z += 10;        // z = z + 10 , z = 40;
        System.out.println( z );
        z += 1;         // z++, z = z + 1 -> 같은 표현
        System.out.println( z );

        // 7. 삼항 연산자( 조건문과 동일 )
        // -> 조건 ? 참 : 거짓 ( 다수 조건 중복 가능 )
        System.out.println( x >= 60 ? "합격" : "불합격" );   // x가 60 이상이면, "합격" 아니면 "불합격" -> '불합격' 출력

        // ** 문자열 비교 vs 리터럴 비교 -> 다르다!!!
        // System.out.println( "10" == 10 ); -> 오류 (비교 불가능)
            // 문자열 비교 -> "문자열A".equals("문자열B");
        System.out.println( "10".equals("10") );    // true
            // 리터럴 비교 -> 리터럴A == 리터럴B ( 비교 연산자 )
        System.out.println( 10 == 10 );             // true
        
    } // main end
} // class end
