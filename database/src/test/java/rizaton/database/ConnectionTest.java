package rizaton.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
    @BeforeAll
    static void setUp() throws SQLException, ClassNotFoundException {
        Driver driver = new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(driver);
        System.out.println("Driver Registered!");
    }

    @Test
    void testConnection() {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jdbc-test",
                    "root", "");

            System.out.println("Connected to database successfully");
        } catch (SQLException ex) {
            Assertions.fail(ex);
        }
    }

    @Test
    void testConnectionClosed() {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jdbc-test",
                "root", "")) {

            System.out.println("Connected to database successfully");
            System.out.println(conn.getMetaData().getDriverName());
            System.out.println("Connection closed successfully");
        } catch (SQLException ex) {
            Assertions.fail(ex);
        }
    }
}
