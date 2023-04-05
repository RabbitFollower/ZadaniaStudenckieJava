import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Lab_6 {

//----------------------------------------------- Zad_1 -----------------------------------------------------------//
//Plik wejściowy: inputFile

    public static void countCharsAndWords(String fileName) {
        File txtFile = new File("src/main/java/" + fileName + ".txt");
        int sentenceLength = 0;
        int whiteCharsCounter = 0;
        int wordCounter = 0;

        try {
            Scanner scanner = new Scanner(txtFile);

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
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        int[] arr = {
                sentenceLength,
                whiteCharsCounter,
                wordCounter
        };
        System.out.println(Arrays.toString(arr));
    }

//----------------------------------------------- Zad_2 -----------------------------------------------------------//
// Wykorzystywane pliki: inputFile i outputFile

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
// Funkcja wykorzystuje plik o nazwie "numberToSum" lub tworzy nowy.

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
            boolean fileCreated = CommonFunctions.createNewFile(fileName);
            if (fileCreated) sumAndSave(fileName, true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//----------------------------------------------- Zad_4 -----------------------------------------------------------//
// Funkcja wykorzystuje plik o nazwie: fileToEncrypt.

    public static void encrypt(String fileNameToEncrypt, int shiftValue) {
        File encryptFile = new File("src/main/java/" + fileNameToEncrypt + ".txt");

        try {
            Scanner scanner = new Scanner(encryptFile);

            while (scanner.hasNextLine()) {
                String row = scanner.nextLine().toLowerCase();

                StringBuilder rowToEncrypt =
                        new StringBuilder(CommonFunctions.caesarCipher(row, shiftValue));

                String fileName = "_" + fileNameToEncrypt + "=" + shiftValue;

                if (fileNameToEncrypt.contains("_") && fileNameToEncrypt.contains("=")) {
                    fileName = fileNameToEncrypt + "-decrypted";
                }
                CommonFunctions.saveToAnotherFile(fileName, String.valueOf(rowToEncrypt), true);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    public static int getShiftValue(String fileName) {
        String shiftValue = "0";

        if (fileName.contains("=")) {
            shiftValue = fileName.substring(fileName.indexOf('=') + 1);
        } else {
            System.out.println("No shift value in file name.");
        }
        return Integer.parseInt(shiftValue) * (-1);
    }

    public static void decrypt(String fileToDecryptName) {
        int shiftValue = Lab_6.getShiftValue(fileToDecryptName);
        Lab_6.encrypt(fileToDecryptName, shiftValue);
    }


//----------------------------------------------- Zad_5 -----------------------------------------------------------//
// Funkcja wykorzystuje plik: employeeData

    public static void yearsToRetiring(String fileName) {
        final int menRetiringAge = 65;
        final int womenRetiringAge = 60;
        int yearsToRetiring = 0;
        File employeeData = new File("src/main/java/" + fileName + ".txt");

        try {
            Scanner scanner = new Scanner(employeeData);

            while (scanner.hasNextLine()) {
                StringBuilder age = new StringBuilder();
                StringBuilder textRow = new StringBuilder(scanner.nextLine());

                for (int textRowIdx = 0; textRowIdx < textRow.length(); textRowIdx++) {
                    char checkedChar = textRow.charAt(textRowIdx);

                    if (Character.isDigit(checkedChar)) {
                       age.append(checkedChar);
                    }
                }
                String outputFileName = null;
                if (String.valueOf(textRow).contains(" M ")) {
                    outputFileName = "men";
                    yearsToRetiring = menRetiringAge - Integer.parseInt(String.valueOf(age));
                }
                else if (String.valueOf(textRow).contains(" K ")) {
                    outputFileName = "women";
                    yearsToRetiring = womenRetiringAge - Integer.parseInt(String.valueOf(age));
                }
                textRow.delete(textRow.length() - 4, textRow.length());
                textRow.append(yearsToRetiring).append("\n");
                CommonFunctions.saveToAnotherFile(outputFileName, String.valueOf(textRow), true);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}
