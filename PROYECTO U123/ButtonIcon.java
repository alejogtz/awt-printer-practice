/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

import java.awt.Button;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ButtonIcon extends Button {

        BufferedImage imagen;

        public ButtonIcon(String resource) {
            super();
            try {
                
                File file = new File(resource);
                System.out.print(file.getAbsolutePath());
                imagen = ImageIO.read(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void paint(Graphics g) {
            g.drawImage(imagen, 0, 0, this.getWidth(), this.getHeight(), null);
        }
    }
