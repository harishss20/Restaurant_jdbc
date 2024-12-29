package Restaurant;

import java.sql.*;

import java.util.Scanner;

public class TableReg {
    int tableNumber = 0;

    Scanner sc = new Scanner(System.in);

    DatabaseCon dbcon = new DatabaseCon();



    public void showTable() throws SQLException {
        String query = "select * from tables where table_status='1'";  //1 -> true   &   0 -> false
        Connection con = dbcon.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        System.out.printf("%-15s | %-15s%n","Table Number", "Table Status");
        System.out.println("------------------------------------");
        while(rs.next()){
            int tb_number = rs.getInt("table_id");
            boolean tb_status = rs.getBoolean("table_status");

            System.out.printf("%-15d | %-15b%n",tb_number  , tb_status);

        }
        System.out.println("------------------------------------");
    }

    public boolean selectTable(int tb) throws SQLException{


        String query ="UPDATE Tables SET table_status=0 WHERE table_id= ? AND table_status=1 ";
        Connection con= dbcon.getConnection();
        PreparedStatement pst = null;
        pst = con.prepareStatement(query);
        pst.setInt(1,tb);

        int rowAffected = pst.executeUpdate();

        if(rowAffected >0){
            return true;
        }
        else{
            return false;
        }

    }
    public boolean deselectTable(int tb) throws SQLException{

        String query ="UPDATE Tables SET table_status=1 WHERE table_id= ? AND table_status=0 ";
        Connection con= dbcon.getConnection();
        PreparedStatement pst = null;
        pst = con.prepareStatement(query);
        pst.setInt(1,tb);

        int rowAffected = pst.executeUpdate();

        if(rowAffected >0){
            return true;
        }
        else{
            return false;
        }

    }

}
