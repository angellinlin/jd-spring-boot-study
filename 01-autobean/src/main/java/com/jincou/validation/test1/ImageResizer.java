package com.jincou.validation.test1;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @author zhouguilong6
 * @date 2024/12/24 17:40
 */
public class ImageResizer {


    public static BufferedImage resize(BufferedImage img, int newW, int newH) {


        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);


        BufferedImage resized = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);


        Graphics2D g2d = resized.createGraphics();


        g2d.drawImage(tmp, 0, 0, null);


        g2d.dispose();


        return resized;


    }

    public static BufferedImage bilinearResize(BufferedImage img, int newW, int newH) {


        BufferedImage resized = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);


        for (int y = 0; y < newH; y++) {


            for (int x = 0; x < newW; x++) {


                int srcX = (int) ((float) x / newW * img.getWidth());


                int srcY = (int) ((float) y / newH * img.getHeight());


                resized.setRGB(x, y, img.getRGB(srcX, srcY));


            }


        }


        return resized;


    }

    public static BufferedImage bicubicResize(BufferedImage img, int newW, int newH) {


        BufferedImage resized = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);


        // Implement bicubic interpolation logic here


        // This is a placeholder for the actual bicubic interpolation code


        return resized;


    }


    public static void main(String[] args) throws Exception {


        File input = new File("D:\\zhouguilong6\\Desktop\\培训报销\\核销文件照片\\dd\\7a1014a34fc29160fb5ae11a68ca3da8_0.jpg");


        BufferedImage image = ImageIO.read(input);


        BufferedImage resized = resize(image, image.getWidth(), image.getHeight());


        File output = new File("D:\\zhouguilong6\\Desktop\\培训报销\\核销文件照片\\dd\\7a1014a34fc29160fb5ae11a68ca3da8_10.jpg");


        ImageIO.write(resized, "jpg", output);


    }


}


