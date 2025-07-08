package Day07;

public class Product { // Product class start
    String name;
    int stock;
    // 매개변수 o, 반환값 o -> boolean (매개변수)
    boolean sell(int x){
        if ( stock >= x ){
            stock -= x;
            return true;
        }else {
            System.out.println("재고 부족");
            return false;
        }
    }
} // Product class end
