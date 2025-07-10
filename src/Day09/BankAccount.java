package Day09;

public class BankAccount {
    // 1. 멤버변수
    private String accountNumber;
    // 2. 생성자
    public BankAccount(String accountNumber){
        this.accountNumber = accountNumber;
    }
    // 3. 메소드
    // getAccountNumber() 메소드 정의 -> getter 메소드
    public String getAccountNumber(){
        return accountNumber;
    }
}
