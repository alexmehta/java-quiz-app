import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;

public class questions {
    public static String[] question;
    public static String[] answer;
    public int a = 0;

    public void getQuestions(File questions) throws FileNotFoundException {
        Scanner myReader = new Scanner(questions);
        while(myReader.hasNextLine()){
            a++;
            myReader.nextLine();
        }
        Scanner newReader = new Scanner(questions);

        question = new String[a/2];
        answer = new String[a/2];
        int f=0;
        for (int c = 0;c<a;c=c+2){
            question[f] = newReader.nextLine();
            answer[f]= newReader.nextLine();
            f++;
        }
        displayTest();
    }
    public void displayTest(){
        System.out.println("Test will begin now");
        Random random = new Random();
        for(int i=0; i<question.length;i++){
            int x =i;
            System.out.println(question[x]);
            Scanner answers = new Scanner(System.in);
            String answerto = answers.next();
            String actual = answer[x];

            actual = actual.replace("answer: ","");
            PrintWriter printWriter = null;
            try {
                printWriter = new PrintWriter("results.txt");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            if (actual.toLowerCase().equals(answerto.toLowerCase())){


                printWriter.println("Answer correct:" +answerto + " " + "Question: " + question[x]);
            }
            else{
                printWriter.println("Answer incorrect:" +answerto + " " + "Question: " + question[x]);
                printWriter.println("Correct answer: " +actual);
            }
            printWriter.close();
        }

    }
    public static void main(String[] args) throws FileNotFoundException {
        questions test = new questions();
        test.getQuestions(new File("questions.txt"));

    }
}
