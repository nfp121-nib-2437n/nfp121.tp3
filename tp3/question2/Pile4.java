package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile4 implements PileI, Cloneable {
    /** la liste des Maillons/Elements */
    private Maillon stk;
    /** la capacité de la pile */
    private int capacite;
    /** le nombre */
    private int nombre;

    /**
     * Classe interne "statique" contenant chaque élément de la chaine c'est une
     * proposition, vous pouvez l'ignorer !
     */
    private static class Maillon implements Cloneable {
        private Object element;
        private Maillon suivant;

        public Maillon(Object element, Maillon suivant) {
            this.element = element;
            this.suivant = suivant;
        }

        public Maillon suivant() {
            return this.suivant;
        }

        public Object element() {
            return this.element;
        }

        public Object clone() throws CloneNotSupportedException {
            Maillon m = (Maillon) super.clone();
            m.element = element;
            return m;
        }
        public String toString(){
            return element+"";
        }
    }

    /**
     * Création d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit être > 0
     */
    public Pile4(int taille) {
        if (taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        this.stk = null;
        this.capacite = taille;
    }

    public Pile4() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if(stk == null) {stk = new Maillon(o,null); nombre=0;} 
        
        Maillon temp = new Maillon(o,null);
    Maillon tete = stk;
        if (tete != null) {
                     while (tete.suivant != null) {
                tete = tete.suivant;
            }
                     tete.suivant = temp;
                     nombre++;
        }
}
    

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
           Maillon tete = stk;
           Object rjt= null;
        while(tete.suivant.suivant!=null){
           
            tete=tete.suivant;
        }
        rjt=tete.suivant;
        tete.suivant = null;
        nombre--;
        return rjt;
    }

    public Object sommet() throws PileVideException {
        if (estVide())
            throw new PileVideException();
           Maillon tete = stk;
        while(tete.suivant!=null){
            tete = tete.suivant;
         }
        return tete;
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        return stk == null; 
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        return taille() == capacite; 
    }

    /**
     * Retourne une représentation en String d'une pile, contenant la
     * représentation en String de chaque élément.
     * 
     * @return une représentation en String d'une pile
     */
    public String toString() {
        if(taille()==0) return "[]";
        String output = "[";
                Maillon temp=null;
        if (stk != null) {
             temp = stk.suivant;
            while (temp.suivant != null) {
                output +=temp.element.toString() + ", ";
                temp = temp.suivant;
            }
 
        }
        output +=temp.element.toString()+"";
        return output+"]";
    }

    public boolean equals(Object o) {
        
        if (o instanceof Pile4) {
            Pile4 p4 = (Pile4) o;
            if(this.capacite()!=p4.capacite())return false;
            if(this.taille()!=p4.taille())return false;
            Maillon tete1 = this.stk;
            Maillon tete2 = p4.stk;
            while(tete1!=null && tete2!=null){
                if (!(tete1.element.equals(tete2.element)))return false;
                tete1=tete1.suivant;
                tete2=tete2.suivant;
            }
        }
        return true;
    }

    public int capacite() {
        return this.capacite;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public int taille() {
        return nombre;
    }
    
    public static void main (String args[]) throws Exception{
       Pile4 p = new question2.Pile4(3);
        p.empiler(3);
        System.out.println(p.taille());
         System.out.println(p.depiler());
         System.out.println(p.taille());
        
         
           
           
       
    }
}