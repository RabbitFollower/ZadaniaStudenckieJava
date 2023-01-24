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



}