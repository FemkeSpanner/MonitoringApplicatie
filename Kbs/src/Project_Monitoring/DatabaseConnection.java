package Project_Monitoring;
import java.sql.*;

public class DatabaseConnection {



    // DB connection



    public static void main(String[] args) {



        String url = "jdbc:mysql://localhost:3306/Monitoring";
        String username = "root", password = "";



        {
            try {
                Connection connection = DriverManager.getConnection(url, username, password);
               Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT waarde FROM Meeting WHERE idComponent=1 AND idSensor=1");
                while (rs.next()) {
                    double id = rs.getDouble("waarde");
                    System.out.println(id);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
