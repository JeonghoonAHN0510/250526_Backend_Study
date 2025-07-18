package Day15;

// 상속은 1개의 부모만 가질 수 있음
// 인터페이스는 여러개의 인터페이스를 가질 수 있음
interface Buy {
    // 추상메소드 : 구현체에서 구현해줘야 사용 가능
    public abstract void buy();

    // 디폴트 메소드 : 인터페이스 타입에서 구현한 메소드 구현 가능
    public default void defaultMethod(){
        System.out.println("인터페이스 내부에서 디폴트 메소드 구현");
    }

    // 정적 메소드 : 인터페이스 타입에서 정적 구현 메소드 구현 가능
    public static void staticMethod(){
        System.out.println("인터페이스 내부에서 정적 메소드 구현");
    }

    // private 메소드 : 현재 인터페이스 타입에서만 사용가능한 메소드 구현 가능
    private void privateMethod(){}

    // private static 메소드 : 현재 인터페이스 타입에서만 사용가능한 정적 메소드 구현 가능
    private static void privateStaticMethod(){}

} // interface end
interface Sell { void sell(); } // interface end

class Customer extends Object implements Buy, Sell{
    // extends    : 클래스 1개당 1개의 클래스만 가능
    // implements : 클래스 1개당 여러개의 인터페이스 가능

    // 각기 다른 인터페이스들의 추상메소드 구현(재정의/오버라이딩)
    @Override
    public void buy() {
        System.out.println("[판매]");
    } // func end
    @Override
    public void sell() {
        System.out.println("[구매]");
    } // func end
} // class end

public class Example2 {
    public static void main(String[] args) {
        // [1]
        Buy buy = new Customer();       // Customer가 Buy를 구현했기 때문에, Buy에 대입 가능
        // [2] 본인의 메소드를 오버라이딩한 메소드만 실행 가능하다.
        buy.buy();  // -> 가능
        // buy.sell(); -> 불가능

        // [3] 디폴트 메소드 : 인터페이스 타입에서 바로 구현이 가능하다.
        // 객체.메소드명();
        buy.defaultMethod();

        // [4] 정적 메소드( 객체 없이 사용 가능 )
        // 인터페이스명.정적메소드명();
        Buy.staticMethod();

        // [5] private 메소드 / private static 메소드
        // -> 오버라이딩 금지 메소드, 인터페이스 내부에서만 사용되는 메소드

    } // main end
} // class end
