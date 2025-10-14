package rizaton.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AutoIncrementTest {
    @Test
    void testAutoIncrement() throws SQLException {
        Connection conn = ConnectionUtil.getDataSource().getConnection();

        String sql = "INSERT INTO comments (email, comment) VALUES (?, ?)";

        PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

        stmt.clearParameters();
        stmt.setString(1, "iza" + "@test.com");
        stmt.setString(2, "hi");
        stmt.addBatch();
        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id =  rs.getInt(1);
            System.out.println("id Comment : " + id);
        }

        rs.close();
        stmt.close();
        conn.close();
    }
}
