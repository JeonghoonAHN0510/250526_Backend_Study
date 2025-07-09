package Day08;

public class BankAccount { // BankAccount class start
    String accountNumber;
    String ownerName;
    int balance;
    // 세 멤버 변수를 모두 초기화하는 생성자를 만드세요.
    BankAccount( String accountNumber, String ownerName, int balance ){
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }
    // 입금(deposit)과 출금(withdraw) 기능을 하는 메소드를 각각 만드세요.
    // 입금 메소드
    // 메소드명 : deposit
    // 매개변수 : num -> 입금액
    // 리턴값 : X      -> 강사님은 잔액이나 성공실패 여부를 리턴하심.
    void deposit(int num){
        balance += num;
    }
    // 출금 메소드
    // 메소드명 : withdraw
    // 매개변수 : num -> 출금액
    // 리턴값 : X
    void withdraw(int num){
        balance -= num;
    }
} // BankAccount class end
