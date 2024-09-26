package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// 1. 정적 변수 선언
// 2. private 생성자 선언
// 3. public 정적 메서드 선언
public class DatabaseConnection {

    // 1.
    private static DatabaseConnection instance;

    // Connection 객체 선언
    private Connection connection;

    // 데이터베이스 연결 정보
    private String url = "jdbc:mysql://localhost:3306/db_tboard?serverTimezone=Asia/Seoul";
    private String username = "root";
    private String password = "asd123";

    // 2.
    private DatabaseConnection() throws SQLException {

        try {
            // JDBC 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    // 3.
    public static synchronized DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        } 
        return instance;
    }

    // Connection 객체 반환 메서드
    public Connection getConnection() {
        return connection;
    }

}
