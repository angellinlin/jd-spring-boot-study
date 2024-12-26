package com.jincou.validation.test1;

import com.jincou.validation.controller.FileToBytesUtil;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.generic.DateTool;
import org.apache.velocity.tools.generic.NumberTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author zhouguilong6
 */
@Component
public class AbstractPDFProcessor {
    @Autowired
    protected PDFProcessorDepend pdfProcessorDepend;

    protected static Logger logger = LoggerFactory.getLogger(AbstractPDFProcessor.class);

    protected AbstractPDFProcessor(PDFProcessorDepend pdfProcessorDepend) {
        this.pdfProcessorDepend = pdfProcessorDepend;

    }


//    protected byte[] sign(byte[] pdf,String pin) throws Exception {
//        DoFileSignatureReq req = builderDoFileSignatureReq(pdf, pin);
//        DoFileSignatureRes doFileSignatureRes = pdfProcessorDepend.getAgreementSignatureResource().doFileSignature(req);
//        if (!doFileSignatureRes.getResult().isSuccess()){
//            logger.info("pdfSign error doFileSignatureRes：{}", JSONObject.toJSONString(doFileSignatureRes));
//            throw new RuntimeException("pdfSign error");
//        }
//        return doFileSignatureRes.getContentBytes();
//    }

//    private DoFileSignatureReq builderDoFileSignatureReq(byte[] pdf,String pin){
//        DoFileSignatureReq req = new DoFileSignatureReq();
//        req.setAppId(pdfProcessorDepend.getAgreementSignatureAppId());
//        req.setAppToken(pdfProcessorDepend.getAgreementSignatureAppToken());
//        req.setContentType("BYTES");
//        req.setContentBytes(pdf);
//        req.setOrgName(pdfProcessorDepend.getSignatureOrgName());
//        req.setPositionKeyword("SIGN_FOR_CFE_12_008");
//        req.setScene(SignatureSceneEnum.WRITE_OFF_FILE.name());
//        req.setJdPin(pin);
//        req.setBatchId(String.valueOf(pdfProcessorDepend.getIdWorker().nextId()));
//        return req;
//    }

    public void genPDFAndSign(AbstractBO bo, String viewName, String fileName, String pin) throws Exception {
        byte[] pdf = genPDF(bo, viewName);
//        savePDF(pdf,"核销文件排查");
        FileToBytesUtil.fileToBytes(pdf,null,null);
//        try {
//            pdf = sign(pdf,pin);
//            savePDF(pdf, fileName);
//        } catch (Exception e) {
//            logger.info("genPDFAndSign error:",e);
//            savePDF(pdf, fileName);
//            throw e;
//        }
    }

    /**
     * 生成PDF
     */
    private byte[] genPDF(AbstractBO model, String view) throws Exception {
        Velocity.init();
        Context ctx = new VelocityContext();
        ctx.put("model", model);
        ctx.put("date", new DateTool() {{
            setFormat("yyyyMMdd");
        }});
        ctx.put("number", new NumberTool() {{
            setFormat("#0.00");
        }});

        StringWriter writer = new StringWriter();
        pdfProcessorDepend.getEngine().mergeTemplate(view, "utf-8", ctx, writer);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(writer.toString().getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PDFUtils.htmlToPdf(inputStream, outputStream, "/verification/files/msyh.ttf", 10F);
        return outputStream.toByteArray();
    }

    /**
     * 保存PDF
     */
//    private void savePDF(byte[] pdf, String fileName) throws Exception {
//        try (OutputStream out = new FileOutputStream(pdfProcessorDepend.getVerificationFiles().getPDFFilePath(fileName))) {
//            out.write(pdf);
//        } catch (Exception e) {
//            logger.info("savePDF error:"+pdfProcessorDepend.getVerificationFiles().getPDFFilePath(fileName),e);
//            throw e;
//        }
//    }
}
