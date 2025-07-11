package Day09;

public class TicketMachine {
    // 1. 멤버변수
    static int totalTickets = 0;    // 정적 변수 선언
    // 2. 생성자

    // 3. 메소드
    // 티켓 발권 메소드 ( 일반 메소드 )
    void issueTicket(){
        totalTickets++;
        System.out.println("티켓 1장을 발권했습니다.");
    }
    // 발권된 티켓수 출력 메소드 ( 객체가 필요없는 정적 메소드 )
    static void printTotalTickets(){
        System.out.printf("총 발권 수 : %d장\n", totalTickets);
    }

}
