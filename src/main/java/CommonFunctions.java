import java.io.File;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class CommonFunctions {

    static Scanner scanner = new Scanner(System.in);

    public static String getStringFromUser(String msg) {
        System.out.println(msg);
        return scanner.nextLine();
    }

    public static int getNumberFromUser(String msg) throws Exception {
        return getNumberFromUser(msg, null, null);
    }

    public static int getNumberFromUserWithMin(String msg, Integer min) throws Exception {
        System.out.println();
        return getNumberFromUser(msg, min, null);
    }
//
    public static int getNumberFromUserWithMax(String msg, Integer max) throws Exception {
        return getNumberFromUser(msg, null, max);
    }

    public static int getNumberFromUser(String msg, Integer min, Integer max) throws Exception {
        System.out.println(msg);
        String numberFromUser;

//        if (min == null) {
//            min = Integer.MIN_VALUE;
//        }

        if (min != null && max != null && min > max) {
            System.out.println("");
            throw new Exception("min > max");
        }

        while ((numberFromUser = scanner.next()) == null
            || !isNumberFromUserInteger(numberFromUser)
            || (min != null && max != null && !isNumberFromUserBetweenMinMax(Integer.parseInt(numberFromUser), min, max))
            || (min == null && max != null && Integer.parseInt(numberFromUser) > max)
            || (min != null && max == null && Integer.parseInt(numberFromUser) < min) ) {

            System.out.println("Podałeś złe dane, wpisz poprawne.");
        }
        System.out.println("poprawne dane");
        return Integer.parseInt(numberFromUser);
    }

    public static boolean isNumberFromUserInteger(String val) {
        try {
            Integer.parseInt(val);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }

    public static boolean isCharANumber(char val) {
        try {
            Integer.parseInt(String.valueOf(val));
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }

    public static boolean isNumberFromUserBetweenMinMax(int val, Integer min, Integer max) {
        if (val < min || val > max) {
            return false;
        }
        return true;
    }

    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(min, max);
    }

//Zad_9_________________________________________________________________________________________________
    public static boolean isNumberEven(int val) {
        if (val % 2 != 0) {
            return false;
        }
        return true;
    }

    public static int sumOfArrsNumbers(int[] arr) {
        int sumOfNumbers = 0;
        for (int i = 0; i < arr.length; i++) {
            sumOfNumbers += arr[i];
        }
        return sumOfNumbers;
    }

    public static int charToInt(char val) {
        return Integer.parseInt(String.valueOf(val));
    }

    public static String getNumbersPaddingLeft(int numberToEdit, int numberMaxLength) {
        int spacesNo = 0;
        StringBuilder editedNumber = new StringBuilder();

        if (String.valueOf(numberToEdit).length() < numberMaxLength) {
            spacesNo = numberMaxLength - String.valueOf(numberToEdit).length();
        }

        for (int i = 0; i < spacesNo; i++) {
            editedNumber.append(" ");
        }

        editedNumber.append(numberToEdit);
        return editedNumber.toString();
    }

//------------------ Copy or Fit Array ---------------//
    public static String[] getFittedArray(String[] arr) {
        int counter = 0;

        for (int arrIdx = 0; arrIdx < arr.length; arrIdx++) {
            if (arr[arrIdx] != null) {
                counter++;
            }
        }

        return Arrays.copyOf(arr, counter);
    }

    public static String[] getExtendedArray(String[] arr) {
        return Arrays.copyOf(arr, arr.length + 5);
    }



//--------------------- Words Counter ------------------------------------//

    public static int wordCount(String searchedString) {
        int wordCounter = 0;

        for (int strIdx = 0; strIdx < searchedString.length(); strIdx++) {
            char checkedChar = searchedString.charAt(strIdx);

            if (Character.isWhitespace(checkedChar) && (!(Character.isWhitespace(searchedString.charAt(strIdx - 1))))
                    || (!Character.isWhitespace(checkedChar) && strIdx == searchedString.length() - 1)) {

                wordCounter++;
            }
        }
        return wordCounter;
    }



//------------------ New File Creator ------------------------------------//

    public static boolean createNewFile(String fileName) {
        File file = new File("src/main/java/" + fileName + ".txt");

        try {
            boolean value = file.createNewFile();
            if (value) {
                System.out.println("New file created!");
            } else {
                System.out.println("File already exists.");
            }
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
        return true;
    }












}// klamra klasy






























//if (numberFromUser.matches("[0-9]+")) {
//        return Integer.parseInt(numberFromUser);
//        if (Integer.parseInt(numberFromUser) < min) {
//        System.out.println("Podałeś liczbę niższą niż minimalna. Zakres to 0-100.");
//        return Integer.parseInt(scanner.next());
//        } else if (Integer.parseInt(numberFromUser) > max) {
//        return getNumberFromUser("Podałeś liczbę wyższą niż maksymalna.");
//        }
//        }