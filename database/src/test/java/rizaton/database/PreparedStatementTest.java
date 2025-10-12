package rizaton.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementTest {
    @Test
    void testPrepareStatement() throws SQLException {
        Connection conn = ConnectionUtil.getDataSource().getConnection();

        String username = "admin";
        String password = "admin";

        String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, username);
        stmt.setString(2, password);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            System.out.println("Welcome " + rs.getString("username"));
        } else {
            System.out.println("Fail");
        }

        stmt.close();
        conn.close();
    }
}
