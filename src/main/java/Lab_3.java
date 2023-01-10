public class Lab_3 {

//Zad_1: Stworzenie arr[10] i wykonaniu wielu operacji na niej ^^'

    public void createArr10() {
        int[] arr = new int[10];
        int min = 0;
//        int[] arr = {3, 7, 2, -6, -8, -3, -10, 5, 2, -5};
//        int[] arr = {1, 2, 3, 4};
// petla wypełnia arr losowymi z zakresu i wyświetla jej elementy:
        for (int i = 0; i < arr.length; i++) {
            arr[i] = CommonFunctions.getRandomNumber(-10, 10);
            System.out.print(arr[i] + "  ");
        }

//min i max liczba w tablicy:

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

//  ile elem. < i > od średniej:
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

































































}//klamra klasy
