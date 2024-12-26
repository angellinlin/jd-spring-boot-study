package com.jincou.validation.config;

import com.jincou.validation.test1.PDFProcessorDepend;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author zhouguilong6
 */ //package com.jincou.validation.config;
//
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//import org.apache.velocity.app.VelocityEngine;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author zhouguilong6
// */ //package com.jincou.validation.config;
////
////
////import com.jd.jr.baitiao.agreement.export.rest.AgreementSignatureResource;
////import com.jd.jr.baitiao.agreement.export.vo.*;
////import com.jd.jr.baitiao.agreement.export.vo.result.BaseResponse;
////import com.jd.jr.cf.ledger.util.IdWorker;
////import com.jd.jrmserver.gateway.export.RedirectViewResponse;
////import com.jincou.validation.factory.FacBean;
////import com.jincou.validation.factory.Factory;
////import com.jincou.validation.simple.ConfigBean;
////import com.jincou.validation.test.PDFProcessorDepend;
////import lombok.AllArgsConstructor;
////import lombok.NoArgsConstructor;
////import org.apache.velocity.app.VelocityEngine;
////import org.springframework.beans.factory.InitializingBean;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////
/////**
//// * @Description: 生成Bean
//// *
//// * @author xub
//// * @date 2019/6/11 下午12:34
//// */
@Configuration
public class BeanTestConfig {

    @Bean
    @Primary
    public PDFProcessorDepend builderPDFProcessorDepend() throws Exception {
        PDFProcessorDepend pdfProcessorDepend = new PDFProcessorDepend();
        VelocityEngine engine = new VelocityEngine();
        engine.setProperty("resource.loader", "file");
        engine.setProperty("file.resource.loader.path", this.getClass().getResource("/verification").getFile());
        engine.setProperty("input.encoding", "utf-8");
        engine.setProperty("output.encoding", "utf-8");
        engine.init();

//        pdfProcessorDepend.setIdWorker(idWorker);
        pdfProcessorDepend.setEngine(engine);
//        pdfProcessorDepend.setAgreementSignatureResource(agreementSignatureResource);
        return pdfProcessorDepend;
    }
}
////
//////    @Bean
//////    public AgreementSignatureResource getAgreementSignatureResource(AgreementSignatureResource factory) throws Exception {
//////        return new AgreementSignatureResource() {
//////            @Override
//////            public QuerySignPdfUrlRes querySignPdfUrl(QuerySignPdfUrlReq querySignPdfUrlReq) {
//////                return null;
//////            }
//////
//////            @Override
//////            public DoAgreementSignRes doAgreementSign(DoAgreementSignReq doAgreementSignReq) {
//////                return null;
//////            }
//////
//////            @Override
//////            public BaseResponse doAgreementSignV2(DoAgreementSignReqV2 doAgreementSignReqV2) {
//////                return null;
//////            }
//////
//////            @Override
//////            public RedirectViewResponse redirectPdfUrl(RedirectPdfUrlReq redirectPdfUrlReq) {
//////                return null;
//////            }
//////
//////            @Override
//////            public BaseResponse agreementRecordForMark(AgreementRecordForMarkReq agreementRecordForMarkReq) {
//////                return null;
//////            }
//////
//////            @Override
//////            public BaseResponse syncSignatureFile(SyncSignatureFileReq syncSignatureFileReq) {
//////                return null;
//////            }
//////
//////            @Override
//////            public AgreementRepairSignRes agreementRepairSign(AgreementRepairSignReq agreementRepairSignReq) {
//////                return null;
//////            }
//////
//////            @Override
//////            public DoFileSignatureRes doFileSignature(DoFileSignatureReq doFileSignatureReq) {
//////                return null;
//////            }
//////        };
//////    }
//////
//////
//////    @Bean
//////    public IdWorker getIdWorker(IdWorker idWorker) throws Exception {
//////        return new IdWorker() {
//////            @Override
//////            public long nextId() {
//////                return 0;
//////            }
//////        };
//////    }
////
////
////    @Override
////    public void afterPropertiesSet() throws Exception {
////
////    }
//}
