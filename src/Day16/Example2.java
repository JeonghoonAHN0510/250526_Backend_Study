package Day16;

public class Example2 {
    // (1) 예외가 발생하는 메소드
    // 예외 발생시 예외 던지기(throws)
    // 반환타입 메소드명() throws 예외클래스명 { }
    public static void method1() throws NullPointerException {
        String str = null;
        System.out.println( str.length() );     // 100% 예외 발생이 예측된다.

    } // func end
    // (2) 예외가 발생하는 메소드
    // 일반예외 클래스는 주로 throws 예외 코드가 존재한다.
    // 실행예외 클래스는 주로 throws 예외 코드가 없다.
    public static void method2() throws ClassNotFoundException {
        Class.forName("com.sql.jdbc");          // 일반예외 -> 무조건 예외처리 해야한다.
    }
    public static void main(String[] args) {
        // [9] 예외던지기 : 예외 발생 시, 메소드를 호출한 곳으로 예외 전달(리턴)
        // 한 곳에서 예외처리를 하기 위해서 메소드 내부에서 발생한 예외를 리턴할 수 있다.
        try{
            method1();
        } catch ( NullPointerException e ) {
            System.out.println("method1의 예외 발생");
        } // try end

        try {
            method2();
        } catch ( ClassNotFoundException e ) {
            System.out.println("method2의 예외 발생");
        } // try end
    } // main end
} // class end
