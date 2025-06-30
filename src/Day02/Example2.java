package Day02;  // 현재 폴더명

import java.util.Scanner;

public class Example2 { // class start
    public static void main(String[] args) { // main start

        // [ 입력 함수 ] : 콘솔 화면에서 키보드로부터 입력받는 방법
        // 1. new Scanner(System.in); : 시스템(컴퓨터)으로부터 입력관련 기능(함수)을 제공하는 객체
        // 기본형 : Scanner scan = new Scanner(System.in);
        // 2. 종류
        Scanner scan = new Scanner(System.in);  // 입력받게 해주는 객체를 scan이라는 변수에 저장하여 편하게 사용
    //(객체타입) (변수명) =  (   객체   );
        // (1) .next()  : 입력받은 문자열 반환, '띄어쓰기 불가능'
            // [1] Scanner 객체로부터 .next() 함수 호출
                // new Scanner(System.in).next();
            // [2] Scanner 객체를 변수에 저장하여 재활용, 타입 변수명 = 자료;
                // String 변수명 = scan.next();
        System.out.print("1. next() : ");
        String str1 = scan.next();    // == new Scanner(System.in).next();
        System.out.println("1. next result : "+ str1);

        // (2) .nextLine() : 입력받은 문자열 반환, '띄어쓰기 가능'
            // String 변수명 = scan.nextLine();
            // 주의할점 : nextLine() 앞에 다른 next()가 존재하면 enter(완료)를 하나로 포함하므로 문제 발생
            // 해결방안 : nextLine() 앞에 무의미한 nextLine() 하나 추가한다!
        System.out.print("2. nextLine() : ");
        scan.nextLine();    // 무의미한 nextLine(), nextLine() 문제 해결을 위하여
        String str2 = scan.nextLine();
        System.out.println("2. nextLine result : " + str2);

        // (3) .nextByte()  : 입력받은 정수를 byte로 반환, 입력값이 byte 허용범위를 벗어나면 오류(+-120)
        System.out.print("3. nextByte() : ");
        byte value1 = scan.nextByte();
        System.out.println("3. nextByte result : " + value1);

        // (4) .nextShort() : 입력받은 정수를 short로 반환, 입력값이 short 허용범위를 벗어나면 오류(+-32,000)
        System.out.print("4. nextShort() : ");
        short value2 = scan.nextShort();
        System.out.println("4. nextShort result : " + value2);

        // (5) .nextInt()   : 입력받은 정수를 int로 반환, 입력값이 int 허용범위를 벗어나면 오류(+-2,100,000,000)
        System.out.print("5. nextInt() : ");
        int value3 = scan.nextInt();
        System.out.println("5. nextInt result : " + value3);

        // (6) .nextLong()  : 입력받은 정수를 long으로 반환, 입력값이 long 허용범위를 벗어나면 오류 (+-2,100,000,000 이상)
        System.out.print("6. nextLong() : ");
        long value4 = scan.nextLong();
        System.out.println("6. nextLong result : " + value4);

        // (7) .nextFloat() : 입력받은 실수를 float로 반환, 입력값이 float 허용범위를 벗어나면 오류(소수점 8자리 표현)
        System.out.print("7. nextFloat : ");
        float value5 = scan.nextFloat();
        System.out.println("7. nextFloat result : " + value5);

        // (8) .nextDouble() : 입력받은 실수를 double로 반환, 입력값이 double 허용범위를 벗어나면 오류(소수점 17자리 표현)
        System.out.print("8. nextDouble : ");
        double value6 = scan.nextDouble();
        System.out.println("8. nextDouble result : " + value6);

        // (9) .nextBoolean() : 입력받은 논리 반환, 입력값이 boolean 허용범위를 벗어나면 오류( true / false 만 )
        System.out.print("9. boolean : ");
        boolean value7 = scan.nextBoolean();
        System.out.println("9. nextBoolean result : " + value7);

        // ** .nextChar() : 존재하지 않음
        // scan.next().charAt( 0 ); : 입력받은 문자열 중에 첫번째 글자 반환
        System.out.print("10. next().charAt( 0 ) : ");
        char value8 = scan.next().charAt( 0 );
        System.out.println("10. next().charAt( 0 ) result : " + value8);
    } // main end
} // class end