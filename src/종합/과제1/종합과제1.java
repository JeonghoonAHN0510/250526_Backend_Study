package 종합.과제1;

import java.util.Scanner;

public class 종합과제1 { // class start
    public static void main(String[] args) { // main start
        String phone1 = null;       int count1 = 0;
        String phone2 = null;       int count2 = 0;
        String phone3 = null;       int count3 = 0;
        for ( ; ; ){
            Scanner scan = new Scanner(System.in);
            System.out.println("=========== 맛집 대기 시스템 ===========");
            System.out.println("       1.대기 등록 | 2.대기 현황");
            System.out.println("======================================");
            System.out.print("선택 : ");
            int option = scan.nextInt();
            if ( option == 1 ){
                System.out.print("전화번호 : ");
                String phone = scan.next();
                System.out.print("인원수 : ");
                int count = scan.nextInt();
                if ( phone1 == null ){
                    phone1 = phone;
                    count1 = count;
                }else if ( phone2 == null ){
                    phone2 = phone;
                    count2 = count;
                }else if ( phone3 == null ){
                    phone3 = phone;
                    count3 = count;
                }else {
                    System.out.println("[경고] 더 이상 대기 등록을 할 수 없습니다.");
                    continue;
                }
                System.out.println("[안내] 대기 등록이 완료되었습니다.");
            }else if ( option == 2 ){
                System.out.println("============= 대기 현황 =============");
                if ( phone1 != null ){
                    System.out.printf("1. 연락처 : %s - 인원 : %d명\n", phone1, count1);
                    System.out.println("------------------------------------");
                }
                if ( phone2 != null ){
                    System.out.printf("2. 연락처 : %s - 인원 : %d명\n", phone2, count2);
                    System.out.println("------------------------------------");
                }
                if ( phone3 != null ){
                    System.out.printf("3. 연락처 : %s - 인원 : %d명\n", phone3, count3);
                    System.out.println("------------------------------------");
                }
                if ( phone1 == null && phone2 == null && phone3 == null ){
                    System.out.println("[경고] 등록된 대기가 없습니다.");
                }
            }else {
                System.out.println("[경고] 잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    } // main end
} // class end
