package Day15;

public class Television implements Device {
    // Device를 구현하도록 하되, turnOn(), turnOff()만 오버라이딩하세요.
    public void turnOn() {
        System.out.println("TV 전원 켜기");
    } // func end
    public void turnOff() {
        System.out.println("TV 전원 끄기");
    } // func end
} // class end
