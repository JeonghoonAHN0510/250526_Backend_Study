package Day15;

public class 실습13 {
    public static void main(String[] args) {
        // [문제 1] 기본 인터페이스와 구현
        Cat cat = new Cat();        Dog dog = new Dog();
        cat.makeSound();            dog.makeSound();

        // [문제 2] 인터페이스 상수
        // 3. main 함수에서 객체를 생성하지 않고,
        // RemoteControl.MAX_VOLUME과 같이 인터페이스 이름으로 직접 접근하여 두 상수를 출력하세요.
        System.out.println( RemoteControl.MAX_VOLUME );     // 10
        System.out.println( RemoteControl.MIN_VOLUME );     // 0

        // [문제 3] 다형성: 인터페이스 타입 변환
        Runnable runner;            // Runnable 타입의 변수 runner를 선언
        runner = new Person();      // runner 변수에 new Person()을 대입
        runner.run();               // run() 메소드를 호출
        runner = new Car();         // 그 다음 new Car()를 대입
        runner.run();               // run() 메소드를 호출

        // [문제 4] 다형성을 활용한 매개변수
        // 4. main 함수에서 Sword 객체와 Gun 객체를 생성한 뒤,
        // 이 객체들을 Character의 useWeapon() 메소드에 인자로 전달하여 동작을 확인하세요.
        Sword sword = new Sword();      Gun gun = new Gun();
        Character character = new Character();
        character.useWeapon( sword );
        character.useWeapon( gun );

        // [문제 5] 다중 인터페이스 구현
        Duck duck = new Duck();     // Duck 객체를 생성
        duck.fly();
        duck.swimmable();

        // [문제 6] instanceof와 인터페이스
        Object object1 = new Duck();                    // Duck 객체를 생성하고, Object 타입의 변수에 저장
        if ( object1 instanceof Flyable ){
            Flyable flyable = (Flyable) object1;        // 해당 인터페이스 타입으로 강제 형변환
            flyable.fly();
        } // if end

        Object object2 = new Duck();                    // Duck 객체를 생성하고, Object 타입의 변수에 저장
        if ( object2 instanceof Swimmable ){
            Swimmable swimmable = (Swimmable) object2;  // 해당 인터페이스 타입으로 강제 형변환
            swimmable.swimmable();
        } // if end

        // [문제 7] 인터페이스를 이용한 객체 교체
        DataAccessObject dao;       // DataAccessObject 타입의 변수 dao를 선언
        dao = new OracleDao();      // dao에 new OracleDao()를 대입
        dao.save();                 // save()를 호출
        dao = new MySqlDao();       // 그 다음 new MySqlDao()를 대입
        dao.save();                 // save()를 호출

        // [문제 8] 익명 구현 객체
        Greeting greeting = new Greeting() {
            public void welcome() {
                System.out.println("익명 구현체 구현");
            } // func end
        }; // 익명구현체 end
        greeting.welcome();

        // [문제 9] 디폴트 메소드 (Default Method)
        // turnOn(), turnOff()와 함께 디폴트 메소드인 setMute()도 호출되는 것을 확인하세요
        Television tv = new Television();       // Television 객체를 생성
        tv.turnOn();        tv.turnOff();
        tv.setMute( true );
        tv.setMute( false );

        // [문제 10] 정적 메소드 (Static Method)
        int result = Calculator.plus( 10, 20 );
        System.out.println( result );

    } // main end
} // class end
