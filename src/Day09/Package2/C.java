package Day09.Package2; // C클래스의 패키지 위치

public class C {
    // 비공개 멤버변수
    private int 비공개변수;
    // 비공개 멤버변수를 반환하는 공개 메소드 -> getter
    public int 반환메소드(){
        // 우회하는 방법을 사용하면 유효성 검사를 할 수 있다.
        return 비공개변수;   // 클래스 내 비공개변수 반환
    }
    private void 저장메소드( int 값 ){
        비공개변수 = 값;
    }
}
