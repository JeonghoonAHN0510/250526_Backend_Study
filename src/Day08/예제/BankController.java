package Day08.예제;

public class BankController { // BankController class start
    // 계좌 배열 선언하기
    Account[] accounts = new Account[100];

    // 1. 계좌등록 기능
    // 메소드명 : accountRegis
    // 매개변수 : 계좌번호, 비밀번호
    // 반환값   : 성공/실패 -> boolean
    boolean accountRegis( String accountId, String pwd ){
        Account account = new Account( accountId, pwd );    // 매개변수로 입력받은 값을 생성된 객체에 등록
        for ( int i = 0; i < accounts.length; i++ ){
            if ( accounts[i] == null ){
                accounts[i] = account;
                return true;
            }
        }
        return false;
    }

    // 2. 입금 기능
    // 메소드명 : deposit
    // 매개변수 :
    // 반환값   :


    // 3. 출금 기능
    // 메소드명 : withdraw
    // 매개변수 :
    // 반환값   :


    // 4. 잔고 기능
    // 메소드명 : balance
    // 매개변수 :
    // 반환값   :


    // 5. 계좌이체 기능
    // 메소드명 :
    // 매개변수 :
    // 반환값   :


} // BankController class end
