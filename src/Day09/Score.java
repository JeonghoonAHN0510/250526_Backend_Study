package Day09;

public class Score {
    // 1. 멤버변수
    private int score;
    // 2. 생성자

    // 3. 메소드
    // 점수 설정 setScore() 정의
    public void setScore(int score) {
        if ( score >= 0 && score <= 100 ){  // 0 이상 100 이하일 때만
            this.score = score;             // 멤버변수에 저장하고
        }else {                             // 범위를 벗어나면
            System.out.println("유효하지 않은 점수입니다.");   // 경고문 출력
        }
    }
}
