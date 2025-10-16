package rizaton.database;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class MetaDataTest {
    @Test
    void testDatabaseMetaData() throws SQLException {
        Connection conn = ConnectionUtil.getDataSource().getConnection();
        DatabaseMetaData metaData = conn.getMetaData();

        System.out.println("Database Product Name : " + metaData.getDatabaseProductName());
        System.out.println("Database Product Version : " + metaData.getDatabaseProductVersion());

        ResultSet rs = metaData.getTables("jdbc-test", null, null, null);
        while (rs.next()) {
            System.out.println("Table : " + rs.getString("TABLE_NAME"));
        }

        rs.close();
        conn.close();
    }

    @Test
    void testParameterMetaData() throws SQLException {
        Connection conn = ConnectionUtil.getDataSource().getConnection();
        String sql = "INSERT INTO comments(email, comment) VALUES (?, ?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();

        System.out.println(parameterMetaData.getParameterCount());
//        System.out.println(parameterMetaData.getParameterType(1)); MySQL driver not supported
//        System.out.println(parameterMetaData.getParameterType(2));

        preparedStatement.close();
        conn.close();
    }

    @Test
    void testResultSetMetaData() throws SQLException {
        Connection conn = ConnectionUtil.getDataSource().getConnection();
        Statement statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM sample_time");

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        System.out.println(resultSetMetaData.getColumnCount());

        for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
            System.out.println("Name : " + resultSetMetaData.getColumnName(i));
            System.out.println("Type : " + resultSetMetaData.getColumnType(i));
            System.out.println("Type name : " + resultSetMetaData.getColumnTypeName(i));
            if (resultSetMetaData.getColumnType(i) == Types.INTEGER) {
                System.out.println("This is INTEGER");
            }
        }

        resultSet.close();
        statement.close();
        conn.close();
    }
}
