package Day15;

public class Duck implements Swimmable, Flyable {
    @Override
    public void fly() {
        System.out.println("하늘을 납니다.");
    } // func end
    @Override
    public void swimmable() {
        System.out.println("물에서 헤엄칩니다.");
    } // func end
} // class end
