
public class Lab_3 {
    public static final int ARR_LENGTH = 20;

//----------------------------------------------- Zad_1 -----------------------------------------------------------//

    public void createArr10() {
        int[] arr = new int[10];
        int min = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = CommonFunctions.getRandomNumber(-10, 10);
            System.out.print(arr[i] + "  ");
        }

        int tempMin = arr[0];
        int tempMax = arr[0];
        for (int i = 1; i <= arr.length - 1; i++) {
            if (arr[i] < tempMin) {
                tempMin = arr[i];
            }
            if (arr[i] > tempMax) {
                tempMax = arr[i];
            }
        }
        System.out.println("Najmniejsza liczba: " + tempMin);
        System.out.println("Największa liczba: " + tempMax);


// średnia:
        double arrItemsSum = 0;
        for (int i = 0; i < arr.length; i++) {
            arrItemsSum += arr[i];
        }
        System.out.println("średnia: " + arrItemsSum / arr.length);

// ile elem. < i > od średniej:
        double average = arrItemsSum / arr.length;
        int counterLess = 0;
        int counterMore = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < average) {
                counterLess++;
            } else if (arr[i] > average) {
                counterMore++;
            }
        }
        System.out.println("ilość liczb mniejszych od średniej: " + counterLess);
        System.out.println("ilość liczb większych od średniej: " + counterMore);

//tablica w odwrotnej kolejności
        for (int i = arr.length - 1; i >= 0; i-- ) {
            System.out.print(arr[i] + " ");
        }
    }

//----------------------------------------------- Zad_2 -----------------------------------------------------------//

    public void createArrAndCheck() {
        final int ARR_LENGTH = 6;
        final int MIN_NO = 3;
        final int MAX_NO = 10;
        int counter = 0;

        if(MIN_NO > MAX_NO) {
            System.out.println("MIN_NO cannot be higher than MAX_NO.");
            return;
        } else if (ARR_LENGTH <= 0) {
            System.out.println("ARR_LENGTH must be higher than 0");
            return;
        }

        int[] arr = new int[ARR_LENGTH];

        for (int i = 0; i < ARR_LENGTH; i++) {
            arr[i] = CommonFunctions.getRandomNumber(MIN_NO, MAX_NO);
            System.out.print(arr[i] + "  ");
        }
        System.out.println("\n");

        for (int number = MIN_NO; number <= MAX_NO; ++number) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == number) {
                    counter++;
                }
            }
            System.out.println(number + " : " + counter);
            counter = 0;
        }
    }

//----------------------------------------------- Zad_3 -----------------------------------------------------------//

    public void getMatrix() {
        final int ROW_NO_MATRIX = 4;
        final int COL_NO_MATRIX = 6;
        final int MIN_RANDOM_VALUE = -500;
        final int MAX_RANDOM_VALUE = 500;
        final int VALUE_LENGTH = (String.valueOf(MIN_RANDOM_VALUE).length() > String.valueOf(MAX_RANDOM_VALUE).length()
                                ? String.valueOf(MIN_RANDOM_VALUE).length()
                                : String.valueOf(MAX_RANDOM_VALUE).length()) + 2;
        int[][] matrix = new int[ROW_NO_MATRIX][COL_NO_MATRIX];

        for(int row = 0; row < ROW_NO_MATRIX; row++) {
            for (int col = 0; col < COL_NO_MATRIX; col++) {
                matrix[row][col] = CommonFunctions.getRandomNumber(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
                System.out.print(CommonFunctions.getNumbersPaddingLeft(matrix[row][col], VALUE_LENGTH));
            }
            System.out.println();
        }

        int tempMin = matrix[0][0];
        int tempMax = matrix[0][0];
        for (int col = 0; col < COL_NO_MATRIX; col++) {
            for (int row = 0; row < ROW_NO_MATRIX; row++) {
                if (tempMin >= matrix[row][col]) {
                    tempMin = matrix[row][col];
                }
                if (tempMax <= matrix[row][col]) {
                    tempMax = matrix[row][col];
                }
            }
            System.out.println("Min: " + tempMin  + "\t" + "Max: " + tempMax);
            tempMin = Integer.MAX_VALUE;
            tempMax = Integer.MIN_VALUE;
        }
    }

//----------------------------------------------- Zad_4 -----------------------------------------------------------//

    public void getBinaryValue() {
        int numberFromUser = 75;
        StringBuilder binaryValue = new StringBuilder();

        while (numberFromUser != 0) {

            if (numberFromUser % 2 == 0) {
                binaryValue.append("0");
            } else {
                binaryValue.append("1");
            }
            numberFromUser /= 2;
        }
        System.out.print(binaryValue.reverse());
    }
}
