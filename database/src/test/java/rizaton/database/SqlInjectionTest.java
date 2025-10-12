package rizaton.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlInjectionTest {
    @Test
    void testSqlInjection() throws SQLException {
        Connection conn = ConnectionUtil.getDataSource().getConnection();

        Statement stmt = conn.createStatement();

        String username = "admin'; #'";
        String password = "salah";

        String sql = "SELECT * FROM admin WHERE " +
                "USERNAME = '" + username + "' " +
                "AND PASSWORD = '" + password + "'";

        System.out.println("sql: " + sql);

        ResultSet rs = stmt.executeQuery(sql);

        if (rs.next()) {
            System.out.println("Welcome : " + rs.getString("USERNAME"));
        } else {
            System.out.println("Login failed");
        }

        rs.close();
        stmt.close();
        conn.close();
    }
}
