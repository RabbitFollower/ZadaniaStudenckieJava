public class ArrayMenager {

    private int[] array1;
    private int currentIndex;

    public ArrayMenager() {
        this.array1  = new int[5];
        this.currentIndex = 0;
    }

    public void add(int liczba) {

        if (currentIndex < array1.length) {
            this.array1[currentIndex++] = liczba;

        } else {
 // 1. stworzyc nowa tab
            int[] array2 = new int[array1.length + 10];

// 2. przepisac wartosci
            for (int i = 0; i < this.array1.length; i++) {

                array2[i] = this.array1[i];
            }
// 3. podmienic stara z nowa
            this.array1 = array2;
            System.out.println();
        }
    }

    public void showAll() {
        for (int i = 0; i < this.array1.length; i++) {
            System.out.println(this.array1[i]);
        }
    }
}
