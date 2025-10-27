package com.jincou.validation.test1;
import javax.imageio.*;
import javax.imageio.stream.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.Iterator;

public class ImageCompressorUtil {

    /**
     * 压缩图片像素并调整质量
     * @param inputStream 原始图片输入流
     * @param outputStream 压缩后输出流
     * @param maxWidth 最大宽度（保持比例）
     * @param maxHeight 最大高度（保持比例）
     * @param quality 压缩质量（0.0-1.0）
     * @param formatName 输出格式（"jpg", "png"等）
     */
    public static void compressImage(InputStream inputStream,
                                     OutputStream outputStream,
                                     int maxWidth,
                                     int maxHeight,
                                     float quality,
                                     String formatName) throws IOException {
        // 读取原始图片
        BufferedImage originalImage = ImageIO.read(inputStream);
        if (originalImage == null) {
            throw new IOException("不支持的图片格式");
        }

        // 计算新尺寸（保持宽高比）
        int originalWidth = originalImage.getWidth();
        int originalHeight = originalImage.getHeight();
        Dimension newSize = calculateScaledDimension(
                new Dimension(originalWidth, originalHeight),
                new Dimension(maxWidth, maxHeight)
        );

        // 创建缩放后的图片
        BufferedImage scaledImage = new BufferedImage(
                newSize.width, newSize.height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = scaledImage.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(originalImage, 0, 0, newSize.width, newSize.height, null);
        g2d.dispose();

        // 获取图片编码器
        ImageWriter writer = getImageWriter(formatName);
        ImageWriteParam writeParam = writer.getDefaultWriteParam();

        // 设置压缩参数（如果支持）
        if (writeParam.canWriteCompressed()) {
            writeParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            writeParam.setCompressionQuality(quality);

            // JPEG特殊处理
            if ("jpg".equalsIgnoreCase(formatName) || "jpeg".equalsIgnoreCase(formatName)) {
                writeParam.setCompressionType("JPEG");
            }
        }

        // 写入输出流
        try (ImageOutputStream ios = ImageIO.createImageOutputStream(outputStream)) {
            writer.setOutput(ios);
            writer.write(null, new IIOImage(scaledImage, null, null), writeParam);
        } finally {
            writer.dispose();
        }
    }

    /**
     * 计算保持比例的缩放尺寸
     */
    private static Dimension calculateScaledDimension(Dimension original, Dimension boundary) {
        double widthRatio = boundary.getWidth() / original.getWidth();
        double heightRatio = boundary.getHeight() / original.getHeight();
        double ratio = Math.min(widthRatio, heightRatio);

        return new Dimension(
                (int) (original.width * ratio),
                (int) (original.height * ratio)
        );
    }

    /**
     * 获取指定格式的ImageWriter
     */
    private static ImageWriter getImageWriter(String formatName) {
        Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName(formatName);
        if (!writers.hasNext()) {
            throw new IllegalArgumentException("不支持的图片格式: " + formatName);
        }
        return writers.next();
    }

    /**
     * 便捷方法：压缩文件到文件
     */
    public static void compressFile(File inputFile, File outputFile,
                                    int maxWidth, int maxHeight,
                                    float quality) throws IOException {
        try (InputStream is = new FileInputStream(inputFile);
             OutputStream os = new FileOutputStream(outputFile)) {
            String formatName = getFormatName(inputFile);
            compressImage(is, os, maxWidth, maxHeight, quality, formatName);
        }
    }

    /**
     * 获取文件格式
     */
    private static String getFormatName(File file) throws IOException {
        String name = file.getName().toLowerCase();
        if (name.endsWith(".jpg") || name.endsWith(".jpeg")) return "jpg";
        if (name.endsWith(".png")) return "png";
        if (name.endsWith(".gif")) return "gif";
        if (name.endsWith(".bmp")) return "bmp";
        throw new IOException("不支持的图片格式: " + file.getName());
    }

    // 使用示例
    public static void main(String[] args) {
        try {
            // 示例1：压缩到800x600，质量80%
            compressFile(
                    new File("original.jpg"),
                    new File("compressed.jpg"),
                    800, 600, 0.8f
            );

            // 示例2：处理字节数组
            byte[] buf = new byte[]{};
            ByteArrayInputStream bis = new ByteArrayInputStream(buf);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            compressImage(bis, bos, 1024, 768, 0.7f, "jpg");
            byte[] compressedBytes = bos.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}