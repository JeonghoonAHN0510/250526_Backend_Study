package Day08;

public class Rectangle { // Rectangle class start
    int width;
    int height;
    // width와 height를 매개변수로 받아 초기화하는 생성자를 만드세요.
    Rectangle( int width, int height ){
        this.width = width;
        this.height = height;
    }
    // 사각형의 넓이(width * height)를 계산하여 반환하는 getArea() 메소드를 만드세요.
    int getArea(){
        return width * height;
    }
} // Rectangle class end
