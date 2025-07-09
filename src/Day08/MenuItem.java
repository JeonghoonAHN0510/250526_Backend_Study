package Day08;

public class MenuItem { // MenuItem class start
    String name;
    int price;
    boolean isSignature;
    // 세 멤버 변수를 모두 초기화하는 생성자를 만드세요.
    MenuItem( String name, int price, boolean isSignature ){
        this.name = name;
        this.price = price;
        this.isSignature = isSignature;
    }
} // MenuItem class end
