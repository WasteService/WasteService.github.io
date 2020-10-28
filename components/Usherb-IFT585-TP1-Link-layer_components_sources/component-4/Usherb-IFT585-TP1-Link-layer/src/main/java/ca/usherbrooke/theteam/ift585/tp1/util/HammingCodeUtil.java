/**
 * TP1 - IFT585
 * @authors The Team : Benjamin Boudreau (08 318 402) (08 318 402), Jean-François Ste-Marie, Jules Deliste, Nicolas Guimier
 */
package ca.usherbrooke.theteam.ift585.tp1.util;

import java.util.Iterator;
import java.util.Vector;
import org.apache.log4j.Logger;

/**
 *
 * @author Jean-Francois Ste-Marie
 */
public class HammingCodeUtil {

    private static Logger log = Logger.getLogger(HammingCodeUtil.class);

////////////////////////////////////////////////////////////////////////////////////////////////////
    public static String encode(String donnee) {
        int nbBitCorrecteur = 0;
        int posiToInsertBitCorrec = 0;

        log.debug("Donne a encoder : " + donnee);

        Vector<Integer> vectBit; // peut-etre mettre le vector en de-hors de la fonction
        vectBit = defaireDonnee(donnee);

        //On vien mettre les bits correcteur a leur place respective. Pour le moment ils sont tous egals a ZERO.
        //on verifie a chaque tour la position du bit correcteur a ajouter afin de voir si le bit
        //va nous etres utile ou pas.
        while ((posiToInsertBitCorrec = (int) Math.pow(2, nbBitCorrecteur)) < vectBit.size()) {
            vectBit.add(posiToInsertBitCorrec - 1, 0);
            nbBitCorrecteur++;
        }

        //On met la valeur respective au bits correcteurs que l'on vient j'ajouter
        for (int j = 0; j < nbBitCorrecteur; j++) {
            int bitNo = (int) Math.pow(2, j); //donne la position du bit corr. soit 1,2,4,8 ...

            vectBit.setElementAt(valeurBitCorrecteur(vectBit, bitNo), bitNo - 1);
        }

        donnee = reconstruireDonnee(vectBit);
         log.debug("Donnee encoder " + donnee);

        return donnee;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////
    public static String decode(String donnee) {
        Vector<Integer> vectBit;
        vectBit = defaireDonnee(donnee);
        int nbBitCorrecteur = 0;

        log.debug("Donnee a decoder : " + donnee);
        log.debug("Code d'erreur : " + codeErreur(vectBit));

        if (Integer.parseInt(codeErreur(vectBit)) != 0) {
            log.debug("CORRECTION!");
            vectBit = correctionErreur(vectBit, codeErreur(vectBit));
        }

        log.debug("Donnee encoder apres verification d'erreur : " + reconstruireDonnee(vectBit));

        while (((int) Math.pow(2, nbBitCorrecteur)) < vectBit.size()) {
                nbBitCorrecteur++;
        }

        for (int i = nbBitCorrecteur - 1; i >= 0; i--) {
                vectBit.removeElementAt((int) Math.pow(2, i) - 1);
        }

        donnee =reconstruireDonnee(vectBit);
        log.debug("Donnee decoder apres correction : " + donnee);

        return donnee;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////
    public static boolean validate(String donneeEncode) {

        Vector<Integer> vectBit;
        vectBit = defaireDonnee(donneeEncode);
        String codeErreur = "";

        log.debug("Validation des donnees : " + donneeEncode);

        codeErreur = codeErreur(vectBit);

        log.debug("Code erreur apres premiere validation : " + codeErreur);

        if (Integer.parseInt(codeErreur) == 0) {
                return true;
        }

        log.debug("CORRECTION dans validation");
        vectBit = correctionErreur(vectBit, codeErreur);

        codeErreur = codeErreur(vectBit);
        log.debug("Code erreur apres deuxieme validation : " + codeErreur);

        return ((Integer.parseInt(codeErreur) == 0) ? true : false);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////
    //Permet de faire la sommation des bits valeurs que couvre le bit correcteur.
    //Une fois la sommation fait, on verifie la parite. Si la somme est paire le bit
    //correcteur cera 0 et 1 si la somme est impaire.
    private static int valeurBitCorrecteur(Vector<Integer> vectBit, int rang) {

        int somme = 0;
        int index = 0;

        do {
            index += rang;

            log.debug("Position du bit correcteur pour lequel on va trouver la valeur : " + rang);

            for (int i = rang; i != 0; i--) {
                if (index != rang) {
                    log.debug("Position pris en compte dans le calcule : " + index);
                    somme += vectBit.elementAt(index - 1);
                }

                if(index == vectBit.size()) { break; }

                index++;
            }
        } while (index + rang <= vectBit.size());

        log.debug("Somme des bits pris en compte : " + somme + " et valeur du bit apres calcul : " + (somme%2));
        //retourne 0 si somme paire et 1 sinon.
        return ((somme % 2 == 0) ? 0 : 1);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////
    private static String codeErreur(Vector<Integer> vectBit) {
        String codeErreur = "";
        int i = 0;
        int bitNo = 0;

        while ((bitNo = (int) Math.pow(2, i)) < vectBit.size()) {
            codeErreur = ((valeurBitCorrecteur(vectBit, bitNo) == vectBit.elementAt(bitNo - 1)) ? 0 : 1) + codeErreur;
            i++;
        }

        return codeErreur;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////
    private static Vector<Integer> correctionErreur(Vector<Integer> vectBit, String codeErreur) {
        int posiToChange = Integer.parseInt(codeErreur, 2);

        log.debug("Position a corriger : " + posiToChange);

        if (posiToChange <= vectBit.size()) {
                vectBit.setElementAt(((vectBit.elementAt(posiToChange - 1) == 0) ? 1 : 0), posiToChange - 1);
        }

        return vectBit;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////
    private static String reconstruireDonnee(Vector<Integer> vectBit) {
        String donnee = "";

        //On ajoute le nouvel encodage dans le String "ligne" vide ci-haut
        Iterator<Integer> it = vectBit.iterator();
        while (it.hasNext()) {
                donnee += it.next();
        }

        return donnee;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////
    private static Vector<Integer> defaireDonnee(String donnee) {
        Vector<Integer> vectBit = new Vector<Integer>();

        //On insert les valeurs du string recu dans le vecteur
        while (donnee.length() != 0) {
                vectBit.addElement(Integer.parseInt(donnee.substring(0, 1)));
                donnee = donnee.substring(1);
        }

        return vectBit;
    }
}
