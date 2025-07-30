package Day23;

import java.util.*;

public class Example3 {
    public static void main(String[] args) {
        /*
        [ 컬렉션 프레임워크 ]
        - Map : 순서없이 key + value를 한 쌍(entry)으로 구성하여, 여러 쌍을 저장하는 구조
            -> 자바에는 JSON이 없어서 JSON과 비슷한 형식을 가지는 Map이 존재
            -> JSON이란? 자바스크립트에서 사용하는 객체 형식(key + value가 한 쌍)
        1. HashMap       : key와 value를 한 쌍(entry)으로 구성하여 여러 쌍을 저장하는 구조
        2. HashTable     : key와 value를 한 쌍(entry)으로 구성하여 여러 쌍을 저장하는 구조 + 메소드 동기화
        3. TreeMap       : key와 value를 한 쌍(entry)으로 구성하여 여러 쌍을 저장하는 구조 + key 기준으로 자동정렬(오름차순)
        4. Properties    : key와 value를 한 쌍(entry)으로 구성하여 여러 쌍을 저장하는 구조 + 제네릭이 없는 구조
        */
        // [1] HashMap 객체 생성, < key타입, value타입 >
        Map< String, Integer > map = new HashMap<>();

        // [2] Map 인터페이스 주요 메소드
        // 1) .put( key자료, value자료 ) : map 객체 내에 key와 value를 한 쌍으로 구성하여 저장
        map.put( "유재석", 95 );       // key : "유재석", value : 95
        map.put( "강호동", 90 );       // key : "강호동", value : 90
        map.put( "신동엽", 75 );       // key : "신동엽", value : 75
        map.put( "유재석", 64 );       // key는 중복 불가능 -> value가 덮어씌어진다.
        map.put( "서장훈", 90 );       // value는 중복 가능
        System.out.println("map = " + map);         // {서장훈=90, 유재석=64, 강호동=90, 신동엽=75}
        // 2) .get( key값 ) : map 객체 내에서 지정한 key의 value 반환
        int value = map.get("유재석");
        System.out.println("value = " + value);     // 64
        // 3) .size() : map 객체 내 entry 개수 반환
        int entry = map.size();
        System.out.println("entry = " + entry);     // entry : 4개, 자료 : 8개
        // 4) .remove( key값 ) : map 객체 내애서 지정한 key의 entry 삭제
        map.remove("유재석");
        System.out.println("map = " + map);         // {서장훈=90, 강호동=90, 신동엽=75}
        // 5) .contains( key값|value값 ) : map 객체 내에 지정한 값이 존재하면 true, 없으면 false
        boolean containKey = map.containsKey("강호동");
        System.out.println("containKey = " + containKey);
        boolean containValue = map.containsValue( 90 );
        System.out.println("containValue = " + containValue);
        // 6) .clear() : map 객체 내 모든 entry 삭제
        // map.clear();
        // 7) .isEmpty() : map 객체 내 entry가 없으면 true, 있으면 false
        boolean empty = map.isEmpty();
        System.out.println("empty = " + empty);
        // * .entrySet() : map 객체 내 모든 entry를 set 인터페이스로 반환
        System.out.println( map.entrySet() );       // [서장훈=90, 강호동=90, 신동엽=75]
        // * .keySet() : map 객체 내 모든 key를 set 인터페이스로 반환
        System.out.println( map.keySet() );         // [서장훈, 강호동, 신동엽]
        // * .values() : map 객체 내 모든 value를 List 인터페이스로 반환
        System.out.println( map.values() );         // [90, 90, 75]

        // [3] Map과 반복문 활용
        // 1) 일반 for문 -> 표현할 수 없음 ( 인덱스가 없기 때문에 )
        // 2) 향상된 for문
        System.out.println("===========");
        for( String key : map.keySet() ){
            System.out.println("key = " + key);                 // key를 뽑아내고
            System.out.println("value = " + map.get( key ));    // key를 이용하여 value를 뽑아낸다. -> 반대는 불가능
        } // for end
        // 3) forEach문
        System.out.println("===========");
        map.keySet().forEach( (key) -> {
            System.out.println("key = " + key);
            System.out.println("value = " + map.get( key ));
        });

        // [4] 활용 : 자바에는 JSON이 없어서 JSON과 비슷한 형식을 가지는 Map이 존재

        // [5] 구현체
        // 1) HashMap       : key와 value를 한 쌍(entry)으로 구성하여 여러 쌍을 저장하는 구조
        HashMap< Integer, String > hashMap = new HashMap<>();
        // 2) HashTable     : key와 value를 한 쌍(entry)으로 구성하여 여러 쌍을 저장하는 구조 + 메소드 동기화
        Hashtable< Integer, String > hashtable = new Hashtable<>();
        // 3) TreeMap       : key와 value를 한 쌍(entry)으로 구성하여 여러 쌍을 저장하는 구조 + key 기준으로 자동정렬(오름차순)
        TreeMap< Integer, String > treeMap = new TreeMap<>();
        // 4) Properties    : key와 value를 한 쌍(entry)으로 구성하여 여러 쌍을 저장하는 구조 + 제네릭이 없는 구조
        // -> 주로 설정 파일로 사용
        Properties properties = new Properties();

        // [6] 다형성
        Map< Integer, String > map1;
        map1 = hashMap;
        map1 = hashtable;
        map1 = treeMap;

    } // main end
} // class end
