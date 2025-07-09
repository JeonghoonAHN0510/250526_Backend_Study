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
    void deposit(int num){
        balance += num;
    }
    void withdraw(int num){
        balance -= num;
    }
} // BankAccount class end
