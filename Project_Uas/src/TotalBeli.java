
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.UUID;




public class TotalBeli {
    static final String jdbc = "com.mysql.cj.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost/shop_buah";
    static final String username ="root";
    static final String password ="";
    
    static Connection con;
    static ResultSet rs;
    static PreparedStatement ps;
    static Statement state;


    public static int itungHarga(int qty, String namabuah) {
        int no = 0;
        Scanner sc = new Scanner(System.in);

        int hasil;
        int harga = 0;
        
        
        
      try{
          Class.forName(jdbc);
          con = DriverManager.getConnection(url, username, password);
          //state = con.createStatement();
          String query = "select harga from tbl_buah_sb where nama_buah = ?";
          ps = con.prepareStatement(query);
          ps.setString(1, namabuah );
          
          rs = ps.executeQuery();
          
          
          while(rs.next()){
             
              harga = rs.getInt("harga");
             
          }
          
        }
        catch(Exception ex){
            System.out.println("harga error");
            
        }

       return harga * qty;
        
    }
}
    