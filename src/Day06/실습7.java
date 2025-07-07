package Day06;

import java.util.Arrays;
import java.util.Scanner;

public class 실습7 { // 실습7 class start
    public static void main(String[] args) {
        // 자바에서 객체를 생성하기 위해서는 *클래스*가 필요하다.
            // 방법1) 같은 파일 내에서 여러개 클래스 선언       ( 비권장 방법 )
            // 방법2) 별도의 .java 파일을 생성하여 클래스 선언  ( 권장 방법 )

        // [문제 1] Book 클래스를 만드세요. 이 클래스는 title(문자열), author(문자열), price(정수) 멤버 변수를 가집니다.
        // 1. main 함수에서 Book 객체 2개를 생성하세요.
        // 2. 첫 번째 객체에는 "이것이 자바다", "신용권", 30000을, 두 번째 객체에는 "자바의 정석", "남궁성", 28000을 각각 저장하세요.
        // 3. 두 객체의 모든 정보를 각각 출력하세요.
        // Book 객체 2개 생성
        Book book1 = new Book();
        Book book2 = new Book();
        // 객체에 정보를 각각 저장하기
        book1.title = "이것이 자바다";   book1.author = "신용권";   book1.price = 30000;
        book2.title = "자바의 정석";     book2.author = "남궁성";   book2.price = 28000;
        // 객체의 모든 정보 각각 출력
        System.out.println( book1.title + "\t" + book1.author + "\t" + book1.price );
        System.out.println( book2.title + "\t" + book2.author + "\t" + book2.price );

        // [문제 2] Pet 클래스를 만드세요. name(문자열), species(문자열, 품종), age(정수) 멤버 변수를 가집니다.
        // 1. main 함수에서 Pet 객체 2개를 생성하세요.
        // 2. 첫 번째 객체에는 "초코", "푸들", 3을, 두 번째 객체에는 "나비", "코리안숏헤어", 5를 각각 저장하세요.
        // 3. "이름: [이름], 종류: [품종], 나이: [나이]살" 형식으로 각 반려동물의 프로필을 출력하세요.
        // Pet 객체 2개 생성
        Pet pet1 = new Pet();
        Pet pet2 = new Pet();
        // 객체에 정보를 각각 저장하기
        pet1.name = "초코";   pet1.species = "푸들";           pet1.age = 3;
        pet2.name = "나비";   pet2.species = "코리안숏헤어";    pet2.age = 5;
        // 객체의 모든 정보 출력
        System.out.printf("이름 : [%s], 종류 : [%s], 나이 : [%d]살\n", pet1.name, pet1.species, pet1.age);
        System.out.printf("이름 : [%s], 종류 : [%s], 나이 : [%d]살\n", pet2.name, pet2.species, pet2.age);

        // [문제 3] Rectangle 클래스를 만드세요. width(정수)와 height(정수) 멤버 변수를 가집니다.
        // 1. main 함수에서 Rectangle 객체를 하나 생성하고, width에 10, height에 5를 저장하세요.
        // 2. 해당 객체의 width와 height 값을 곱하여 "사각형의 넓이: [넓이]"를 출력하세요.
        // Rectangle 객체 생성
        Rectangle rectangle = new Rectangle();
        // 해당 객체에 정보 대입
        rectangle.width = 10; rectangle.height = 5;
        // 객체의 값 곱하여 출력
        System.out.printf("사각형의 넓이 : [%d]", rectangle.width * rectangle.height);

        // [문제 4] BankAccount 클래스를 만드세요. accountNumber(문자열), ownerName(문자열), balance(정수, 잔액) 멤버 변수를 가집니다.
        // 1. main 함수에서 BankAccount 객체를 하나 생성하고,
        // 계좌번호는 "111-222-3333", 예금주는 "유재석", 초기 잔액은 10000으로 저장하세요.
        // 2. balance에 5000을 더하여 입금 상황을 구현하고, "입금 후 잔액: [잔액]"을 출력하세요.
        // 3. 다시 balance에서 3000을 빼서 출금 상황을 구현하고, "출금 후 잔액: [잔액]"을 출력하세요.
        // BankAccount 객체 생성
        BankAccount account = new BankAccount();
        // 객체에 정보 저장
        account.accountNumber = "111-222-3333"; account.ownerName = "유재석"; account.balance = 10000;
        // 입금 상황 구현하고,
        account.balance += 5000;
        // 입금 후 잔액 출력
        System.out.printf("입금 후 잔액 : [%d]\n", account.balance );
        // 출금 상황 구현하고,
        account.balance -= 3000;
        // 출금 후 잔액 출력
        System.out.printf("출금 후 잔액 : [%d]\n", account.balance );

        // [문제 5] Product 클래스를 만드세요. name(문자열)과 price(정수) 멤버 변수를 가집니다.
        // 1. main 함수에서 Product 객체 2개를 생성하고,
        // 각각 "새우깡", 1500과 "콜라", 2000 정보를 저장하세요.
        // 2. if문을 사용하여 두 객체의 price를 비교하고, 더 비싼 상품의 이름을 출력하세요.
        // Product 객체 2개 생성
        Product product1 = new Product();
        Product product2 = new Product();
        // 각각의 정보 저장
        product1.name = "새우깡"; product1.price = 1500;
        product2.name = "콜라";   product2.price = 2000;
        // price 비교하고
        if ( product1.price > product2.price ){     // product1이 더 크면
            System.out.println( product1.name );    // product1.name 출력
        }else {                                     // 그렇지 않으면(=product2가 더 크면)
            System.out.println( product2.name );    // product2.name 출력
        }
        // [문제 6] Member 클래스를 만드세요.
        // id(문자열)와 isLogin(boolean) 멤버 변수를 가집니다.
        // 1. main 함수에서 Member 객체를 하나 생성하고,
        // 아이디는 "admin", isLogin은 false로 초기화하세요.
        // 2. "로그인 전 상태: [isLogin 값]"을 출력하세요.
        // 3. 객체의 isLogin 값을 true로 변경하여 로그인 상황을 구현하세요.
        // 4. "로그인 후 상태: [isLogin 값]"을 출력하세요.
        // Member 객체 하나 생성
        Member member1 = new Member();
        // 주어진 값으로 초기화
        member1.id = "admin";   member1.isLogin = false;
        // 로그인 전 상태 출력
        System.out.printf("로그인 전 상태 : [%b]\n", member1.isLogin);
        // member1.isLogin을 true로 변경하고
        member1.isLogin = true;
        // 로그인 후 상태 출력
        System.out.printf("로그인 후 상태 : [%b]\n", member1.isLogin);

        // [문제 7] Television 클래스를 만드세요. channel(정수)과 volume(정수) 멤버 변수를 가집니다.
        // 1. main 함수에서 Television 객체를 생성하고, channel은 7, volume은 20으로 초기화하세요.
        // 2. 객체의 channel 값을 11로 변경하고,
        // volume 값은 2 감소시킨 뒤, 변경된 채널과 볼륨을 출력하세요.
        // Television 객체 생성
        Television tv1 = new Television();
        // 주어진 값으로 초기화
        tv1.channel = 7;    tv1.volume = 20;
        // 변경된 값으로 수정
        tv1.channel = 11;   tv1.volume -= 2;
        // 변경된 채널과 볼륨 출력
        System.out.printf("변경된 채널 : %d, 변경된 볼륭 : %d\n", tv1.channel, tv1.volume);

        // [문제 8] Player 클래스를 만드세요. name(문자열), power(정수), speed(정수) 멤버 변수를 가집니다.
        // 1. main 함수에서 Player 객체 2개를 생성하세요.
        // 2. 첫 번째 객체에는 "손흥민", 90, 95를, 두 번째 객체에는 "이강인", 85, 92를 각각 저장하세요.
        // 3. 두 객체의 power와 speed의 합을 각각 계산하고, 합이 더 높은 선수의 이름을 출력하세요.
        // Player 객체 2개 생성
        Player player1 = new Player();
        Player player2 = new Player();
        // 주어진 값을 각각 저장
        player1.name = "손흥민"; player1.power = 90; player1.speed = 95;
        player2.name = "이강인"; player2.power = 85; player2.speed = 92;
        // 두 객체의 power speed의 합을 계산하고
        int sum1 = player1.power + player1.speed;
        int sum2 = player2.power + player2.speed;
        if ( sum1 > sum2 ){                     // sum1이 더 크다면
            System.out.println( player1.name ); // player1.name 출력
        }else {                                 // 그렇지 않으면(= sum2가 더 크다면)
            System.out.println( player2.name ); // player2.name 출력
        }

        // [문제 9] MenuItem 클래스를 만드세요. name(문자열), price(정수), isSignature(boolean, 대표메뉴 여부) 멤버 변수를 가집니다.
        // 1. main 함수에서 MenuItem 객체 3개를 생성하고,
        // 첫 번째는 "김치찌개", 8000, true, 두 번째는 "된장찌개", 8000, false, 세 번째는 "계란찜", 3000, false로 저장하세요.
        // 2. if문을 사용하여 isSignature가 true인 메뉴 객체를 찾아, "[대표메뉴] [메뉴이름] : [가격]원" 형식으로 출력하세요.
        // MenuItem 객체 3개 출력
        MenuItem menu1 = new MenuItem();
        MenuItem menu2 = new MenuItem();
        MenuItem menu3 = new MenuItem();
        // 주어진 값 저장
        menu1.name = "김치찌개";    menu1.price = 8000;     menu1.isSignature = true;
        menu2.name = "된장찌개";    menu2.price = 8000;     menu2.isSignature = false;
        menu3.name = "계란찜";     menu3.price = 3000;     menu3.isSignature = false;
        // if문을 사용하기
        if (menu1.isSignature){     // isSignature가 true면
            System.out.printf("[대표메뉴] [%s] : [%d]원\n", menu1.name, menu1.price);
        }
        if (menu2.isSignature){     // isSignature가 true면
            System.out.printf("[대표메뉴] [%s] : [%d]원\n", menu2.name, menu2.price);
        }
        if (menu3.isSignature){     // isSignature가 true면
            System.out.printf("[대표메뉴] [%s] : [%d]원\n", menu3.name, menu3.price);
        }

        // [문제 10] UserProfile 클래스를 만드세요. name(문자열), age(정수), mbti(문자열) 멤버 변수를 가집니다.
        // 1. main 함수에서 UserProfile 객체를 하나 생성하세요.
        // 2. Scanner를 사용하여 사용자로부터 이름, 나이, MBTI를 순서대로 입력받으세요.
        // 3. 입력받은 값들을 생성된 객체의 각 멤버 변수에 저장하세요.
        // 4. 모든 정보가 저장된 객체의 멤버 변수들을 가져와
        // "--- 프로필 ---", "이름: [이름]", "나이: [나이]", "MBTI: [MBTI]" 형식으로 출력하세요.
        // UserProfile 객체 생성
        UserProfile user = new UserProfile();
        // Scanner를 사용하여
        Scanner scan = new Scanner(System.in);
        // 이름, 나이, MBTI 입력받기
        System.out.print("이름 : ");
        String name = scan.next();
        System.out.print("나이 : ");
        int age = scan.nextInt();
        System.out.print("MBTI : ");
        String MBTI = scan.next();
        // 입력받은 값을 생성된 객체에 저장
        user.name = name;   user.age = age;     user.mbti = MBTI;
        // 요구사항대로 출력
        System.out.println("--- 프로필 ---");
        System.out.printf("이름: [%s], 나이: [%d], MBTI: [%s]", user.name, user.age, user.mbti);

    }
} // 실습7 class end
class Book{ // Book class start     Book 클래스 선언
    // 멤버변수 선언
    String title;
    String author;
    int price;
} // Book class end

