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

public class Tampilan {
    public static void main(String[] args) {
        
         try {
            Play();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    
        
        
    }
    
    public static void Play() throws Exception{
        
        Scanner sc = new Scanner(System.in);
        System.out.println("+====================================================================+");
        System.out.println("|                              SHOP BUAH                             |");
        System.out.println("|====================================================================+");
        System.out.println("1.login                                                              |");
        System.out.println("2.out                                                                |");
        System.out.println("+====================================================================+");
        System.out.print("masukan pilihan \t:");
        int pilihan = sc.nextInt();
     
        
        
        if (pilihan == 1) {
            System.out.println("+====================================================================+");
            System.out.println("|                           menu login                               |");
            System.out.println("+====================================================================+");
            Login.play();
            
        }
        else if (pilihan == 2){
            System.out.println("logout berhasil");
            System.out.println("=====================================================================");
        }
        else{
            System.out.println("masukan tidak sesuai");
            System.out.println("=====================================================================");
            Tampilan.Play();
        }
        sc.close();
       
        
        
        }
        
    }