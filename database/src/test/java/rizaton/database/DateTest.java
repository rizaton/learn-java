package rizaton.database;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class DateTest {
    @Test
    void testDate() throws SQLException {
        Connection conn = ConnectionUtil.getDataSource().getConnection();

        String sql = """
            INSERT INTO sample_time(sample_time, sample_date, sample_timestamp) VALUES (?, ?, ?);
        """;

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setTime(1, new Time(System.currentTimeMillis()));
        stmt.setDate(2, new Date(System.currentTimeMillis()));
        stmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));

        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }

    @Test
    void testQuery() throws SQLException {
        Connection conn = ConnectionUtil.getDataSource().getConnection();

        String sql = "SELECT * FROM sample_time";

        PreparedStatement stmt = conn.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Time time = rs.getTime("sample_time");
            System.out.println("Time " + time);
            Date date = rs.getDate("sample_date");
            System.out.println("Date " + date);
            Timestamp timestamp = rs.getTimestamp("sample_timestamp");
            System.out.println("Timestamp " + timestamp);
        }

        rs.close();
        stmt.close();
        conn.close();
    }
}
