package Restaurant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Menu {

    DatabaseCon dbCon = new DatabaseCon();

    public void showMenu() throws SQLException {
        String query = "SELECT * FROM menu";
        Connection con = dbCon.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        // Print header
        System.out.printf("%-10s | %-25s | %-10s%n", "Id", "Name", "Price");
        System.out.println("--------------------------------------------------");

        while (rs.next()) {
            int itemId = rs.getInt("item_id");
            String name = rs.getString("name");
            int price = rs.getInt("price");

            // Print each row in a formatted way
            System.out.printf("%-10d | %-25s | %-10d%n", itemId, name, price);
        }


        rs.close();
        st.close();
        con.close();
    }

}
