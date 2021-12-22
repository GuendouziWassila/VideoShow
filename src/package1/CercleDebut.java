package package1;

import java.awt.Graphics;

public class CercleDebut extends Cercle{
	 //------- variables d'instance (attributs) --------------------------
    /**
     * pointe du début du train Cercle; Exprimé en degrés
     */
    protected double pointe;

    //-------- Constructeurs ---------------------------------------------
    /**
     * créer le début du train Cercle en fixant sa position initiale, son rayon et sa pointe
     *
     * @param xInit abscisse du centre u cercle
     * @param yInit ordonnée du centre du cercle
     * @param rInit rayon du cercle
     * @param cInit la pointe intial (en degrés)
     */
    public CercleDebut(int xInit, int yInit, int rInit, double cInit) {
        super(xInit, yInit, rInit);
        pointe = cInit;
    }

    /**
     * crée un début de train Cercle en fixant sa position initiale. Son rayon et sa pointe sont
     * fixés avec les valeurs par défaut.
     *
     * @param xInit abscisse du centre du cercle
     * @param yInit ordonnée du centre du cerclce
     */
    public CercleDebut(int xInit, int yInit) {
        this(xInit, yInit, R, 0.0);
    }

    //-------- Méthodes ---------------------------------------------  
    /**
     * affiche le début du train Cercle en la matérialisant par un disque noir
     *
     * @param g cet objet de classe Graphics passé en paramètre est l'objet qui
     * prend en charge la gestion de l'affichage dans la fenètre de dessin.
     * C'est cet objet qui gère le contexte graphique" pour cette fenètre.
     */
    @Override
    public void dessiner(Graphics g) {
        g.fillOval(x - r, y - r, 2 * r, 2 * r);
    }

    private double normalize(double d) {
        double res = Math.abs(d) % 360;
        if (d < 0) {
            if (res > 180) {
                res = 360 - res;
            } else {
                res = -res;
            }
        } else {
            if (res > 180) {
                res = -(360 - res);
            }
        }
        return res;
    }

    /**
     * Modifie la pointe du train Cercle. La pointe courante du train cercle est modifié
     * en lui ajoutant une variation de la pointe passée en paramètre.
     *
     * @param deltaC la variation &  appliquer à la pointe de la chenille (en degrés).
     */
    public void devierPointe(double deltaC) {
        pointe += deltaC;
        pointe = normalize(pointe);
    }

    /**
     * deplace le centre du train cercle de manière Ã  ce que le déplacement
     * effectué corresponde Ã  un déplacement d'une distance egale au rayon du
     *  début du train  dans la direction indiquée par la pointe.
     */
    public void deplacerSelonPointe() {
        x = (int) (x + r * Math.cos(Math.PI * pointe / 180));
        y = (int) (y + r * Math.sin(Math.PI * pointe / 180));
    }

    /**
     * teste si la pointe actuel garantit que prochain dÃ©placement du début du train Cercle selon
     * sa pointe maintiendra celle-ci entiÃ¨rement dans la zone de dessin.
     *
     * @param xMax la taille en x de la zone de dessin
     * @param yMax la taille en y de la zone de dessin
     *
     * @return true la point (x',y') dÃ©fini par x' = x + R * cos(pointe) et 
     *         y' = y + R * sin(pointe) est Ã  une distance >= R de chacun des
     *         bords de la zone.
     */ 
    public boolean pointeOK(int xMax, int yMax) {
        int x1 = (int) (x + r * Math.cos(Math.PI * pointe / 180));
        int y1 = (int) (y + r * Math.sin(Math.PI * pointe / 180));

        return x1 >= r && x1 <= (xMax - r) && y1 >= r & y1 <= (yMax - r);
    }
}
