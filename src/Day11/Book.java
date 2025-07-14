package Day11;

public class Book {
    // 1. 멤버변수 - 무조건 private
    private String title;
    private String author;
    // 2. 생성자 - 기본생성자, 전체생성자
    // 기본생성자
    public Book(){}
    // 전체생성자
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    // 3. 메소드 - getter / setter / toString
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
