import java.util.Locale;

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




















}
