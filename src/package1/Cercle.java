package package1;

import java.awt.Graphics;

public class Cercle {

	 //-------------- constantes ----------------------------------------
    /**
     * rayon par défaut du cercle
     */
    public final static int R = 5;

  //-------------- variables d'instance (attributs)--------------------
    /**
     * abscisse du centre du cercle
     */
    protected int x;

    /**
     * ordonnées du centre du cercle
     */
    protected int y;

    /**
     * rayon du cercle
     */
    protected int r;

  // ------ Constructeurs ---------------------------------------------
    /**
     * créer un Cercle en fixant la position initiale de son centre et son rayon.
     *
     * @param xInit abscisse du centre du cercle
     * @param yInit ordonnÃ©e du centre du cercle
     * @param rInit rayon du cercle
     */
    public Cercle(int xInit, int yInit, int rInit) {
        this.x = xInit;
        this.y = yInit;
        this.r = rInit;
    }

    /**
     * créere un Cercle en fixant la position initiale de son centre et avec la
     * valeur par défaut pour son rayon.
     *
     * @param xInit abscisse du centre du cercle
     * @param yInit ordonnée du centre du cercle
     */
    public Cercle(int xInit, int yInit) {
        this(xInit, yInit, R);
    }

  // ------ Méthodes -------------------------------------------------
    /**
     * retourne abscisse du centre du cercle
     *
     * @return abscisse du centre
     */
    public int getX() {
        return x;
    }

    /**
     * retourne ordonnée du centre du cercle
     *
     * @return ordonnée du centre
     */
    public int getY() {
        return y;
    }

    /**
     * positionne le centre du cercle en un point donné
     *
     * @param px nouvelle abscisse du centre
     * @param py nouvelle ordonnée du centre
     */
    public void placerA(int px, int py) {
        x = px;
        y = py;
    }

    /**
     * affiche le cercle
     *
     * @param g cet objet de classe Graphics passé en paramètre est l'objet qui
     * prend en charge la gestion de l'affichage dans la fenètre de dessin.
     * C'est cet objet qui gère le contexte graphique" pour cette fenètre.
     */
    public void dessiner(Graphics g) {
        g.drawOval(x - r, y - r, 2 * r, 2 * r);
    }
	
	
	
}
