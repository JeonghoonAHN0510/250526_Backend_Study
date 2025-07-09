package Day08.예제;

public class    Account { // Account class start
    String accountId;   // 계좌번호
    String pwd;         // 비밀번호
    int balance;        // 잔고

    Account(String accountId, String pwd) {
        this.accountId = accountId;
        this.pwd = pwd;
        balance = 0;
    }

} // Account class end
