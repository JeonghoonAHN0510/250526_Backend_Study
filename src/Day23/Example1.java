package Day23;

import java.util.ArrayList;
import java.util.List;

public class Example1 {
    public static void main(String[] args) {
        /*
        [ 컬렉션 프레임워크 ]
        - 자료구조 틀
        - 인터페이스 종류 : List, Set, Map...
        - 구현체 종류
            1) List : ArrayList, LinkedList, Vector...
                (1) .add(자료)
                (2) .set( 인덱스, 자료 )
                (3) .get(인덱스)
                (4) .size()
                (5) .contains(자료)
                (6) .indexOf(자료)
                (7) .remove(인덱스)
                (8) .isEmpty()
                (9) .clear()
            2) Set  : HashSet, TreeSet...
            3) Map  : HashMap, TableMap...


        */
        // [1] 인터페이스타입 변수명 = new 구현체명();
        ArrayList<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        // [2] List 인터페이스 주요 메소드
        // 1) .add(자료) : 지정한 자료를 리스트 내 마지막에 추가
        list2.add("유재석");   list2.add("강호동");
        list2.add("신동엽");   list2.add("유재석");   // 중복 허용
        list2.add( 2, "서장훈");       // 리스트 내 지정한 인덱스 앞에 추가
        System.out.println("list2 = " + list2);
        // 2) .set( 인덱스, 자료 ) : 리스트 내 지정한 인덱스 자료를 지정한 자료로 수정
        list2.set( 0, "유재석2");
        System.out.println("list2 = " + list2);
        // 3) .get(인덱스) : 리스트 내 지정한 인덱스의 자료 반환
        String get = list2.get( 2 );
        System.out.println("get = " + get);         // '서장훈' 반환
        // 4) .size() : 리스트 내 자료 개수 반환
        int size = list2.size();
        System.out.println("size = " + size);       // 5 반환
        // 5) .contains(자료) : 리스트 내 지정한 자료가 존재하면 true, 없으면 false
        boolean contains = list2.contains("서장훈");
        System.out.println("contains = " + contains);   // true 반환
        // 6) .indexOf(자료) : 리스트 내 지정한 자료의 인덱스 반환(만약 없으면, -1 반환)
        int index1 = list2.indexOf("서장훈");
        System.out.println("index1 = " + index1);     // 2 반환
        int index2 = list2.indexOf("박명수");
        System.out.println("index2 = " + index2);     // -1 반환
        // 7) .remove(인덱스) : 리스트 내 지정한 인덱스의 자료 삭제
        list2.remove(2);        // 2번 인덱스의 자료인 '서장훈' 삭제
        System.out.println("list2 = " + list2);
        // 8) .isEmpty() : 리스트 내 요소가 비어있으면 true, 존재하면 false
        boolean empty = list2.isEmpty();
        System.out.println("empty = " + empty);     // false 반환
        // 9) .clear() : 리스트 내 모든 요소 삭제
        // list2.clear();
        System.out.println("list2 = " + list2);

        // [3] 리스트와 반복문 활용
        // 1) 일반 for문
        for ( int i = 0; i < list2.size(); i++ ){
            System.out.println("i = " + i);
        } // for end
        // 2) 향상된 for문
        for ( String str : list2 ){
            System.out.println("str = " + str);
        } // for end
        // 3) forEach문 : 리스트 내 요소를 반복변수에 대입하여, 실행문 처리를 반복한다.
        // 리스트명.forEach( (반복변수) -> {실행문} );
        // 람다식 함수 : 복잡한 함수 선언 방식을 간소화, (매개변수) -> {실행문}
        list2.forEach( (str) -> {
            System.out.println("str = " + str);
        });

    } // main end
} // class end
