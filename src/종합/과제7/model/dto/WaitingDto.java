package 종합.과제7.model.dto;

public class WaitingDto {
    // 1. 멤버변수
    private String phone;
    private int count;
    // 2. 생성자 : 기본생성자 / 전체생성자
    public WaitingDto() {}
    public WaitingDto(String phone, int count) {
        this.phone = phone;
        this.count = count;
    }
    // 3. 메소드 : getter / setter / toString()
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }
    public String toString() {
        return "WaitingDto{" +
                "phone='" + phone + '\'' +
                ", count=" + count +
                '}';
    } // func end
} // class end
