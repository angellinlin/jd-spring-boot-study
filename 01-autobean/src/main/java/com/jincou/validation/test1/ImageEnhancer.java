package com.jincou.validation.test1;

/**
 * @author zhouguilong6
 * @date 2024/12/24 17:20
 */
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageEnhancer {
    public static BufferedImage loadImage(String filePath) throws IOException {
        File imageFile = new File(filePath);
        BufferedImage image = ImageIO.read(imageFile);
        return image;
    }

    public static BufferedImage enhance(BufferedImage image) {
        float[] matrix = {
                -1, -1, -1,
                -1,  9, -1,
                -1, -1, -1
        };
        Kernel kernel = new Kernel(3, 3, matrix);
        ConvolveOp op = new ConvolveOp(kernel);
        BufferedImage enhancedImage = op.filter(image, null);
        return enhancedImage;
    }

    public static void saveImage(BufferedImage image, String filePath) throws IOException {
        File imageFile = new File(filePath);
        ImageIO.write(image, "jpg", imageFile);
    }

    public static void main(String[] args) {

        try {
            // 加载图片
            BufferedImage originalImage = loadImage("D:\\zhouguilong6\\Desktop\\培训报销\\核销文件照片\\dd\\7a1014a34fc29160fb5ae11a68ca3da8_0.jpg");

            // 提升图片清晰度
            BufferedImage enhancedImage = enhance(originalImage);

            // 保存图片
            saveImage(enhancedImage, "D:\\zhouguilong6\\Desktop\\培训报销\\核销文件照片\\dd\\7a1014a34fc29160fb5ae11a68ca3da8_4.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
