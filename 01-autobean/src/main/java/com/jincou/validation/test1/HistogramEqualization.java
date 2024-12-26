package com.jincou.validation.test1;

/**
 * @author zhouguilong6
 * @date 2024/12/24 18:12
 */
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class HistogramEqualization {
    public static BufferedImage applyGaussianBlur(BufferedImage original) {
        int radius = 3;
        int width = original.getWidth();
        int height = original.getHeight();
        BufferedImage result = new BufferedImage(width, height, original.getType());

        float[] kernel = {
                1/16f, 1/8f, 1/16f,
                1/8f,  1/4f, 1/8f,
                1/16f, 1/8f, 1/16f
        };

        for (int i = radius; i < width - radius; i++) {
            for (int j = radius; j < height - radius; j++) {
                float sumR = 0, sumG = 0, sumB = 0;

                for (int ki = -radius; ki <= radius; ki++) {
                    for (int kj = -radius; kj <= radius; kj++) {
                        int pixel = original.getRGB(i + ki, j + kj);
                        float weight = kernel[(ki + radius) * (2 * radius + 1) + (kj + radius)];

                        sumR += weight * ((pixel >> 16) & 0xFF);
                        sumG += weight * ((pixel >> 8) & 0xFF);
                        sumB += weight * (pixel & 0xFF);
                    }
                }

                int newPixel = ((int)sumR << 16) | ((int)sumG << 8) | (int)sumB;
                result.setRGB(i, j, newPixel);
            }
        }

        return result;
    }

    public static BufferedImage equalizeHistogram(BufferedImage original) {
        int width = original.getWidth();
        int height = original.getHeight();
        BufferedImage result = new BufferedImage(width, height, original.getType());

        int[] histogram = new int[256];
        int[] cumulativeHist = new int[256];
        int[] equalizedPixels = new int[256];

        // 计算直方图
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int pixel = original.getRGB(i, j) & 0xFF;
                histogram[pixel]++;
            }
        }

        // 计算累积分布函数 (CDF)
        cumulativeHist[0] = histogram[0];
        for (int i = 1; i < 256; i++) {
            cumulativeHist[i] = cumulativeHist[i - 1] + histogram[i];
        }

        // 计算均衡后的像素值
        int totalPixels = width * height;
        for (int i = 0; i < 256; i++) {
            equalizedPixels[i] = (cumulativeHist[i] * 255) / totalPixels;
        }

        // 应用均衡化
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int pixel = original.getRGB(i, j) & 0xFF;
                int newPixel = equalizedPixels[pixel];
                int rgb = (newPixel << 16) | (newPixel << 8) | newPixel;
                result.setRGB(i, j, rgb);
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        File input = new File("D:\\zhouguilong6\\Desktop\\培训报销\\核销文件照片\\dd\\7a1014a34fc29160fb5ae11a68ca3da8_0.jpg");
        BufferedImage original = ImageIO.read(input);
        BufferedImage enhanced = applyGaussianBlur(original);
        ImageIO.write(enhanced, "jpg", new File("D:\\zhouguilong6\\Desktop\\培训报销\\核销文件照片\\dd\\7a1014a34fc29160fb5ae11a68ca3da8_10.jpg"));
    }
}
