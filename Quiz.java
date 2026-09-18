package MiniSmartSystem;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
public class Quiz {
    public void StartQuiz(String username, Scanner input) {
        try {
            File f = new File("Questions.txt");
            Scanner sc = new Scanner(f);
            int score = 0, wrong = 0, correct = 0;
            long startTime = System.currentTimeMillis();
            long totalTime = 5 * 60 * 1000;

            while(sc.hasNextLine()) {
                long passedTime = System.currentTimeMillis() - startTime;
                if(passedTime >= totalTime) {
                    System.out.println("Time Over!");
                    break;
                }
                long RemainingTime = (totalTime - passedTime) / 1000;
                System.out.println("\nTime Left = " + RemainingTime + " sec");
                String line = sc.nextLine();
                String[] Q = line.split("\\|");
                System.out.println("\n" + Q[0]);
                System.out.println("1= " + Q[1]);
                System.out.println("2= " + Q[2]);
                System.out.println("3= " + Q[3]);
                System.out.println("4= " + Q[4]);
                System.out.print("Answer: ");

                int ans = -1;
                if(input.hasNextInt()){
                    ans=input.nextInt();
                }else{
                    input.next();
                    System.out.println("invalid input maeked wrong");
                }
                if(ans == Integer.parseInt(Q[5].trim())) {
                    score++;
                    correct++;
                } else {
                    score--;
                    wrong++;
                }
            }
            sc.close();

            System.out.println("\n*===== RESULT =====*");
            System.out.println("Score=   " + score);
            System.out.println("Correct= " + correct);
            System.out.println("Wrong=   " + wrong);
            SaveResult(username, score, correct, wrong);

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void SaveResult(String username, int score, int correct, int wrong) {
        try {
            FileWriter fw = new FileWriter("Results.txt", true);
            fw.write(username + "," + score + "," + correct + "," + wrong + "\n");
            fw.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}