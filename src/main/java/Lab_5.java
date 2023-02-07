import java.util.ArrayList;
import java.util.Arrays;

public class Lab_5 {

                                                //Zad_1
//------------------------------------------ Iterating way: -------------------------------------------//

    public static void getFactorial() throws Exception {
        int number = CommonFunctions.getNumberFromUserWithMin("Podaj liczbę aby obliczyć jej silnię: ", 1);
        int counter = 1;
        int factorial = 1;

        if (number > 1) {
            while (counter <= number) {
                factorial *= counter;
                counter++;
            }
            System.out.println("Silnia liczby wynosi: " + factorial);
        } else {
            System.out.println("Liczba nie może być mniejsza od 1.");
        }
    }


//----------------------------------------- With Recursion: ------------------------------------------//

    public static int getFactorial2(int number) {
        number *= (number > 1) ? getFactorial2(number - 1) : number;
        return number;
    }


                                           //Zad_2
//----------------------------- Iterating way + memory saving: ---------------------------------------//


    public static void getNthFibonacciValue(int nthPlace) {
        int tempResult = 0;
        int[] resultsArr = new int[2];
        resultsArr[0] = 1;
        resultsArr[1] = 2;

        if (nthPlace == 0) {
            System.out.println("Wynik: " + resultsArr[0]);
        } else if (nthPlace == 1) {
            System.out.println("Wynik: " + resultsArr[1]);
        } else if (nthPlace > 1) {
            for (int i = 2; i <= nthPlace; i++) {
                tempResult = resultsArr[0] + resultsArr[1];
                resultsArr[0] = resultsArr[1];
                resultsArr[1] = tempResult;
            }
            System.out.println("Wynik: " + resultsArr[resultsArr.length - 1]);
        }
    }

//----------------------------------- Iterating way  ----------------------------------------------//

    public static void getNthFibonacciValue3(int nthPlace) {
        int[] result = new int[nthPlace + 1];
        result[0] = 1;
        result[1] = 2;

        if (nthPlace == 0) {
            System.out.println("Wynik: " + result[0]);
        } else if (nthPlace == 1) {
            System.out.println("Wynik: " + result[1]);
        } else if (nthPlace > 1) {
            for (int i = 2; i <= nthPlace; i++) {
                result[i] = result[i - 2] + result[i - 1];
            }
            System.out.println("Wynik: " + result[result.length - 1]);
        }
    }


//----------------------------------------- With Recursion: ----------------------------------------//
    public static int getNthFibonacciValue2(int nthPlace) {
        if (nthPlace == 0) {
            nthPlace = 1;
        } else if (nthPlace == 1) {
            nthPlace = 2;
        } else if (nthPlace > 1) {
            nthPlace = getNthFibonacciValue2(nthPlace - 2) + getNthFibonacciValue2(nthPlace - 1);
        }
        return nthPlace;
    }


                                                //Zad_3
//------------------------------------------------------------------------------------------------------------//

    public static int getPosition(String text, char character) {
        return text.indexOf(character);
    }

    //-----------With ForLoop----------------//

    public static int getPosition2(String text, char character) {
        for (int textIndex = 0; textIndex < text.length(); textIndex++) {
            if (text.charAt(textIndex) == character) {
                System.out.println(textIndex);
                return textIndex;
            }
        }
        System.out.println("-1");
        return -1;
    }
//wroc i zrob dla wszystkich powtorzen


                                            //Zad_4
//------------------------------------------------------------------------------------------------------------//

    public static String flipCase(String text) {
        String flippedText = "";
        System.out.println("Original: " + text);

        for (int textIndex = 0; textIndex < text.length(); textIndex++) {
            String subText = text.substring(textIndex, textIndex + 1);

            if (Character.isLowerCase(text.charAt(textIndex))) {
                subText = subText.toUpperCase();
            }
            if (Character.isUpperCase(text.charAt(textIndex))) {
                subText = subText.toLowerCase();
            }
            flippedText = flippedText.concat(subText);
        }
        System.out.println("Fliped text: " + flippedText);
        return flippedText;
    }

// ------- With StringBuilder ------------//
    public static String flipCase2(String text) {
        StringBuilder flippedText = new StringBuilder();

        for (int textIndex = 0; textIndex < text.length(); textIndex++) {
            char subChar = text.charAt(textIndex);

            if (Character.isLowerCase(text.charAt(textIndex))) {
                subChar = Character.toUpperCase(subChar);
            }
            if (Character.isUpperCase(text.charAt(textIndex))) {
                subChar = Character.toLowerCase(subChar);
            }
            flippedText.append(subChar);
        }
        return flippedText.toString();
    }

//------------
    public static String flipCase3(String text) {
        StringBuilder flippedText = new StringBuilder();

        for (int textIndex = 0; textIndex < text.length(); textIndex++) {
            flippedText.append(Character.isLowerCase(text.charAt(textIndex)) ?
                    Character.toUpperCase(text.charAt(textIndex)) : Character.toLowerCase(text.charAt(textIndex)));
        }
        return flippedText.toString();
    }


