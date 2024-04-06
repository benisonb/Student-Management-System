package P6;

import java.sql.*;

public class SQL_q extends InsertionWindow {
    static void runQuery() {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/sms",
                    "root", "KARS@123");

            Statement st = connection.createStatement();
            double p = (m1 + m2 + m3) / 3.0;
            String sql = "INSERT INTO Student_Details VALUES (" + sno + ", " + id + ", '" + nm + "', " + m1 + ", " + m2 + ", " + m3 + ", " + p + ")";
            
            st.executeUpdate(sql);
            st.close();
            connection.close(); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
