package rizaton.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementTest {
    @Test
    void testCreateStatement() throws SQLException {
        Connection conn = ConnectionUtil.getDataSource().getConnection();
        Statement stmt = conn.createStatement();

        stmt.close();
        conn.close();
    }

    @Test
    void testExecuteUpdate() throws SQLException {
        Connection conn = ConnectionUtil.getDataSource().getConnection();

        Statement stmt = conn.createStatement();

        String sql = """
                INSERT INTO customers(id, name, email) VALUES
                ('tony','Tony', 'tony@test.com');
                """;
        int update = stmt.executeUpdate(sql);
        System.out.println(update);

        stmt.close();
        conn.close();

    }

    @Test
    void testExecuteDelete() throws SQLException {
        Connection conn = ConnectionUtil.getDataSource().getConnection();

        Statement stmt = conn.createStatement();

        String sql = """
                DELETE FROM customers;
                """;
        int update = stmt.executeUpdate(sql);
        System.out.println(update);

        stmt.close();
        conn.close();
    }

    @Test
    void testExecuteQuery() throws SQLException {
        Connection conn = ConnectionUtil.getDataSource().getConnection();

        Statement stmt = conn.createStatement();

        String sql = """
                SELECT * FROM customers;
                """;
        ResultSet rs = stmt.executeQuery(sql);

        rs.close();
        stmt.close();
        conn.close();
    }
}
