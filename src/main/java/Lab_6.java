import java.io.*;
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
            System.out.println("Saved successfully:   " + outputFile);

        } catch (FileNotFoundException exception) {
            System.out.println("File not found");
        }

    }


//----------------------------------------------- Zad_3 -----------------------------------------------------------//


    public static void sumAndSave(String fileName) {
        sumAndSave(fileName, false);
    }

    public static void sumAndSave(String fileName, boolean repeated) {
        File numbersToSum = new File("src/main/java/" + fileName + ".txt");
        int sum = 0;

        try {
            Scanner scanner = new Scanner(numbersToSum);

            while (scanner.hasNextInt()) {
                sum += scanner.nextInt();
            }

            FileWriter writer = new FileWriter("src/main/java/" + fileName + ".txt", true);
            PrintWriter output = new PrintWriter(writer);
            output.append("\n").append(String.valueOf(sum + 1));
            System.out.println(sum + 1);
            output.close();

        } catch (FileNotFoundException exception) {
            boolean filecreated = CommonFunctions.createNewFile(fileName);
            if (filecreated) sumAndSave(fileName, true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }







}
