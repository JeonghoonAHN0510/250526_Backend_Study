package Day14;

public interface TestInterface {
    // 멤버변수 만들기 -> 불가능
    // int value1;

    // 생성자 만들기 -> 불가능
    // TestInterface(){}

    // 메소드 만들기 -> 불가능
    // void method(){}

    // [2] 상수 만들기 -> public static final(생략 가능)
    // 주의할점 : 상수는 무조건 초기값이 있어야한다.
    public static final int value2 = 10;
    int value3 = 20;                // 키워드를 생략한 상수

    // [4] 추상메소드 : 선언부만 선언하고 실행문{}이 없는 메소드
    // public abstract 반환타입 메소드();
    // 실행문은 각 클래스가 구현한다.(오버라이딩)
    public abstract void method2();
    boolean method3( int a );       // 키워드를 생략한 추상메소드


}
