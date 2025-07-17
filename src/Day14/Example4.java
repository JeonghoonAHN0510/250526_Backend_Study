package Day14;

class 자동차{
    타이어 tire;          // 타이어타입으로 멤버변수 선언
    void run(){         // 메소드 선언
        this.tire.roll();
    }
}

interface 타이어{      // 인터페이스
    void roll();      // 추상메소드 -> 구현부가 없음
}

class 한국타이어 implements 타이어{
    // 추상메소드 자동완성 : 우클릭 후 [생성]
    @Override
    public void roll() {
        System.out.println("[한국]타이어 회전");
    } // func end
} // class end

class 금호타이어 implements 타이어{
    // @Override -> 생략 가능
    public void roll() {
        System.out.println("[금호]타이어 회전");
    } // func end
} // class end

public class Example4 {
    public static void main(String[] args) {
        자동차 myCar = new 자동차();
        // myCar.run();                // 오류 발생

        // myCar.tire = new 타이어();   // 인터페이스는 생성자가 없어서 객체를 생성할 수 없음

        // [1] 구현해주는 객체 필요(구현체)
        myCar.tire = new 한국타이어();   // 한국타이어는 클래스여서 객체를 생성할 수 있음
        myCar.run();                   // '[한국]타이어 회전' 출력

        myCar.tire = new 금호타이어();   // 금호타이어 객체를 tire에 대입
        myCar.run();                   // '[금호]타이어 회전' 출력

        // tire 멤버변수는 Tire 타입인데, 왜 한국타이어/금호타이어 타입이 대입될까?
        // -> 구현관계여서(interface) 대입이 가능하다. 한국타이어/금호타이어가 Tire타입을 구현했기 때문에.

        System.out.println( myCar.tire instanceof 타이어 );        // True
        System.out.println( myCar.tire instanceof 한국타이어 );     // False
        System.out.println( myCar.tire instanceof 금호타이어 );     // True

    } // main end
} // class end
