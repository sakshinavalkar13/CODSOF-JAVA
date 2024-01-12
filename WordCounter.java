import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class WordCounter{
    public static int countwords(String text){
        String[] words=text.split("\\s+|\\p{Punct}");
        int wordCount=0;
        for(String word:words){
            if(!word.trim().isEmpty()){
                wordCount++;
            }
        }
        return wordCount;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 'text' to input text directly or 'file' to provide a file : ");
        String userInput=sc.nextLine();
        if(userInput.equalsIgnoreCase("text")){
        System.out.println("ENTER YOUR TEXT");
        String text=sc.nextLine();
        int totalWords=countwords(text);
        System.out.println("TOTAL EORDS IN THE TEXT : "+ totalWords);
        }
        else if(userInput.equalsIgnoreCase("file")){
            System.out.println("ENTER THE FILE NAME (with extension) : ");
            String filename=sc.nextLine();

            try{
                File file=new File(filename);
                Scanner fileScanner=new Scanner(file);

                String text="";
                while ((fileScanner.hasNextLine())) {
                    text+=fileScanner.nextLine()+" ";
                    
                }
                int totalWords=countwords(text);
                System.out.println("TOTAL WORDS IN THE FILE : "+ totalWords);
                fileScanner.close();
            }catch(FileNotFoundException e){
                System.out.println("File not found!");
            }
        }
        else{
            System.out.println("Invalid input,Please enter 'text' or 'file'.");

        }
        sc.close();
        
    }
}