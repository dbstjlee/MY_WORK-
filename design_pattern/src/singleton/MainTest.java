package singleton;

import java.sql.Connection;
import java.sql.SQLException;

public class MainTest {

    public static void main(String[] args) throws SQLException {

      /*   // 싱글톤 객체를 불러 와보자!!
        SingleTon systemSingleTon1 = SingleTon.getInstance();
        SingleTon systemSingleTon2 = SingleTon.getInstance();

        // 주소값이 같다면
        if(systemSingleTon1 == systemSingleTon2) {
            //System.out.println("같은 객체를 바라보고 있습니다.");
        }
 */
        // connection 객체 생성
        DatabaseConnection connection1 = DatabaseConnection.getInstance();
        Connection conn = connection1.getConnection();
        System.out.println("db 연결?" + conn);

    }

}
