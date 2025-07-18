package Day15;

public class OracleDao implements DataAccessObject {
    @Override
    public void save() {
        System.out.println("Oracle DB에 저장");
    }
} // class end
