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

    












}
