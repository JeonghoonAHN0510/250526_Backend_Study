package 종합.예제6;

// Board : 데이터 모델 -> 게시물 형식
// -> 기능 구현보다는 데이터를 객체로 바꾸는 역할
public class Board {
    // 1. 멤버변수 : 주로 멤버변수는 private 사용
    // 게시물에 들어갈 속성
    private String content;
    private String writer;
    // 2. 생성자 : 주로 기본 생성자 1개, 모든 멤버변수를 갖는 생성자 1개 필수로 만들고 시작.
    // 1) 기본 생성자
    public Board() {
    }
    // 2) 모든 멤버변수를 갖는 생성자
    public Board(String content, String writer) {
        this.content = content;
        this.writer = writer;
    }
    // 3. 메소드
    // 1) private로 선언된 멤버변수를 외부(다른 클래스)로부터 접근할 수 있도록 getter / setter 생성
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    // 2) 작업하면서 객체의 주소값이 아닌 객체 내 멤버변수값 반환 -> toString() 사용
    // -> 주소값이 아닌 문자열로 반환해준다.
    // -> 코딩하면서 혼자 확인용
    @Override
    public String toString() {
        return "Board{" +
                "content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }
} // class end
