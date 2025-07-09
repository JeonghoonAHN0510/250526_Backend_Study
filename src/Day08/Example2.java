package Day08;

class 학생설계도{ // student class start
    // 멤버변수 = 속성/상태/특징/데이터...
    String name;        // 이름
    String lunchBox;    // 점심도시락

    // 메소드 = 이벤트/행위/동작/사용법...
    void 밥먹기(){
        System.out.println( name + "은 " + lunchBox + "를 먹습니다.");
    }
} // student class end

public class Example2 { // Example2 class start
    public static void main(String[] args) { // main start
        // 아직 객체 만들지 않았음
        // 객체 만들기
        학생설계도 s1 = new 학생설계도();
        s1.name = "유재석";
        s1.lunchBox = "신라면";
        // 이제 객체 1개
        학생설계도 s2 = new 학생설계도();
        s2.name = "강호동";
        s2.lunchBox = "김밥";
        // 이제 객체 2개
        s2.밥먹기();       // 강호동은 김밥을 먹습니다.
        s1.밥먹기();       // 유재석은 신라면을 먹습니다.

        //
        학생설계도[] 학생명단 = new 학생설계도[100];
        학생명단[0] = s1;
        학생명단[0].밥먹기();  // 유재석은 신라면을 먹습니다.


    } // main end
} // Example2 class end
