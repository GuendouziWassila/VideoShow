package package1;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class CercleDebutImage extends CercleDebut {

	/**
     * l'image a afficher pour le début de cercle
     */
    private final BufferedImage img;
    
    /**
     * 
     * @param xInit abscisse initial du centre du cerlce de début
     * @param yInit ordonnées intiial du centre du cerlce de début
     * @param pointe la pointe initialdu cerlce de début
     * @param img l'image du cerlce de début
     */
    public CercleDebutImage(int xInit, int yInit, int cap, BufferedImage img) {
        super(xInit, yInit, img.getWidth() /2 , cap);
        this.img = img;
    }

    // redÃ©finition de la mÃ©thode dessiner
    
    @Override
    public void dessiner(Graphics g) {
        g.drawImage(img, 
                this.x - r, this.y - r, this.x + r, this.y + r,
                0, 0, 63, 63, null);
    }
	
}
