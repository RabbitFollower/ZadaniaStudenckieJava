import org.apache.commons.lang3.StringUtils;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.isAsciiPrintable;
import static org.apache.commons.lang3.StringUtils.substring;

public class Lab_2 {
    Scanner skaner = new Scanner(System.in);

    //Zad_1 Wyświetlanie liczb nieparzystych od 0 do podaniej liczby

    public int displayOddNumbers() {
        int oddNumberMax;
        int oddNumber = 1;

        System.out.println("Podaj liczbę  całkowitą dodatnią: ");
        int positiveNumber = skaner.nextInt();

        if (positiveNumber % 2 == 0) {
            oddNumberMax = positiveNumber - 1;
        } else {
            oddNumberMax = positiveNumber;
        }

        System.out.println("Liczby nieparzyste z zakresu to: ");

        while (oddNumber <= oddNumberMax) {
            System.out.println(oddNumber);
            oddNumber = oddNumber + 2;
        }

        return 0;
    }

    public void displayOddNumbers2() {
        int positiveNumber = CommonFunctions.getNumberFromUser("Podaj liczbę  całkowitą dodatnią: "); // 33
        int testNumber = 0;

        while (testNumber++ < positiveNumber) {
            if (testNumber % 2 != 0) {
                System.out.println(testNumber);
            }
        }
    }

//Zad_2 Suma ciągu cyfr:


    public void sumOfNumbersSequence1() {
        int result1 = 0;
        int result2 = 0;
        int result3 = 0;

        System.out.println("Podaj liczbę całkowitą: ");
        int numberMin = skaner.nextInt();
        int tempNumberMin = numberMin;

        System.out.println("Podaj liczbę całkowitą większą od poprzedniej: ");
        int numberMax = skaner.nextInt();

        if (numberMin > numberMax) {
            int temp = numberMin;
            numberMin = numberMax;
            numberMax = temp;
        }

        //  Pętla "for":
        for (int i = numberMin; i <= numberMax; i++) {
            result1 += i;
        }
        System.out.println("Suma ciągu to : " + result1);

        //  Pętla "while":
        while (numberMin <= numberMax) {
            result2 = result2 + numberMin;
            numberMin++;
        }
        System.out.println(result2);

        numberMin = tempNumberMin;

        //  Pętla "do while":
        do {
            result3 = result3 + numberMin;
            numberMin++;
        } while (numberMin <= numberMax);

        System.out.println(result3);
    }

    public int getMin(int num1, int num2) {
        return num1 <= num2 ? num1 : num2;
    }

    public void sumOfNumbersSequence2() {
        int result = 0;
        int minNumber = 0;
        int maxNumber = 0;

        System.out.println("Podaj liczbę całkowitą: ");
        int userInput1 = skaner.nextInt();

        System.out.println("Podaj drugą liczbę całkowitą: ");
        int userInput2 = skaner.nextInt();

        minNumber = getMin(userInput1, userInput2);
        maxNumber = getMin(userInput1, userInput2);

        for (int i = minNumber; i <= maxNumber; i++) {
            result += i;
        }
        System.out.println("Wynik po wykonaniu petli for: " + result);
        result = 0;

        while (minNumber <= maxNumber) {
            result += minNumber++;
        }

        System.out.println("Wynik po wykonaniu petli while: " + result);
        result = 0;
        minNumber = getMin(userInput1, userInput2);

        do {
            result += minNumber;
        }
        while (++minNumber <= maxNumber);

        System.out.println("Wynik po wykonaniu petli do-while: " + result);
    }

//Zad_3 Potęgi liczby 2 do zakresu podanego przez użytkownika

// PODPOWIEDZI:

