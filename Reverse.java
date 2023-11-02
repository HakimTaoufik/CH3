public class Reverse {
    // exercice 3.1 page 50
    public static void reverse(int[] t) {
        // renverse un tableau d'entiers
        for (int i = 0; i < t.length / 2; i++) {
            int x = t[i];
            t[i] = t[t.length - i -1];
            t[t.length - i -1] = x;
        };
        return;
    }
    public static void main(String[] args) {
        int[] t = new int[]{1,2,3,4,5};
        reverse(t);
        for (int i = 0; i < t.length; i++) {
            System.out.println(t[i]);
        }
        return;
} }