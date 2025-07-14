package Day11;

import java.util.ArrayList;

public class Example1 { // class start
    public static void main(String[] args) { // main start
        /*
        [ ArrayList ]
        - 자바에서 미리 제공하는 클래스
        1. 정의 : 컬렉션프레임워크 중 리스트 자료형 클래스
        2. 목적 : 가변 길이의 배열 지원
            - 배열       : 고정 길이, 메소드(기능) 제공 x
            vs
            - ArrayList : 가변 길이, 메소드(기능) 제공 o
        3. 사용법
            1) 선언 방법
            ArrayList<항목타입> 변수명 = new ArrayList<>();
            * <제네릭타입> : 리스트에 저장할 요소들의 타입
            2) 요소 추가
                (1) 변수명.add( 요소값 );           : 마지막 인덱스 뒤에 요소값 추가
                (2) 변수명.add( 인덱스, 요소값 );    : 지정한 인덱스에 요소값 삽입
            3) 요소 수정
                (1) 변수명.set( 인덱스, 새로운값 );    : 지정한 인덱스의 요소값 수정
            4) 요소 출력
                (1) 리스트명                 : 전체 출력
                (2) 리스트명.size();         : 리스트 내 전체 요소 개수 반환
                (3) 리스트명.get(인덱스);     : 지정한 인덱스의 요소값 반환
            5) 요소 삭제
                (1) 변수명.remove( 인덱스 );  : 지정한 인덱스 삭제
        4. ArrayList와 반복문 관계
            (1) 일반 for문
            for ( int i = 0; i < 리스트변수명.size(); i++){
                항목타입 변수명 = 리스트변수명.get( i );
            }
            (2) 향상된 for문
            for ( 항목타입 변수명 : 리스트변수명){
            }
        */
        // [1] ArrayList 객체 생성
        ArrayList<String> 리스트객체 = new ArrayList<>();

        // [2] ArratList 요소 추가 : 변수명.add(요소값);
        리스트객체.add("유재석");

        // [3] ArrayList 출력
        System.out.println("리스트객체 = " + 리스트객체); // soutv : 단축어

        // 요소 추가 : add();
        리스트객체.add("강호동");
        리스트객체.add("신동엽");
        System.out.println( 리스트객체 );
        
        // 요소를 중간에 추가
        리스트객체.add( 1 , "박명수");      // 1번 인덱스 자리에 요소를 추가하고, 나머지를 뒤로 밀어낸다.
        System.out.println( 리스트객체 );
        
        // [4] 요소 수정 : .set();
        리스트객체.set( 1 , "이명수");      // 1번 인덱스 자리의 요소값을 수정한다.
        System.out.println( 리스트객체 );

        // [5] 리스트 크기 확인 : .size();
        System.out.println( 리스트객체.size() );

        // [6] 요소값 출력(반환) : .get(인덱스);  인덱스의 요소값 반환
        System.out.println( 리스트객체.get(0) );     // vs 변수명[0];

        // [7] 요소 삭제 : .remove(인덱스);
        리스트객체.remove(1);              // 1번 인덱스 요소값 삭제
        System.out.println( 리스트객체 );

        // [8] ArrayList와 반복문의 관계
        // 일반 for문
        for ( int i = 0; i < 리스트객체.size(); i++){
            String str = 리스트객체.get(i);
            System.out.println( str );
        }
        // 향상된 for문 : for( 항목타입 변수명 : 리스트명 ){}
        for ( String str : 리스트객체 ){     // 리스트 내 요소값 하나씩 str에 대입 반복
            System.out.println( str );
        }

        // [9] String이 아닌 클래스 타입
        // 1) Member 객체 3개 생성
        Member m1 = new Member( "강호동", 10 );
        Member m2 = new Member( "신동엽", 20 );
        Member m3 = new Member( "유재석", 30 );
        // 2) Member 타입의 객체 3개를 저장할 ArrayList 생성
        ArrayList<Member> memberList = new ArrayList<>();   // <항목타입>
        // 3) ArrayList에 객체 저장
        memberList.add( m1 );
        memberList.add( m2 );
        memberList.add( m3 );
        // 4) ArrayList 순회하기
        // 일반 for문
        for ( int i = 0; i < memberList.size(); i++){
            Member member = memberList.get( i );
            System.out.println("이름 : " + member.name + "\n나이 : " + member.age);
        } // for end
        // 향상된 for문
        for ( Member member : memberList ){
            System.out.println( "이름 : " + member.name );
            System.out.println( "나이 : " + member.age );
        } // for end
    } // main end
} // class end

class Member{
    String name;    // 이름
    int age;        // 나이
    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }
} // class end