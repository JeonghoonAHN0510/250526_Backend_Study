package Day22;

import java.util.ArrayList;

class Box1{
    String content;
} // class end

class Box2{
    int content;
} // class end

// 클래스를 정의할 때, 타입을 정하지 않고 표현
// -> content에 String/int 등등의 타입을 넣을 수 있음
// 인스턴스를 생성할 때, 타입을 정한다.
class Box< T >{
    T content;
} // class end

class miniArrayList< E >{
    E[] data = (E[]) new Object[10];
}

// [4]
class Dto< T, E >{
    T value1;
    E value2;
} // class end

public class Example3 {
    public static void main(String[] args) {
        /*
        [ 제네릭 타입 ]
        1. 정의 : 여러가지 타입에서 동작할 수 있도록 만든 키워드
        2. 목적 : 클래스를 정의할 때 변수 타입을 정하지 않고, 인스턴스를 생성할 때 변수 타입을 정한다.
                 -> 다양한 타입의 데이터를 처리할 수 있다.
        3. 사용법 : < >를 이용한 표현
            1) 클래스 정의
            class 클래스명 < 제네릭타입 > {
                제네릭타입 변수명;
            }
            2) 인스턴스 생성
            클래스명<제네릭타입> 변수명 = new 생성자명<>();
        4. 활용처 : 컬렉션 프레임워크(실무 중요)
            -> 대표적으로 ArrayList<제네릭타입>
        5. 특징 : 변수 타입의 유연성, 코드 중복제거, 잘못된 타입 방지
        6. 주의할 점 : 기본타입은 사용 불가능 -> 래퍼클래스로 변경하여 사용

        */
        // [1] String 타입 멤버변수에 String 타입 자료
        Box1 box1 = new Box1();
        box1.content = "안녕하세요";          // 저장
        String content1 = box1.content;     // 호출

        // [2] int 타입 멤버변수에 int 타입 자료
        Box2 box2 = new Box2();
        box2.content = 100;                 // 저장
        int content2 = box2.content;        // 호출

        // [3] <T> 제네릭 타입
        Box<String> box3 = new Box<>();
        Box<Integer> box4 = new Box<>();
        box3.content = "제네릭 String";
        box4.content = 100;

        // [4] 제네릭 타입 여러개
        Dto< String, Integer > box5 = new Dto<>();
        box5.value1 = "String";
        box5.value2 = 100;

        Dto< Double, Boolean > box6 = new Dto<>();
        box6.value1 = 10.5;
        box6.value2 = false;
        // 같은 클래스에서 서로 다른 멤버변수 타입을 사용할 수 있다.

        // [활용] 제네릭 중첩
        Dto< Integer, ArrayList<String> > dto1 = new Dto<>();
        ArrayList<String> sList = new ArrayList<>();
        // ArrayList : 타입/클래스, <String> : ArrayList 안에서 사용할 타입/클래스
        dto1.value1 = 100;
        dto1.value2 = sList;

    } // main end
} // class end
