package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection_DB {
    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection("jdbc:mysql://@localhost:8889/test03?user=root&password=");
    }
}
