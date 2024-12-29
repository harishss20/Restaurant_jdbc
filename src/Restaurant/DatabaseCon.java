package Restaurant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseCon {

    private final String url="";
    private final String user="";
    private final String password="";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