                                                //Zad_5
//------------------------------------------------------------------------------------------------------------------//

    public static boolean startsWith(String str1, String str2) {
        return str1.startsWith(str2);
    }

    public static boolean startsWith2(String str1, String str2) {
       for (int str2Index = 0; str2Index < str2.length(); str2Index++) {
           if (str2.charAt(str2Index) != str1.charAt(str2Index)) {
               return false;
           }
       }
       return true;
    }


//--------------------------------------------// Zad_6 //-----------------------------------------------------------//
//              VOID -> INT
//    private static boolean isCharAllowed(char character) {
//        if (character == '-'
//                || character == '+'
//                || character == 'e') {
//            return true;
//        }
//        return false;
//    }

    public static int stringToInt(String string) {
//        String str = "325";           ok
//        String str = "+13";           ok
//        String str = "-14";           ok
//        String str = "dcsc";          ok
//        String str = "0003";          ok
//        String str = "+zonk";         ok
//        String str = "-934-21";
//        String str = "-13-kr";
//        String str = "3e2";                       // 300
//        String str = "-3e2";                      // -300
//        String str = "-3e-2";                     // -3

        if (string.isEmpty() || string.matches("^[a-zA-Z+-]+") ) { //pusty albo zawiera litery z '+' i '-'
            return 0;
        }

        for (int stringIndex = 0; stringIndex < string.length(); stringIndex++) {
            if (true) {
               string = string.substring(0, stringIndex);
               break;
            }
        }
        return Integer.parseInt(string);
    }

//    -------------

    private static boolean isNotAllowedChar(char charToTest) {
        return !(charToTest == '+' || charToTest == '-' || charToTest ==  'e');
    }

    private static boolean isPlusOrMinusAtFirstPosition(char charToTest, int stringIndex) {
        return (stringIndex == 0 && ( charToTest == '-' || charToTest == '+'));
    }

    public static int stringToInt2() {

        String[] arr = {"325"
                    , "+13"
                    , "-14"
                    , "dcsc"
                    , "0003"
                    , "+zonk"
                    , "-934-21"
                    , "-13-kr"
                    , "6e2e4"
                    , "3e2"
                    , "-3e2"
                    , "-3e-2"};

        StringBuilder builder = new StringBuilder();
        for (String string : arr) {
            builder.append("Test element: " + string);

            if (string.isEmpty() || string.matches("^[a-zA-Z+-]+") ) { //pusty albo zawiera litery z '+' i '-'
                string = "0";
            }
            else {
                for (int stringIndex = 0; stringIndex < string.length(); stringIndex++) {
                    char charToTest = string.charAt(stringIndex);
                    if (!Character.isDigit(charToTest) && !(charToTest == '-' || charToTest == '+' || charToTest == 'e')
                            || (stringIndex != 0 && (charToTest == '-' || charToTest == '+'))
                            || charToTest == 'e' && (stringIndex == 0 || stringIndex == string.length() - 1
                                || stringIndex != string.indexOf(charToTest)
                                || !Character.isDigit(string.charAt(stringIndex + 1)))
                    ) {
                        string = string.substring(0, stringIndex);
                        break;
                    }
                }

                if (string.contains("e")) {
                    int idxE = string.indexOf("e");
                    String beforeE = string.substring(0, idxE);
                    String afterE = string.substring(idxE + 1);
                    string = String.valueOf(Integer.parseInt(beforeE) * Math.pow(10, (double)Integer.parseInt(afterE)));
                }
                else {
                    string = String.valueOf(Integer.parseInt(string));
                }
            }
            builder.append(" = " + string);
            builder.append("\n");
        }
        System.out.println("Wyniki: \n" + builder.toString());
        return 0;
    }
//U know what to do :)


//--------------------------------------------// Zad_7 //-----------------------------------------------------------//

    public static int searchStringAndGetPosition(String searchedString) {
        String[] stringsArr = {
                "Ala ma kota",
                "Ala",
                "ma",
                "kot",
                "Atak",
                ""
        };

        StringBuilder strBuilder = new StringBuilder();

        for (String str : stringsArr) {
            strBuilder.append("Wynik dla: ").append(str).append(" = ");
            strBuilder.append(searchedString.contains(str) ? searchedString.indexOf(str) : -1).append("\n");
        }
        System.out.println(strBuilder);
        return 0;
    }


//--------------------------------------------// Zad_8 //-----------------------------------------------------------//

