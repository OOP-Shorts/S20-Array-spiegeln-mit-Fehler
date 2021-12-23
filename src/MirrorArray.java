import java.util.Arrays;

public class MirrorArray {

    /*
        Die Methode soll ein Array zurückgeben, dass das originale übergebene Array und seine Spiegelung enthält.
        Wird zum Beipiel das Array {3, 4, 5} in values übergeben, dann soll die Methode das Array {3, 3, 5, 5, 4, 3}
        zurückgeben.
        Der vorgegebene Code funktioniert fast. Leider haben sich aber 2 Fehler eingeschlichen, die zu unerwartetem
        Verhalten führen. Finde die Fehler und reperiere die Methode!
     */
    public static int[] getMirroredArray(int[] values) {
        int[] mirroredArray = new int[values.length * 2];

        // Lässt man die for-Schleife bis values.length * 2 durchiterieren so entsteht ein Fehler, weil das originale
        // values-Array zu klein ist und der Index i deshalb irgendwann außerhalb der Array-Grenzen liegt.
        for (int i = 0; i < values.length; i++) {
            mirroredArray[i] = values[i];
            // Wird von values.length hier 1 abgezogen, wird der Wert an der Position values.length - 1 überschrieben.
            mirroredArray[values.length + i] = values[values.length - 1 - i];
        }

        return mirroredArray;
    }

    public static void main(String[] args) {
        int[] testValues = {1, 2, 3};
        int[] mirrored = getMirroredArray(testValues);

        int[] solution = {1, 2, 3, 3, 2, 1};

        if(Arrays.equals(mirrored, solution)) {
            System.out.println("Correct!");
        } else {
            System.out.println("Not Correct :(");
        }
    }
}
