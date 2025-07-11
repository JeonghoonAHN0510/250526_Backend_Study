package 종합.예제7.model.dto;

// BoardDto의 역할 : 데이터의 모델이면서 이동 객체

public class BoardDto {
    // 1. 멤버변수 : private로 선언
    private String content;
    private String writer;
    // 2. 생성자 : 기본 생성자, 모든 멤버변수를 갖는 생성자 각 1개씩 필수
    // 기본 생성자
    public BoardDto(){}
    // 모든 멤버변수를 갖는 생성자
    public BoardDto(String content, String writer) {
        this.content = content;
        this.writer = writer;
    }
    // 3. 메소드
    // 1) getter / setter
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
    // 2) toString()
    @Override
    public String toString() {
        return "BoardDto{" +
                "content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }
}
