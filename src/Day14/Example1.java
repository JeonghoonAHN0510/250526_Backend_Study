package Day14;


class 상위클래스{
    // 멤버변수
    int value1 = 10;    int value2 = 20;
    // 생성자
    상위클래스(){ System.out.println("[상위클래스 인스턴스 생성]"); }
    // 메소드
    void showValue(){ System.out.println(">>상위클래스 메소드 실행<<"); }
} // class end

class 하위클래스 extends 상위클래스{
    // 멤버변수
    int value3 = 30;    int value2 = 40;
    // 생성자
    하위클래스(){ System.out.println("[하위클래스 인스턴스 생성]"); }
    // 메소드
    void showValue2(){ System.out.println(">>하위클래스 메소드2 실행<<"); }
        // 상위클래스의 메소드와 이름 동일
    void showValue(){ System.out.println(">>하위클래스 메소드 실행<<"); }
} // class end



public class Example1 {
    public static void main(String[] args) {
        // 1. 상위클래스 객체 생성
        상위클래스 obj1 = new 상위클래스();
        obj1.showValue();
        // obj1.showValue2(); -> 하위클래스에 접근 불가

        // 2. 하위클래스 객체 생성
        하위클래스 obj2 = new 하위클래스();
        obj2.showValue2();      // 본인클래스 접근 가능
        obj2.showValue();       // 상위클래스 접근 가능

        // 3. 멤버변수명이 동일할 때 구분 : 멤버변수는 객체마다 할당
        System.out.println( obj2.value1 );      // 상위클래스의 멤버변수 사용 가능
        System.out.println( obj2.value3 );      // 본인클래스의 멤버변수 사용 가능
        System.out.println( obj2.value2 );      // 상/하위클래스에 이름이 같은 멤버변수가 있다면, 본인클래스 우선

        // 하위클래스에서 상위클래스로 변환
        상위클래스 obj3 = obj2;                   // obj3의 태생은 '하위클래스'
        System.out.println( obj3.value2 );      // obj3는 상위클래스이므로, '20' 출력

        // 4. 메소드명이 동일할 때 구분 : 메소드는 모든 객체가 공유하여 사용(객체마다 할당 X)
        // 오버로딩 vs *오버라이딩*
        obj2.showValue();                       // obj2(하위클래스) 하위클래스 메소드 실행
        obj3.showValue();                       // obj3(상위클래스) 하위클래스 메소드 실행 -> obj3의 태생은 '하위클래스'
        // 오버라이딩은 *태생* 타입의 메소드 실행
        obj1.showValue();                       // obj1(상위클래스) 상위클래스 메소드 실행

    } // main end
} // class end
