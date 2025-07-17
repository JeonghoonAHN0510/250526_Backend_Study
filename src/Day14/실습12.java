package Day14;

import java.util.ArrayList;

public class 실습12 {
    public static void main(String[] args) {
        // [문제 1] 기본 상속
        Student student = new Student(); // main 함수에서 Student 객체를 생성하고,
        // 상속받은 name과 자신의 studentId에 값을 저장한 뒤
        student.name = "유재석";   student.studentId = 1;
        // 모두 출력하세요.
        System.out.println("이름 : " + student.name + "\n학번 : " + student.studentId);

        // [문제 2] 메소드 오버라이딩 (Method Overriding)
        Cat cat = new Cat();        // main 함수에서 Cat 객체를 생성
        cat.makeSound();            // makeSound() 메소드를 호출

        // [문제 3] 생성자 호출 순서
        new Computer();             // main 함수에서 Computer 객체를 생성
        // -> 부모클래스 생성자가 먼저 실행되고, 자식클래스 생성자가 실행된다.

        // [문제 4] 다형성: 자동 타입 변환 (Upcasting)
        // main 함수에서 Triangle 객체를 생성하여 Figure 타입의 변수에 저장
        Figure figure = new Triangle();
        // 이것이 가능한 이유
        // -> Triangle 객체를 생성하면, 자동으로 상위클래스인 Figure, Object 객체가 생성되기 때문에, Figure 타입의 변수에 저장할 수 있다.

        // [문제 5] 다형성과 오버라이딩
        // main 함수에서 Shape shape = new Circle(); 코드를 작성
        Shape shape = new Circle();
        // shape.draw()를 호출했을 때
        shape.draw();
        // 그 이유를 주석으로 설명하세요.
        // -> 변수 shape는 태생이 Circle 클래스이고, draw() 메소드는 Circle 클래스에서 재정의(오버라이딩)되었기 때문에 "원을 그립니다."가 출력되게 된다.

        // [문제 6] instanceof와 강제 타입 변환 (Downcasting)
        Vehicle vehicle = new Bus();
        if ( vehicle instanceof Bus ){  // 만약 Bus 타입이 맞다면
            Bus bus = (Bus) vehicle;    // Bus 타입으로 강제 변환
            bus.checkFare();            // checkFare() 메소드를 호출
        } // if end
        // 상위클래스 -> 하위클래스의 타입변환이기 대문에 강제 타입변환을 해야한다.

        // [문제 7] 다형성을 활용한 객체 배열
        // Beverage 타입의 배열을 생성
        ArrayList<Beverage> beverages = new ArrayList<>();
        // Coke 객체와 Coffee 객체를 저장
        beverages.add( new Coke() );    beverages.add( new Coffee() );
        // 반복문을 사용하여 배열의 모든 요소를 꺼내 drink() 메소드를 호출
        for ( Beverage beverage : beverages ){
            beverage.drink();
        } // for end
        // Beverage 타입에 Coke 객체와 Coffee 객체를 저장할 수 있는 이유
        // -> 각 객체는 Beverage로부터 상속받고 있기 때문에 각 객체를 생성하면 자동으로 Beverage 객체도 생성된다.

        // [문제 8] 다형성을 활용한 매개변수
        // Sword 객체와 Gun 객체를 생성
        Sword sword = new Sword();
        Gun gun = new Gun();
        // 이 객체들을 Character의 use() 메소드에 인자로 전달
        Character character = new Character();
        character.use( sword );
        character.use( gun );

        // [문제 9] 필드와 메소드의 오버라이딩 차이
        // SuperClass obj = new SubClass(); 로 객체를 생성
        SuperClass obj = new SubClass();
        // obj.name과 obj.method()를 각각 호출했을 때의 결과를 확인
        System.out.println( obj.name );     // '상위' 출력
        obj.method();                       // '하위 메소드' 출력
        // 왜 다른 결과가 나오는지 주석으로 설명하세요.
        // -> 멤버변수는 객체마다 할당되고, obj는 SuperClass기 때문에 SuperClass의 멤버변수인 '상위'가 출력된다.
        // -> obj.method()는 obj의 태생이 SubClass고 메소드가 재정의(오버라이딩)됐기 때문에 SubClass의 method()가 출력된다.

        // [문제 10] 다중 상속 관계
        Laptop laptop = new Laptop();                           // Laptop 객체를 생성한 뒤,
        // instanceof 연산자로 확인하고 결과를 출력
        System.out.println( laptop instanceof Electronic );     // true
        System.out.println( laptop instanceof Device );         // true
        // -> Laptop 객체가 생성되면서, 부모클래스인 Electronic과 Device가 같이 생성되므로 형 변환이 가능하다.

    } // main end
} // class end
