package com.jincou.validation.test1;

/**
 * @author zhouguilong6
 * @date 2024/12/25 9:08
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 * @author SinNeR@blueidea.com
 * create a image
 */
public class HelloImage {
    public static void main(String[] args){
        BufferedImage image = new BufferedImage(80, 25,
                BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setColor(new Color(255,255,255));
        g.fillRect(0, 0, 80, 25);
        g.setColor(new Color(0,0,0));
        g.drawString("HelloImage",6,16);
        g.dispose();
        try{
            ImageIO.write(image, "jpeg", new File("C:\\helloImage.jpeg"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
