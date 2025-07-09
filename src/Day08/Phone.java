package Day08;

public class Phone {
    // 1. 멤버변수(객체 내에 포함되는 변수)
    String model;   // 핸드폰 모델명
    String color;   // 핸드폰 색상
    int price;      // 핸드폰 가격
    // 2. 생성자
    // 1) 기본 생성자
    Phone(){
        System.out.println("--> Phone 기본 생성자 실행");
    }
    // 2) 매개변수가 있는 생성자
    Phone ( String pModel, String pColor ){
        model = pModel;     // 멤버변수에 입력받은 매개변수 대입
        color = pColor;     // 멤버변수에 입력받은 매개변수 대입
        price = 1200000;    // 초기값을 임의로 고정한다.
    }
    // 3) 생성자의 오버로드
    // -> 기존 생성자와 매개변수의 타입/순서/개수가 다르면 오버로드한다고 함.
    Phone ( String model, String color, int price ){
        // 멤버변수 : 객체 내 변수
        // 매개변수 : 메소드/생성자에서 사용되는 인수값 저장변수
        // -> 멤버변수와 매개변수의 이름이 같다...?
        // -> model = model; -> 사용 불가능
        // 해결책 : this 키워드 사용 -> 현재 메소드/생성자를 호출하는 객체를 가리킨다.
        this.model = model;     // this.model -> 멤버변수, model -> 매개변수
        this.color = color;     // this.color -> 멤버변수, color -> 매개변수
        this.price = price;     // this.price -> 멤버변수, price -> 매개변수
        // this 쓰기 귀찮으니깐 이름 다르게 할게요;;;;
        // -> 관례적으로 초기화 값은 멤버번수 이름과 매개변수 이름을 동일하게 한다.
        // -> 다른 사람이 내 코드를 보면 이해를 못할 수도 있다.(협업에서 중요할 듯?)
    }

    // 3. 메소드
}
