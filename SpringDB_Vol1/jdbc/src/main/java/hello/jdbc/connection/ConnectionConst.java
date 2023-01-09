package hello.jdbc.connection;


/**
 * 상수기 때문에 객체 생성을 하지 못하도록 abstract 추상 클래스로 만들었다.
 */
public abstract class ConnectionConst {
    public static final String URL = "jdbc:mariadb://localhost:3306/springdb";
    public static final String USERNAME = "jdbc";
    public static final String PASSWORD = "jdbc";
}
