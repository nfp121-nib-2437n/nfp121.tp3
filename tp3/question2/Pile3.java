package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile3 implements PileI {

    private Vector<Object> v;
public static int TAILLE_PAR_DEFAUT = 5;
    private int capacite;
    public Pile3() {
        this(0);
    }

    public Pile3(int taille) {
        if(taille <= 0) taille = TAILLE_PAR_DEFAUT;
        capacite = taille;
        v = new Vector<Object>(capacite);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        this.v.add(o);
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
            Object o = v.get(taille()-1);
            v.remove(v.get(taille()-1));
            return  o;
    }

    public Object sommet() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        return v.lastElement();
    }

    public int taille() {
        if(!estVide())
        return v.lastIndexOf(v.lastElement())+1;
        return 0;
    }

    public int capacite() {
        return capacite;
    }

    public boolean estVide() {
        return v.isEmpty();
    }

    public boolean estPleine() {
        return v.size() == capacite();
    }

    public String toString() {
        return v.toString();
    }

    public boolean equals(Object o) {
        return v.equals(((Pile3)o).getVector());
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    public Vector getVector(){
        return this.v;
    }
}
