package Day15;

public class MySqlDao implements DataAccessObject {
    @Override
    public void save() {
        System.out.println("MySQL DB에 저장");
    } // func end
} // class end
