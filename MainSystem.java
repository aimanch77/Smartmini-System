package MiniSmartSystem;
import java.util.Scanner;
public class MainSystem {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Auth A= new Auth();
        Quiz Q= new Quiz();
        while(true){
        System.out.println("\n╔══════════════════════════════════╗");
       System.out.println("        ===== SMART SYSTEM =====");
       System.out.println("╚══════════════════════════════════╝");
       System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        int choice = sc.nextInt();
        sc.nextLine();
        if(choice==1){
        System.out.print("Username: ");
        String u = sc.nextLine();
        System.out.print("Password: ");
        String p = sc.nextLine();
        A.register(u, p);
        }
        else if(choice==2) {
          System.out.print("Username: ");
          String u = sc.nextLine();
          System.out.print("Password: ");
          String p = sc.nextLine();
          if(A.login(u, p)) {
           System.out.println("Login Successful");
           Q.StartQuiz(u,sc)  ;
                } else {
                System.out.println("Invalid Login");
                }
            }
            else if(choice==3) {
            System.out.println("Program Ended");
                break;
        }
        else{
            System.out.println("Invalid ");
        }
         }
         sc.close();
    }    
}
