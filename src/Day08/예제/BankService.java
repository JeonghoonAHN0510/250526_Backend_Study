package Day08.예제;

import java.util.Scanner;

public class BankService { // BankService class start
    public static void main(String[] args) { // main start

        BankController bc = new BankController();
        
        for ( ; ; ){ // 무한루프 start
            // 반복 출력문
            System.out.println("==================== KB Bank ====================");
            System.out.println("  1.계좌등록 | 2.입금 | 3.출금 | 4.잔고 | 5.계좌이체");
            System.out.println("=================================================");
            // Scanner를 통해 입력받기
            Scanner scan = new Scanner(System.in);
            System.out.print("선택 : ");      int option = scan.nextInt();
            // 선택에 따라 출력하기
            if ( option == 1 ){         // 1을 선택하면
                System.out.println("------- 계좌 등록 (보내는 사람) -------");
                System.out.print("계좌번호 : ");      String accountId = scan.next();
                System.out.print("비밀번호 : ");      String pwd = scan.next();
                boolean result = bc.accountRegis( accountId, pwd );
                if ( result ){
                    System.out.println("[안내] 계좌 등록이 완료되었습니다.");
                }else {
                    System.out.println("[경고] 계좌 등록에 실패하였습니다.");
                }
            }else if ( option == 2 ){   // 2를 선택하면
                
            }else if ( option == 3 ){   // 3을 선택하면

            }else if ( option == 4 ){   // 4를 선택하면

            }else if ( option == 5 ){   // 5를 선택하면

            }else {                     // 유효성 검사
                System.out.println("[경고] 잘못된 선택입니다. 다시 선택해주세요.");
            }

        } // 무한루프 end
    } // main end
} // BankService class end
