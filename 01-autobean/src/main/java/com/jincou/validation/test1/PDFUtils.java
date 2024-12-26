package com.jincou.validation.test1;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class PDFUtils {
    private static Logger logger = LoggerFactory.getLogger(PDFUtils.class);

    public static void htmlToPdf(InputStream htmlIn, OutputStream pdfOut, String fontPath, float fontSize) throws Exception {
        Document document = null;
        PdfWriter writer = null;
        try {
            document = new Document();
            writer = PdfWriter.getInstance(document, pdfOut);
            document.open();
            XMLWorkerHelper.getInstance().parseXHtml(writer, document, htmlIn, StandardCharsets.UTF_8, new ClassPathFontProvider(fontPath, fontSize));
        } finally {
            if (document != null) {
                document.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }

    private static class ClassPathFontProvider extends XMLWorkerFontProvider {
        private String fontPath;
        private float fontSize;

        ClassPathFontProvider(String fontPath, float fontSize) {
            super(new File(PDFUtils.class.getResource(fontPath).getFile()).getParentFile().getPath());
            this.fontPath = PDFUtils.class.getResource(fontPath).getFile();
            this.fontSize = fontSize;
        }

        @Override
        public Font getFont(String fontName, String encoding, boolean embedded, float size, int style, BaseColor color) {
            BaseFont bf = null;
            try {
                bf = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
            Font font = new Font(bf, fontSize, style, color);
            font.setColor(color);
            return font;
        }
    }
}
