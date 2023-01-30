
public class Lab_4 {

    //Zad_1
    public static void countLastCharFromString() {

        String stringFromUser =
                CommonFunctions.getStringFromUser("Podaj string aby wyświetlić liczbę powtórzeń ostatniego znaku:");
        char lastChar = stringFromUser.charAt(stringFromUser.length() - 1);
        int lastCharCounter = 0;

        for (int stringIndex = 0; stringIndex < stringFromUser.length(); stringIndex++) {
            if (stringFromUser.charAt(stringIndex) == lastChar) {
                lastCharCounter++;
            }
        }
        System.out.println("Liczba powtórzeń litery/znaku " + "\"" + lastChar + "\" to: " + lastCharCounter);
    }

//Zad_2 ------------------------------ With StringBuilder: --------------------------------------------

    public static void getReversedString() {
        StringBuilder stringFromUser =
                new StringBuilder(CommonFunctions.getStringFromUser("Podaj string do odwrócenia: "));

        System.out.println("Odwrócony string: " + stringFromUser.reverse());
    }

//Zad_2 ------------------------------ With ForLoop + StringBuilder: --------------------------------------------

    public static void getReversedString2() {
        StringBuilder reversedString = new StringBuilder();
        StringBuilder stringFromUser =
                new StringBuilder(CommonFunctions.getStringFromUser("Podaj string do odwrócenia: "));

        for (int stringIndex = stringFromUser.length() - 1; stringIndex >= 0; stringIndex--) {
            reversedString.append(stringFromUser.charAt(stringIndex));
        }
        System.out.println("Odwrócony string: " + reversedString);
    }


    //Zad_3
//--------------------------------------- With StringBuilder: -------------------------------------------
    public static void isStringPalindrome() {
        StringBuilder stringFromUser =
                new StringBuilder(CommonFunctions.getStringFromUser("Sprawdź czy słowo jest palindromem:"));

        StringBuilder reversedString = new StringBuilder();

        for (int stringIndex = stringFromUser.length() -1; stringIndex >= 0; stringIndex--) {
            reversedString.append(stringFromUser.charAt(stringIndex));
        }

        if (stringFromUser.toString().equals(reversedString.toString())) {
            System.out.println(stringFromUser + " jest palindromem.");
        } else {
            System.out.println(stringFromUser + " nie jest palindromem.");
        }
    }

    //--------------------------------------- Memory saving way: -------------------------------------------
    public static void isStringPalindrome2() {
        boolean isSameLetter = true;
        String stringFromUser = CommonFunctions.getStringFromUser("Sprawdź czy słowo jest palindromem:");

        for (int stringIndex = 0; stringIndex < stringFromUser.length() / 2; stringIndex++) {
            if (stringFromUser.charAt(stringIndex)
                    != stringFromUser.charAt((stringFromUser.length() - 1) - stringIndex)) {
                isSameLetter = false;
                break;
            }
        }
        System.out.println("Słowo: " + stringFromUser + (isSameLetter ? " jest" : " nie jest") + " palindromem");
    }

//Zad_4

    public static void sumNumbersFromString() {
        String stringFromUser = CommonFunctions.getStringFromUser("Podaj tekst do zsumowania w nim liczb: ");
        int numbersFromString = 0;

        for (int stringIndex = 0; stringIndex < stringFromUser.length(); stringIndex++) {
            if (CommonFunctions.isCharANumber(stringFromUser.charAt(stringIndex))) {
                 numbersFromString += Integer.parseInt(String.valueOf(stringFromUser.charAt(stringIndex)));
            }
        }
        System.out.println(numbersFromString);
    }

//Zad_5

    public static void checkIfBracketsArePaired() {
        StringBuilder stringFromUser = new StringBuilder("2 * (3.4 - (-7)/2)*(a-2)/(b-1)");
        int bracketsCounter = 0;

        for (int stringIndex = 0; stringIndex < stringFromUser.length(); stringIndex++) {
            if (String.valueOf(stringFromUser.charAt(stringIndex)).equals("(")
                || String.valueOf(stringFromUser.charAt(stringIndex)).equals(")")) {
                bracketsCounter++;
            }
        }

        if (bracketsCounter == 0 || bracketsCounter % 2 != 0) {
            System.out.println("Błędne sparowanie nawiasów");
            return;
        }

        for (int stringIndex = 0; stringIndex < stringFromUser.length(); stringIndex++) {
            if (String.valueOf(stringFromUser.charAt(stringIndex)).equals(")")) {

                for (int reversedIndex = stringIndex; reversedIndex >= 0; reversedIndex--) {
                    if (String.valueOf(stringFromUser.charAt(reversedIndex)).equals("(")) {
                        stringFromUser.replace(stringIndex, stringIndex + 1, "*");
                        stringFromUser.replace(reversedIndex, reversedIndex + 1, "*");
                        break;
                    }
                }
            }
        }

        System.out.println((String.valueOf(stringFromUser).contains("(") || String.valueOf(stringFromUser).contains(")")
        ? "Błędne sparowanie nawiasów"
        : "Dobrze sparowane nawiasy"));

        System.out.println(stringFromUser);
    }

//Zad_6

    public static void getEncryptedString() {
        final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
        int shiftValue = 10;
        StringBuilder stringToEncrypt =
                new StringBuilder(CommonFunctions.getStringFromUser("Podaj string do zaszyfrowania: "));

        System.out.println("Ciąg wejściowy: " + stringToEncrypt + "      Wartość przesunięcia: " + shiftValue);
        System.out.println("------------------------------------------------------------------------");

        for (int stringToEncryptIndex = 0; stringToEncryptIndex < stringToEncrypt.length(); stringToEncryptIndex++) {
            int alphaCharIndex = ALPHABET.indexOf(stringToEncrypt.charAt(stringToEncryptIndex));
            int encodedCharIndex = alphaCharIndex + shiftValue;

            if (encodedCharIndex > ALPHABET.length() - 1) {
                encodedCharIndex %= ALPHABET.length();
            }
            while (encodedCharIndex < 0) {
                encodedCharIndex += ALPHABET.length();
            }
            System.out.println("Litera do zakodowania: " + stringToEncrypt.charAt(stringToEncryptIndex));
            System.out.println("Zakodowana litera: " + (ALPHABET.charAt(encodedCharIndex)));
            System.out.println("------------------------------------------------------------------------");

            stringToEncrypt.replace(stringToEncryptIndex,
                                    stringToEncryptIndex + 1,
                                    String.valueOf(ALPHABET.charAt(encodedCharIndex)));
        }
        System.out.println("Ciąg wyjściowy: " + stringToEncrypt);

    }







}
















































