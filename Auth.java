package MiniSmartSystem;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
public class Auth{
    public void register(String username, String password){
        try{
             File f = new File("users.txt");
             if(f.exists()){
          Scanner sc = new Scanner(f) ;
          while(sc.hasNextLine()){
            String line=sc.nextLine();
            String[] A=line.split(",");
            if(A[0].equals(username) ){
            System.out.println(" Sorry user already exsisted ");
            sc.close();
            return;
          }
        } sc.close();
    }
          FileWriter fw = new FileWriter("users.txt",true );
          fw.write(username+ "," +password+ "\n");
          fw.close();
           System.out.println("congragulations Registered Successfully");
    }    
         catch(IOException e){
            e.printStackTrace();
        }
    }
   public boolean login(String username, String password) {
    try{
    File f= new File("users.txt");
    Scanner sc = new Scanner(f);
    while(sc.hasNextLine()){
        String line = sc.nextLine();
        String [] S = line.split(",");
        if(S[0].equals(username)&& S[1].equals(password)){
            sc.close();
            return true;
        } 
    }sc.close();
   } catch(IOException e){
    e.printStackTrace();
   } 
   return false;
}
}