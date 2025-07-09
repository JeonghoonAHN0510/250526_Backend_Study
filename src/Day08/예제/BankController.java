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
        for ( int i = 0; i < accounts.length; i++ ){        // accounts 배열 순회
            if ( accounts[i] == null ){                     // 빈 공간을 찾으면
                accounts[i] = account;                      // 생성한 객체를 대입
                return true;                                // 등록 성공 -> true 반환
            }
        }
        return false;   // 빈 공간을 못 찾아, 등록 실패 -> false 반환
    }
    // 2. 입금 기능
    // 메소드명 : deposit
    // 매개변수 : 계좌번호, 비밀번호, 입금액
    // 반환값   : 성공/실패 -> boolean
    boolean deposit( String accountId, String pwd, int money ){
        for ( int i = 0; i < accounts.length; i++ ){    // 배열을 순회
            Account account = accounts[i];              // i번째 account 변수에 대입
            if ( account != null ){                     // i번째 계좌가 null이 아니라면
                if ( account.accountId.equals(accountId) && account.pwd.equals(pwd) ){  // i번째 계좌가 입력받은 계좌번호와 비밀번호 둘 다 일치한다면
                    account.balance += money;           // 잔고에 입금액 추가
                    return true;                        // 입금 성공 -> true 반환
                }
            }
        }
        return false;   // 같은 계좌를 찾지 못해 입금 실패 -> false 반환
    }
    // 3. 출금 기능
    // 메소드명 : withdraw
    // 매개변수 : 계좌번호, 비밀번호, 출금액
    // 반환값   : 성공/실패 -> boolean
    boolean withdraw( String accountId, String pwd, int money ){
        for ( int i = 0; i < accounts.length; i++ ){    // 배열을 순회
            Account account = accounts[i];              // i번째 account 변수에 대입
            // i번째 계좌가 null이 아니고 입력받은 계좌번호와 비밀번호 둘 다 일치하고 잔고가 출금액보다 많다면
            if ( account != null && account.accountId.equals(accountId) && account.pwd.equals(pwd) && account.balance >= money ){
                account.balance -= money;           // 잔고에서 출금액 빼기
                return true;                        // 출금 성공 -> true 반환
            }
        }
        return false;   // 같은 계좌를 찾지 못해 출금 실패 -> false 반환
    }
    // 4. 잔고 기능
    // 메소드명 : balance
    // 매개변수 : 계좌번호, 비밀번호
    // 반환값   : 잔고 -> int
    int balance( String accountId, String pwd ){
        int result = 0;
        for ( int i = 0; i < accounts.length; i++ ){
            Account account = accounts[i];
            // i번째 계좌가 null이 아니고, 입력받은 계좌번호와 비밀번호 둘 다 일치하면
            if ( account != null && account.accountId.equals(accountId) && account.pwd.equals(pwd) ){
                result = account.balance;
            }
        }
        return result;
    }

    // 5. 계좌이체 기능
    // 메소드명 : transfer
    // 매개변수 : 보내는 계좌번호, 비밀번호, 받는 계좌번호, 이체금액
    // 반환값   : int -> 0 이체완료, 1 잔액부족, 2 계좌불일치
    int transfer( String accountId1, String pwd, String accountId2, int money ){
        int result = 0;
        boolean check1 = false;     // 찾음 확인 변수
        boolean check2 = false;     // 찾음 확인 변수
        Account account1 = null;    // 보내는 계좌 정보 받을 변수
        Account account2 = null;    // 받는 계좌 정보 받을 변수
        // 보내는 계좌정보 찾고
        for ( int i = 0; i < accounts.length; i++){ // 보내는 계좌정보 찾기위해 순회
            Account account = accounts[i];          // i번째 계좌정보 변수에 대입
            if ( account != null ){                 // 등록된 계좌 중에서
                if ( account.accountId.equals(accountId1) && account.pwd.equals(pwd) ){ // 계좌번호, 비밀번호 둘 다 일치하면
                    account1 = account;             // 보내는 계좌 변수에 저장
                    result = 0;                     // 리턴값 바꾸고
                    check1 = true;                  // 찾음 표시
                    break;                          // 찾았으니 반복문 종료
                }
            }
        } // for end
        // 받는 계좌정보 찾고
        for ( int i = 0; i < accounts.length; i++){ // 받는 계좌정보 찾기위해 순회
            Account account = accounts[i];          // i번째 계좌정보 변수에 대입
            if ( account != null ){                 // 등록된 계좌 중에서
                if ( account.accountId.equals(accountId2)){ // 계좌번호가 일치하면
                    account2 = account;             // 받는 계좌 변수에 저장
                    result = 0;                     // 리턴값 바꾸고
                    check2 = true;                  // 찾음 표시
                    break;                          // 찾았으니 반복문 종료
                }
            }
        } // for end
        // 이체금액 이체
        if ( check1 && check2 ){
            if ( account1.balance < money ){            // 보내는 계좌 잔고보다 이체금액이 많으면
                result = 1;
            }else {                                     // 잔고가 이체금액 이상이면
                account1.balance -= money;              // 이체금액을 빼고
                account2.balance += money;              // 이체금액을 더하고
            }
        }
        if ( account1 == null || account2 == null ){
            result = 2;
        }
        return result;
    }
} // BankController class end
