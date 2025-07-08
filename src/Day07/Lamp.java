package Day07;

public class Lamp { // Lamp class start
    boolean isOn = false;
    // 멤버변수 x, 반환값 x -> void ()
    void turnOn(){      // turnOn 호출하면
        isOn = true;    // isOn이 true가 되고
    }
    void turnOff(){     // turnOff 호출하면
        isOn = false;   // isOn이 false가 되고
    }
} // Lamp class end
