package rizaton.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseTransactionTest {

    @Test
    void testCommit() throws SQLException {
        Connection conn = ConnectionUtil.getDataSource().getConnection();
        conn.setAutoCommit(false);

        String sql = "INSERT INTO comments(email, comment) VALUES (?, ?)";

        for (int i = 0; i < 100; i++) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "test@example.com");
            stmt.setString(2, "test");
            stmt.executeUpdate();
            stmt.close();
        }

        conn.commit();
        conn.close();

    }

    @Test
    void testRollback() throws SQLException {
        Connection conn = ConnectionUtil.getDataSource().getConnection();
        conn.setAutoCommit(false);

        String sql = "INSERT INTO comments(email, comment) VALUES (?, ?)";

        for (int i = 0; i < 100; i++) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "test@example.com");
            stmt.setString(2, "test");
            stmt.executeUpdate();
            stmt.close();
        }

        conn.rollback();
        conn.close();

    }
}