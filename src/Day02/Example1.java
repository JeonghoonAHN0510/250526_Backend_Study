package Day02;  // 패키지명(폴더)

public class Example1 { // class start
    public static void main(String[] args) {    // main start

        // 변수 타입변환(캐스팅)
        // 다형성 : 하나의 자료가 여러개 타입으로 변환이 가능하다.(매우 중요!!!!!!!!!!!)
        // 1. 자동 타입변환 (묵시적)
            // byte(1) -> short/char(2) -> int(4) -> long(8) -> float(4) -> double(8)
            // (1) 메모리 크기가 작은 것에서 큰 것으로 변환!!
            // (2) 데이터 손실이 비교적 적다.
            // (3) 변환타입명 변수명1 = 변수명2;
        byte byteValue = 10;                // 10을 byte 타입으로 분류
        short shortValue = byteValue;       // byte  -> short  변환!
        int intValue = shortValue;          // short -> int    변환!
        long longValue = intValue;          // int   -> long   변환!
        float floatValue = longValue;       // long  -> float  변환!
        double doubleValue = floatValue;    // float -> double 변환!
        System.out.println(doubleValue);    // 10의 double 타입인 10.0 출력
        // 2. 강제 타입변환 (명시적)
            // double -> float -> long -> int -> short/char -> byte
            // (1) 메모리 크기가 큰 것에서 작은 것으로 변환!!
            // (2) 데이터 손실이 비교적 크다.
            // (3) 변환타입명 변수명1 = (변환타입명)변수명2;
        double dValue = 3.14;               // 3.14를 double 타입으로 분류
        float fValue = (float) dValue;      // double -> float 강제 변환!
        long lValue = (long) fValue;        // float  -> long  강제 변환!
        System.out.println(lValue);         // 손실 발생 : 3.14(float : 실수타입) -> 3(long : 정수타입)
        int iValue = (int) lValue;          // long   -> int   강제 변환!
        short sValue = (short) iValue;      // int    -> short 강제 변환!
        byte bValue = (byte) sValue;        // short  -> byte  강제 변환!
        System.out.println(bValue);         // 3의 byte 타입인 3 출력
        // 3. 연산 타입변환
            // (1) 연산중인 항 중에서 더 큰 항으로 자동 타입변환
            // (2) 단, int 이하의 연산 결과는 int 이다
        byte b1 = 10;       byte b2 = 20;
        short s1 = 30;      int i1 = 40;
        long l1 = 50;
        float f1 = 3.14f;   double d1 = 2.86;
        int result1 = b1 + b2;      // byte + byte   = int
        int result2 = b1 + s1;      // byte + short  = int
        int result3 = i1 + i1;      // int  + int    = int
        long result4 = i1 + l1;     // int  + long   = long
        float result5 = i1 + f1;    // int  + float  = float
        System.out.println( result5 ); // '43.14' 출력
        double result6 = i1 + d1;   // int  + double = double
        System.out.println( result6 ); // '42.86' 출력
    }   // main end
}   // class end
