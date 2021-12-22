package package1;

import java.awt.Graphics;

public class TrainCercle {

	 //------- variables d'instance (attributs) --------------------------
    /**
     * tableau stockant les références des cercles du train
     */
    private final Cercle[] lesCercles;
    /**
     * la d�but du train de cercle
     */
    protected CercleDebut leDebut;
    /**
     * la zône de dessin o� se déplace le train de cercle
     */
    private Dessin dess;

    //-------- Constructeurs ---------------------------------------------
    /**
     * cr�e un train de cercle en sp�cifiant la feuille de dessin dans laquelle elle
     * se d�place, le rayon et le nombre de ces cercles.
     *
     * @param d la feuille de dessin o� se situe le train de cercle
     * @param r rayon des cerlces du train 
     * @param nbCercle nombre de cercles du train 
     */
    public TrainCercle(Dessin d, int r, int nbCercle) {
        this(d, new CercleDebut(d.getLargeur() / 2, d.getHauteur() / 2, r, 0.0), r, nbCercle);
    }

    /**
     * Crée un train de cercle en spécifiant la feuille de dessin dans laquelle elle
     * se déplace, le rayon et le nombre de ces cercles.
     * 
     * Ce constructeur a une visibilité protected. Il n'est pas public, car sa 
     * vocation n'est pas d'être invoqué par un programme applicatif. Il est prévu
     * pour un usage interne, en particulier pour d'éventuelles sous classes
     * de trainCercle, afin de pouvoir créer des trains de cercles avec un d�butCercle de type diff�rent
     *
     *
     * @param xInit la feuille de dessin où se situe le train de cercle
     * @param CercleDebut le cercle de d�but du train;
     * @param r rayon des cercles de train
     * @param nbCercle nombre de cercle du train
     */
    protected TrainCercle(Dessin d, CercleDebut deb, int r, int nbCercle) {

    	 this.dess = d;
         // crée un cercle de d�but au centre de la fenêtre et de pointe 0
         this.leDebut = deb;
         int xTete = leDebut.getX();
         int yTete = leDebut.getY();

        // 1) créer le tableau
        lesCercles = new Cercle[nbCercle];
        // 2) remplir le tableau en cr�eant les cercles et en stockant
        //    leur r�f�rence dans les �l�ments du tableau.
        // cr�er les cercles, à gauche les uns des autres. Le premier
        // (Cercle n° 0) étant à gauche du d�but
        for (int i = 0; i < lesCercles.length; i++) {
            lesCercles[i] = new Cercle(xTete - (i + 1) * r, yTete, r);
        }
    }

    /**
     * affiche le train de cercle
     *
     * @param g cet objet de classe Graphics passé en paramètre est l'objet qui
     * prend en charge la gestion de l'affichage dans la fenêtre de dessin.
     * C'est cet objet qui gère le "contexte graphique" pour cette fenêtre.
     */
 
    public void dessiner(Graphics g) {
        // dessiner la tête
    	leDebut.dessiner(g);
        for (Cercle c : lesCercles) {
            c.dessiner(g);
        }
    }

    /**
     * fait effectuer à au train de cercle un déplacement élémentaire en avant dans la
     * direction indiquée par sa pointe. La pointe subit une déviation alétoire d'un
     * angle de plus ou moins 30 degrés. Si le d�but du train atteint un
     * des bords , sa pointe est alors dévié de 90°.
     */
   
    public void deplacer() {
        if (lesCercles.length > 0) {
            // fait avancer les anneaux.
            // le ième anneau prends la place du (i-1)ème anneau, l'anneau 0 prenant la place
            // de la tête
            for (int i = lesCercles.length - 1; i > 0; i--) {
                lesCercles[i].placerA(lesCercles[i - 1].getX(), lesCercles[i - 1].getY());
            }
            lesCercles[0].placerA(leDebut.getX(), leDebut.getY());
        }

        // calcule une nouvelle pointe qui garanti que le cercle de dd�but reste dans la zone
        // de dessin
        leDebut.devierPointe(-30.0 + Math.random() * 60.0);
        while (!leDebut.pointeOK(dess.getLargeur(), dess.getHauteur())) {
        	leDebut.devierPointe(10);
        }
        // fait avancer le cercle de dd�but
        leDebut.deplacerSelonPointe();
    }

}//train cercle	
	
	
	

