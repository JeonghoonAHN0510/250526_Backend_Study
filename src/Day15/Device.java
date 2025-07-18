package Day15;

public interface Device {
    // turnOn(), turnOff() 추상 메소드와 함께,
    void turnOn();
    void turnOff();
    // public default void setMute(boolean mute) 디폴트 메소드를 추가하세요.
    // 디폴트 메소드는 "무음 처리합니다."를 출력하도록 구현합니다.
    public default void setMute( boolean mute ){
        if ( mute ){
            System.out.println("무음모드 On");
        } else {
            System.out.println("무음모드 Off");
        } // if end
    } // func end
} // interface end