    // 3. za duzo kombinujesz, 1 if wystarczy, jest n == 0, to return 1
    //          jesli tak to zrobisz, to nie musi byc "ELSE", bo return wychodzi z funkcji
    // 4. uzyj petli for, bedzie latwiej, i=0; i<N; i++, a za kazdym razem mnozysz *= a
    //          w tym wypadku nie uzywasz i, posluzy tylko do iteracji


//    public void testGetSquare() {
//        System.out.println("Wynik potegowania 2^1 = " + Math.pow(2, 1)
//                + " moja func = " + getSquare(2, 1));
//
//        System.out.println("Wynik potegowania 2^2 = " + Math.pow(2, 2)
//                + " moja func = " + getSquare(2, 2));
//
//        System.out.println("Wynik potegowania 2^3 = " + Math.pow(2, 3)
//                + " moja func = " + getSquare(2, 3));
//
//        System.out.println("Wynik potegowania 2^4 = " + Math.pow(2, 4)
//                + " moja func = " + getSquare(2, 4));
//
//
//        System.out.println("Wynik potegowania 2^5 = " + Math.pow(2, 5)
//                + " moja func = " + getSquare(2, 5));
//
//    }

    private int getPower(int a, int n) {
        int result = 1;

        if (n == 0) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            result *= a;
        }
        return result;
    }

    public void number2SquareSequence() {
        System.out.println("Podaj liczbę całkowitą dodatnią: ");
        int userInput = skaner.nextInt();
        int a = 2;
        int i = 0;

//        while (!(getPower(a, i) > userInput)) {
        while (getPower(a, i) < userInput) {
            System.out.println(getPower(a, i));
            i++;
        }
    }


    //Zad_4

    public void displaySumOfNumbers() {
        int result = 0;
        int number;

        System.out.println("Podaj liczbę do zsumowania: ");
        while ((number = skaner.nextInt()) != 0) {
            result += number;
            System.out.println("Wynik: " + result + "      Podaj kolejną liczbę: ");
        }

        System.out.println(number);

    }

    public int calcSumOfNumbersUntilZero() {
        int number = skaner.nextInt();
        if (number == 0) {
            return number;
        }
        return number + calcSumOfNumbersUntilZero();
    }

    public int calcSumOfNumbersUntilZero2() {
        int number;
        return (number = skaner.nextInt()) == 0 ? 0 : number + calcSumOfNumbersUntilZero();
    }


    //Zad_5

    public void readStringAndSumMinMax() {
        String numbers = "2,94,7,52,0,2,42"; //getStringFromUser("Wpisz ciąg liczb całkowitych oddzielonych przecinkiem: ");

        String substr = numbers.substring(0, numbers.indexOf("0"));
        System.out.println(substr);
        int numberOfComas = StringUtils.countMatches(substr, ",");

        int numbersArr[] = new int[numberOfComas];

        for (int i = 0; i < numbersArr.length; i++) {
            numbersArr[i] = Integer.parseInt(substr.substring(0, substr.indexOf(",")));
            substr = substr.substring(substr.indexOf(",") + 1);
            if (substr == "") {
                break;
            }
        }

        numbersArr = sortNumbers(numbersArr);

        double sumMinMax = numbersArr[0] + numbersArr[(numbersArr.length - 1)];
        System.out.println(sumMinMax);
        double arithmeticAverageMinMax = (sumMinMax / 2);
        System.out.println(arithmeticAverageMinMax);

    }

    private boolean isStringCorrect(String numbers) {

        if ("".equals(numbers) || numbers == null) {
            return false;
        }
        if (numbers.contains(",,")) {
            return false;
        }

        if (numbers.matches("(.+)?[0-9]+-(.+)?")) {
            return false;
        }
        // chcę sprawdzić czy przecinek jest pierwszy
        if (numbers.charAt(0) == ',') {
            return false;
        }
        return true;
    }

    //sprawdź każdy przypadek pojedynczo i wyklucz
    public void testIsStringCorrect() {
        HashMap<String, Boolean> testNumbers = new HashMap<>();
        testNumbers.put("2,7,52,2,42,6", false);
        testNumbers.put("2,10,7,52,0,2,42", true);
        testNumbers.put("2,94,7,52,04,2,0,42", false);
        testNumbers.put("2,94,7,,0,2,42", false);
        testNumbers.put("2,94,7-,52,0,2,42", false);
        testNumbers.put("7-,52,0,2,42", false);
        testNumbers.put("2,94,7-", false);
        testNumbers.put("7-", false);
        testNumbers.put("2,94.7,52,0,2,42", false);
        testNumbers.put("2,94,7, 52,0,2,42", false);
        testNumbers.put("2,94,7,kot,0,2,42", false);
        testNumbers.put(",94,7,52,0,2,42", false);
        testNumbers.put("2,94,7,52,0,2,42,", true);
        testNumbers.put("2,94,-7,52,0,-2,42", true);
        testNumbers.put("", false);
        testNumbers.put(",", false);
        testNumbers.put("0,2,94,-7,52,0,-2,42", false); //do zastanowienia???
        testNumbers.put(",0,2,94,-7,52,0,-2,42", false); //do zastanowienia???

        for (Map.Entry element : testNumbers.entrySet()) {
            if (!(isStringCorrect((String) element.getKey()) == (Boolean) element.getValue())) {
                System.out.println((String) element.getKey()
                        + " expected: " + (Boolean) element.getValue()
                        + ", result: " + isStringCorrect((String) element.getKey()));
            }
        }
    }


    private int[] sortNumbers(int[] numbersArr) {
        int n = numbersArr.length;
        do {
            for (int i = 0; i < n - 1; i++) {
                if (numbersArr[i] > numbersArr[i + 1]) {
                    int temp = numbersArr[i];
                    numbersArr[i] = numbersArr[i + 1];
                    numbersArr[i + 1] = temp;
                }
            }
            n -= 1;
        }
        while (n > 1);
        return numbersArr;
    }


