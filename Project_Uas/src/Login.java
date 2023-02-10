
import java.util.Scanner;

public  class Login {
    
    
    public static void play() throws Exception{
        Scanner sc = new Scanner(System.in);
        
        
        System.out.print("masukan id \t \t:");
        String id = sc.nextLine();
        System.out.print("masukan password \t:");
        String password = sc.nextLine();
        try {
            if (password.equals(CrudManajement.Getpass(id))) {
                AdminMenu.setuser(id);
                AdminMenu.Play();
            
        }
        else{
            System.out.println("Id dan Password tidak sesuai");}
            Tampilan.Play();
        } catch (Exception e) {
            System.out.println("ID anda tidak terdaftar");
            
        }
        
            
    }
        
        
        
    }
    

  
    

    


