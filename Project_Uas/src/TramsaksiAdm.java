
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.UUID;


public class TramsaksiAdm  {
   
    static final String jdbc = "com.mysql.cj.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost/shop_buah";
    static final String username ="root";
    static final String password ="";
    
    static Connection con;
    static ResultSet rs;
    static PreparedStatement ps;

    public static void pencatatan( String user) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukan Nama Buah \t:");
        String namaBuah = sc.nextLine();
        System.out.println("MAsukan Quantitas\t:");
        int qty = sc.nextInt();
        

       
      try{
          Class.forName(jdbc);
          con = DriverManager.getConnection(url, username, password);
          String query = "insert into tbl_transaksi values(?,?,?,current_timestamp(),?,?)";
          ps = con.prepareStatement(query);
          ps.setString(1, TramsaksiAdm.GenerateID());
          ps.setString(2, user);
          ps.setString(3, CrudManajement.getkdBuah(namaBuah));
          ps.setInt(4, qty);
          ps.setInt(5, TotalBeli.itungHarga(qty, namaBuah));
          
          if(ps.executeUpdate()>0){
            System.out.println("total harga bayarnya adalah : "+TotalBeli.itungHarga(qty, namaBuah));
            
              System.out.println("Proses Insert Berhasil");
              AdminMenu.Play();
          }
          else{
              System.out.println("Proses Gagal");
              AdminMenu.Play();
          }
        
        }
        catch(Exception ex){
            ex.printStackTrace();
            
            
        }
        
    }

    public static String GenerateID(){
        String id = "";
        for (int i = 0; i < 7; i++) {
            UUID gfh = UUID.randomUUID();
            id += gfh.toString().charAt(i);
            
        }
        return id;
    }

}