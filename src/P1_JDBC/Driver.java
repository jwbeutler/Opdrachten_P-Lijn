package P1_JDBC;
import java.sql.*;

public class Driver {
    private static final String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@//localhost:32118/xe";
    private static final String DB_USER = "JANWILLEM";
    private static final String DB_PASS = "janwillem";
    private static Connection conn;

    // De methode die met JDBC aan de slag gaat moet een SQLException opvangen of gooien
    public static void main(String[] args) throws SQLException {
        //Besluit welke driver je gaat gebruiken voor je verbinding
        try {
            Class.forName(DB_DRIV).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        // Leg de connectie met de database
        conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        System.out.println("Connection made");


        System.out.println("complete");
    }
    }
