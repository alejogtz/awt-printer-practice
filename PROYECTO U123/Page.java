 

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Page extends Canvas {

    Label info;
    /**
     * Path largue
     */
    String path = "resources/pages/";

    //imgs by default, no changes
    public static enum Positions {
        HORIZONTAL, VERTICAL
    };
    /**
     * agregar los tamanios de hoja, oficio, carta etc.
     */
    private static final int[][] tams_hoja = {{281, 363}, {}, {}};
    /**
     * Imagenes
     */
    private static String[] imgs = {"PICTURE_0.jpg", "PICTURE_1.jpg", "PICTURE_2.jpg", "PICTURE_3.jpg",
        "PICTURE_4.jpg", "PICTURE_5.jpg", "PICTURE_6.jpg", "PICTURE_7.jpg", "PICTURE_8.jpg"};

    private static BufferedImage imagen;
    private static BufferedImage imgcolor;
    //End...

    /*Configuration of Page*/
    private int LIMIT_LEFT;//de que hoja empieza
    private int LIMIT_RIGHT;//en que hoja termina
    private int PAGE_NOW;//en que hoja termina
    private static int ancho;//ancho actual de la hoja
    private static int alto;//alto actual de la hoja

    private int copiesperpage = 1;

    private static String color; //formato de colo
    public Positions position; //sentido de la hoja, vertical u horizontal

    /**
     * End of Configuration
     */
    /**
     *
     * @param etiqueta
     */
    private int dx, dy;

    /**
     *
     * @param etiqueta
     */
    Page(Label etiqueta) {
        this();
        info = etiqueta;
        info.setText((PAGE_NOW + 1) + " of " + (LIMIT_RIGHT + 1));
    }

    public Page() {
        //Default
        color = "Color";//Color.WHITE;
        LIMIT_LEFT = 0;
        LIMIT_RIGHT = imgs.length - 1;
        PAGE_NOW = 0;
        ancho = 281;
        alto = 363;
        imgcolor = imagen = readImg(path + imgs[PAGE_NOW]);

    }

    @Override
    public void paint(Graphics g) {
        this.setBackground(Color.white);
        g.drawImage(imagen, dx, dy, ancho, alto, null);
    }

    public void last() {
        setPAGE_NOW(LIMIT_RIGHT);
    }

    public void first() {
        setPAGE_NOW(LIMIT_LEFT);
    }

    public void back() {
        setPAGE_NOW(PAGE_NOW - 1);
    }

    public void next() {
        setPAGE_NOW(PAGE_NOW + 1);
    }

    public void reset() {
        setLIMIT_LEFT(1);
        setLIMIT_RIGHT(9);
    }

    public int getCantPages() {
        return imgs.length;
    }

    private static BufferedImage readImg(String path) {
        try {
            BufferedImage img = ImageIO.read(new File(path));
            return img;
        } catch (IOException ex) {
            Logger.getLogger(Page.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean isLast() {

        return PAGE_NOW == LIMIT_RIGHT;
    }

    public boolean isFirst() {
        return PAGE_NOW == LIMIT_LEFT;
    }

    public void setColor(String color) {
        Page.color = color;
        if (Page.color == "BLACK") {
            WB WandB = new WB();
            imagen = WandB.set_Blanco_y_Negro_con_Umbral(imagen);
        } else if (Page.color == "COLOR") {
            imagen = imgcolor;
        }
        repaint();
    }

    public void setPAGE_NOW(int PAGE_NOW) {
        //System.err.println(LIMIT_RIGHT + " " + PAGE_NOW);
        if (PAGE_NOW >= LIMIT_LEFT && PAGE_NOW <= LIMIT_RIGHT) {
            this.PAGE_NOW = PAGE_NOW;
            imgcolor = imagen = readImg(path + imgs[PAGE_NOW]);
            setColor(color);
            info.setText((PAGE_NOW + 1) + " of " + (LIMIT_RIGHT + 1));
            repaint();
        }
    }

    public void setPosition(Positions position) {
        this.position = position;
        if (this.position == Positions.HORIZONTAL) {
            ///Modificado y = 80 x1=363
            setBounds(30, 100, 363, 281);
            //alto = ancho;
        } else {
            ///Mddificado 30
            setBounds(30, 50, 281, 363);
            //ancho = 281;
            //salto = 363;
        }
        setCopiesperpage(copiesperpage);
        repaint();
    }

    public void setLIMIT_LEFT(int LIMIT_LEFT) {
        if (LIMIT_LEFT > 0 && LIMIT_LEFT - 1 <= LIMIT_RIGHT) {
            this.LIMIT_LEFT = LIMIT_LEFT - 1;
            setPAGE_NOW(this.LIMIT_LEFT);
        }
    }

    public void setLIMIT_RIGHT(int LIMIT_RIGHT) {
        if (LIMIT_RIGHT - 1 >= this.LIMIT_LEFT && LIMIT_RIGHT <= imgs.length) {
            this.LIMIT_RIGHT = LIMIT_RIGHT - 1;
            if (PAGE_NOW > this.LIMIT_RIGHT) {
                setPAGE_NOW(this.LIMIT_RIGHT);
            } else {
                setPAGE_NOW(PAGE_NOW);
            }
        }
    }

    public void setLocacion(String donde) {
        //System.err.println(copiesperpage);
        if (copiesperpage != 1) {
            switch (donde) {
                case "arriba-izq":

                    dx = 0;//this.getWidth()/2;
                    dy = 0;//this.getHeight()/2;
                    break;
                case "arriba-der":
                    if (copiesperpage < 3) {
                        return;
                    }
                    dx = this.getWidth() / 2;
                    dy = 0;//this.getHeight()/2;
                    break;
                case "abajo-izq":
                    dx = 0;//this.getWidth()/2;
                    dy = this.getHeight() / 2;
                    break;
                case "abajo-der":
                     if (copiesperpage < 3) {
                        return;
                    }
                    dx = this.getWidth() / 2;
                    dy = this.getHeight() / 2;
                    break;

            }
        }
        repaint();
    }

    public void setCopiesperpage(int copiesperpage) {
        this.copiesperpage = copiesperpage;
        switch (copiesperpage) {
            case 1:
                if (position == Positions.HORIZONTAL) {
                    ancho = 363;
                    alto = 281;
                } else {
                    ancho = 281;
                    alto = 363;
                }
                dx = 0;
                dy = 0;
                break;
            case 2:
                ancho = this.getWidth();
                alto = this.getHeight() / 2;
                break;
            case 4:
                ancho = this.getWidth() / 2;
                alto = this.getHeight() / 2;
                break;
            case 8:
                ancho = this.getWidth() / 2;
                alto = this.getHeight() / 4;
                break;
            case 16:
                ancho = this.getWidth() / 4;
                alto = this.getHeight() / 4;
                break;
        }
        repaint();
    }

    /**
     * Clase necesaria para dar color
     */
    class WB {

        private int r, g, b;
        private Color color;
        int umbral = 127;// 

        public BufferedImage set_Blanco_y_Negro_con_Umbral(BufferedImage f) {
            BufferedImage bn = new BufferedImage(f.getWidth(), f.getHeight(), BufferedImage.TYPE_BYTE_BINARY);
            //se traspasan los colores Pixel a Pixel
            for (int i = 0; i < f.getWidth(); i++) {
                for (int j = 0; j < f.getHeight(); j++) {
                    color = new Color(f.getRGB(i, j));
                    //se extraen los valores RGB
                    r = color.getRed();
                    g = color.getGreen();
                    b = color.getBlue();
                    //dependiendo del valor del umbral, se van separando los
                    // valores RGB a 0 y 255  
                    r = (r > umbral) ? 255 : 0;
                    g = (g > umbral) ? 255 : 0;
                    b = (b > umbral) ? 255 : 0;
                    bn.setRGB(i, j, new Color(r, g, b).getRGB());
                }
            }
            return bn;
        }
    }
}
