package rizaton.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetTest {
    @Test
    void testExecuteQuery() throws SQLException {
        Connection conn = ConnectionUtil.getDataSource().getConnection();

        Statement stmt = conn.createStatement();

        String sql = """
                SELECT * FROM customers;
                """;
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            String id = rs.getString("customers.id");
            String name = rs.getString("customers.name");
            String email = rs.getString("customers.email");
            System.out.println(
                String.join(", ", id, name, email)
            );
        }

        rs.close();
        stmt.close();
        conn.close();
    }
}
