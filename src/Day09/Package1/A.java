package Day09.Package1; // A클래스의 패키지 위치

public class A {
    public int 공개변수 = 1;        // public    -> 어디서든 접근 가능
    private int 비공개변수 = 2;     // private   -> 현재 클래스에서만 접근 가능
    int 일반변수 = 3;               // (default) -> 같은/하위 패키지에서만 접근 가능
    public void 메소드(){
        System.out.println( 공개변수 );
        System.out.println( 비공개변수 );    // 본인 클래스여서 private여도 접근 가능
        System.out.println( 일반변수 );
    }
}
