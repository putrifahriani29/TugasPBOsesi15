/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.UUID;




public class CrudManajement {
    static final String jdbc = "com.mysql.cj.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost/shop_buah";
    static final String username ="root";
    static final String password ="";
    
    static Connection con;
    static ResultSet rs;
    static PreparedStatement ps;
    static Statement state;
    
    public static int getIndex( String prime) throws Exception{
        int no = 0;
      Class.forName(jdbc);
          con = DriverManager.getConnection(url, username, password);
          //state = con.createStatement();
          
          String query = "select * from ?";
          ps = con.prepareStatement(query);
          ps.setString(1, prime );
          rs = ps.executeQuery();
          
          while(rs.next()){
              no++;
              
    }
          return no;
    
    }
   
    public static void deleteBuah() throws Exception {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Kode Buah Yang Akan Dihapus");
        String kode_buah = sc.next();
        
      try{
          Class.forName(jdbc);
          con = DriverManager.getConnection(url, username, password);
          String query = "delete from  tbl_buah_sb where Kd_buah = ?";
          
          ps = con.prepareStatement(query);
          ps.setString(1,kode_buah);
          
          
          if(ps.executeUpdate()>0){
              System.out.println("Proses Hapus Data Berhasil");
          }
          else{
              System.out.println("Proses Gagal");
          }
          
          
          
          
        }
        catch(Exception ex){
            ex.printStackTrace();
            
            
            AdminMenu.Play();
            
        }
      AdminMenu.Play();
    }

    
    
    //untuk insert data ke tabel part
    public static void insertBuah() throws Exception{
        Scanner sc = new Scanner(System.in);    
        System.out.print(" kode Buah \t:");
        String kode_buah = sc.next();
        System.out.print(" Nama Buah\t:");
        String nama_buah = sc.next();
        System.out.print(" Harga Buah \t:");
        int harga_buah = sc.nextInt();
        System.out.print(" Stok Buah \t:");
        int stok = sc.nextInt();
        
      try{
          Class.forName(jdbc);
          con = DriverManager.getConnection(url, username, password);
          //state = con.createStatement();
          String query = "insert into tbl_buah_sb values(?,?,?,?)";
          ps = con.prepareStatement(query);
          ps.setString(1, kode_buah);
          ps.setString(2, nama_buah);
          ps.setInt(3, harga_buah);
          ps.setInt(4, stok);
          
          if(ps.executeUpdate()>0){
              System.out.println("Proses Insert Berhasil");
              AdminMenu.Play();
          }
          else{
              System.out.println("Proses Gagal");
              AdminMenu.Play();
          }          
        }
        catch(Exception ex){
            System.out.println("proses insert tidak berhasil");
            AdminMenu.Play();
            
            
        }}
        
    public static void showBuah() throws Exception {
        int no = 0;
        
      try{
          Class.forName(jdbc);
          con = DriverManager.getConnection(url, username, password);
          state = con.createStatement();
          String query = "select * from tbl_buah_sb";
          rs = state.executeQuery(query);
          
          
          while(rs.next()){
              no++;
              System.out.println("no :" + no);
              System.out.println("Kode Buah :" + rs.getString(1));
              System.out.println("Nama Buah :" + rs.getString(2));
              System.out.println("Harga Buah :" + rs.getInt(3));
              System.out.println("Stok Buah :" + rs.getInt(4));
              System.out.println("----------------------------------------------");
          }
          
        }
        catch(Exception ex){
            
            
            
        }
      AdminMenu.Play();
        
    }
    
