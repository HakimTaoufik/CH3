package CH3;
public class JeuDeBattaile {
    public static void battre(int[] donne) {
        // shuffle a deck
        // test réussi
        int n = donne.length, i, j, tmp;
        for (i = 0; i < n;i++) {
            j = (int)(Math.random() * (i+1));
            tmp = donne[i];
            donne[i] = donne[j];
            donne[j] = tmp;
        }
    }

    public static int[] creerJeu(int n) {
        // creates a deck of a length n
        // test réussi
        int[] jeu = new int[n];
        for (int i = 0; i < jeu.length; i++) {
            jeu[i] = i;
        }
        battre(jeu);
        return jeu;
    }

    public static void distribuer(int[] jeuA, int[] jeuB, int[] donne) {
        // distribute the deck to player A and B
        //test réussi
        for (int i = donne.length -1; i > 0; i--) {
            if ((i & 1) == 0) {
                jeuA[i/2] = donne[i];
            } 
            else {
                jeuB[i/2] = donne[i];
            }
        }
    }

    public static int[][] bataille(int[] jeuA, int[] jeuB) {
        int a = jeuA.length, b = jeuB.length;
        int gainA = 0, gainB = 0;
        for (int i = 0; i < Math.min(a, b); i++) {
            if (jeuA[i] > jeuB[i]) {
                gainA++;
            } else {
                gainB++;
            }
        }
        int[] residuA, residuB;
        residuA = new int[gainA];
        residuB = new int[gainB];
        int ia = 0, ib = 0, i=0;
        do {
            if (jeuA[ia] > jeuB[ib]) {
                residuA[ia] = jeuA[i];
                ia++;
                i++;
            } else if (jeuA[ia] < jeuB[ib]){
                residuB[ib] = jeuB[i];
                ib++;
                i++;
            }
        } while (ia < gainA && ib < gainB);
        int[][] residu = new int[][]{residuA, residuB};
        return residu;
    }

    public static String jouer(int n) {
        int[] donne;
        donne = creerJeu(n);
        int[] jeuAlice = new int[donne.length/2];
        int[] jeuBob = new int[donne.length/2];
        distribuer(jeuAlice, jeuBob, donne);

        int a,b;
        do{
            for (int i : jeuBob) {
                System.out.println("Voici les cartes de Bob :" + i);
            }
            for (int i : jeuAlice) {
                System.out.println("Voici les cartes de Alice :" + i);
            }
            int[][] tmp; tmp = bataille(jeuAlice, jeuBob);
            jeuAlice = tmp[0];
            jeuBob = tmp[1];
            a = jeuAlice.length;
            b = jeuBob.length;
        } while (a > 0 && b > 0);

        if (a==0 && b==0) {
            return "Égalité entre Alice et Bob !";
        } else if (a == 0){
            return "Bob a gagné.";
        } else {
            return "Alice a gagné";
        }
    }

    public static void main(String[] args) {
        System.out.println(jouer(32));
    }
}