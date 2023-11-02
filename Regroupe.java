public class Regroupe {
    // exercice 3.2 page 51
    public static void regroupe(int[] tab) {
        int lastZeroIndex = 0;
        for (int i0 = 0; i0 < tab.length; i0++) {
            if (tab[i0] == 0) {
                tab[lastZeroIndex] = 0;
                lastZeroIndex++;
            }
        }
        for (int i = lastZeroIndex; i < tab.length; i++) {
            tab[i] = 1;
        }
    }
    public static void main(String[] args) {
        int[] t = new int[]{1,0,0,1,0,1,0,0,0,0,1,1};
        regroupe(t);
        for (int i = 0; i < t.length; i++) {
            System.out.println(t[i]);
        }
    }
}
