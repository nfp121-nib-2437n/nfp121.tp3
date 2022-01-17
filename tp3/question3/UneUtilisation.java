package question3;

import question1.PolygoneRegulier;

public class UneUtilisation {

    public static void main(String[] args) throws Exception {
        // déclarer p1
        Pile2 p1 = new Pile2(5);
        Pile2 p2 = new Pile2(5);
        // déclarer p2
        PolygoneRegulier p3 = new PolygoneRegulier(4,6);
        // p1 est ici une pile de polygones réguliers PolygoneRegulier.java
        p1.empiler(new PolygoneRegulier(4, 100));
        p1.empiler(new PolygoneRegulier(5, 100));

        System.out.println(" la pile p1 = " + p1);

        p2.empiler(p1);
        System.out.println(" la pile p2 = " + p2);

        try {
            // oui, il existe une erreur de compilation puisque p1 n'est pas generique
             
             p1.empiler(new PolygoneRegulier(5,100)); // désormais une erreur de
             
             // oui, il existe une erreur de compilation puisque p1 contient des eleements
             // de type polygoneregulier et non string.
             String s = (String)p1.depiler(); // désormais une erreur de
            // compilation
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}