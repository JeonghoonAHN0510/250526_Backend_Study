package 종합.과제4;

public class Waiting { // Waiting class start
    // 1. 멤버변수 -> private로 생성
    private String phone;
    private int count;
    // 2. 생성자 -> 기본생성자 1개, 모든 멤버변수를 갖는 생성자 1개
    public Waiting(){

    }
    public Waiting(String phone, int count) {
        this.phone = phone;
        this.count = count;
    }
    // 3. 메소드 -> getter / setter 메소드 생성( private 멤버변수에 접근하기 위해서)
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
} // Waiting class end
