package Day08;

public class Goods { // Goods class start
    String name;
    int price;
    // 기본 생성자 : name은 "미정", price는 0으로 초기화
    Goods(){
        name = "미정";
        price = 0;
    }
    // 매개변수가 있는 생성자: name과 price를 매개변수로 받아 초기화
    Goods( String name, int price ){
        this.name = name;
        this.price = price;
    }
} // Goods class end
