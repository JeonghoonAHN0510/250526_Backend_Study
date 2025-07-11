package 종합.과제5.model.dto;

// DTO : 데이터 모델
// -> 싱글톤을 만들면 안 됨.

public class WaitingDto {
    // 1. 멤버변수
    private String phone;
    private int count;
    // 2. 생성자 : 기본생성자 + 모든 멤버변수를 갖는 생성자
    public WaitingDto(){ }
    public WaitingDto(String phone, int count) {
        this.phone = phone;
        this.count = count;
    }
    // 3. 메소드 : getter/setter + toString()
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "WaitingDto{" +
                "phone='" + phone + '\'' +
                ", count=" + count +
                '}';
    }
} // class end