    public static void wordCount() {
        String searchedString = "Ala ma kota, kot ma Alę.         xxxx";
        int wordCounter = 0;

        for (int strIdx = 0; strIdx < searchedString.length(); strIdx++) {
            char checkedChar = searchedString.charAt(strIdx);

            if (Character.isWhitespace(checkedChar) && (!(Character.isWhitespace(searchedString.charAt(strIdx - 1))))
                || (!Character.isWhitespace(checkedChar) && strIdx == searchedString.length() - 1)) {

                wordCounter++;
            }
        }
        System.out.println("Liczba słów: " + wordCounter);
    }


//--------------------------------------------// Zad_9 //-----------------------------------------------------------//

    public static void splitStringToArray() {
        String stringToSplit = "Ala ma kota a kot ma Alę i eloo";
        String[] arr = new String[5];
        int arrIdx = 0;
        StringBuilder arrItem = new StringBuilder();

        for (int stringIdx = 0; stringIdx < stringToSplit.length(); stringIdx++) {
            char checkedChar = stringToSplit.charAt(stringIdx);

            if (Character.isLetter(checkedChar)) {
                arrItem.append(checkedChar);
            }
            if ((!Character.isLetter(checkedChar) && !arrItem.isEmpty())
                    || (Character.isLetter(checkedChar) && stringIdx == stringToSplit.length() - 1)) {

                if (arrIdx >= arr.length) {
                    arr = CommonFunctions.getExtendedArray(arr);
                }

                arr[arrIdx] = String.valueOf(arrItem);
                arrItem = new StringBuilder();
                arrIdx++;
            }
        }
        arr = CommonFunctions.getFittedArray(arr);
        System.out.println("Tablica:  " + Arrays.toString(arr)
                + "\n" + "Długość tablicy: " + arr.length);
    }

//    Funkcja która zrobi mi kopię tablicy (na wymiar), najlepiej jakby pomniejszała jeśli mniej elem niż length
//    i powiększała gdy jest za dużo. (jak zbyt zawiłe to 2 osobne a później próbuj połączyć)


    public static void splitStringToArray2() {
        String stringToSplit = "Ala ma kota, ,kot ! , 123jest ładny. a.a";
        ArrayList<String> list = new ArrayList<>();
        StringBuilder listItem = new StringBuilder();


        for (int stringIdx = 0; stringIdx < stringToSplit.length(); stringIdx++) {
            char checkedChar = stringToSplit.charAt(stringIdx);

            if (Character.isLetter(checkedChar)) {
                listItem.append(checkedChar);
            }

            if ((!Character.isLetter(checkedChar) && !listItem.isEmpty())
                || (Character.isLetter(checkedChar) && stringIdx == stringToSplit.length() - 1)
            ) {
                list.add(listItem.toString());
                System.out.println("list item:  " + listItem);
                listItem = new StringBuilder();
            }
        }
        System.out.println("------------------------------------------");
        System.out.println("Lista: " + list);
    }


//--------------------------------------------// Zad_10 //----------------------------------------------------------//

    public static void repetitionCounter() {
        String checkedString = "mama ma kota";
        String checkedSequence = "ma";
        int starCounter = 0;

        if (!checkedString.contains("*")) {

            checkedString = checkedString.replace(checkedSequence, "*");

            for (int strIdx = 0; strIdx < checkedString.length(); strIdx++) {

                if (String.valueOf(checkedString.charAt(strIdx)).contains("*")) {
                    starCounter++;
                }
            }
            System.out.println("liczba powtórzeń: " + starCounter);
        } else {
            System.out.println("Znak '*' jest zakazany, podaj inny ciąg.");
        }
    }


    public static int repetitionCounter2() {
        String checkedString = "mama ma kota";
        String checkedSequence = "ma";
        int spaceCounterStart = 0;
        int spaceCounterEnd = 0;

        for (int strIdx = 0;  strIdx < checkedString.length(); strIdx++) {
             char checkedChar = checkedString.charAt(strIdx);

             if (Character.isWhitespace(checkedChar)) {
                 spaceCounterStart++;
             }
        }

        checkedString = checkedString.replace(checkedSequence, " ");

        for (int strIdx = 0;  strIdx < checkedString.length(); strIdx++) {
            char checkedChar = checkedString.charAt(strIdx);

            if (Character.isWhitespace(checkedChar)) {
                 spaceCounterEnd++;
            }
        }
        System.out.println("liczba powtórzeń: " + (spaceCounterEnd - spaceCounterStart));
        return spaceCounterEnd - spaceCounterStart;
    }


//--------------------------------------------// Zad_11 //----------------------------------------------------------//

    public static void cutString() {
        StringBuilder stringToCut = new StringBuilder("Ala ma kota");
        int start = 0;
        int howMany = 4;
        int end = start + howMany;

        System.out.println("Wynik: " + '"' + stringToCut.delete(start, end) + '"');
    }


//--------------------------------------------// Zad_12 //----------------------------------------------------------//





























}









