package P2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class OracleBaseDao {
    private Connection myConnection = null;

    protected Connection getConnection() {
        String url = "jdbc:oracle:thin:@localhost:32118:xe";
        String username = "JANWILLEM2";
        String password = "JANWILLEM2";

        if (myConnection == null) {
            try {
                myConnection = DriverManager.getConnection(url, username, password);
            } catch (Exception exc) {
                exc.printStackTrace();
            }
        }

        return myConnection;
    };

    public void closeConnection() {
        try {
            myConnection.close();
            myConnection = null;
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
