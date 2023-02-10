/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
/**
 *
 * @author HP
 */
public class AdminMenu {
    
    
    
    static String user;
    public static void setuser(String id){
        user = id;
        
    
    }
    
    
    public static void Play() throws Exception{
        Scanner sc = new Scanner(System.in);
         System.out.println("Menu Buah");
         System.out.println("[-----------------------------------+");
         System.out.println("ID Admin :  "+user                   +"|");
        System.out.println("[------------------------------------|");
        System.out.println("1.Edit data Buah                     |");
        System.out.println("2.transaksi                          |");
        System.out.println("3 logout                             |");
        System.out.println("[------------------------------------+");
        System.out.print("Masukan pilihan \t: ");
        int pil = sc.nextInt();
        
        if (pil == 1) {
            
        System.out.println("Menu Buah");
        System.out.println("ID Admin : "+ user                  +"|");
        System.out.println("------------------------------------+");
        System.out.println("1.show data Buah                    |");
        System.out.println("2.insert data Buah                  |");
        System.out.println("3.delete data Buah                  |");
        System.out.println("4.update data Buah                  |");
        System.out.println("5.cari Buah                         |");
        System.out.println("6.Kembali                           |");
        System.out.println("------------------------------------+");
        System.out.print("Masukan pilihan \t: ");
         pil = sc.nextInt();
        
        
        if (pil == 1) {
            CrudManajement.showBuah();
        }
        else if (pil == 2) {
            CrudManajement.insertBuah();
            
        }
        else if (pil == 3) {
            CrudManajement.deleteBuah();
            
        }
        else if (pil == 4) {
            CrudManajement.update();
            
        }
        else if (pil == 5) {
                CrudManajement.cariBuah();
            }
        else if (pil == 6) {
            AdminMenu.Play();
            
        }
        else{ System.out.println("pilihan yang anda masukan salah");  }
        }
        
        else if (pil == 2){
            
            System.out.println("------------------------------------+");
            System.out.println("1.Masukan Transaksi                 |");
            System.out.println("2.lihat histori transaksi           |");
            System.out.println("3.Back                              |");
            System.out.println("------------------------------------+");
            System.out.print("Masukan pilihan \t:");
            pil = sc.nextInt();
            
            if (pil == 1) {
                TramsaksiAdm.pencatatan(user);
            }
            else if (pil == 2) {
                CrudManajement.Showhistory();
                
            }
            else if (pil == 3){
                AdminMenu.Play();
            }
            else{System.out.println("masukan tidak valid");
            AdminMenu.Play();
            
            }
            
            
            
            
        }
        else if (pil == 3) {
            System.out.println("logout berhasil");
            Tampilan.Play();
            
        }
        else  {
            System.out.println("input salah ");
            AdminMenu.Play();
        }
        
        
        
       
    }
    
}
