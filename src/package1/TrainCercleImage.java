package package1;

import java.awt.Graphics;
import java.awt.image.BufferedImage;



public class TrainCercleImage extends TrainCercle {


	 /**
     * @param d la feuille de dessin oÃ¹ se situe le train
     * @param nbCercle nombre cerlce du train
     * @param img l'image du début de train
     */
    public TrainCercleImage(Dessin d, int nbCercle, BufferedImage img) {
        
    	super(d, new CercleDebutImage(d.getLargeur() /2 , d.getHauteur() /2, 0, img),
                img.getWidth() /2, nbCercle);
    }
    
}
