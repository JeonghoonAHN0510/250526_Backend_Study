package Day14;

class Car{
    Tire tire;
    void run(){
        this.tire.roll();
    } // func end
} // class end

class Tire{
    void roll(){
        System.out.println("[일반]타이어 회전");
    } // func end
} // class end

// Tire로부터 상속받아 HankookTire에서 메소드 재정의
class HankookTire extends Tire{
    void roll(){
        System.out.println("[한국]타이어 회전");
    } // func end
} // class end

// Tire로부터 상속받아 KumhoTire에서 메소드 재정의
class KumhoTire extends Tire{
    void roll(){
        System.out.println("[금호]타이어 회전");
    } // func end
} // class end


public class Example2 {
    public static void main(String[] args) {
        // 1. Car 객체 생성
        Car myCar = new Car();
     // myCar.run();                    // Car는 만들었지만, 멤버변수(tire)가 null -> [오류]
        myCar.tire = new Tire();        // 멤버변수에 tire 객체 대입
        myCar.run();                    // 멤버변수가 생성되어, '[일반]타이어 회전' 출력

        // 2. 타이어 교체
        myCar.tire = new HankookTire(); // 멤버변수에 HTire 객체 대입
        myCar.run();                    // 멤버변수가 바뀌어, '[한국]타이어 회전' 출력

        // 3. 타이어 교체
        myCar.tire = new KumhoTire();   // 멤버변수에 KTire 객체 대입
        myCar.run();                    // 멤버변수가 바뀌어, '[금호]타이어 회전' 출력

        // !! Tire 타입의 멤버변수는 Tire, HTire, KTire객체를 모두 대입받을 수 있다.
        // 이유 : 상속관계라서, 자식타입은 부모타입으로 자동 타입변환

        System.out.println( myCar.tire instanceof Tire );           // True
        System.out.println( myCar.tire instanceof KumhoTire );      // True
        System.out.println( myCar.tire instanceof HankookTire );    // False
        // 이유 : KumhoTire가 생성될 때 -> KumhoTire, Tire, Object 객체 생성 -> HankookTire 객체는 생성되지않음.
        // 하위타입의 객체가 생성되면, 상위타입의 객체들도 같이 생성됨. -> 형제관계는 생성되지않음.

    } // main end
} // class end
