package com.jincou.validation.test1;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * 核销文件管理
 *
 * @author dongjian1
 */
public final class VerificationFiles {
    private static Logger logger = LoggerFactory.getLogger(VerificationFiles.class);

    private String basePath;
    private Long investorLoanId;

    public VerificationFiles(String basePath, Long investorLoanId) {
        this.basePath = basePath;
        this.investorLoanId = investorLoanId;
    }

    public String getPDFDirPath() {
        return basePath + File.separator + investorLoanId;
    }


    public String getPDFFilePath(String fileName) {
        return getPDFDirPath() + File.separator + fileName + ".pdf";
    }


    public void init() throws Exception {
        try {
            logger.info("init dir path:"+this.getPDFDirPath());
            File pdfDir = new File(this.getPDFDirPath());
            FileUtils.deleteDirectory(pdfDir);
            FileUtils.forceMkdir(pdfDir);
        } catch (IOException e) {
            logger.info("init dir error:",e);
            throw e;
        }
    }

    public void cleanPDF() {
        try {
            File d8ir = new File(getPDFDirPath());
            FileUtils.deleteDirectory(d8ir);
        } catch (Exception e) {
            logger.error("clean dir error:" + getPDFDirPath(), e);
        }
    }

}
