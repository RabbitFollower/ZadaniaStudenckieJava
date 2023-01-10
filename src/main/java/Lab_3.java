public class Lab_3 {

//Zad_1: Stworzenie arr[10] i wykonaniu wielu operacji na niej ^^'

    public void createArr10() {
        int[] arr = new int[10];
        int min = 0;
       // int[] arr = {3, 7, 2, -6, -8, -3, -10, 5, 2, -5};
// petla wypełnia arr losowymi z zakresu i wyświetla jej elementy:
        for (int i = 0; i < arr.length; i++) {
            arr[i] = CommonFunctions.getRandomNumber(-10, 10);
            System.out.print(arr[i] + "  ");
        }
        for (int i = 0;  i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                min = arr[i];
            } else min = arr[i + 1];
// przerobić na min i tempMin z Math.min???
        }
        System.out.println("Najmniejsza liczba: " + min);


    }

































































}//klamra klasy
