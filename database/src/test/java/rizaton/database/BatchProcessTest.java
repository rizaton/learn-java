package rizaton.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcessTest {

    @Test
    void testStatement() throws SQLException {
        Connection conn = ConnectionUtil.getDataSource().getConnection();
        Statement stmt = conn.createStatement();

        String sql = "INSERT INTO comments (email, comment) VALUES ('iza@test.com', 'hi')";

        for (int i = 0; i < 1000; i++) {
            stmt.addBatch(sql);
        }

        stmt.executeBatch();

        stmt.close();
        conn.close();
    }

    @Test
    void testPreparedStatement() throws SQLException {
        Connection conn = ConnectionUtil.getDataSource().getConnection();

        String sql = "INSERT INTO comments (email, comment) VALUES (?, ?)";

        PreparedStatement stmt = conn.prepareStatement(sql);

        for (int i = 0; i < 1000; i++) {
            stmt.clearParameters();
            stmt.setString(1, "iza" + i + "@test.com");
            stmt.setString(2, "hi" + i);
            stmt.addBatch();
        }

        stmt.executeBatch();

        stmt.close();
        conn.close();
    }
}
