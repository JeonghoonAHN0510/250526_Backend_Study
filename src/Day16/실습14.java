package Day16;

public class 실습14 {
    public static void main(String[] args) {

        // [문제 1] ArithmeticException 처리
        try {
            int result = 10 / 0;
        }catch ( ArithmeticException  e ){
            System.out.println("0으로 나눌 수 없습니다.");
        } // try end

        // [문제 2] NumberFormatException 처리
        try {
            String notANumber = "오류";
            int value = Integer.parseInt(notANumber);
        }catch ( NumberFormatException e ){
            System.out.println("잘못된 숫자 형식입니다.");
        } // try end

        // [문제 3] ArrayIndexOutOfBoundsException 처리
        try {
            String[] fruits = {"사과", "바나나"};
            System.out.println(fruits[2]);
        }catch ( ArrayIndexOutOfBoundsException e ){
            System.out.println("잘못된 인덱스에 접근했습니다.");
        } // try end

        // [문제 4] NullPointerException 처리
        try {
            String text = null;
            System.out.println("글자 수: " + text.toUpperCase());
        }catch ( NullPointerException e ){
            System.out.println("객체가 초기화되지 않았습니다.");
        } // try end

        // [문제 5] finally 블록으로 리소스 정리하기
        try {
            System.out.println("데이터베이스 연결을 시작합니다.");
        }finally {
            System.out.println("데이터베이스 연결을 종료합니다.");
        } // try end

        // [문제 6] 다중 catch 블록

        try {
            String text = null;
            text.length();

            int result = 5 / 0;
        } catch ( NullPointerException e1 ){
            System.out.println("객체가 초기화되지 않았습니다.");
        } catch ( ArithmeticException e2 ){
            System.out.println("0으로 나눌 수 없습니다.");
        } // try end

        // [문제 7] throws로 예외 떠넘기기
        try {
            pauseOneSecond();
        } catch (InterruptedException e) {
            System.out.println("예외 던지기");
        } // try end

        // [문제 8] Exception 클래스로 모든 예외 처리
        //1. try 블록 안에 ArrayIndexOutOfBoundsException을 유발하는 코드를 작성하세요.
        //2. catch 블록을 단 하나만 사용하여, 모든 예외의 부모 클래스인 Exception 타입으로 예외를 처리하세요.
        //3. catch 블록에서는 "알 수 없는 오류가 발생했습니다." 라고 출력하세요.
        //필요코드

        try {
            int[] arr = new int[2];
            System.out.println(arr[5]);
        } catch ( Exception e ){
            System.out.println("알 수 없는 오류가 발생했습니다.");
        } // try end
    } // main end
    // Thread.sleep(1000); 코드를 포함하는 pauseOneSecond() 메소드를 만드세요. + 예외를 떠넘기도록 선언
    static void pauseOneSecond() throws InterruptedException {
        Thread.sleep(1000);
    } // func end
} // class end
