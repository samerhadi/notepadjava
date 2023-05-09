import org.w3c.dom.Node;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        boolean running = false;
        while (!running)
        {
        System.out.println("Choose an Option: 1 to write a note, 2 to find a note, 3 to delete a note and 4 to close program...");
        Scanner inputScanner = new Scanner(System.in);
        int userInput = inputScanner.nextInt();
        if(userInput == 1)
        {
            System.out.println(makeNote());
        }

        else if (userInput == 2)
        {
            System.out.println(findNote());
        }

        else if (userInput == 3)
        {
            System.out.println(deleteNote());
        }

       else if (userInput == 4)
        {
            running=true;
        }
        else{
            System.out.println("you have to choose option 1,2 or 3");
        }
        }

    }

    public static String makeNote() {
        boolean yn;
        String text;

            System.out.println("Write a Note:");
            Scanner scanner = new Scanner(System.in);
            String lineIn = scanner.nextLine();
            try {
                FileWriter fileWriter = new FileWriter("Memo.txt", true);
                fileWriter.append(lineIn).append("\n");
                fileWriter.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Vill du skriva en till NOTE? SVARA yes/no ");
            Scanner sc = new Scanner(System.in);
            text = sc.nextLine();
            switch (text) {
                case "yes":
                    yn = false;
                    System.out.println(makeNote());
                    break;
                case "no":
                    yn = true;
                    System.out.println("Dessa är dina notes!");
                    break;
                default:
                    System.out.println("please enter again ");

            }

        return lineIn;
    }

    public static String findNote() {
        System.out.println("Write a word of your note:");
        Scanner scanner = new Scanner(System.in);
        String lineIn = scanner.nextLine();
        try {
            Scanner fileScan = new Scanner(new File("Memo.txt"));
            while (fileScan.hasNextLine()) {
                String fileRad = fileScan.nextLine();
                if (fileRad.contains(lineIn)) {
                    return fileRad;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "Note not found!";
    }



    public static String deleteNote() {
        System.out.println("Write a word from a note to delete");
        Scanner scanner = new Scanner(System.in);
        String lineIn = scanner.nextLine();
        boolean found= false;
        StringBuilder str= new StringBuilder();
        try {
            Scanner fileScan = new Scanner(new File("Memo.txt"));

            while (fileScan.hasNextLine()) {

                String fileRad = fileScan.nextLine();

                if(fileRad.contains(lineIn)){
                    found= true;
                }
                else  {
                    str.append(fileRad+"\n");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            FileWriter fileWriter = new FileWriter("Memo.txt");
            fileWriter.append(str.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (found){
            return "Note deleted";
        }
        return "Note not deleted";
    }




}
