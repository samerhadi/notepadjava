import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Choose an Option: 1 to write a note, 2 to find a note and 3 to delete a note...");
        Scanner inputScanner = new Scanner(System.in);
        int userInput = inputScanner.nextInt();
        switch (userInput) {
            case 1:
                System.out.println(makeNote());
                break;
            case 2:

                System.out.println(findNote());
                break;
            case 3:
                System.out.println(deleteNote());
                break;
            default:
                System.exit(0);
        }

    }

    public static String makeNote() {
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

        scanner.close();
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
