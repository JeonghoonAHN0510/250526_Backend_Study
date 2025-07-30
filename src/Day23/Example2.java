package Day23;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Example2 {
    public static void main(String[] args) {
        /*
        [ 컬렉션 프레임워크 ] - Set : 순서 보장없이 요소들을 저장하는 구조(집합 구조)
        1. HashSet : 중복없는 여러개의 요소 저장 + 빠르다
        2. TreeSet : 중복없는 여러개의 요소 저장 + 자동정렬(오름차순)
        3. LinkedHashSet : 중복없는 여러개의 요소 저장 + 링크구조 + 느리다
        */
        // [1] HashSet 객체 생성
        Set<String> set1 = new HashSet<>();

        // [2] Set 인터페이스 주요 메소드
        // 1) .add(자료) : 지정한 자료를 집합에 추가
        set1.add("유재석");    set1.add("강호동");
        set1.add("신동엽");    set1.add("유재석");        // 이미 존재하는 자료는 중복이므로 불가능
        System.out.println("set1 = " + set1);           // [유재석, 강호동, 신동엽]
        // 2) .size() : 집합 내 자료 개수 반환
        int size = set1.size();
        System.out.println("size = " + size);
        // 3) .contains(자료) : 집합 내 자료가 존재하면 true, 없으면 false
        boolean contains = set1.contains("강호동");
        System.out.println("contains = " + contains);
        // 4) .remove(자료) : 집합 내 자료 삭제
        set1.remove("강호동");
        System.out.println("set1 = " + set1);           // [유재석, 신동엽]
        // 5) .isEmpty() : 집합 내 자료가 없으면 true, 있으면 false
        boolean empty = set1.isEmpty();
        System.out.println("empty = " + empty);
        // 6) .clear() : 집합 내 모든 자료 삭제
        // set1.clear();

        // [3] 집합과 반복문 활용
        // 1) 일반 for문 -> 표현할 수 없음 ( 인덱스가 없기 때문에 )
        // 2) 향상된 for문
        for ( String str : set1 ){
            System.out.println("str = " + str);
        } // for end
        // 3) forEach문
        set1.forEach( str -> System.out.println("str = " + str) );

        // [4] 구현체
        // 1) HashSet
        HashSet<Integer> hashSet = new HashSet<>();

        // 2) LinkedHashSet : 중복없는 여러개의 요소 저장 + 링크구조 + 느리다
        LinkedHashSet linkedHashSet = new LinkedHashSet();

        // 3) TreeSet
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add( 30 );  treeSet.add( 20 );
        System.out.println("treeSet = " + treeSet);     // [20, 30]

        // Set 인터페이스와 구현체
        Set<Integer> set2;
        set2 = hashSet;
        set2 = linkedHashSet;
        set2 = treeSet;

        // [5] 활용 : JDBC에서의 ResultSet

    } // main end
} // class end