// Zad_7 Narysuj Prostokąt w konsoli:

    private void drawRectangle(char fillingChar, int posX, int posY, int lengthX, int lengthY) {
        for (int x = 1; x < posX + lengthX; x++) {
            for (int y = 1; y < posY + lengthY; y++) {
                System.out.print((y >= posY && x >= posX) ? fillingChar : ' ');
            }
            System.out.print("\n");
        }
    }

    private void drawRectangle2(char fillingChar, int posX, int posY, int lengthX, int lengthY) {
        for (int x = 1; x < posX + lengthX; x++) {
            System.out.print("\n");
        }
    }

    public void drawRectangle() {
        // 1. Filling char
        String userInput;
        while ("".equals(userInput = CommonFunctions.getStringFromUser("Podaj znak do wypelnienia: "))) {
            System.out.println("Złe dane wejściowe, miałeś wpisać znak");
        }
        char fillingChar = userInput.charAt(0);

        // 2. Coordinate
        int posX;
        while ((posX = CommonFunctions.getNumberFromUser("Podaj pozycję X: ")) < 1) {
            System.out.println("Złe dane wejściowe, X musi byc > 1");
        }

        int posY;
        while ((posY = CommonFunctions.getNumberFromUser("Podaj pozycję Y: ")) < 1) {
            System.out.println("Złe dane wejściowe, Y musi byc > 1");
        }

        // TODO: ZMIEN JAK POWYZEJ
        // 3. dlugosci
        int lengthX;
        while ((lengthX = CommonFunctions.getNumberFromUser("Podaj dlugość X: ")) < 1) {
            System.out.println("Złe dane wejściowe, lengthX musi byc > 1");
        }

        int lengthY;
        while ((lengthY = CommonFunctions.getNumberFromUser("Podaj dlugość Y: ")) < 1) {
            System.out.println("Złe dane wejściowe, lengthY musi byc > 1");
        }

        drawRectangle(fillingChar, posX, posY, lengthX, lengthY);
    }


//Zad_6 Gra w "więcej - mniej":

    public void lessMoreGame() {
        int randomNumber = CommonFunctions.getRandomNumber(0, 100);
        int yourNumber;
        System.out.println(randomNumber);

        while (randomNumber != (yourNumber = CommonFunctions.getNumberFromUser("Podaj liczbę od 0 - 100", 0, 100))) {
            if (yourNumber > randomNumber) {
                System.out.println("Podałeś za dużą wartość");
            } else {
                System.out.println("Podałeś za małą wartość");
            }
        }
        System.out.println("Gratulacje, wygrałeś! Szukana liczba to: " + randomNumber);
    }

