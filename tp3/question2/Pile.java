package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile implements PileI {

    private Object[] zone;
    private int ptr;
    public static int TAILLE_PAR_DEFAUT = 5;

    public Pile(int taille) {
        if(taille < 0) {taille = TAILLE_PAR_DEFAUT+1;}
        zone = new Object[taille];
        ptr =0;
    }

    public Pile() {
        zone = new Object[TAILLE_PAR_DEFAUT+1];
        ptr =0;
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        this.zone[this.ptr] = o;
        this.ptr++;
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        this.ptr--;
        return zone[ptr];
    }

    public Object sommet() throws PileVideException {
        return zone[taille()-1];
    }

    public int capacite() {
        //System.out.println("capacite :"+ zone.length);
        return zone.length;
    }

    public int taille() {
        return ptr;
    }

    public boolean estVide() {
        return taille() ==0;
    }

    public boolean estPleine() {
        //System.out.println("taille : "+taille());
        //System.out.println("capacite : "+capacite());
        return taille()==capacite();
    }

    public boolean equals(Object o) {
        Pile tmp = (Pile) o;
        if(this.taille()!= tmp.taille())return false;
        if(this.capacite()!= tmp.capacite())return false;
        for(int i=0;i<taille();i++){
            boolean found = false;
            for(int j=0;j<tmp.taille();j++){
                if(zone[i] == tmp.zone[j])found = true;
                System.out.println(i);
            }
            if(!found)return false;
        }
        return true;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i = ptr - 1; i >= 0; i--) {
            sb.append(zone[i]);
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}