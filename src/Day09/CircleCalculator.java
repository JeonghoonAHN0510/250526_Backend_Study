package Day09;

public class CircleCalculator {
    // 1. 멤버변수
    final double PI = 3.14159;    // 상수 선언
    // 2. 생성자

    // 3. 메소드
    // 메소드명 : printCircleArea
    // 매개변수 : 반지름 -> int
    // 출력값 : 원넓이 -> double
    double printCircleArea( int radius ){
        return radius * radius * PI;
    }
}