//Zad_8 Choinka

    public void drawChristmasTree() {
        int height = CommonFunctions.getNumberFromUser("Podaj liczbę pięter choinki :)");
        int middle = height - 1;
        int rowsLength = height * 2 - 1;

        for (int row = 0; row < height; row++) {
            for (int column = 0; column < rowsLength; column++) {
                System.out.print(((column >= middle - row) && (column <= middle + row)) ? "*" : " ");
            }
            System.out.print("\n");
        }
    }


// Zad_9 ?????! Wrócić i ogarnąc dla liczb ujemnych !????

    public void countSumAndRatio() {
        String usersNumber = String.valueOf(CommonFunctions.getNumberFromUser("Podaj długą liczbę całkowitą:"));
        int sumOfNumbers = 0;
        int[] evenArr = new int[usersNumber.length()];
        int[] oddArr = new int[usersNumber.length()];
        int evenIndex = 0;
        int oddIndex = 0;
//suma cyfr:
        for (int i = 0; i < usersNumber.length(); i++) {
            sumOfNumbers += CommonFunctions.charToInt(usersNumber.charAt(i));
        }
        System.out.println("suma: " + sumOfNumbers);

//rozdzielanie liczb na odd i even do tablic:
        for (int i = 0; i < usersNumber.length(); i++) {
            if (CommonFunctions.isNumberEven(usersNumber.charAt(i))) {
                evenArr[evenIndex] = CommonFunctions.charToInt(usersNumber.charAt(i));
                evenIndex += 1;
                oddArr = Arrays.copyOf(oddArr, oddArr.length - 1);
            } else {
                oddArr[oddIndex] = CommonFunctions.charToInt(usersNumber.charAt(i));
                oddIndex += 1;
                evenArr = Arrays.copyOf(evenArr, evenArr.length - 1);
            }
        }
//liczenie średnich + ratio:
        double evenSum = (double) CommonFunctions.sumOfArrsNumbers(evenArr) / evenArr.length;
        double oddSum = (double) CommonFunctions.sumOfArrsNumbers(oddArr) / oddArr.length;
        double ratio = evenSum / oddSum;
        System.out.println("stosunek średnich arytmetycznych liczb parzystych i nieparzystych to: " + evenSum + "/" + oddSum);
        System.out.println("stosunek średnich arytmetycznych liczb parzystych i nieparzystych to: " + ratio);

    }

//Zad_10

    public void getNumbersDivisors() {
        int usersNumber = CommonFunctions.getNumberFromUser("Podaj liczbę aby wyświetlić jej dzielniki: ");
        System.out.println("Dzielniki dla liczby " + usersNumber + " to: ");
        if (usersNumber < 0) {
            for (int iNegative = usersNumber; iNegative <= Math.abs(usersNumber); iNegative++) {
                if (iNegative != 0 && usersNumber % iNegative == 0) {
                    System.out.println(iNegative);
                }
            }
        }
        for (int i = 1; i <= usersNumber; i++) {
            if (usersNumber % i == 0) {
                System.out.println(i);
            }
        }
    }

//Zad_11 Sprawdzanie czy liczba jest pierwszą

    public void isPrimeNumberFor() {
        int number = CommonFunctions.getNumberFromUser("Podaj liczbę aby sprawdzić czy jest pierwszą: ",2,null);
        boolean flag = false;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }
    }

//    public void isPrimeNumberWhile() {
//        int number = 7, i = 2;
//        boolean flag = false;
//        while (i <= number / 2) {
//            if (number % i == 0) {
//                flag = true;
//                break;
//            }
//            i++;
//        }
//        if (!flag) {
//            System.out.println(number + " is a prime number.");
//        } else {
//            System.out.println(number + " is not a prime number.");
//        }
//    }

}//klamra klasy