    public static void update() throws Exception{
   
        Scanner sc = new Scanner(System.in);    
        System.out.print(" kode Buah \t:");
        String kode_buah = sc.next();
        System.out.print(" Nama Buah \t:");
        String nama_buah = sc.next();
        System.out.print(" Harga Buah \t:");
        int harga_buah = sc.nextInt();
        System.out.print(" stok Buah \t:");
        int stok = sc.nextInt();
        
      try{
          Class.forName(jdbc);
          con = DriverManager.getConnection(url, username, password);
          //state = con.createStatement();
          String query = "update tbl_buah_sb set kd_buah=?, Nama_buah=?, harga=?, QTY=? where kd_buah=?";
          ps = con.prepareStatement(query);
          ps.setString(1, kode_buah);
          ps.setString(2, nama_buah);
          ps.setInt(3, harga_buah);
          ps.setInt(4, stok);
          ps.setString(5, kode_buah);
          
          if(ps.executeUpdate()>0){
              System.out.println("Proses Update Berhasil");
          }
          else{
              System.out.println("Proses Gagal");
          }          
        }
        catch(Exception ex){
  
            ex.printStackTrace();
            
        }
      AdminMenu.Play();
    }
    public static String Getpass(String id) throws Exception{
        Class.forName(jdbc);
        con = DriverManager.getConnection(url, username, password);
        
        String query = "SELECT password FROM tbl_admin WHERE id_admin = ?";
        ps = con.prepareStatement(query);
        ps.setString(1, id);
        rs = ps.executeQuery();

        if(!rs.next()){
            return null;
            
        }
        else{
            return rs.getString(1).toString();
        }    
    }

    public static void pencatatan(String user) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukan nama barang \t:");
        String namaBArang = sc.nextLine();
        System.out.println("MAsukan Quantitas\t:");
        int qty = sc.nextInt();
        

       
      try{
          Class.forName(jdbc);
          con = DriverManager.getConnection(url, username, password);
          String query = "insert into tbl_transaksi values(?,?,current_timestamp(),?,?)";
          ps = con.prepareStatement(query);
          ps.setString(1, CrudManajement.GenerateID());
          ps.setString(2, user);
          ps.setString(3, CrudManajement.getkdBuah(namaBArang));
          ps.setInt(4, qty);
          
          if(ps.executeUpdate()>0){
              System.out.println("Proses Insert Berhasil");
          }
          else{
              System.out.println("Proses Gagal");
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


    public static void cariBuah() {
        int no = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Cari Nama Buah");
        String nama_buah = sc.next();
        
        
      try{
          Class.forName(jdbc);
          con = DriverManager.getConnection(url, username, password);
          //state = con.createStatement();
          String query = "select * from tbl_buah_sb where nama_buah like ?";
          ps = con.prepareStatement(query);
          ps.setString(1,"%" + nama_buah + "%");
          
          rs = ps.executeQuery();
          
          
          while(rs.next()){
              System.out.println("-------------------+");
              no++;
              System.out.println("no :" + no);
              System.out.println("Kode Buah  : " + rs.getString(1)+"|");
              System.out.println("Nama Buah  : " + rs.getString(2)+"|");
              System.out.println("Harga buah : " + rs.getInt(3)   +"|");
              System.out.println("Stok Buah  : " + rs.getInt(4)   +"|");
              System.out.println("--------------------+");
              
          }
          System.out.println("jumlah  yang muncul adalah  : "+ no);
          AdminMenu.Play();

          
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
       
        
    }
    public static String getkdBuah(String namaBuah)  {
        Scanner snc = new Scanner(System.in);
    
        String kode = "";
        
      try{
          Class.forName(jdbc);
          con = DriverManager.getConnection(url, username, password);
          String query = "select kd_buah from tbl_buah_sb where nama_buah like ?";
          ps = con.prepareStatement(query);
          ps.setString(1, namaBuah  );
          
          rs = ps.executeQuery();
          
          
          while(rs.next()){
              kode = rs.getString(1).toString();
       
              
          }  
        }
        catch(Exception ex){
            ex.printStackTrace();     
        }
        return kode;
    }
    public static void Showhistory() throws Exception {
        int no = 0;
        
      try{
          Class.forName(jdbc);
          con = DriverManager.getConnection(url, username, password);
          state = con.createStatement();
          String query = "select * from tbl_transaksi";
          rs = state.executeQuery(query);
          
          
          while(rs.next()){
              no++;
              System.out.println("no :" + no);
              System.out.println("kode transaksi \t :" + rs.getString(1));
              System.out.println("id Admin \t :" + rs.getString(2));
              System.out.println("kode buah \t :" + rs.getString(3));
              System.out.println("Tanggal \t :" + rs.getDate(4));
               System.out.println("Kuantitas \t :" + rs.getInt(5));
               System.out.println("Total Harga \t :" + rs.getInt(6));
              System.out.println("----------------------------------------------");
          }
          
        }
        catch(Exception ex){
            ex.printStackTrace();
            
            
        }
      AdminMenu.Play();
        
    }


}