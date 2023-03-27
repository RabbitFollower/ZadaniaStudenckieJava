import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Lab_6 {

//----------------------------------------------- Zad_1 -----------------------------------------------------------//

    public static void countCharsAndWords() throws FileNotFoundException {
        File txtFile = new File("src/main/java/inputFile.txt");
        Scanner scanner = new Scanner(txtFile);
        int sentenceLength = 0;
        int whiteCharsCounter = 0;
        int wordCounter = 0;

        while (scanner.hasNextLine()) {
           String sentence = scanner.nextLine();
            sentenceLength += sentence.length();
            wordCounter += CommonFunctions.wordCount(sentence);

            for (int sentIdx = 0; sentIdx < sentence.length(); sentIdx++) {
                char checkedChar = sentence.charAt(sentIdx);
                if (Character.isWhitespace(checkedChar)) {
                    whiteCharsCounter++;
                }
            }
        }
        int[] arr = {
                sentenceLength,
                whiteCharsCounter,
                wordCounter
        };
        System.out.println(Arrays.toString(arr));
    }

//----------------------------------------------- Zad_2 -----------------------------------------------------------//

    public static void searchWord(String inputFileName, String outputFileName, String word) {
        File inputFile = new File("src/main/java/" + inputFileName + ".txt");
        File outputFile = new File("src/main/java/" + outputFileName + ".txt");
        int rowCounter = 1;

        try {
            Scanner scanner = new Scanner(inputFile);
            PrintWriter writer = new PrintWriter(outputFile);

            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();

                if (row.contains(word)) {
                    writer.println(rowCounter + "." + row);
                }
                rowCounter++;
            }
            writer.close();
            System.out.println("Zapisano pomyślnie:  " + outputFile);

        } catch (FileNotFoundException exception) {
            System.out.println("File not found");
        }

    }







}
