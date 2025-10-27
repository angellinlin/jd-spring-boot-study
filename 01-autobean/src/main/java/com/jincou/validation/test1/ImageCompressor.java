package com.jincou.validation.test1;
import javax.imageio.*;
import javax.imageio.stream.*;
import java.awt.image.*;
import java.io.*;

public class ImageCompressor {
    public static byte[] compressImage(byte[] originalBytes, float quality) throws IOException {
        // 读取原始图片
        BufferedImage image = ImageIO.read(new ByteArrayInputStream(originalBytes));

        // 获取图片格式（如 "jpg", "png"）
        String format = getImageFormat(originalBytes);

        // 配置压缩参数
        ImageWriter writer = ImageIO.getImageWritersByFormatName(format).next();
        ImageWriteParam param = writer.getDefaultWriteParam();

        if (param.canWriteCompressed()) {
            param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            param.setCompressionQuality(quality); // 0.0-1.0，推荐0.75
        }

        // 执行压缩
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ImageOutputStream ios = ImageIO.createImageOutputStream(baos)) {
            writer.setOutput(ios);
            writer.write(null, new IIOImage(image, null, null), param);
        }

        return baos.toByteArray();
    }

    private static String getImageFormat(byte[] imageBytes) throws IOException {
        InputStream is = new ByteArrayInputStream(imageBytes);
        String format = ImageIO.getImageReaders(ImageIO.createImageInputStream(is)).next().getFormatName();
        is.close();
        return format.toLowerCase();
    }
}