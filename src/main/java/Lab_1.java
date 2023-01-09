import java.util.Scanner;


public class Lab_1 {
    Scanner skaner = new Scanner(System.in);
    private int currentIndex;

    public void ArrayMenager() {
        this.currentIndex = 0;
    }


    // Zadanie 1 - nazwa ma mówic co funkcja robi, to na dole to tylko przyklad
    public double celsjuszeNaFarenheity(double stopnie) {
        return stopnie * 1.8 + 32;
    }



    //Zad 2 itd.
    public void trzyLiczby() {
        int[] mojeLiczby = new int[3];


        for (int i = 0; i < mojeLiczby.length; i++) {
            System.out.println("Podaj " + (i+1) + ". liczbę całkowitą:");
            mojeLiczby[i] = skaner.nextInt();
        }

        mojeLiczby = sort(mojeLiczby);
        System.out.println(mojeLiczby[0]);
        System.out.println(mojeLiczby[2]);
    }

    private int[] sort(int[] arrayToSort) {
        int n = arrayToSort.length;

        do {
            for (int i = 0; i < n-1; i++) {
                if (arrayToSort[i] > arrayToSort[i+1]) {
                    int temp = arrayToSort[i];
                    arrayToSort[i] = arrayToSort[i+1];
                    arrayToSort[i+1] = temp;
                }
            }
        }
        while (n > 1);
        return arrayToSort;
    }

    //Zad_3 Obliczanie BMI
//do przerobienia (zmienne min/max), if do przerobienia(sprawdzanie czy jest nadwaga/niedowaga w przeciwnym wypadku waga normalna
    public double calculateBMI(double weight, double growth) {
        double yourBMI = (weight / (growth * growth)) * 10000;

        if (yourBMI < 18.5) {
            System.out.println("Twoje BMI:" + yourBMI + ". Niedowaga :(");
        } else if (yourBMI >= 18.5 && yourBMI <= 24.9) {
            System.out.println("Twoje BMI:" + yourBMI + ". Waga prawidłowa :)");
        } else {
            System.out.println("Twoje BMI:" + yourBMI + ". Nadwaga :(");
        }
        return yourBMI;
    }

    //Zad_4 Obliczanie podatku + skrócona notacja
//zmienne zamiast konkretnych liczb
    public double calculateTax (double income) {
//        double yourTax;
        //double yourTax =
        return income <= 85528.00 ? (income * 18 / 100) - 556.02 : 14839.02 + ((income - 85528.00) * 0.32);

//        if (income <= 85528.00) {
//            yourTax = (income * 18 / 100) - 556.02;
//        } else {
//            yourTax = 14839.02 + ((income - 85528.00) * 0.32);
//        }
        //System.out.println("Twój podatek: " + yourTax + " PLN");
        //return yourTax;
    }





    //Zad_5 Miesięczna rata za sprzęt
//
    public double monthlyInstallment (double price, int numberOfInstallments) {
        double yourInstalment = 0;

        if (price >= 100 && price <= 10000 && numberOfInstallments >= 6 && numberOfInstallments <= 48) {
            if (numberOfInstallments >= 6 && numberOfInstallments <= 12) {
                yourInstalment = price * 1.025 / numberOfInstallments;
            } else if (numberOfInstallments >= 13 && numberOfInstallments <= 24) {
                yourInstalment = price * 1.05 / numberOfInstallments;
            }  else if (numberOfInstallments >= 25 && numberOfInstallments <= 48) {
                yourInstalment = price * 1.1 / numberOfInstallments;
            }
        } else {
            System.out.println("Zmień dane na prawidłowe");
        }
        System.out.println("Twoja rata wynosi: " + yourInstalment);
        return yourInstalment;
    }

    public double monthlyInstallment2 (double price, int numberOfInstallments) {
        double yourInstalment = 0;
        double yourInstalmentFactory = 1;

        if (price < 100 || price > 10000) {
            System.out.println("Cena nie miesci sie w przedziale");
            return 0;
        }

        if (numberOfInstallments >= 6 && numberOfInstallments <= 12) {
            yourInstalmentFactory = 1.025;
        }
        else if (numberOfInstallments <= 24) {
            yourInstalmentFactory = 1.05;
        }
        else if (numberOfInstallments <= 48) {
            yourInstalmentFactory = 1.1;
        }
        else {
            System.out.println("Ilosc rat nie miesci sie w przedziale");
            return 0;
        }

        yourInstalment = price * yourInstalmentFactory / numberOfInstallments;

        System.out.println("Twoja rata wynosi: " + yourInstalment);
        return yourInstalment;
    }


    //Zad_6 KALKULATOR

    public void calculate() {
        double result = 0;

        System.out.println("Kalkulator liczb rzeczywistych.");
        System.out.println("Pierwsza liczba rzeczywista: ");
        double number1 = skaner.nextDouble();

        System.out.println("Działanie arytmetyczne: ");
        String arithmeticSymbol = skaner.next();

        System.out.println("Druga liczba rzeczywista: ");
        double number2 = skaner.nextDouble();

        switch (arithmeticSymbol) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                result = number1 / number2;
                break;
        }
        System.out.println("Wynik: " + result);
    }


}

//funkcja zaokrąglająca???
//z=new BigDecimal(z).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); przestarzałe, poszukaj nowego






