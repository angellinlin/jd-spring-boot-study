package com.jincou.validation.test1;//package com.jincou.validation.test1;
//
//import com.jincou.validation.test1.PDFProcessorDepend;
//import com.jincou.validation.test1.VerificationFiles;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.commons.lang3.concurrent.BasicThreadFactory;
//import org.apache.velocity.app.VelocityEngine;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.DisposableBean;
//import org.springframework.beans.factory.InitializingBean;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Service;
//
//import java.io.File;
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.SynchronousQueue;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//
//
///**
// * 核销文件
// *
// * @author dongjian1
// */
//@Service
//@Scope("singleton")
//public class VerificationServiceImpl implements InitializingBean {
//
//    protected Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    private VelocityEngine engine;
//
////    private final JingdongStorageService jss;
//
//
//    @Override
//    public void afterPropertiesSet() {
//        engine = new VelocityEngine();
//        engine.setProperty("resource.loader", "file");
////        engine.setProperty("file.resource.loader.path", this.getClass().getResource("/verification").getFile());
//        engine.setProperty("input.encoding", "utf-8");
//        engine.setProperty("output.encoding", "utf-8");
//        engine.init();
//        PDFProcessorDepend pdfProcessorDepend = new PDFProcessorDepend();
////        pdfProcessorDepend.setVerificationFiles(verificationFiles);
////        pdfProcessorDepend.setDeviceCryptoService(deviceCryptoService);
//        pdfProcessorDepend.setEngine(engine);
//    }
//
//    private PDFProcessorDepend builderPDFProcessorDepend(VerificationFiles verificationFiles, String signatureOrgName){
//        PDFProcessorDepend pdfProcessorDepend = new PDFProcessorDepend();
////        pdfProcessorDepend.setVerificationFiles(verificationFiles);
////        pdfProcessorDepend.setDeviceCryptoService(deviceCryptoService);
//        pdfProcessorDepend.setEngine(engine);
//
//        return pdfProcessorDepend;
//    }
//
//}
